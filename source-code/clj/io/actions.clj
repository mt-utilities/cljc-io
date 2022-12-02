
(ns io.actions
    (:require [clojure.java.io]
              [io.check   :as check]
              [io.config  :as config]
              [io.file    :as file]
              [io.read    :as read]
              [string.api :as string]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn create-directory!
  ; @param (string) directory-path
  ; @param (map)(opt) options
  ; {:warn? (boolean)(opt)
  ;   Default: true}
  ;
  ; @usage
  ; (create-directory! "my-directory/my-subdirectory")
  ;
  ; @return (boolean)
  ([directory-path]
   (create-directory! directory-path {}))

  ([directory-path {:keys [warn?] :or {warn? true}}]
   ; https://stackoverflow.com/questions/6774369/recursively-create-directory
   ; (try (-> directory-path java.io.File. .mkdir)  ...)
   ; (try (-> directory-path java.io.File. .mkdirs) ...)
   (when-not (check/directory-exists? directory-path)
             (if warn? (println (str config/CREATE-DIRECTORY-MESSAGE " \"" directory-path "\"")))
             (try (-> directory-path java.io.File. .mkdirs)
                  (catch Exception e (println e))))))

(defn create-path!
  ; @param (string) item-path
  ; @param (map)(opt) options
  ; {:warn? (boolean)(opt)
  ;   Default: true}
  ;
  ; @usage
  ; (create-path! "my-directory/my-file.ext")
  ;
  ; @example
  ; (create-path! "my-directory/my-file.ext")
  ; =>
  ; It only creates the my-directory (if it does not exist),
  ; to settle the path for the item.
  ;
  ; @return (boolean)
  ([item-path]
   (create-path! item-path {}))

  ([item-path {:keys [warn?] :or {warn? true} :as options}]
   (when-let [parent-path (file/item-path->parent-path item-path)]
             (if warn? (println (str config/CREATE-DIRECTORY-MESSAGE " \"" parent-path "\"")))
             (if-not (check/directory-exists? parent-path)
                     (create-directory!       parent-path options)))))

(defn create-file!
  ; @param (string) filepath
  ; @param (map)(opt) options
  ; {:return? (boolean)(opt)
  ;   Default: true
  ;  :warn? (boolean)(opt)
  ;   Default: true}
  ;
  ; @usage
  ; (create-file! "my-directory/my-file.ext")
  ;
  ; @return (nil or string)
  ; Returns an empty string if the file is created or with the file's content
  ; if it is already exists.
  ; Returns nil if the return? option is set to false.
  ([filepath]
   (create-file! filepath {}))

  ([filepath {:keys [return? warn?] :or {return? true warn? true}}]
   (when-not (check/file-exists? filepath)
             (create-path!       filepath {:warn? false})
             (if warn? (println (str config/CREATE-FILE-MESSAGE " \"" filepath "\"")))
             (spit filepath nil))
   (if return? (read/read-file filepath))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn delete-file!
  ; @param (string) filepath
  ; @param (map)(opt) options
  ; {:warn? (boolean)(opt)
  ;   Default: true}
  ;
  ; @usage
  ; (delete-file! "my-directory/my-file.ext")
  ;
  ; @return (boolean)
  ([filepath]
   (delete-file! filepath {}))

  ([filepath {:keys [warn?] :or {warn? true}}]
   (try (if (check/file-exists?          filepath)
            (clojure.java.io/delete-file filepath)
            (throw (Exception. config/FILE-DOES-NOT-EXIST-ERROR)))
       (catch Exception e (if warn? (println (str e " \"" filepath "\"")))))))

(defn copy-file!
  ; @param (string) source-filepath
  ; @param (string) destination-filepath
  ; @param (map)(opt) options
  ; {:return? (boolean)(opt)
  ;   Default: true
  ;  :warn? (boolean)(opt)
  ;   Default: true}
  ;
  ; @usage
  ; (copy-file! "my-directory/my-source-file.ext"
  ;            "my-directory/my-destination-file.ext")
  ;
  ; @return (nil or string)
  ; Returns with the file's content or with nil if the return? option is set to false.
  ([source-filepath destination-filepath]
   (copy-file! source-filepath destination-filepath {}))

  ([source-filepath destination-filepath {:keys [return? warn?] :or {return? true warn? true}}]
   (try (if (check/file-exists? source-filepath)
            (do (clojure.java.io/copy (-> source-filepath      str clojure.java.io/file)
                                      (-> destination-filepath str clojure.java.io/file))
                (if return? (read/read-file destination-filepath)))
            (throw (Exception. config/FILE-DOES-NOT-EXIST-ERROR)))
        (catch Exception e (if warn? (println (str e " \"" source-filepath "\"")))))))

(defn write-file!
  ; @param (string) filepath
  ; @param (*) content
  ; @param (map)(opt) options
  ; {:create? (boolean)(opt)
  ;  Default: false
  ; :return? (boolean)(opt)
  ;   Default: true
  ; :warn? (boolean)(opt)
  ;  Default: true}
  ;
  ; @usage
  ; (write-file! "my-directory/my-file.ext" "My content")
  ;
  ; @usage
  ; (write-file! "my-directory/my-file.ext" "My content" {...})
  ;
  ; @return (nil or string)
  ; Returns with the file's content or with nil if the return? option is set to false.
  ([filepath content]
   (write-file! filepath content {}))

  ([filepath content {:keys [create? return? warn?] :or {return? true warn? true} :as options}]
   (if (check/file-exists? filepath)
       (spit filepath (str content))
       (if create? (do (create-path! filepath {:warn? false})
                       (if warn? (println (str config/CREATE-FILE-MESSAGE " \"" filepath "\"")))
                       (spit filepath (str content)))
                   (if warn? (println (str config/FILE-DOES-NOT-EXIST-ERROR " \"" filepath "\"")))))
   (if return? (read/read-file filepath))))

(defn empty-file!
  ; @param (string) filepath
  ; @param (map)(opt) options
  ; {:create? (boolean)(opt)
  ;   Default: false
  ; :return? (boolean)(opt)
  ;   Default: true
  ;  :warn? (boolean)(opt)
  ;   Default: true}
  ;
  ; @usage
  ; (empty-file! "my-directory/my-file.ext")
  ;
  ; @return (nil or string)
  ; Returns with an empty string or with nil if the return? option is set to false.
  ([filepath]
   (empty-file! filepath {}))

  ([filepath options]
   (write-file! filepath nil options)))

(defn append-to-file!
  ; @param (string) filepath
  ; @param (*) content
  ; @param (map)(opt) options
  ; {:create? (boolean)(opt)
  ;  Default: false
  ; :max-line-count (integer)(opt)
  ; :return? (boolean)(opt)
  ;   Default: true
  ; :warn? (boolean)(opt)
  ;  Default: true}
  ;
  ; @usage
  ; (append-to-file! "my-directory/my-file.ext" "My content")
  ;
  ; @usage
  ; (append-to-file! "my-directory/my-file.ext" "My content" {...})
  ;
  ; @return (nil or string)
  ; Returns with the file's content or with nil if the return? option is set to false.
  ([filepath content]
   (append-to-file! filepath content {}))

  ([filepath content {:keys [max-line-count] :as options}]
   (let [file-content (read/read-file filepath)
         output       (str file-content "\n" content)]
                           ; If the maximum number of lines is limited ...
        (if max-line-count (let [output (string/max-lines output max-line-count)]
                                (write-file! filepath output options))
                           ; If the maximum number of lines is NOT limited ...
                           (write-file! filepath output options)))))

(defn prepend-to-file!
  ; @param (string) filepath
  ; @param (*) content
  ; @param (map)(opt) options
  ; {:create? (boolean)(opt)
  ;  Default: false
  ; :max-line-count (integer)(opt)
  ; :return? (boolean)(opt)
  ;   Default: true
  ; :warn? (boolean)(opt)
  ;  Default: true}
  ;
  ; @usage
  ; (prepend-to-file! "my-directory/my-file.ext" "My content")
  ;
  ; @usage
  ; (prepend-to-file! "my-directory/my-file.ext" "My content" {...})
  ;
  ; @return (nil or string)
  ; Returns with the file's content or with nil if the return? option is set to false.
  ([filepath content]
   (prepend-to-file! filepath content {}))

  ([filepath content {:keys [max-line-count] :as options}]
   (let [file-content (read/read-file filepath)
         output       (str content "\n" file-content)]
                           ; If the maximum number of lines is limited ...
        (if max-line-count (let [output (string/max-lines output max-line-count)]
                                (write-file! filepath output options))
                           ; If the maximum number of lines is NOT limited ...
                           (write-file! filepath output options)))))

(defn copy-uri-to-file!
  ; @param (string) uri
  ; @param (?) file
  ; @param (map)(opt) options
  ; {:warn? (boolean)(opt)
  ;  Default: true}
  ;
  ; @return (nil)
  ([uri file]
   (copy-uri-to-file! uri file {}))

  ([uri file {:keys [warn?] :or {warn? true}}]
   (try (with-open [input  (clojure.java.io/input-stream  uri)
                    output (clojure.java.io/output-stream file)]
                   (clojure.java.io/copy input output))
        (catch Exception e (if warn? (println e))))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn delete-empty-directory!
  ; @param (string) directory-path
  ; @param (map)(opt) options
  ; {:warn? (boolean)(opt)
  ;  Default: true}
  ;
  ; @usage
  ; (delete-empty-directory! "my-directory/my-subdirectory")
  ;
  ; @return (boolean)
  ([directory-path]
   (delete-empty-directory! directory-path {}))

  ([directory-path {:keys [warn?] :or {warn? true}}]
   (try (if (check/directory-exists?     directory-path)
            (clojure.java.io/delete-file directory-path)
            (throw (Exception. config/DIRECTORY-DOES-NOT-EXIST-ERROR)))
        (catch Exception e (if warn? (println (str e " \"" directory-path "\"")))))))

(defn empty-directory!
  ; @param (string) directory-path
  ; @param (map)(opt) options
  ; {:warn? (boolean)(opt)
  ;  Default: true}
  ;
  ; @usage
  ; (empty-directory! "my-directory/my-subdirectory")
  ;
  ; @return (boolean)
  ([directory-path]
   (empty-directory! directory-path {}))

  ([directory-path options]
   (doseq [item-path (read/item-list directory-path)]
          (if (check/directory? item-path)
              (do (empty-directory!        item-path options)
                  (delete-empty-directory! item-path options))
              (delete-file! item-path)))))

(defn delete-directory!
  ; @param (string) directory-path
  ; @param (map)(opt) options
  ; {:warn? (boolean)(opt)
  ;  Default: true}
  ;
  ; @usage
  ; (delete-directory! "my-directory/my-subdirectory")
  ;
  ; @return (boolean)
  ([directory-path]
   (empty-directory! directory-path {}))

  ([directory-path options]
   (empty-directory!        directory-path options)
   (delete-empty-directory! directory-path options)))

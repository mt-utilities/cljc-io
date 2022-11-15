
(ns io.actions
    (:require [clojure.java.io]
              [io.check          :as check]
              [io.config         :as config]
              [io.file           :as file]
              [io.read           :as read]
              [mid-fruits.string :as string]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn create-directory!
  ; @param (string) directory-path
  ;
  ; @usage
  ; (create-directory! "my-directory/my-subdirectory")
  ;
  ; @return (boolean)
  [directory-path]
  (if-not (check/directory-exists? directory-path)
          (println (str config/CREATE-DIRECTORY-MESSAGE " \"" directory-path "\"")))
  ; https://stackoverflow.com/questions/6774369/recursively-create-directory
  ; (try (-> directory-path java.io.File. .mkdir) ...)
  (try (-> directory-path java.io.File. .mkdirs)
       (catch Exception e (println e))))

(defn create-file!
  ; @param (string) filepath
  ;
  ; @usage
  ; (create-file! "my-directory/my-file.ext")
  ;
  ; @return (nil)
  [filepath]
  (if-not (check/file-exists? filepath)
          (println (str config/CREATE-FILE-MESSAGE " \"" filepath "\"")))
  (spit filepath nil))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn delete-file!
  ; @param (string) filepath
  ;
  ; @usage
  ; (delete-file! "my-directory/my-file.ext")
  ;
  ; @return (boolean)
  [filepath]
  (try (if (check/file-exists?          filepath)
           (clojure.java.io/delete-file filepath)
           (throw (Exception. config/FILE-DOES-NOT-EXIST-ERROR)))
      (catch Exception e (println (str e " \"" filepath "\"")))))

(defn copy-file!
  ; @param (string) source-filepath
  ; @param (string) destination-filepath
  ;
  ; @usage
  ; (copy-file! "my-directory/my-source-file.ext"
  ;             "my-directory/my-destination-file.ext")
  ;
  ; @return (nil)
  [source-filepath destination-filepath]
  (try (if (check/file-exists? source-filepath)
           (clojure.java.io/copy (clojure.java.io/file      source-filepath)
                                 (clojure.java.io/file destination-filepath))
           (throw (Exception. config/FILE-DOES-NOT-EXIST-ERROR)))
       (catch Exception e (println (str e " \"" source-filepath "\"")))))

(defn write-file!
  ; @param (string) filepath
  ; @param (*) content
  ; @param (map)(opt) options
  ; {:create? (boolean)(opt)
  ;   Default: false}
  ;
  ; @usage
  ; (write-file! "my-directory/my-file.ext" "My content")
  ;
  ; @usage
  ; (write-file! "my-directory/my-file.ext" "My content" {...})
  ;
  ; @return (nil)
  ([filepath content]
   (write-file! filepath content {}))

  ([filepath content {:keys [create?]}]
   (if (check/file-exists? filepath)
       (spit filepath (str content))
       (if create? (do (println (str config/CREATE-FILE-MESSAGE " \"" filepath "\""))
                       (if-let [directory-path (file/filepath->directory-path filepath)]
                               (if-not (check/directory-exists? directory-path)
                                       (create-directory!       directory-path)))
                       (spit filepath (str content)))))))

(defn append-to-file!
  ; @param (string) filepath
  ; @param (*) content
  ; @param (map)(opt) options
  ; {:create? (boolean)(opt)
  ;   Default: false
  ;  :max-line-count (integer)(opt)}
  ;
  ; @usage
  ; (append-to-file! "my-directory/my-file.ext" "My content")
  ;
  ; @usage
  ; (append-to-file! "my-directory/my-file.ext" "My content" {...})
  ;
  ; @return (nil)
  ([filepath content]
   (append-to-file! filepath content {}))

  ([filepath content {:keys [max-line-count] :as options}]
   (let [file-content (read/read-file filepath)
         output       (str file-content "\n" content)]
        (if max-line-count ; If the maximum number of lines is limited ...
                           (let [output (string/max-lines output max-line-count)]
                                (write-file! filepath output options))
                           ; If the maximum number of lines is NOT limited ...
                           (write-file! filepath output options)))))

(defn prepend-to-file!
  ; @param (string) filepath
  ; @param (*) content
  ; @param (map)(opt) options
  ; {:create? (boolean)(opt)
  ;   Default: false
  ;  :max-line-count (integer)(opt)}
  ;
  ; @usage
  ; (prepend-to-file! "my-directory/my-file.ext" "My content")
  ;
  ; @usage
  ; (prepend-to-file! "my-directory/my-file.ext" "My content" {...})
  ;
  ; @return (nil)
  ([filepath content]
   (prepend-to-file! filepath content {}))

  ([filepath content {:keys [max-line-count] :as options}]
   (let [file-content (read/read-file filepath)
         output       (str content "\n" file-content)]
        (if max-line-count ; If the maximum number of lines is limited ...
                           (let [output (string/max-lines output max-line-count)]
                                (write-file! filepath output options))
                           ; If the maximum number of lines is NOT limited ...
                           (write-file! filepath output options)))))

(defn copy-uri-to-file!
  ; @param (string) uri
  ; @param (?) file
  ;
  ; @return (nil)
  [uri file]
  (try (with-open [input  (clojure.java.io/input-stream  uri)
                   output (clojure.java.io/output-stream file)]
                  (clojure.java.io/copy input output))
       (catch Exception e (println e))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn delete-empty-directory!
  ; @param (string) directory-path
  ;
  ; @usage
  ; (delete-empty-directory! "my-directory/my-subdirectory")
  ;
  ; @return (boolean)
  [directory-path]
  (try (if (check/directory-exists?     directory-path)
           (clojure.java.io/delete-file directory-path)
           (throw (Exception. config/DIRECTORY-DOES-NOT-EXIST-ERROR)))
      (catch Exception e (println (str e " \"" directory-path "\"")))))

(defn empty-directory!
  ; @param (string) directory-path
  ;
  ; @usage
  ; (empty-directory! "my-directory/my-subdirectory")
  ;
  ; @return (boolean)
  [directory-path]
  (doseq [item-path (read/item-list directory-path)]
         (if (check/directory? item-path)
             (do (empty-directory!        item-path)
                 (delete-empty-directory! item-path))
             (delete-file! item-path))))

(defn delete-directory!
  ; @param (string) directory-path
  ;
  ; @usage
  ; (delete-directory! "my-directory/my-subdirectory")
  ;
  ; @return (boolean)
  [directory-path]
  (empty-directory!        directory-path)
  (delete-empty-directory! directory-path))

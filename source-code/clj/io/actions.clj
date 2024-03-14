
(ns io.actions
    (:require [clojure.java.io]
              [fruits.string.api :as string]
              [io.check          :as check]
              [io.messages       :as messages]
              [io.read           :as read]
              [io.utils          :as utils]
              [iso.io.file       :as file]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn create-directory!
  ; @description
  ; Creates a directory to the given directory path.
  ;
  ; @param (string) directory-path
  ; @param (map)(opt) options
  ; {:warn? (boolean)(opt)
  ;   If TRUE, prints the error message (if any) to the console.
  ;   Default: true}
  ;
  ; @usage
  ; (create-directory! "my-directory/my-subdirectory")
  ; =>
  ; true
  ;
  ; @return (boolean)
  ([directory-path]
   (create-directory! directory-path {}))

  ([directory-path {:keys [warn?] :or {warn? true}}]
   ; https://stackoverflow.com/questions/6774369/recursively-create-directory
   ; (try (-> directory-path java.io.File. .mkdir)  ...)
   ; (try (-> directory-path java.io.File. .mkdirs) ...)
   (if-not (check/directory-exists? directory-path)
           (do (if warn? (println (str messages/CREATE-DIRECTORY-MESSAGE " \"" directory-path "\"")))
               (try (-> directory-path java.io.File. .mkdirs)
                    (catch Exception e (println e))))
           (-> :directory-already-exists))))

(defn create-path!
  ; @description
  ; Creates the ancestor directories of the given path.
  ;
  ; @param (string) item-path
  ; @param (map)(opt) options
  ; {:warn? (boolean)(opt)
  ;   If TRUE, prints the error message (if any) to the console.
  ;   Default: true}
  ;
  ; @usage
  ; (create-path! "my-directory/my-subdirectory/my-file.ext")
  ; =>
  ; true
  ;
  ; @return (boolean)
  ([item-path]
   (create-path! item-path {}))

  ([item-path {:keys [warn?] :or {warn? true} :as options}]
   (when-let [parent-path (file/item-path->parent-path item-path)]
             (if-not (check/directory-exists? parent-path)
                     (create-directory!       parent-path options)
                     (-> :path-already-exists)))))

(defn create-file!
  ; @description
  ; Creates an empty file to the given filepath.
  ;
  ; @param (string) filepath
  ; @param (map)(opt) options
  ; {:return? (boolean)(opt)
  ;   If TRUE, returns the file content.
  ;   Default: true
  ;  :warn? (boolean)(opt)
  ;   If TRUE, prints the error message (if any) to the console.
  ;   Default: true}
  ;
  ; @usage
  ; (create-file! "my-directory/my-file.ext")
  ; =>
  ; ""
  ;
  ; @return (string)
  ([filepath]
   (create-file! filepath {}))

  ([filepath {:keys [return? warn?] :or {return? true warn? true}}]
   (when-not (check/file-exists? filepath)
             (create-path!       filepath {:warn? false})
             (if warn? (println (str messages/CREATE-FILE-MESSAGE " \"" filepath "\"")))
             (spit filepath nil))
   (if return? (read/read-file filepath))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn delete-file!
  ; @description
  ; Deletes the file at the given filepath.
  ;
  ; @param (string) filepath
  ; @param (map)(opt) options
  ; {:warn? (boolean)(opt)
  ;   If TRUE, prints the error message (if any) to the console.
  ;   Default: true}
  ;
  ; @usage
  ; (delete-file! "my-directory/my-file.ext")
  ; =>
  ; true
  ;
  ; @return (boolean)
  ([filepath]
   (delete-file! filepath {}))

  ([filepath {:keys [warn?] :or {warn? true}}]
   (try (if (check/file-exists?          filepath)
            (clojure.java.io/delete-file filepath)
            (throw (Exception. messages/FILE-DOES-NOT-EXIST-ERROR)))
        (catch Exception e (if warn? (println (str e " \"" filepath "\"")))))))

(defn copy-file!
  ; @description
  ; Duplicates the file at the given filepath.
  ;
  ; @param (string) source-filepath
  ; @param (string) destination-filepath
  ; @param (map)(opt) options
  ; {:return? (boolean)(opt)
  ;   If TRUE, returns the file content.
  ;   Default: true
  ;  :warn? (boolean)(opt)
  ;   If TRUE, prints the error message (if any) to the console.
  ;   Default: true}
  ;
  ; @usage
  ; (copy-file! "my-directory/my-source-file.ext"
  ;             "my-directory/my-destination-file.ext")
  ; =>
  ; "My content"
  ;
  ; @return (string)
  ([source-filepath destination-filepath]
   (copy-file! source-filepath destination-filepath {}))

  ([source-filepath destination-filepath {:keys [return? warn?] :or {return? true warn? true}}]
   ; @note (#7440)
   ; It's important to ensure that file paths are not NIL before passing them to the 'clojure.java.io/file' function.
   ; Otherwise, NIL file paths would cause errors.
   (try (if (check/file-exists? source-filepath)
            (do (clojure.java.io/copy (-> source-filepath      str clojure.java.io/file)
                                      (-> destination-filepath str clojure.java.io/file))
                (if return? (read/read-file destination-filepath)))
            (throw (Exception. messages/FILE-DOES-NOT-EXIST-ERROR)))
        (catch Exception e (if warn? (println (str e " \"" source-filepath "\"")))))))

(defn write-file!
  ; @description
  ; Overwrites the file at the given filepath with the given content.
  ;
  ; @param (string) filepath
  ; @param (*) content
  ; @param (map)(opt) options
  ; {:ensure-eol? (boolean)(opt)
  ;   If TRUE, ensures that the file content ends with a newline character.
  ;  :create? (boolean)(opt)
  ;   If TRUE, creates the file in case if it does not exist.
  ;   Default: false
  ;  :return? (boolean)(opt)
  ;   If TRUE, returns the file content.
  ;   Default: true
  ;  :warn? (boolean)(opt)
  ;   If TRUE, prints the error message (if any) to the console.
  ;   Default: true}
  ;
  ; @usage
  ; (write-file! "my-directory/my-file.ext" "My content")
  ; =>
  ; "My content"
  ;
  ; @return (string)
  ([filepath content]
   (write-file! filepath content {}))

  ([filepath content {:keys [create? ensure-eol? return? warn?] :or {return? true warn? true} :as options}]
   (if (check/file-exists? filepath)
       (if ensure-eol? (spit filepath (-> content str utils/ensure-eol))
                       (spit filepath (-> content str)))
       (if create? (do (create-path! filepath {:warn? false})
                       (if warn?      (println (str messages/CREATE-FILE-MESSAGE " \"" filepath "\"")))
                       (if ensure-eol? (spit filepath (-> content str utils/ensure-eol))
                                       (spit filepath (-> content str))))
                   (if warn? (println (str messages/FILE-DOES-NOT-EXIST-ERROR " \"" filepath "\"")))))
   (if return? (read/read-file filepath))))

(defn update-file!
  ; @description
  ; Updates the file at the given filepath by applying the given 'f' function on its content.
  ;
  ; @param (string) filepath
  ; @param (function) f
  ; @param (*) params
  ;
  ; @usage
  ; (update-file! "my-directory/my-file.ext" clojure.string/upper-case)
  ; =>
  ; "MY CONTENT"
  ;
  ; @return (string)
  [filepath f & params]
  ; @note (#5012)
  ; Unlike other file handling functions, the 'update-file!' function, (due to variadic arguments) ...
  ; ... does not take 'options' parameter.
  ; ... always creates the file if it does not exist!
  ; ... always prints a warning message when the file does not exist!
  (let [file-content (read/read-file filepath {:warn? false})
        output       (apply f file-content params)]
       (write-file!    filepath output {:create? true :warn? true})
       (read/read-file filepath {:warn? false})))

(defn empty-file!
  ; @description
  ; Deletes the content of the file at the given filepath.
  ;
  ; @param (string) filepath
  ; @param (map)(opt) options
  ; {:create? (boolean)(opt)
  ;   If TRUE, creates the file in case if it does not exist.
  ;   Default: false
  ;  :return? (boolean)(opt)
  ;   If TRUE, returns the file content.
  ;   Default: true
  ;  :warn? (boolean)(opt)
  ;   If TRUE, prints the error message (if any) to the console.
  ;   Default: true}
  ;
  ; @usage
  ; (empty-file! "my-directory/my-file.ext")
  ; =>
  ; ""
  ;
  ; @return (string)
  ([filepath]
   (empty-file! filepath {}))

  ([filepath options]
   (write-file! filepath nil options)))

(defn append-to-file!
  ; @description
  ; Appends the given content to the content of the file at the given filepath.
  ;
  ; @param (string) filepath
  ; @param (*) content
  ; @param (map)(opt) options
  ; {:create? (boolean)(opt)
  ;   If TRUE, creates the file in case if it does not exist.
  ;   Default: false
  ;  :max-line-count (integer)(opt)
  ;  :return? (boolean)(opt)
  ;   If TRUE, returns the file content.
  ;   Default: true
  ;  :warn? (boolean)(opt)
  ;   If TRUE, prints the error message (if any) to the console.
  ;   Default: true}
  ;
  ; @usage
  ; (append-to-file! "my-directory/my-file.ext" "\nAnother content")
  ; =>
  ; "My content\nAnother content"
  ;
  ; @return (string)
  ([filepath content]
   (append-to-file! filepath content {}))

  ([filepath content {:keys [max-line-count] :as options}]
   (let [file-content (read/read-file filepath)
         output       (str file-content "\n" content)]
        (if max-line-count ; If the maximum number of lines is limited ...
                           (let [output (string/limit-lines output max-line-count)]
                                (write-file! filepath output options))
                           ; If the maximum number of lines is NOT limited ...
                           (write-file! filepath output options)))))

(defn prepend-to-file!
  ; @description
  ; Prepends the given content to the content of the file at the given filepath.
  ;
  ; @param (string) filepath
  ; @param (*) content
  ; @param (map)(opt) options
  ; {:create? (boolean)(opt)
  ;   If TRUE, creates the file in case if it does not exist.
  ;   Default: false
  ;  :max-line-count (integer)(opt)
  ;  :return? (boolean)(opt)
  ;   If TRUE, returns the file content.
  ;   Default: true
  ;  :warn? (boolean)(opt)
  ;   If TRUE, prints the error message (if any) to the console.
  ;   Default: true}
  ;
  ; @usage
  ; (prepend-to-file! "my-directory/my-file.ext" "Another content\n")
  ; =>
  ; "Another content\nMy content"
  ;
  ; @return (string)
  ([filepath content]
   (prepend-to-file! filepath content {}))

  ([filepath content {:keys [max-line-count] :as options}]
   (let [file-content (read/read-file filepath)
         output       (str content "\n" file-content)]
        (if max-line-count ; If the maximum number of lines is limited ...
                           (let [output (string/limit-lines output max-line-count)]
                                (write-file! filepath output options))
                           ; If the maximum number of lines is NOT limited ...
                           (write-file! filepath output options)))))

(defn copy-uri-to-file!
  ; @description
  ; Opens an input stream from the given URI and copies its content to the file at the given filepath.
  ;
  ; @param (string) uri
  ; @param (string) destination-filepath
  ; @param (map)(opt) options
  ; {:warn? (boolean)(opt)
  ;   If TRUE, prints the error message (if any) to the console.
  ;   Default: true}
  ;
  ; @usage
  ; (copy-uri-to-file! "..." "my-file.ext")
  ;
  ; @return (nil)
  ([uri destination-filepath]
   (copy-uri-to-file! uri destination-filepath {}))

  ([uri destination-filepath {:keys [warn?] :or {warn? true}}]
   (try (with-open [input  (clojure.java.io/input-stream  uri)
                    output (clojure.java.io/output-stream destination-filepath)]
                   (clojure.java.io/copy input output))
        (catch Exception e (if warn? (println e))))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn delete-empty-directory!
  ; @description
  ; Deletes the directory at the given directory path if it is empty.
  ;
  ; @param (string) directory-path
  ; @param (map)(opt) options
  ; {:warn? (boolean)(opt)
  ;   If TRUE, prints the error message (if any) to the console.
  ;   Default: true}
  ;
  ; @usage
  ; (delete-empty-directory! "my-directory/my-subdirectory")
  ; =>
  ; true
  ;
  ; @return (boolean)
  ([directory-path]
   (delete-empty-directory! directory-path {}))

  ([directory-path {:keys [warn?] :or {warn? true}}]
   (try (if (check/directory-exists?     directory-path)
            (clojure.java.io/delete-file directory-path)
            (throw (Exception. messages/DIRECTORY-DOES-NOT-EXIST-ERROR)))
        (catch Exception e (if warn? (println (str e " \"" directory-path "\"")))))))

(defn empty-directory!
  ; @description
  ; Deletes the files in the directory at the given directory path.
  ;
  ; @param (string) directory-path
  ; @param (map)(opt) options
  ; {:warn? (boolean)(opt)
  ;   If TRUE, prints the error message (if any) to the console.
  ;   Default: true}
  ;
  ; @usage
  ; (empty-directory! "my-directory/my-subdirectory")
  ; =>
  ; true
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
  ; @description
  ; Deletes the directory at the given directory path.
  ;
  ; @param (string) directory-path
  ; @param (map)(opt) options
  ; {:warn? (boolean)(opt)
  ;   If TRUE, prints the error message (if any) to the console.
  ;   Default: true}
  ;
  ; @usage
  ; (delete-directory! "my-directory/my-subdirectory")
  ; =>
  ; true
  ;
  ; @return (boolean)
  ([directory-path]
   (empty-directory! directory-path {}))

  ([directory-path options]
   (empty-directory!        directory-path options)
   (delete-empty-directory! directory-path options)))

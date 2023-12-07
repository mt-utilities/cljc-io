
(ns io.read
    (:require [clojure.java.io]
              [io.check   :as check]
              [io.env     :as env]
              [io.errors  :as errors]
              [io.utils   :as utils]
              [string.api :as string]
              [vector.api :as vector]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn read-resource-file
  ; @description
  ; - Returns the content of the file found on the given resource filepath.
  ; - Resource filepaths are relative to the Java resources directory.
  ;
  ; @param (string) resource-path
  ; @param (map)(opt) options
  ; {:warn? (boolean)(opt)
  ;   If TRUE, the function prints the error message to the console in case of any error.
  ;   Default: true}
  ;
  ; @usage
  ; (read-resource-file "my-directory/my-file.ext")
  ;
  ; @return (string)
  ([resource-path]
   (read-resource-file resource-path {}))

  ([resource-path {:keys [warn?] :or {warn? true}}]
   (try (if-let [resource-url (clojure.java.io/resource resource-path)]
                (slurp resource-url)
                (throw (Exception. errors/RESOURCE-DOES-NOT-EXIST-ERROR)))
        (catch Exception e (if warn? (println (str e " \"" resource-path "\"")))))))

(defn resource-file-list
  ; @description
  ; - Returns with the filenames found on the given resource directory path (non-recursive).
  ; - Resource directory paths are relative to the Java resources directory.
  ;
  ; @param (string) directory-path
  ; @param (map)(opt) options
  ; {:warn? (boolean)(opt)
  ;   If TRUE, the function prints the error message to the console in case of any error.
  ;   Default: true}
  ;
  ; @usage
  ; (resource-file-list "my-directory")
  ;
  ; @example
  ; (resource-file-list "my-directory")
  ; =>
  ; ["my-directory/my-file.ext" ...]
  ;
  ; @return (strings in vector)
  ([directory-path]
   (resource-file-list directory-path {}))

  ([directory-path {:keys [warn?] :or {warn? true}}]
   (try (if-let [resource-url (clojure.java.io/resource directory-path)]
                (let [resource-root-url (env/get-resource-root-url directory-path)
                      directory         (-> resource-url clojure.java.io/file)]
                     (and (-> directory .isDirectory)
                          (let [file-seq (-> directory .listFiles)]
                               (letfn [(f0 [%] (string/not-starts-with! (-> % .toURI .normalize) resource-root-url))]
                                      (utils/file-seq->file-list (str directory-path "/") file-seq {:output-f f0})))))
                (throw (Exception. errors/RESOURCE-DOES-NOT-EXIST-ERROR)))
        (catch Exception e (if warn? (println (str e " \"" directory-path "\"")))))))

(defn all-resource-file-list
  ; @description
  ; - Returns with the filenames found on the given resource directory path (recursive).
  ; - Resource directory paths are relative to the Java resources directory.
  ;
  ; @param (string) directory-path
  ; @param (map)(opt) options
  ; {:warn? (boolean)(opt)
  ;   If TRUE, the function prints the error message to the console in case of any error.
  ;   Default: true}
  ;
  ; @usage
  ; (all-resource-file-list "my-directory")
  ;
  ; @example
  ; (all-resource-file-list "my-directory")
  ; =>
  ; ["my-directory/my-file.ext" ...]
  ;
  ; @return (strings in vector)
  ([directory-path]
   (all-resource-file-list directory-path {}))

  ([directory-path {:keys [warn?] :or {warn? true}}]
   (try (if-let [resource-url (clojure.java.io/resource directory-path)]
                (let [resource-root-url (env/get-resource-root-url directory-path)
                      directory         (-> resource-url clojure.java.io/file)]
                     (and (-> directory .isDirectory)
                          (let [file-seq (-> directory file-seq)]
                               (letfn [(f0 [%] (string/not-starts-with! (-> % .toURI .normalize) resource-root-url))]
                                      (utils/file-seq->file-list (str directory-path "/") file-seq {:output-f f0})))))
                (throw (Exception. errors/RESOURCE-DOES-NOT-EXIST-ERROR)))
        (catch Exception e (if warn? (println (str e " \"" directory-path "\"")))))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn read-file
  ; @description
  ; Returns the content of the file found on the given filepath.
  ;
  ; @param (string) filepath
  ; @param (map)(opt) options
  ; {:warn? (boolean)(opt)
  ;   If TRUE, the function prints the error message to the console in case of any error.
  ;   Default: true}
  ;
  ; @usage
  ; (read-file "my-directory/my-file.ext")
  ;
  ; @return (string)
  ([filepath]
   (read-file filepath {}))

  ([filepath {:keys [warn?] :or {warn? true}}]
   (try (if (check/file-exists? filepath)
            (slurp              filepath)
            (throw (Exception. errors/FILE-DOES-NOT-EXIST-ERROR)))
       (catch Exception e (if warn? (println (str e " \"" filepath "\"")))))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn file-list
  ; @description
  ; Returns with the filenames found on the given directory path (non-recursive).
  ;
  ; @param (string) directory-path
  ; @param (map)(opt) options
  ; {:ignore-hidden? (boolean)(opt)
  ;   Default: false
  ;  :warn? (boolean)(opt)
  ;   If TRUE, the function prints the error message to the console in case of any error.
  ;   Default: true}
  ;
  ; @example
  ; (file-list "my-directory")
  ; =>
  ; ["my-directory/my-file.ext" ...]
  ;
  ; @return (strings in vector)
  ([directory-path]
   (file-list directory-path {}))

  ([directory-path {:keys [ignore-hidden? warn?] :or {warn? true}}]
   ; XXX#7440 (source-code/clj/io/README.md)
   (try (if (check/directory-exists? directory-path)
            (let [file-seq (-> directory-path str clojure.java.io/file .listFiles)]
                 (utils/file-seq->file-list directory-path file-seq {:ignore-hidden? ignore-hidden?}))
            (throw (Exception. errors/DIRECTORY-DOES-NOT-EXIST-ERROR)))
       (catch Exception e (if warn? (println (str e " \"" directory-path "\"")))))))

(defn all-file-list
  ; @description
  ; Returns with the filenames found on the given directory path (recursive).
  ;
  ; @param (string) directory-path
  ; @param (map)(opt) options
  ; {:ignore-hidden? (boolean)(opt)
  ;   Default: false
  ;  :warn? (boolean)(opt)
  ;   If TRUE, the function prints the error message to the console in case of any error.
  ;   Default: true}
  ;
  ; @example
  ; (all-file-list "my-directory")
  ; =>
  ; ["my-directory/my-file.ext" ...]
  ;
  ; @return (strings in vector)
  ([directory-path]
   (all-file-list directory-path {}))

  ([directory-path {:keys [ignore-hidden? warn?] :or {warn? true}}]
   ; XXX#7440 (source-code/clj/io/README.md)
   (try (if (check/directory-exists? directory-path)
            (let [file-seq (-> directory-path str clojure.java.io/file file-seq)]
                 (utils/file-seq->file-list directory-path file-seq {:ignore-hidden? ignore-hidden?}))
            (throw (Exception. errors/DIRECTORY-DOES-NOT-EXIST-ERROR)))
        (catch Exception e (if warn? (println (str e " \"" directory-path "\"")))))))

(defn search-files
  ; @description
  ; Returns with the filenames found on the given search path (recursive) that match the given search pattern.
  ;
  ; @param (string) search-path
  ; @param (string) search-pattern
  ; @param (map)(opt) options
  ; {:ignore-hidden? (boolean)(opt)
  ;   Default: false
  ;  :warn? (boolean)(opt)
  ;   If TRUE, the function prints the error message to the console in case of any error.
  ;   Default: true}
  ;
  ; @example
  ; (search-files "my-directory" #"[a-z\-]{1,20}\.ext")
  ; =>
  ; ["my-directory/my-file.ext" ...]
  ;
  ; @return (strings in vector)
  ([search-path search-pattern]
   (search-files search-path search-pattern {}))

  ([search-path search-pattern {:keys [ignore-hidden? warn?] :or {warn? true}}]
   ; XXX#7440 (source-code/clj/io/README.md)
   (try (if (check/directory-exists? search-path)
            (let [file-seq (-> search-path str clojure.java.io/file file-seq)]
                 (utils/file-seq->file-list search-path file-seq {:ignore-hidden? ignore-hidden? :filter-pattern search-pattern}))
            (throw (Exception. errors/DIRECTORY-DOES-NOT-EXIST-ERROR)))
        (catch Exception e (if warn? (println (str e " \"" search-path "\"")))))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn subdirectory-list
  ; @description
  ; Returns with the subdirectory names found on the given directory path (non-recursive).
  ;
  ; @param (string) directory-path
  ; @param (map)(opt) options
  ; {:ignore-hidden? (boolean)(opt)
  ;   Default: false
  ;  :warn? (boolean)(opt)
  ;   If TRUE, the function prints the error message to the console in case of any error.
  ;   Default: true}
  ;
  ; @example
  ; (subdirectory-list "my-directory")
  ; =>
  ; ["my-directory/my-subdirectory" ...]
  ;
  ; @return (strings in vector)
  ([directory-path]
   (subdirectory-list directory-path {}))

  ([directory-path {:keys [ignore-hidden? warn?] :or {warn? true}}]
   ; XXX#7440 (source-code/clj/io/README.md)
   (try (if (check/directory-exists? directory-path)
            (let [file-seq (-> directory-path str clojure.java.io/file .listFiles)]
                 (utils/file-seq->directory-list directory-path file-seq {:ignore-hidden? ignore-hidden?}))
            (throw (Exception. errors/DIRECTORY-DOES-NOT-EXIST-ERROR)))
        (catch Exception e (if warn? (println (str e " \"" directory-path "\"")))))))

(defn all-subdirectory-list
  ; @description
  ; Returns with the subdirectory names found on the given directory path (recursive).
  ;
  ; @param (string) directory-path
  ; @param (map)(opt) options
  ; {:ignore-hidden? (boolean)(opt)
  ;   Default: false
  ;  :warn? (boolean)(opt)
  ;   If TRUE, the function prints the error message to the console in case of any error.
  ;   Default: true}
  ;
  ; @example
  ; (all-subdirectory-list "my-directory")
  ; =>
  ; ["my-directory/my-subdirectory" ...]
  ;
  ; @return (strings in vector)
  ([directory-path]
   (all-subdirectory-list directory-path {}))

  ([directory-path {:keys [ignore-hidden? warn?] :or {warn? true}}]
   ; XXX#7440 (source-code/clj/io/README.md)
   (try (if (check/directory-exists? directory-path)
            (let [file-seq (-> directory-path str clojure.java.io/file file-seq)]
                 (utils/file-seq->directory-list directory-path file-seq {:ignore-hidden? ignore-hidden?}))
            (throw (Exception. errors/DIRECTORY-DOES-NOT-EXIST-ERROR)))
        (catch Exception e (if warn? (println (str e " \"" directory-path "\"")))))))

(defn search-subdirectories
  ; @description
  ; Returns with the subdirectory names found on the given search path (recursive) that match the given search pattern.
  ;
  ; @param (string) search-path
  ; @param (string) search-pattern
  ; @param (map)(opt) options
  ; {:ignore-hidden? (boolean)(opt)
  ;   Default: false
  ;  :warn? (boolean)(opt)
  ;   If TRUE, the function prints the error message to the console in case of any error.
  ;   Default: true}
  ;
  ; @example
  ; (search-subdirectories "my-directory" #"[a-z\-]{1,20}")
  ; =>
  ; ["my-directory/my-subdirectory" ...]
  ;
  ; @return (strings in vector)
  ([search-path search-pattern]
   (search-subdirectories search-path search-pattern {}))

  ([search-path search-pattern {:keys [ignore-hidden? warn?] :or {warn? true}}]
   ; XXX#7440 (source-code/clj/io/README.md)
   (try (if (check/directory-exists? search-path)
            (let [file-seq (-> search-path str clojure.java.io/file file-seq)]
                 (utils/file-seq->directory-list search-path file-seq {:ignore-hidden? ignore-hidden? :filter-pattern search-pattern}))
            (throw (Exception. errors/DIRECTORY-DOES-NOT-EXIST-ERROR)))
        (catch Exception e (if warn? (println (str e " \"" search-path "\"")))))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn item-list
  ; @description
  ; Returns with the subdirectory names and filenames found on the given directory path (non-recursive).
  ;
  ; @param (string) directory-path
  ; @param (map)(opt) options
  ; {:ignore-hidden? (boolean)(opt)
  ;   Default: false
  ;  :warn? (boolean)(opt)
  ;   If TRUE, the function prints the error message to the console in case of any error.
  ;   Default: true}
  ;
  ; @example
  ; (item-list "my-directory")
  ; =>
  ; ["my-directory/my-subdirectory" "my-directory/my-subdirectory/my-file.ext" ...]
  ;
  ; @return (strings in vector)
  ([directory-path]
   (item-list directory-path {}))

  ([directory-path {:keys [ignore-hidden? warn?] :or {warn? true}}]
   ; XXX#7440 (source-code/clj/io/README.md)
   (try (if (check/directory-exists? directory-path)
            (let [file-seq (-> directory-path str clojure.java.io/file .listFiles)]
                 (utils/file-seq->item-list directory-path file-seq {:ignore-hidden? ignore-hidden?}))
            (throw (Exception. errors/DIRECTORY-DOES-NOT-EXIST-ERROR)))
        (catch Exception e (if warn? (println (str e " \"" directory-path "\"")))))))

(defn all-item-list
  ; @description
  ; Returns with the subdirectory names and filenames found on the given directory path (recursive).
  ;
  ; @param (string) directory-path
  ; @param (map)(opt) options
  ; {:ignore-hidden? (boolean)(opt)
  ;   Default: false
  ;  :warn? (boolean)(opt)
  ;   If TRUE, the function prints the error message to the console in case of any error.
  ;   Default: true}
  ;
  ; @example
  ; (all-item-list "my-directory")
  ; =>
  ; ["my-directory/my-subdirectory" "my-directory/my-subdirectory/my-file.ext" ...]
  ;
  ; @return (strings in vector)
  ([directory-path]
   (all-item-list directory-path {}))

  ([directory-path {:keys [ignore-hidden? warn?] :or {warn? true}}]
   ; XXX#7440 (source-code/clj/io/README.md)
   (try (if (check/directory-exists? directory-path)
            (let [file-seq (-> directory-path str clojure.java.io/file file-seq)]
                 (utils/file-seq->item-list directory-path file-seq {:ignore-hidden? ignore-hidden?}))
            (throw (Exception. errors/DIRECTORY-DOES-NOT-EXIST-ERROR)))
        (catch Exception e (if warn? (println (str e " \"" directory-path "\"")))))))

(defn search-items
  ; @description
  ; Returns with the subdirectory names and filenames found on the given search path (recursive) that match the given search pattern.
  ;
  ; @param (string) search-path
  ; @param (string) search-pattern
  ; @param (map)(opt) options
  ; {:ignore-hidden? (boolean)(opt)
  ;   Default: false
  ;  :warn? (boolean)(opt)
  ;   If TRUE, the function prints the error message to the console in case of any error.
  ;   Default: true}
  ;
  ; @example
  ; (search-items "my-directory" #"[a-z\-\.]{1,20}")
  ; =>
  ; ["my-directory/my-subdirectory" "my-directory/my-file.ext" ...]
  ;
  ; @return (strings in vector)
  ([search-path search-pattern]
   (search-items search-path search-pattern {}))

  ([search-path search-pattern {:keys [ignore-hidden? warn?] :or {warn? true}}]
   ; XXX#7440 (source-code/clj/io/README.md)
   (try (if (check/directory-exists? search-path)
            (let [file-seq (-> search-path str clojure.java.io/file file-seq)]
                 (utils/file-seq->item-list search-path file-seq {:ignore-hidden? ignore-hidden? :filter-pattern search-pattern}))
            (throw (Exception. errors/DIRECTORY-DOES-NOT-EXIST-ERROR)))
        (catch Exception e (if warn? (println (str e " \"" search-path "\"")))))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn empty-directory?
  ; @description
  ; Returns TRUE if the given directory path is empty.
  ;
  ; @param (string) directory-path
  ; @param (map)(opt) options
  ; {:ignore-hidden? (boolean)(opt)
  ;   Default: false
  ;  :warn? (boolean)(opt)
  ;   If TRUE, the function prints the error message to the console in case of any error.
  ;   Default: true}
  ;
  ; @usage
  ; (empty-directory? "my-directory/my-subdirectory")
  ;
  ; @return (boolean)
  ([directory-path]
   (empty-directory? directory-path {}))

  ([directory-path options]
   (-> directory-path (item-list options) empty?)))

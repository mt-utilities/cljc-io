
(ns io.check
    (:require [clojure.java.io]
              [iso.io.check :as check]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; iso.io.check
(def filename-valid?         check/filename-valid?)
(def filename-invalid?       check/filename-invalid?)
(def directory-name-valid?   check/directory-name-valid?)
(def directory-name-invalid? check/directory-name-invalid?)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn file-exists?
  ; @description
  ; Checks whether the file exists on the given filepath.
  ;
  ; @param (string) filepath
  ;
  ; @usage
  ; (file-exists? "my-directory/my-file.ext")
  ;
  ; @return (boolean)
  [filepath]
  ; XXX#7440 (source-code/clj/io/README.md)
  (let [file (-> filepath str clojure.java.io/file)]
       (and (-> file .exists)
            (-> file .isDirectory not))))

(defn file-not-exists?
  ; @description
  ; Checks whether the file does not exist on the given filepath.
  ;
  ; @param (string) filepath
  ;
  ; @usage
  ; (file-not-exists? "my-directory/my-file.ext")
  ;
  ; @return (boolean)
  [filepath]
  ; XXX#7440 (source-code/clj/io/README.md)
  (let [file (-> filepath str clojure.java.io/file)]
       (or (-> file .extists not)
           (-> file .isDirectory))))

(defn file?
  ; @description
  ; Checks whether the file exists on the given filepath.
  ;
  ; @param (string) filepath
  ;
  ; @usage
  ; (file-exists? "my-directory/my-file.ext")
  ;
  ; @return (boolean)
  [filepath]
  (file-exists? filepath))

(defn directory-exists?
  ; @description
  ; Checks whether the directory exists on the given path.
  ;
  ; @param (string) directory-path
  ;
  ; @usage
  ; (directory-exists? "my-directory/my-subdirectory")
  ;
  ; @return (boolean)
  [directory-path]
  ; XXX#7440 (source-code/clj/io/README.md)
  (let [directory (-> directory-path str clojure.java.io/file)]
       (and (-> directory .exists)
            (-> directory .isDirectory))))

(defn directory-not-exists?
  ; @description
  ; Checks whether the directory does not exist on the given path.
  ;
  ; @param (string) directory-path
  ;
  ; @usage
  ; (directory-not-exists? "my-directory/my-subdirectory")
  ;
  ; @return (boolean)
  [directory-path]
  ; XXX#7440 (source-code/clj/io/README.md)
  (let [directory (-> directory-path str clojure.java.io/file)]
       (or (-> directory .exists      not)
           (-> directory .isDirectory not))))

(defn directory?
  ; @description
  ; Checks whether the directory exists on the given path.
  ;
  ; @param (string) directory-path
  ;
  ; @usage
  ; (directory-exists? "my-directory/my-subdirectory")
  ;
  ; @return (boolean)
  [directory-path]
  (directory-exists? directory-path))


(ns io.check
    (:require [clojure.java.io]))

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
  (let [file (-> filepath str clojure.java.io/file)]
       (or (-> file .extists not)
           (-> file .isDirectory))))

(defn directory?
  ; @description
  ; Checks whether a directory exists on the given filepath.
  ;
  ; @param (string) directory-path
  ;
  ; @usage
  ; (directory? "my-directory/my-subdirectory")
  ;
  ; @return (boolean)
  [directory-path]
  (-> directory-path str clojure.java.io/file .isDirectory))

(defn directory-exists?
  ; @description
  ; Checks whether the directory exists on the given filepath.
  ;
  ; @param (string) directory-path
  ;
  ; @usage
  ; (directory-exists? "my-directory/my-subdirectory")
  ;
  ; @return (boolean)
  [directory-path]
  (let [directory (-> directory-path str clojure.java.io/file)]
       (and (.exists      directory)
            (.isDirectory directory))))

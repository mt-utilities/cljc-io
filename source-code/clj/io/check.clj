
(ns io.check
    (:require [clojure.java.io]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn file-exists?
  ; @param (string) filepath
  ;
  ; @usage
  ;  (file-exists? "my-directory/my-file.ext")
  ;
  ; @return (boolean)
  [filepath]
  (let [file (clojure.java.io/file filepath)]
       (and (-> file .exists)
            (-> file .isDirectory not))))

(defn file-not-exists?
  ; @param (string) filepath
  ;
  ; @usage
  ;  (file-not-exists? "my-directory/my-file.ext")
  ;
  ; @return (boolean)
  [filepath]
  (let [file (clojure.java.io/file filepath)]
       (or (-> file .extists not)
           (-> file .isDirectory))))

(defn directory?
  ; @param (string) directory-path
  ;
  ; @usage
  ;  (directory? "my-directory/my-subdirectory")
  ;
  ; @return (boolean)
  [directory-path]
  (-> directory-path clojure.java.io/file .isDirectory))

(defn directory-exists?
  ; @param (string) directory-path
  ;
  ; @usage
  ;  (directory-exists? "my-directory/my-subdirectory")
  ;
  ; @return (boolean)
  [directory-path]
  (let [directory (clojure.java.io/file directory-path)]
       (and (.exists      directory)
            (.isDirectory directory))))

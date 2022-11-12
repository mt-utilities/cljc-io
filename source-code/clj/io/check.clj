
(ns io.check
    (:require [clojure.java.io]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn file-exists?
  ; @param (string) filepath
  ;
  ; @return (boolean)
  [filepath]
  (let [file (clojure.java.io/file filepath)]
       (and (-> file .exists)
            (-> file .isDirectory not))))

(defn file-not-exists?
  ; @param (string) filepath
  ;
  ; @return (boolean)
  [filepath]
  (let [file (clojure.java.io/file filepath)]
       (or (-> file .extists not)
           (-> file .isDirectory))))

(defn directory?
  ; @param (string) directory-path
  ;
  ; @return (boolean)
  [directory-path]
  (-> directory-path clojure.java.io/file .isDirectory))

(defn directory-exists?
  ; @param (string) directory-path
  ;
  ; @return (boolean)
  [directory-path]
  (let [directory (clojure.java.io/file directory-path)]
       (and (.exists      directory)
            (.isDirectory directory))))


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

(defn resource-file-exists?
  ; @description
  ; Checks whether the resource file exists on the given resource path.
  ;
  ; @param (string) resource-path
  ;
  ; @usage
  ; (resource-file-exists? "my-directory/my-file.ext")
  ;
  ; @return (boolean)
  [resource-path]
  (if-let [resource-url (clojure.java.io/resource resource-path)]
          (-> resource-url clojure.java.io/file .isFile)))

(defn resource-file-not-exists?
  ; @description
  ; Checks whether the resource file does not exist on the given resource path.
  ;
  ; @param (string) resource-path
  ;
  ; @usage
  ; (resource-file-not-exists? "my-directory/my-file.ext")
  ;
  ; @return (boolean)
  [resource-path]
  (if-let [resource-url (clojure.java.io/resource resource-path)]
          (-> resource-url clojure.java.io/file .isFile not)))

(defn resource-file?
  ; @description
  ; Checks whether the resource file exists on the given resource path.
  ;
  ; @param (string) resource-path
  ;
  ; @usage
  ; (resource-file? "my-directory/my-file.ext")
  ;
  ; @return (boolean)
  [resource-path]
  (resource-file-exists? resource-path))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn resource-directory-exists?
  ; @description
  ; Checks whether the resource directory exists on the given resource path.
  ;
  ; @param (string) resource-path
  ;
  ; @usage
  ; (resource-directory-exists? "my-directory")
  ;
  ; @return (boolean)
  [resource-path]
  (if-let [resource-url (clojure.java.io/resource resource-path)]
          (-> resource-url clojure.java.io/file .isDirectory)))

(defn resource-directory-not-exists?
  ; @description
  ; Checks whether the resource directory does not exist on the given resource path.
  ;
  ; @param (string) resource-path
  ;
  ; @usage
  ; (resource-directory-not-exists? "my-directory")
  ;
  ; @return (boolean)
  [resource-path]
  (if-let [resource-url (clojure.java.io/resource resource-path)]
          (-> resource-url clojure.java.io/file .isDirectory not)))

(defn resource-directory?
  ; @description
  ; Checks whether the resource directory exists on the given resource path.
  ;
  ; @param (string) resource-path
  ;
  ; @usage
  ; (resource-directory? "my-directory")
  ;
  ; @return (boolean)
  [resource-path]
  (resource-directory-exists? resource-path))

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
  ; (file? "my-directory/my-file.ext")
  ;
  ; @return (boolean)
  [filepath]
  (file-exists? filepath))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

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
  ; (directory? "my-directory/my-subdirectory")
  ;
  ; @return (boolean)
  [directory-path]
  (directory-exists? directory-path))

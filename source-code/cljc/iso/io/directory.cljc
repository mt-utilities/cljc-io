
(ns iso.io.directory
    (:require [fruits.string.api :as string]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn directory-path->directory-name
  ; @description
  ; Returns the direction name from the given directory path.
  ;
  ; @param (string) directory-path
  ;
  ; @usage
  ; (directory-path->directory-name "my-directory/my-subdirectory")
  ; =>
  ; "my-subdirectory"
  ;
  ; @return (string)
  [directory-path]
  (if-let [directory-name (string/after-last-occurence directory-path "/")]
          (-> directory-name)
          (-> directory-path)))

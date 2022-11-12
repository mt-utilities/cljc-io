
(ns io.directory
    (:require [candy.api         :refer [return]]
              [mid-fruits.string :as string]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn directory-path->directory-name
  ; @param (string) directory-path
  ;
  ; @example
  ;  (directory-path->directory-name "a/b")
  ;  =>
  ;  "b"
  ;
  ; @return (string)
  [directory-path]
  (if-let [directory-name (string/after-last-occurence directory-path "/")]
          (return directory-name)
          (return directory-path)))

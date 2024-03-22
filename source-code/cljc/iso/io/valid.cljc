
(ns iso.io.valid
    (:require [fruits.string.api :as string]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn valid-relative-path
  ; @description
  ; Ensures that the leading and trailing slashes are used correctly in the given relative path.
  ;
  ; @param (string) n
  ;
  ; @usage
  ; (valid-relative-path "/my-directory")
  ; =>
  ; "/my-directory"
  ;
  ; @usage
  ; (valid-relative-path "my-directory/")
  ; =>
  ; "/my-directory"
  ;
  ; @usage
  ; (valid-relative-path "")
  ; =>
  ; "/"
  ;
  ; @return (string)
  [n]
  (-> n (string/not-end-with "/")
        (string/start-with   "/")))

(defn valid-absolute-path
  ; @description
  ; Ensures that the leading and trailing slashes are used correctly in the given absolute path.
  ;
  ; @param (string) n
  ;
  ; @usage
  ; (valid-absolute-path "my-directory")
  ; =>
  ; "my-directory"
  ;
  ; @usage
  ; (valid-absolute-path "/my-directory/")
  ; =>
  ; "my-directory"
  ;
  ; @usage
  ; (valid-absolute-path "")
  ; =>
  ; ""
  ;
  ; @return (string)
  [n]
  (-> n (string/not-end-with   "/")
        (string/not-start-with "/")))

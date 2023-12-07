
(ns iso.io.valid
    (:require [fruits.string.api :as string]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn valid-relative-path
  ; @param (string) n
  ;
  ; @usage
  ; (valid-relative-path "/my-directory")
  ;
  ; @example
  ; (valid-relative-path "/my-directory")
  ; =>
  ; "/my-directory"
  ;
  ; @example
  ; (valid-relative-path "my-directory/")
  ; =>
  ; "/my-directory"
  ;
  ; @example
  ; (valid-relative-path "")
  ; =>
  ; "/"
  ;
  ; @return (string)
  [n]
  (-> n (string/not-ends-with! "/")
        (string/starts-with!   "/")))

(defn valid-absolute-path
  ; @param (string) n
  ;
  ; @usage
  ; (valid-absolute-path "my-directory")
  ;
  ; @example
  ; (valid-absolute-path "my-directory")
  ; =>
  ; "my-directory"
  ;
  ; @example
  ; (valid-absolute-path "/my-directory/")
  ; =>
  ; "my-directory"
  ;
  ; @example
  ; (valid-absolute-path "")
  ; =>
  ; ""
  ;
  ; @return (string)
  [n]
  (-> n (string/not-ends-with!   "/")
        (string/not-starts-with! "/")))

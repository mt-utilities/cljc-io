
(ns io.validators
    (:require [io.config :as config]
              [regex.api :refer [re-match? re-mismatch?]]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn filename-valid?
  ; @param (string) filename
  ;
  ; @example
  ; (filename-valid? "my-file.ext")
  ; =>
  ; true
  ;
  ; @example
  ; (filename-valid? "my-directory/my-file.ext")
  ; =>
  ; false
  ;
  ; @return (boolean)
  [filename]
  (re-match? filename config/FILENAME-PATTERN))

(defn filename-invalid?
  ; @param (string) filename
  ;
  ; @example
  ; (filename-invalid? "my-file.ext")
  ; =>
  ; false
  ;
  ; @example
  ; (filename-invalid? "my-directory/my-file.ext")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [filename]
  (re-mismatch? filename config/FILENAME-PATTERN))

(defn directory-name-valid?
  ; @param (string) directory-name
  ;
  ; @example
  ; (directory-name-valid? "my-directory")
  ; =>
  ; true
  ;
  ; @example
  ; (directory-name-valid? "my-directory/my-subdirectory")
  ; =>
  ; false
  ;
  ; @return (boolean)
  [directory-name]
  (re-match? directory-name config/DIRECTORY-NAME-PATTERN))

(defn directory-name-invalid?
  ; @param (string) directory-name
  ;
  ; @example
  ; (directory-name-invalid? "my-directory")
  ; =>
  ; false
  ;
  ; @example
  ; (directory-name-invalid? "my-directory/my-subdirectory")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [directory-name]
  (re-mismatch? directory-name config/DIRECTORY-NAME-PATTERN))

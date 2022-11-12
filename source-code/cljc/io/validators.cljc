
(ns io.validators
    (:require [io.config :as config]
              [regex.api :refer [re-match? re-mismatch?]]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn filename-valid?
  ; @param (string) filename
  ;
  ; @return (boolean)
  [filename]
  (re-match? filename config/FILENAME-PATTERN))

(defn filename-invalid?
  ; @param (string) filename
  ;
  ; @return (boolean)
  [filename]
  (re-mismatch? filename config/FILENAME-PATTERN))

(defn directory-name-valid?
  ; @param (string) directory-name
  ;
  ; @return (boolean)
  [directory-name]
  (re-match? directory-name config/DIRECTORY-NAME-PATTERN))

(defn directory-name-invalid?
  ; @param (string) directory-name
  ;
  ; @return (boolean)
  [directory-name]
  (re-mismatch? directory-name config/DIRECTORY-NAME-PATTERN))

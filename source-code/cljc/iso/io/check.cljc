
(ns iso.io.check
    (:require [fruits.regex.api :refer [re-match? re-mismatch?]]
              [iso.io.config    :as config]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn filename-valid?
  ; @param (string) filename
  ;
  ; @usage
  ; (filename-valid? "my-file.ext")
  ; =>
  ; true
  ;
  ; @usage
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
  ; @usage
  ; (filename-invalid? "my-file.ext")
  ; =>
  ; false
  ;
  ; @usage
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
  ; @usage
  ; (directory-name-valid? "my-directory")
  ; =>
  ; true
  ;
  ; @usage
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
  ; @usage
  ; (directory-name-invalid? "my-directory")
  ; =>
  ; false
  ;
  ; @usage
  ; (directory-name-invalid? "my-directory/my-subdirectory")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [directory-name]
  (re-mismatch? directory-name config/DIRECTORY-NAME-PATTERN))

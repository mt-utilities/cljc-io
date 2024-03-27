
(ns iso.io.check
    (:require [fruits.regex.api :refer [re-match? re-mismatch?]]
              [iso.io.config    :as config]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn filename-valid?
  ; @description
  ; Returns TRUE if the given filename does not contain any illegal character.
  ;
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
  (-> filename (re-match? config/FILENAME-PATTERN)))

(defn filename-invalid?
  ; @description
  ; Returns TRUE if the given filename contains any illegal character.
  ;
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
  (-> filename (re-mismatch? config/FILENAME-PATTERN)))

(defn directory-name-valid?
  ; @description
  ; Returns TRUE if the given directory name does not contain any illegal character.
  ;
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
  (-> directory-name (re-match? config/DIRECTORY-NAME-PATTERN)))

(defn directory-name-invalid?
  ; @description
  ; Returns TRUE if the given directory name contains any illegal character.
  ;
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
  (-> directory-name (re-mismatch? config/DIRECTORY-NAME-PATTERN)))

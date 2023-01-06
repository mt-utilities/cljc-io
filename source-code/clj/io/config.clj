
(ns io.config
    (:require [iso.io.config :as config]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; iso.io.config
(def FILENAME-PATTERN       config/FILENAME-PATTERN)
(def DIRECTORY-NAME-PATTERN config/DIRECTORY-NAME-PATTERN)
(def MAX-FILENAME-LENGTH    config/MAX-FILENAME-LENGTH)
(def MIME-TYPES             config/MIME-TYPES)
(def EXTENSIONS             config/EXTENSIONS)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; The directory- and filenames has to be printed between quotes, otherwise it might
; be hard to recognize the printed NIL values.

; @constant (string)
(def RESOURCE-DOES-NOT-EXIST-ERROR "Resource does not exist:")

; @constant (string)
(def FILE-DOES-NOT-EXIST-ERROR "File does not exist:")

; @constant (string)
(def DIRECTORY-DOES-NOT-EXIST-ERROR "Directory does not exist:")

; @constant (string)
(def CREATE-FILE-MESSAGE "Creating file:")

; @constant (string)
(def CREATE-DIRECTORY-MESSAGE "Creating directory:")

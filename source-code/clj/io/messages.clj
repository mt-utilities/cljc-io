
(ns io.messages)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; Directory names and filenames must be printed between quotes, otherwise it might
; be hard to recognize printed NIL values.

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @ignore
;
; @constant (string)
(def RESOURCE-DOES-NOT-EXIST-ERROR "Resource does not exist:")

; @ignore
;
; @constant (string)
(def FILE-DOES-NOT-EXIST-ERROR "File does not exist:")

; @ignore
;
; @constant (string)
(def DIRECTORY-DOES-NOT-EXIST-ERROR "Directory does not exist:")

; @ignore
;
; @constant (string)
(def CREATE-FILE-MESSAGE "Creating file:")

; @ignore
;
; @constant (string)
(def CREATE-DIRECTORY-MESSAGE "Creating directory:")

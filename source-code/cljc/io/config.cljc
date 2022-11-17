
(ns io.config
    (:require [map.api :as map]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; A hibaüzenetek kiírásakor a fájlok/mappák neveit idézőjelek között szükséges
; kiírni, hogy a nil értékű nevek is egyértelműen felismerhetők legyenek!

; @constant (string)
(def FILE-DOES-NOT-EXIST-ERROR "File does not exist:")

; @constant (string)
(def DIRECTORY-DOES-NOT-EXIST-ERROR "Directory does not exist:")

; @constant (string)
;  Ha a swap-edn-file! függvény egy nem létező fájl tartalmát próbálja beolvasni,
;  akkor megjelenik a FILE-DOES-NOT-EXIST-ERROR hibaüzenet, majd ezután a tartalom
;  fájlba írásakor, amikor létrejön az addig nem létező fájl megjelenik a CREATE-FILE-MESSAGE
;  üzenet, így egyértelmű, hogy a FILE-DOES-NOT-EXIST-ERROR hibaüzenet ignorálható,
;  mivel az addig hiányzó fájl létrehozása megtörtént.
(def CREATE-FILE-MESSAGE "Creating file:")

; @constant (string)
(def CREATE-DIRECTORY-MESSAGE "Creating directory:")

; @constant (string)
(def FILENAME-PATTERN       #"^[a-zA-Z0-9àèìòùÀÈÌÒÙáéíóúýÁÉÍÓÚÝâêîôûÂÊÎÔÛãñõÃÑÕäëïöüÿÄËÏÖÜŸçÇßØøÅåÆæœ._ \-#()?!+%=]+$")

; @constant (string)
(def DIRECTORY-NAME-PATTERN #"^[a-zA-Z0-9àèìòùÀÈÌÒÙáéíóúýÁÉÍÓÚÝâêîôûÂÊÎÔÛãñõÃÑÕäëïöüÿÄËÏÖÜŸçÇßØøÅåÆæœ._ \-#()?!+%=]+$")

; @constant (integer)
(def MAX-FILENAME-LENGTH 32)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @constant (map)
(def MIME-TYPES {"aac"  "audio/aac"
                 "avi"  "video/x-msvideo"
                 "bin"  "application/octet-stream"
                 "bmp"  "image/bmp"
                 "bz"   "application/x-bzip"
                 "bz2"  "application/x-bzip2"
                 "css"  "text/css"
                 "doc"  "application/msword"
                 "docx" "application/vnd.openxmlformats-officedocument.wordprocessingml.document"
                 "gif"  "image/gif"
                 "htm"  "text/html"
                 "html" "text/html"
                 "ico"  "image/vnd.microsoft.icon"
                 "jar"  "application/java-archive"
                 "jpg"  "image/jpeg"
                 "jpeg" "image/jpeg"
                 "js"   "text/javascript"
                 "mpeg" "video/mpeg"
                 "mp3"  "audio/mpeg"
                 "mp4"  "video/mp4"
                 "m4a"  "audio/m4a"
                 "m4v"  "video/mp4"
                 "odp"  "application/vnd.oasis.opendocument.presentation"
                 "ods"  "application/vnd.oasis.opendocument.spreadsheet"
                 "odt"  "application/vnd.oasis.opendocument.text"
                 "otf"  "font/otf"
                 "png"  "image/png"
                 "pdf"  "application/pdf"
                 "ppt"  "application/vnd.ms-powerpoint"
                 "rar"  "application/x-rar-compressed"
                 "rtf"  "application/rtf"
                 "svg"  "image/svg+xml"
                 "tar"  "application/x-tar"
                 "tif"  "image/tiff"
                 "tiff" "image/tiff"
                 "ttf"  "font/ttf"
                 "txt"  "text/plain"
                 "wav"  "audio/wav"
                 "weba" "audio/webm"
                 "webm" "video/webm"
                 "webp" "image/webp"
                 "xml"  "text/xml"
                 "xls"  "application/vnd.ms-excel"
                 "xlsx" "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
                 "zip"  "application/zip"
                 "7z"   "application/x-7z-compressed"})

; @constant (map)
(def EXTENSIONS (map/swap MIME-TYPES))

; @constant (strings in vector)
;  A rendszer által ismert képformátumok. A lista tetszés szerint bővíthető.
(def IMAGE-EXTENSIONS ["bmp" "gif" "jpg" "jpeg" "png" "tif" "tiff" "webp"])

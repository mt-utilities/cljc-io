
(ns iso.io.config
    (:require [map.api :as map]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @constant (string)
(def FILENAME-PATTERN #"^[a-zA-Z0-9àèìòùÀÈÌÒÙáéíóúýÁÉÍÓÚÝâêîôûÂÊÎÔÛãñõÃÑÕäëïöüÿÄËÏÖÜŸçÇßØøÅåÆæœ._ \-#()?!+%=]+$")

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


(ns iso.io.config)

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
; {"my-extension" (string)}
;
; @usage
; (get MIME-TYPES "jpeg")
; =>
; "image/jpeg"
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
; {"my-mime-type" (string)}
;
; @usage
; (get EXTENSIONS "image/jpeg")
; =>
; "jpeg"
(def EXTENSIONS {"audio/aac"                                                               "aac"
                 "video/x-msvideo"                                                         "avi"
                 "application/octet-stream"                                                "bin"
                 "image/bmp"                                                               "bmp"
                 "application/x-bzip"                                                      "bz"
                 "application/x-bzip2"                                                     "bz2"
                 "text/css"                                                                "css"
                 "application/msword"                                                      "doc"
                 "application/vnd.openxmlformats-officedocument.wordprocessingml.document" "docx"
                 "image/gif"                                                               "gif"
                ;"text/html"                                                               "htm"
                 "text/html"                                                               "html"
                 "image/vnd.microsoft.icon"                                                "ico"
                 "application/java-archive"                                                "jar"
                ;"image/jpeg"                                                              "jpg"
                 "image/jpeg"                                                              "jpeg"
                 "text/javascript"                                                         "js"
                 "video/mpeg"                                                              "mpeg"
                 "audio/mpeg"                                                              "mp3"
                 "video/mp4"                                                               "mp4"
                 "audio/m4a"                                                               "m4a"
                ;"video/mp4"                                                               "m4v"
                 "application/vnd.oasis.opendocument.presentation"                         "odp"
                 "application/vnd.oasis.opendocument.spreadsheet"                          "ods"
                 "application/vnd.oasis.opendocument.text"                                 "odt"
                 "font/otf"                                                                "otf"
                 "image/png"                                                               "png"
                 "application/pdf"                                                         "pdf"
                 "application/vnd.ms-powerpoint"                                           "ppt"
                 "application/x-rar-compressed"                                            "rar"
                 "application/rtf"                                                         "rtf"
                 "image/svg+xml"                                                           "svg"
                 "application/x-tar"                                                       "tar"
                ;"image/tiff"                                                              "tif"
                 "image/tiff"                                                              "tiff"
                 "font/ttf"                                                                "ttf"
                 "text/plain"                                                              "txt"
                 "audio/wav"                                                               "wav"
                 "audio/webm"                                                              "weba"
                 "video/webm"                                                              "webm"
                 "image/webp"                                                              "webp"
                 "text/xml"                                                                "xml"
                 "application/vnd.ms-excel"                                                "xls"
                 "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"       "xlsx"
                 "application/zip"                                                         "zip"
                 "application/x-7z-compressed"                                             "7z"})

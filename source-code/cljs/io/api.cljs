
(ns io.api
    (:require [io.base64     :as base64]
              [io.blob       :as blob]
              [io.directory  :as directory]
              [io.file       :as file]
              [io.filesize   :as filesize]
              [io.mime-type  :as mime-type]
              [io.valid      :as valid]
              [iso.io.check  :as check]
              [iso.io.config :as config]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @redirect (io.base64/*)
(def base64->blob base64/base64->blob)

; @redirect (io.blob/*)
(def blob->object-url blob/blob->object-url)

; @redirect (iso.io.check/*)
(def filename-valid?         check/filename-valid?)
(def filename-invalid?       check/filename-invalid?)
(def directory-name-valid?   check/directory-name-valid?)
(def directory-name-invalid? check/directory-name-invalid?)

; @redirect (iso.io.config/*)
(def MIME-TYPES config/MIME-TYPES)
(def EXTENSIONS config/EXTENSIONS)

; @redirect (io.directory/*)
(def directory-path->directory-name directory/directory-path->directory-name)

; @redirect (io.file/*)
(def extension->audio?        file/extension->audio?)
(def extension->image?        file/extension->image?)
(def extension->text?         file/extension->text?)
(def extension->video?        file/extension->video?)
(def item-path->parent-path   file/item-path->parent-path)
(def filepath->directory-path file/filepath->directory-path)
(def filepath->filename       file/filepath->filename)
(def filepath->extension      file/filepath->extension)
(def filename->extension      file/filename->extension)
(def filename->basename       file/filename->basename)
(def filepath->basename       file/filepath->basename)
(def filepath->mime-type      file/filepath->mime-type)
(def filename->mime-type      file/filename->mime-type)
(def filepath->audio?         file/filepath->audio?)
(def filepath->image?         file/filepath->image?)
(def filepath->text?          file/filepath->text?)
(def filepath->video?         file/filepath->video?)
(def filename->audio?         file/filename->audio?)
(def filename->image?         file/filename->image?)
(def filename->text?          file/filename->text?)
(def filename->video?         file/filename->video?)

; @redirect (io.filesize/*)
(def B->kB  filesize/B->kB)
(def B->MB  filesize/B->MB)
(def B->GB  filesize/B->GB)
(def kB->B  filesize/kB->B)
(def kB->MB filesize/kB->MB)
(def kB->GB filesize/kB->GB)
(def MB->B  filesize/MB->B)
(def MB->kB filesize/MB->kB)
(def MB->GB filesize/MB->GB)
(def GB->B  filesize/GB->B)
(def GB->kB filesize/GB->kB)
(def GB->MB filesize/GB->MB)

; @redirect (io.mime-type/*)
(def mime-type->extension mime-type/mime-type->extension)
(def extension->mime-type mime-type/extension->mime-type)
(def unknown-mime-type?   mime-type/unknown-mime-type?)
(def mime-type->image?    mime-type/mime-type->image?)

; @redirect (io.valid/*)
(def valid-relative-path valid/valid-relative-path)
(def valid-absolute-path valid/valid-absolute-path)

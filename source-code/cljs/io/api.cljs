
(ns io.api
    (:require [io.config     :as config]
              [io.directory  :as directory]
              [io.file       :as file]
              [io.filesize   :as filesize]
              [io.mime-type  :as mime-type]
              [io.validators :as validators]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; io.config
(def MIME-TYPES config/MIME-TYPES)
(def EXTENSIONS config/EXTENSIONS)

; io.directory
(def directory-path->directory-name directory/directory-path->directory-name)

; io.file
(def extension->audio?        file/extension->audio?)
(def extension->image?        file/extension->image?)
(def extension->text?         file/extension->text?)
(def extension->video?        file/extension->video?)
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


; io.filesize
(def B->KB  filesize/B->KB)
(def B->MB  filesize/B->MB)
(def B->GB  filesize/B->GB)
(def KB->B  filesize/KB->B)
(def KB->MB filesize/KB->MB)
(def KB->GB filesize/KB->GB)
(def MB->B  filesize/MB->B)
(def MB->KB filesize/MB->KB)
(def MB->GB filesize/MB->GB)

; io.mime-type
(def mime-type->extension mime-type/mime-type->extension)
(def extension->mime-type mime-type/extension->mime-type)
(def unknown-mime-type?   mime-type/unknown-mime-type?)
(def mime-type->image?    mime-type/mime-type->image?)

; io.validators
(def filename-valid?         validators/filename-valid?)
(def filename-invalid?       validators/filename-invalid?)
(def directory-name-valid?   validators/directory-name-valid?)
(def directory-name-invalid? validators/directory-name-invalid?)

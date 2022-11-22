
(ns io.api
    (:require [clojure.java.io]
              [io.actions    :as actions]
              [io.check      :as check]
              [io.config     :as config]
              [io.directory  :as directory]
              [io.edn        :as edn]
              [io.file       :as file]
              [io.filesize   :as filesize]
              [io.mime-type  :as mime-type]
              [io.read       :as read]
              [io.size       :as size]
              [io.validators :as validators]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; clojure.java.io
(def file          clojure.java.io/file)
(def input-stream  clojure.java.io/input-stream)
(def output-stream clojure.java.io/output-stream)

; io.actions
(def create-directory!       actions/create-directory!)
(def create-file!            actions/create-file!)
(def delete-file!            actions/delete-file!)
(def copy-file!              actions/copy-file!)
(def write-file!             actions/write-file!)
(def append-to-file!         actions/append-to-file!)
(def prepend-to-file!        actions/prepend-to-file!)
(def copy-uri-to-file!       actions/copy-uri-to-file!)
(def delete-empty-directory! actions/delete-empty-directory!)
(def empty-directory!        actions/empty-directory!)
(def delete-directory!       actions/delete-directory!)

; io.check
(def file-exists?      check/file-exists?)
(def file-not-exists?  check/file-not-exists?)
(def directory?        check/directory?)
(def directory-exists? check/directory-exists?)

; io.config
(def MIME-TYPES config/MIME-TYPES)
(def EXTENSIONS config/EXTENSIONS)

; io.directory
(def directory-path->directory-name directory/directory-path->directory-name)

; io.edn
(def write-edn-file! edn/write-edn-file!)
(def read-edn-file   edn/read-edn-file)
(def swap-edn-file!  edn/swap-edn-file!)

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

; io.read
(def read-file             read/read-file)
(def file-list             read/file-list)
(def all-file-list         read/all-file-list)
(def subdirectory-list     read/subdirectory-list)
(def all-subdirectory-list read/all-subdirectory-list)
(def item-list             read/item-list)
(def all-item-list         read/all-item-list)
(def empty-directory?      read/empty-directory?)

; io.size
(def get-filesize          size/get-filesize)
(def max-filesize-reached? size/max-filesize-reached?)

; io.validators
(def filename-valid?         validators/filename-valid?)
(def filename-invalid?       validators/filename-invalid?)
(def directory-name-valid?   validators/directory-name-valid?)
(def directory-name-invalid? validators/directory-name-invalid?)

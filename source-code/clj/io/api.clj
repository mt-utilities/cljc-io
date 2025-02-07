
(ns io.api
    (:require [io.actions   :as actions]
              [io.base64    :as base64]
              [io.check     :as check]
              [io.config    :as config]
              [io.directory :as directory]
              [io.edn       :as edn]
              [io.env       :as env]
              [io.file      :as file]
              [io.filesize  :as filesize]
              [io.mime-type :as mime-type]
              [io.read      :as read]
              [io.size      :as size]
              [io.stream    :as stream]
              [io.utils     :as utils]
              [io.valid     :as valid]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @redirect (io.actions/*)
(def create-directory!       actions/create-directory!)
(def create-path!            actions/create-path!)
(def create-file!            actions/create-file!)
(def delete-file!            actions/delete-file!)
(def copy-file!              actions/copy-file!)
(def write-file!             actions/write-file!)
(def update-file!            actions/update-file!)
(def empty-file!             actions/empty-file!)
(def append-to-file!         actions/append-to-file!)
(def prepend-to-file!        actions/prepend-to-file!)
(def copy-uri-to-file!       actions/copy-uri-to-file!)
(def delete-empty-directory! actions/delete-empty-directory!)
(def empty-directory!        actions/empty-directory!)
(def delete-directory!       actions/delete-directory!)

; @redirect (io.base64/*)
(def base64->byte-array base64/base64->byte-array)
(def encode-base64!     base64/encode-base64!)
(def decode-base64!     base64/encode-base64!)
(def save-base64!       base64/encode-base64!)

; @redirect (io.check/*)
(def filename-valid?                check/filename-valid?)
(def filename-invalid?              check/filename-invalid?)
(def directory-name-valid?          check/directory-name-valid?)
(def directory-name-invalid?        check/directory-name-invalid?)
(def resource-file-exists?          check/resource-file-exists?)
(def resource-file-not-exists?      check/resource-file-not-exists?)
(def resource-file?                 check/resource-file?)
(def resource-directory-exists?     check/resource-directory-exists?)
(def resource-directory-not-exists? check/resource-directory-not-exists?)
(def resource-directory?            check/resource-directory?)
(def file-exists?                   check/file-exists?)
(def file-not-exists?               check/file-not-exists?)
(def file?                          check/file?)
(def directory-exists?              check/directory-exists?)
(def directory-not-exists?          check/directory-not-exists?)
(def directory?                     check/directory?)

; @redirect (io.config/*)
(def MIME-TYPES config/MIME-TYPES)
(def EXTENSIONS config/EXTENSIONS)

; @redirect (io.directory/*)
(def directory-path->directory-name directory/directory-path->directory-name)

; @redirect (io.edn/*)
(def read-edn-file     edn/read-edn-file)
(def create-edn-file!  edn/create-edn-file!)
(def write-edn-file!   edn/write-edn-file!)
(def update-edn-file!  edn/update-edn-file!)
(def read-edn-header   edn/read-edn-header)
(def write-edn-header! edn/write-edn-header!)

; @redirect (io.env/*)
(def get-resource-root-path io.env/get-resource-root-path)
(def get-resource-root-url  io.env/get-resource-root-url)

; @redirect (io.file/*)
(def file                   file/file)
(def extension->audio?      file/extension->audio?)
(def extension->image?      file/extension->image?)
(def extension->text?       file/extension->text?)
(def extension->video?      file/extension->video?)
(def item-path->parent-path file/item-path->parent-path)
(def filepath->parent-path  file/filepath->parent-path)
(def filepath->filename     file/filepath->filename)
(def filepath->extension    file/filepath->extension)
(def filepath->mime-type    file/filepath->mime-type)
(def filepath->basename     file/filepath->basename)
(def filename->extension    file/filename->extension)
(def filename->mime-type    file/filename->mime-type)
(def filename->basename     file/filename->basename)
(def filepath->audio?       file/filepath->audio?)
(def filepath->image?       file/filepath->image?)
(def filepath->text?        file/filepath->text?)
(def filepath->video?       file/filepath->video?)
(def filename->audio?       file/filename->audio?)
(def filename->image?       file/filename->image?)
(def filename->text?        file/filename->text?)
(def filename->video?       file/filename->video?)

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

; @redirect (io.read/*)
(def read-resource-file     read/read-resource-file)
(def resource-file-list     read/resource-file-list)
(def all-resource-file-list read/all-resource-file-list)
(def read-file              read/read-file)
(def file-list              read/file-list)
(def all-file-list          read/all-file-list)
(def search-files           read/search-files)
(def subdirectory-list      read/subdirectory-list)
(def all-subdirectory-list  read/all-subdirectory-list)
(def search-subdirectories  read/search-subdirectories)
(def item-list              read/item-list)
(def all-item-list          read/all-item-list)
(def search-items           read/search-items)
(def empty-directory?       read/empty-directory?)

; @redirect (io.size/*)
(def get-filesize           size/get-filesize)
(def max-filesize-exceeded? size/max-filesize-exceeded?)

; @redirect (io.stream/*)
(def input-stream  stream/input-stream)
(def output-stream stream/output-stream)

; @redirect (io.utils/*)
(def ensure-eol               utils/ensure-eol)
(def file-seq->item-list      utils/file-seq->item-list)
(def file-seq->file-list      utils/file-seq->file-list)
(def file-seq->directory-list utils/file-seq->directory-list)

; @redirect (io.valid/*)
(def valid-relative-path valid/valid-relative-path)
(def valid-absolute-path valid/valid-absolute-path)

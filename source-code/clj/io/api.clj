
;; -- Namespace ---------------------------------------------------------------
;; ----------------------------------------------------------------------------

(ns io.api
    (:require [clojure.java.io]
              [io.actions :as actions]
              [io.check   :as check]
              [io.edn     :as edn]
              [io.helpers :as helpers]
              [io.read    :as read]
              [io.size    :as size]))



;; -- Redirects ---------------------------------------------------------------
;; ----------------------------------------------------------------------------

; clojure.java.io
(def file          clojure.java.io/file)
(def input-stream  clojure.java.io/input-stream)
(def output-stream clojure.java.io/output-stream)

; io.actions
(def delete-file!            actions/delete-file!)
(def copy-file!              actions/copy-file!)
(def write-file!             actions/write-file!)
(def append-to-file!         actions/append-to-file!)
(def create-file!            actions/create-file!)
(def copy-uri-to-file!       actions/copy-uri-to-file!)
(def create-directory!       actions/create-directory!)
(def delete-empty-directory! actions/delete-empty-directory!)
(def empty-directory!        actions/empty-directory!)
(def delete-directory!       actions/delete-directory!)

; io.check
(def file-exists?      check/file-exists?)
(def file-not-exists?  check/file-not-exists?)
(def directory?        check/directory?)
(def directory-exists? check/directory-exists?)

; io.edn
(def write-edn-file! edn/write-edn-file!)
(def read-edn-file   edn/read-edn-file)
(def swap-edn-file!  edn/swap-edn-file!)

; io.helpers
(def MIME-TYPES                     helpers/MIME-TYPES)
(def EXTENSIONS                     helpers/EXTENSIONS)
(def IMAGE-EXTENSIONS               helpers/IMAGE-EXTENSIONS)
(def B->KB                          helpers/B->KB)
(def B->MB                          helpers/B->MB)
(def KB->B                          helpers/KB->B)
(def KB->MB                         helpers/KB->MB)
(def MB->B                          helpers/MB->B)
(def MB->KB                         helpers/MB->KB)
(def mime-type->extension           helpers/mime-type->extension)
(def extension->mime-type           helpers/extension->mime-type)
(def unknown-mime-type?             helpers/unknown-mime-type?)
(def extension->image?              helpers/extension->image?)
(def mime-type->image?              helpers/mime-type->image?)
(def filepath->filename             helpers/filepath->filename)
(def filepath->extension            helpers/filepath->extension)
(def filename->extension            helpers/filename->extension)
(def filepath->basepath             helpers/filepath->basepath)
(def filename->basename             helpers/filename->basename)
(def filepath->basename             helpers/filepath->basename)
(def filepath->mime-type            helpers/filepath->mime-type)
(def filename->mime-type            helpers/filename->mime-type)
(def filepath->image?               helpers/filepath->image?)
(def filename->image?               helpers/filename->image?)
(def directory-path->directory-name helpers/directory-path->directory-name)
(def filename-valid?                helpers/filename-valid?)
(def filename-invalid?              helpers/filename-invalid?)
(def directory-name-valid?          helpers/directory-name-valid?)
(def directory-name-invalid?        helpers/directory-name-invalid?)

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


(ns io.file
    (:require [iso.io.file :as file]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @redirect (iso.io.file/*)
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

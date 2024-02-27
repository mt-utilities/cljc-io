
(ns io.mime-type
    (:require [iso.io.mime-type :as mime-type]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @redirect (iso.io.mime-type/*)
(def mime-type->extension mime-type/mime-type->extension)
(def extension->mime-type mime-type/extension->mime-type)
(def unknown-mime-type?   mime-type/unknown-mime-type?)
(def mime-type->audio?    mime-type/mime-type->audio?)
(def mime-type->image?    mime-type/mime-type->image?)
(def mime-type->text?     mime-type/mime-type->text?)
(def mime-type->video?    mime-type/mime-type->video?)

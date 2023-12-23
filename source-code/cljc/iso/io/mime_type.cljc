
(ns iso.io.mime-type
    (:require [fruits.string.api :as string]
              [iso.io.config     :as config]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn mime-type->extension
  ; @param (string) mime-type
  ;
  ; @usage
  ; (mime-type->extension "text/xml")
  ; =>
  ; "xml"
  ;
  ; @usage
  ; (mime-type->extension "foo/bar")
  ; =>
  ; "unknown"
  ;
  ; @return (string)
  [mime-type]
  (get config/EXTENSIONS (string/to-lowercase mime-type) "unknown"))

(defn extension->mime-type
  ; @param (extension)
  ;
  ; @usage
  ; (extension->mime-type "xml")
  ; =>
  ; "text/xml"
  ;
  ; @usage
  ; (extension->mime-type "bar")
  ; =>
  ; "unknown/unknown"
  ;
  ; @return (string)
  [extension]
  (get config/MIME-TYPES (string/to-lowercase extension) "unknown/unknown"))

(defn unknown-mime-type?
  ; @param (string) mime-type
  ;
  ; @usage
  ; (unknown-mime-type? "text/xml")
  ; =>
  ; false
  ;
  ; @usage
  ; (unknown-mime-type? "foo/bar")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [mime-type]
  (-> mime-type mime-type->extension nil?))

(defn mime-type->audio?
  ; @param (string) extension
  ;
  ; @usage
  ; (mime-type->image? "audio/mpeg")
  ; =>
  ; true
  ;
  ; @usage
  ; (mime-type->image? "application/pdf")
  ; =>
  ; false
  ;
  ; @return (boolean)
  [mime-type]
  (string/starts-with? mime-type "audio"))

(defn mime-type->image?
  ; @param (string) extension
  ;
  ; @usage
  ; (mime-type->image? "image/png")
  ; =>
  ; true
  ;
  ; @usage
  ; (mime-type->image? "application/pdf")
  ; =>
  ; false
  ;
  ; @return (boolean)
  [mime-type]
  (string/starts-with? mime-type "image"))

(defn mime-type->text?
  ; @param (string) extension
  ;
  ; @usage
  ; (mime-type->image? "text/plain")
  ; =>
  ; true
  ;
  ; @usage
  ; (mime-type->image? "application/pdf")
  ; =>
  ; false
  ;
  ; @return (boolean)
  [mime-type]
  (string/starts-with? mime-type "text"))

(defn mime-type->video?
  ; @param (string) extension
  ;
  ; @usage
  ; (mime-type->image? "video/mpeg")
  ; =>
  ; true
  ;
  ; @usage
  ; (mime-type->image? "application/pdf")
  ; =>
  ; false
  ;
  ; @return (boolean)
  [mime-type]
  (string/starts-with? mime-type "video"))

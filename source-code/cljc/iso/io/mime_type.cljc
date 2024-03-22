
(ns iso.io.mime-type
    (:require [fruits.string.api :as string]
              [iso.io.config     :as config]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn mime-type->extension
  ; @description
  ; Returns the extension that corresponds to the given MIME type.
  ;
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
  ; @description
  ; Returns the MIME type that corresponds to the given extension.
  ;
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
  ; @description
  ; Returns TRUE if the given MIME type is unknown.
  ;
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
  ; @description
  ; Returns TRUE if the given MIME type corresponds to an audio file.
  ;
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
  ; @description
  ; Returns TRUE if the given MIME type corresponds to an image file.
  ;
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
  ; @description
  ; Returns TRUE if the given MIME type corresponds to a text file.
  ;
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
  ; @description
  ; Returns TRUE if the given MIME type corresponds to a video file.
  ;
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

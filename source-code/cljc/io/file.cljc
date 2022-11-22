
(ns io.file
    (:require [candy.api    :refer [return]]
              [io.mime-type :as mime-type]
              [string.api   :as string]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn extension->audio?
  ; @param (string) extension
  ;
  ; @example
  ; (extension->audio? "mp3")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [extension]
  (-> extension mime-type/extension->mime-type mime-type/mime-type->audio?))

(defn extension->image?
  ; @param (string) extension
  ;
  ; @example
  ; (extension->image? "png")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [extension]
  (-> extension mime-type/extension->mime-type mime-type/mime-type->image?))

(defn extension->text?
  ; @param (string) extension
  ;
  ; @example
  ; (extension->text? "txt")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [extension]
  (-> extension mime-type/extension->mime-type mime-type/mime-type->text?))

(defn extension->video?
  ; @param (string) extension
  ;
  ; @example
  ; (extension->video? "mp4")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [extension]
  (-> extension mime-type/extension->mime-type mime-type/mime-type->video?))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn filepath->directory-path
  ; @param (string) filepath
  ;
  ; @example
  ; (filepath->directory-path "my-directory/my-subdirectory/my-file.ext")
  ; =>
  ; "my-directory/my-subdirectory"
  ;
  ; @return (string)
  [filepath]
  (string/before-last-occurence filepath "/" {:return? false}))

(defn filepath->filename
  ; @param (string) filepath
  ;
  ; @example
  ; (filepath->filename "my-directory/my-file.ext")
  ; =>
  ; "my-file.ext"
  ;
  ; @return (string)
  [filepath]
  (string/after-last-occurence filepath "/" {:return? true}))

(defn filepath->extension
  ; @param (string) filepath
  ;
  ; @example
  ; (filepath->extension "my-directory/my-file.EXT")
  ; =>
  ; "ext"
  ;
  ; @example
  ; (filepath->extension "my-directory/.my-hidden-file.ext")
  ; =>
  ; "ext"
  ;
  ; @example
  ; (filepath->extension "my-directory/.my-hidden-file")
  ; =>
  ; nil
  ;
  ; @return (string)
  [filepath]
  (let [filename (-> filepath filepath->filename (string/not-starts-with! "."))]
       (if-let [extension (string/after-last-occurence filename "." {:return? false})]
               (string/lowercase extension))))

(defn filename->extension
  ; @param (string) filename
  ;
  ; @example
  ; (filename->extension "my-file.EXT")
  ; =>
  ; "ext"
  ;
  ; @example
  ; (filename->extension ".my-hidden-file.ext")
  ; =>
  ; "ext"
  ;
  ; @example
  ; (filename->extension ".my-hidden-file")
  ; =>
  ; nil
  ;
  ; @return (string)
  [filename]
  (filepath->extension filename))

(defn filename->basename
  ; @param (string) filename
  ;
  ; @example
  ; (filename->basename "my-file.EXT")
  ; =>
  ; "my-file"
  ;
  ; @example
  ; (filename->basename ".my-hidden-file.ext")
  ; =>
  ; ".my-hidden-file"
  ;
  ; @example
  ; (filename->basename ".my-hidden-file")
  ; =>
  ; ".my-hidden-file"
  ;
  ; @return (string)
  [filename]
  (if-let [extension (filename->extension filename)]
          (string/before-last-occurence filename (str "." extension))
          (return filename)))

(defn filepath->basename
  ; @param (string) filepath
  ;
  ; @example
  ; (filepath->basename "my-directory/my-file.EXT")
  ; =>
  ; "my-file"
  ;
  ; @example
  ; (filepath->basename "my-directory/.my-hidden-file.ext")
  ; =>
  ; ".my-hidden-file"
  ;
  ; @example
  ; (filepath->basename "my-directory/.my-hidden-file")
  ; =>
  ; ".my-hidden-file"
  ;
  ; @return (string)
  [filepath]
  (-> filepath filepath->filename filename->basename))

(defn filepath->mime-type
  ; @param (string) filepath
  ;
  ; @example
  ; (filepath->mime-type "my-directory/my-image.png")
  ; =>
  ; "image/png"
  ;
  ; @example
  ; (filepath->mime-type "my-directory/my-file")
  ; =>
  ; "unknown/unknown"
  ;
  ; @return (string)
  [filepath]
  (-> filepath filepath->extension mime-type/extension->mime-type))

(defn filename->mime-type
  ; @param (string) filename
  ;
  ; @example
  ; (filename->mime-type "my-image.png")
  ; =>
  ; "image/png"
  ;
  ; @example
  ; (filename->mime-type "my-file")
  ; =>
  ; "unknown/unknown"
  ;
  ; @return (string)
  [filename]
  (filepath->mime-type filename))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn filepath->audio?
  ; @param (string) filepath
  ;
  ; @example
  ; (filepath->audio? "my-directory/my-audio.mp3")
  ; =>
  ; true
  ;
  ; @example
  ; (filepath->audio? "my-directory/my-file.ext")
  ; =>
  ; false
  ;
  ; @example
  ; (filepath->audio? "my-directory/my-file")
  ; =>
  ; false
  ;
  ; @return (boolean)
  [filepath]
  (-> filepath filepath->extension extension->audio?))

(defn filepath->image?
  ; @param (string) filepath
  ;
  ; @example
  ; (filepath->image? "my-directory/my-image.png")
  ; =>
  ; true
  ;
  ; @example
  ; (filepath->image? "my-directory/my-file.ext")
  ; =>
  ; false
  ;
  ; @example
  ; (filepath->image? "my-directory/my-file")
  ; =>
  ; false
  ;
  ; @return (boolean)
  [filepath]
  (-> filepath filepath->extension extension->image?))

(defn filepath->text?
  ; @param (string) filepath
  ;
  ; @example
  ; (filepath->text? "my-directory/my-text.txt")
  ; =>
  ; true
  ;
  ; @example
  ; (filepath->text? "my-directory/my-file.ext")
  ; =>
  ; false
  ;
  ; @example
  ; (filepath->text? "my-directory/my-file")
  ; =>
  ; false
  ;
  ; @return (boolean)
  [filepath]
  (-> filepath filepath->extension extension->text?))

(defn filepath->video?
  ; @param (string) filepath
  ;
  ; @example
  ; (filepath->video? "my-directory/my-video.mp4")
  ; =>
  ; true
  ;
  ; @example
  ; (filepath->video? "my-directory/my-file.ext")
  ; =>
  ; false
  ;
  ; @example
  ; (filepath->video? "my-directory/my-file")
  ; =>
  ; false
  ;
  ; @return (boolean)
  [filepath]
  (-> filepath filepath->extension extension->image?))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn filename->audio?
  ; @param (string) filename
  ;
  ; @example
  ; (filename->audio? "my-audio.mp3")
  ; =>
  ; true
  ;
  ; @example
  ; (filename->audio? "my-file.ext")
  ; =>
  ; false
  ;
  ; @example
  ; (filename->audio? "my-file")
  ; =>
  ; false
  ;
  ; @return (boolean)
  [filename]
  (filepath->audio? filename))

(defn filename->image?
  ; @param (string) filename
  ;
  ; @example
  ; (filename->image? "my-image.png")
  ; =>
  ; true
  ;
  ; @example
  ; (filename->image? "my-file.ext")
  ; =>
  ; false
  ;
  ; @example
  ; (filename->image? "my-file")
  ; =>
  ; false
  ;
  ; @return (boolean)
  [filename]
  (filepath->image? filename))

(defn filename->text?
  ; @param (string) filename
  ;
  ; @example
  ; (filename->text? "my-text.txt")
  ; =>
  ; true
  ;
  ; @example
  ; (filename->text? "my-file.ext")
  ; =>
  ; false
  ;
  ; @example
  ; (filename->text? "my-file")
  ; =>
  ; false
  ;
  ; @return (boolean)
  [filename]
  (filepath->text? filename))

(defn filename->video?
  ; @param (string) filename
  ;
  ; @example
  ; (filename->video? "my-video.mp4")
  ; =>
  ; true
  ;
  ; @example
  ; (filename->video? "my-file.ext")
  ; =>
  ; false
  ;
  ; @example
  ; (filename->video? "my-file")
  ; =>
  ; false
  ;
  ; @return (boolean)
  [filename]
  (filepath->image? filename))

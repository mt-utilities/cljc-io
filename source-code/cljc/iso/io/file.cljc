
(ns iso.io.file
    (:require [fruits.string.api :as string]
              [iso.io.mime-type  :as mime-type]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn extension->audio?
  ; @param (string) extension
  ;
  ; @usage
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
  ; @usage
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
  ; @usage
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
  ; @usage
  ; (extension->video? "mp4")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [extension]
  (-> extension mime-type/extension->mime-type mime-type/mime-type->video?))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn item-path->parent-path
  ; @param (string) item-path
  ;
  ; @usage
  ; (item-path->parent-path "my-directory/my-subdirectory/my-file.ext")
  ; =>
  ; "my-directory/my-subdirectory"
  ;
  ; @usage
  ; (item-path->parent-path "my-file.ext")
  ; =>
  ; nil
  ;
  ; @return (string)
  [item-path]
  (string/before-last-occurence item-path "/" {:return? false}))

(defn filepath->directory-path
  ; @param (string) filepath
  ;
  ; @usage
  ; (filepath->directory-path "my-directory/my-subdirectory/my-file.ext")
  ; =>
  ; "my-directory/my-subdirectory"
  ;
  ; @usage
  ; (filepath->directory-path "my-file.ext")
  ; =>
  ; nil
  ;
  ; @return (string)
  [filepath]
  (item-path->parent-path filepath))

(defn filepath->filename
  ; @param (string) filepath
  ;
  ; @usage
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
  ; @usage
  ; (filepath->extension "my-directory/my-file.ext")
  ; =>
  ; "ext"
  ;
  ; @usage
  ; (filepath->extension "my-directory/my-file.EXT")
  ; =>
  ; "ext"
  ;
  ; @usage
  ; (filepath->extension "my-directory/.my-hidden-file.ext")
  ; =>
  ; "ext"
  ;
  ; @usage
  ; (filepath->extension "my-directory/.my-hidden-file")
  ; =>
  ; nil
  ;
  ; @return (string)
  [filepath]
  ; @NOTE (#5591)
  ; Filenames of hidden files (in UNIX based systems) start with a period (.).
  ; In case of only period is in the filename, it might not be an extension marker!
  ; E.g., .my-hidden-file
  (let [filename (-> filepath filepath->filename (string/not-starts-with! "."))]
       (if-let [extension (string/after-last-occurence filename "." {:return? false})]
               (string/to-lowercase extension))))

(defn filename->extension
  ; @param (string) filename
  ;
  ; @usage
  ; (filename->extension "my-file.ext")
  ; =>
  ; "ext"
  ;
  ; @usage
  ; (filename->extension "my-file.EXT")
  ; =>
  ; "ext"
  ;
  ; @usage
  ; (filename->extension ".my-hidden-file.ext")
  ; =>
  ; "ext"
  ;
  ; @usage
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
  ; @usage
  ; (filename->basename "my-file.ext")
  ; =>
  ; "my-file"
  ;
  ; @usage
  ; (filename->basename ".my-hidden-file.ext")
  ; =>
  ; ".my-hidden-file"
  ;
  ; @usage
  ; (filename->basename ".my-hidden-file")
  ; =>
  ; ".my-hidden-file"
  ;
  ; @return (string)
  [filename]
  (if-let [extension (filename->extension filename)]
          (string/before-last-occurence filename (str "." extension))
          (-> filename)))

(defn filepath->basename
  ; @param (string) filepath
  ;
  ; @usage
  ; (filepath->basename "my-directory/my-file.ext")
  ; =>
  ; "my-file"
  ;
  ; @usage
  ; (filepath->basename "my-directory/.my-hidden-file.ext")
  ; =>
  ; ".my-hidden-file"
  ;
  ; @usage
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
  ; @usage
  ; (filepath->mime-type "my-directory/my-image.png")
  ; =>
  ; "image/png"
  ;
  ; @usage
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
  ; @usage
  ; (filename->mime-type "my-image.png")
  ; =>
  ; "image/png"
  ;
  ; @usage
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
  ; @usage
  ; (filepath->audio? "my-directory/my-audio.mp3")
  ; =>
  ; true
  ;
  ; @usage
  ; (filepath->audio? "my-directory/my-file.ext")
  ; =>
  ; false
  ;
  ; @usage
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
  ; @usage
  ; (filepath->image? "my-directory/my-image.png")
  ; =>
  ; true
  ;
  ; @usage
  ; (filepath->image? "my-directory/my-file.ext")
  ; =>
  ; false
  ;
  ; @usage
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
  ; @usage
  ; (filepath->text? "my-directory/my-text.txt")
  ; =>
  ; true
  ;
  ; @usage
  ; (filepath->text? "my-directory/my-file.ext")
  ; =>
  ; false
  ;
  ; @usage
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
  ; @usage
  ; (filepath->video? "my-directory/my-video.mp4")
  ; =>
  ; true
  ;
  ; @usage
  ; (filepath->video? "my-directory/my-file.ext")
  ; =>
  ; false
  ;
  ; @usage
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
  ; @usage
  ; (filename->audio? "my-audio.mp3")
  ; =>
  ; true
  ;
  ; @usage
  ; (filename->audio? "my-file.ext")
  ; =>
  ; false
  ;
  ; @usage
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
  ; @usage
  ; (filename->image? "my-image.png")
  ; =>
  ; true
  ;
  ; @usage
  ; (filename->image? "my-file.ext")
  ; =>
  ; false
  ;
  ; @usage
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
  ; @usage
  ; (filename->text? "my-text.txt")
  ; =>
  ; true
  ;
  ; @usage
  ; (filename->text? "my-file.ext")
  ; =>
  ; false
  ;
  ; @usage
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
  ; @usage
  ; (filename->video? "my-video.mp4")
  ; =>
  ; true
  ;
  ; @usage
  ; (filename->video? "my-file.ext")
  ; =>
  ; false
  ;
  ; @usage
  ; (filename->video? "my-file")
  ; =>
  ; false
  ;
  ; @return (boolean)
  [filename]
  (filepath->video? filename))

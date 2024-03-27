
(ns iso.io.file
    (:require [fruits.string.api :as string]
              [iso.io.mime-type  :as mime-type]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn extension->audio?
  ; @description
  ; Returns TRUE if the given extension corresponds to an audio file.
  ;
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
  ; @description
  ; Returns TRUE if the given extension corresponds to an image file.
  ;
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
  ; @description
  ; Returns TRUE if the given extension corresponds to a text file.
  ;
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
  ; @description
  ; Returns TRUE if the given extension corresponds to a video file.
  ;
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
  ; @description
  ; Returns the parent path of the given item path (file- or directory path).
  ;
  ; @param (string) item-path
  ;
  ; @usage
  ; (item-path->parent-path "my-directory/my-subdirectory/my-file.ext")
  ; =>
  ; "my-directory/my-subdirectory"
  ;
  ; @usage
  ; (item-path->parent-path "my-directory/my-subdirectory")
  ; =>
  ; "my-directory"
  ;
  ; @return (string)
  [item-path]
  (-> item-path (string/before-last-occurence "/" {:return? false})))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn filepath->parent-path
  ; @description
  ; Returns the parent path of the given filepath.
  ;
  ; @param (string) filepath
  ;
  ; @usage
  ; (filepath->parent-path "my-directory/my-subdirectory/my-file.ext")
  ; =>
  ; "my-directory/my-subdirectory"
  ;
  ; @return (string)
  [filepath]
  (-> filepath item-path->parent-path))

(defn filepath->filename
  ; @description
  ; Returns the filename of the given filepath.
  ;
  ; @param (string) filepath
  ;
  ; @usage
  ; (filepath->filename "my-directory/my-file.ext")
  ; =>
  ; "my-file.ext"
  ;
  ; @return (string)
  [filepath]
  (-> filepath (string/after-last-occurence "/" {:return? true})))

(defn filepath->extension
  ; @description
  ; Returns the extension of the given filepath.
  ;
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
  (let [filename (-> filepath filepath->filename (string/not-start-with "."))]
       (if-let [extension (string/after-last-occurence filename "." {:return? false})]
               (string/to-lowercase extension))))

(defn filepath->mime-type
  ; @description
  ; Returns the MIME type of the given filepath.
  ;
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

(defn filepath->basename
  ; @description
  ; Returns the basename (filename without extension) of the given filepath.
  ;
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
  (if-let [filename (-> filepath filepath->filename)]
          (if-let [extension (-> filepath filepath->extension)]
                  (-> filename (string/before-last-occurence (str "." extension)))
                  (-> filename))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn filename->extension
  ; @description
  ; Returns the extension of the given filename.
  ;
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
  (-> filename filepath->extension))

(defn filename->mime-type
  ; @description
  ; Returns the MIME type of the given filename.
  ;
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
  (-> filename filepath->mime-type))

(defn filename->basename
  ; @description
  ; Returns the basename (filename without extension) of the given filename.
  ;
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
  (-> filename filepath->basename))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn filepath->audio?
  ; @description
  ; Returns TRUE if the given filepath corresponds to an audio file.
  ;
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
  ; @description
  ; Returns TRUE if the given filepath corresponds to an image file.
  ;
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
  ; @description
  ; Returns TRUE if the given filepath corresponds to a text file.
  ;
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
  ; @description
  ; Returns TRUE if the given filepath corresponds to a video file.
  ;
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
  ; @description
  ; Returns TRUE if the given filename corresponds to an audio file.
  ;
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
  (-> filename filepath->audio?))

(defn filename->image?
  ; @description
  ; Returns TRUE if the given filename corresponds to an image file.
  ;
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
  (-> filename filepath->image?))

(defn filename->text?
  ; @description
  ; Returns TRUE if the given filename corresponds to a text file.
  ;
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
  (-> filename filepath->text?))

(defn filename->video?
  ; @description
  ; Returns TRUE if the given filename corresponds to a video file.
  ;
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
  (-> filename filepath->video?))

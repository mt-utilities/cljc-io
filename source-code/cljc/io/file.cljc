
(ns io.file
    (:require [candy.api         :refer [return]]
              [io.config         :as config]
              [io.mime-type      :as mime-type]
              [mid-fruits.string :as string]
              [mid-fruits.vector :as vector]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

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
  (vector/contains-item? config/IMAGE-EXTENSIONS extension))

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

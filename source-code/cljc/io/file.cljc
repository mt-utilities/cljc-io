
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
  ;  (extension->image? "png")
  ;  =>
  ;  true
  ;
  ; @return (boolean)
  [extension]
  (vector/contains-item? config/IMAGE-EXTENSIONS extension))

(defn filepath->directory-path
  ; @param (string) filepath
  ;
  ; @example
  ;  (filepath->directory-path "a/b.png")
  ;  =>
  ;  "a"
  ;
  ; @return (string)
  [filepath]
  (string/before-last-occurence filepath "/" {:return? false}))

(defn filepath->filename
  ; @param (string) filepath
  ;
  ; @example
  ;  (filepath->filename "a/b.png")
  ;  =>
  ;  "b.png"
  ;
  ; @return (string)
  [filepath]
  (string/after-last-occurence filepath "/" {:return? true}))

(defn filepath->extension
  ; @param (string) filepath
  ;
  ; @example
  ;  (filepath->extension "a/b.PNG")
  ;  =>
  ;  "png"
  ;
  ; @example
  ;  (filepath->extension "a/.hidden-file.txt")
  ;  =>
  ;  "txt"
  ;
  ; @example
  ;  (filepath->extension "a/.hidden-file")
  ;  =>
  ;  nil
  ;
  ; @return (string)
  [filepath]
  (let [filename (-> filepath filepath->filename (string/not-starts-with! "."))]
       (if-let [extension (string/after-last-occurence filename "." {:return? false})]
               (string/lowercase extension))))

(defn filename->extension
  ; @param (string) filename
  ;
  ; @return (string)
  [filename]
  (filepath->extension filename))

(defn filename->basename
  ; @param (string) filename
  ;
  ; @example
  ;  (filename->basename "b.png")
  ;  =>
  ;  "b"
  ;
  ; @example
  ;  (filename->basename ".hidden-file.txt")
  ;  =>
  ;  ".hidden-file"
  ;
  ; @example
  ;  (filename->basename ".hidden-file")
  ;  =>
  ;  ".hidden-file"
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
  ;  (filepath->basename "a/b.png")
  ;  =>
  ;  "b"
  ;
  ; @example
  ;  (filepath->basename "a/.hidden-file.txt")
  ;  =>
  ;  ".hidden-file"
  ;
  ; @example
  ;  (filepath->basename "a/.hidden-file")
  ;  =>
  ;  ".hidden-file"
  ;
  ; @return (string)
  [filepath]
  (-> filepath filepath->filename filename->basename))

(defn filepath->mime-type
  ; @param (string) filepath
  ;
  ; @example
  ;  (filepath->mime-type "a/b.png")
  ;  =>
  ;  "image/png"
  ;
  ; @example
  ;  (filepath->mime-type "a/b")
  ;  =>
  ;  "unknown/unknown"
  ;
  ; @return (string)
  [filepath]
  (-> filepath filepath->extension mime-type/extension->mime-type))

(defn filename->mime-type
  ; @param (string) filename
  ;
  ; @return (string)
  [filename]
  (filepath->mime-type filename))

(defn filepath->image?
  ; @param (string) filepath
  ;
  ; @usage
  ;  (filepath->image? "a/b.png")
  ;
  ; @return (boolean)
  [filepath]
  (-> filepath filepath->extension extension->image?))

(defn filename->image?
  ; @param (string) filename
  ;
  ; @return (boolean)
  [filename]
  (filepath->image? filename))

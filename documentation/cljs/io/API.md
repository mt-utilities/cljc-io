
# io.api ClojureScript namespace

##### [README](../../../README.md) > [DOCUMENTATION](../../COVER.md) > io.api

### Index

- [B->GB](#b-gb)

- [B->MB](#b-mb)

- [B->kB](#b-kb)

- [GB->B](#gb-b)

- [GB->MB](#gb-mb)

- [GB->kB](#gb-kb)

- [MB->B](#mb-b)

- [MB->GB](#mb-gb)

- [MB->kB](#mb-kb)

- [directory-name-invalid?](#directory-name-invalid)

- [directory-name-valid?](#directory-name-valid)

- [directory-path->directory-name](#directory-path-directory-name)

- [extension->audio?](#extension-audio)

- [extension->image?](#extension-image)

- [extension->mime-type](#extension-mime-type)

- [extension->text?](#extension-text)

- [extension->video?](#extension-video)

- [filename->audio?](#filename-audio)

- [filename->basename](#filename-basename)

- [filename->extension](#filename-extension)

- [filename->image?](#filename-image)

- [filename->mime-type](#filename-mime-type)

- [filename->text?](#filename-text)

- [filename->video?](#filename-video)

- [filename-invalid?](#filename-invalid)

- [filename-valid?](#filename-valid)

- [filepath->audio?](#filepath-audio)

- [filepath->basename](#filepath-basename)

- [filepath->directory-path](#filepath-directory-path)

- [filepath->extension](#filepath-extension)

- [filepath->filename](#filepath-filename)

- [filepath->image?](#filepath-image)

- [filepath->mime-type](#filepath-mime-type)

- [filepath->text?](#filepath-text)

- [filepath->video?](#filepath-video)

- [item-path->parent-path](#item-path-parent-path)

- [kB->B](#kb-b)

- [kB->GB](#kb-gb)

- [kB->MB](#kb-mb)

- [mime-type->extension](#mime-type-extension)

- [mime-type->image?](#mime-type-image)

- [unknown-mime-type?](#unknown-mime-type)

### B->GB

```
@param (B) n
```

```
@usage
(B->GB 420)
```

```
@return (GB)
```

<details>
<summary>Source code</summary>

```
(defn B->GB
  [n]
  (/ n 1000000000))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [B->GB]]))

(io.api/B->GB ...)
(B->GB        ...)
```

</details>

---

### B->MB

```
@param (B) n
```

```
@usage
(B->MB 420)
```

```
@return (MB)
```

<details>
<summary>Source code</summary>

```
(defn B->MB
  [n]
  (/ n 1000000))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [B->MB]]))

(io.api/B->MB ...)
(B->MB        ...)
```

</details>

---

### B->kB

```
@param (B) n
```

```
@usage
(B->kB 420)
```

```
@return (kB)
```

<details>
<summary>Source code</summary>

```
(defn B->kB
  [n]
  (/ n 1000))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [B->kB]]))

(io.api/B->kB ...)
(B->kB        ...)
```

</details>

---

### GB->B

```
@param (GB) n
```

```
@usage
(GB->B 420)
```

```
@return (B)
```

<details>
<summary>Source code</summary>

```
(defn GB->B
  [n]
  (* n 1000000000))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [GB->B]]))

(io.api/GB->B ...)
(GB->B        ...)
```

</details>

---

### GB->MB

```
@param (GB) n
```

```
@usage
(GB->MB 420)
```

```
@return (MB)
```

<details>
<summary>Source code</summary>

```
(defn GB->MB
  [n]
  (* n 1000))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [GB->MB]]))

(io.api/GB->MB ...)
(GB->MB        ...)
```

</details>

---

### GB->kB

```
@param (GB) n
```

```
@usage
(GB->kB 420)
```

```
@return (kB)
```

<details>
<summary>Source code</summary>

```
(defn GB->kB
  [n]
  (* n 1000000))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [GB->kB]]))

(io.api/GB->kB ...)
(GB->kB        ...)
```

</details>

---

### MB->B

```
@param (MB) n
```

```
@usage
(MB->B 420)
```

```
@return (B)
```

<details>
<summary>Source code</summary>

```
(defn MB->B
  [n]
  (* n 1000000))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [MB->B]]))

(io.api/MB->B ...)
(MB->B        ...)
```

</details>

---

### MB->GB

```
@param (MB) n
```

```
@usage
(MB->GB 420)
```

```
@return (GB)
```

<details>
<summary>Source code</summary>

```
(defn MB->GB
  [n]
  (/ n 1000))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [MB->GB]]))

(io.api/MB->GB ...)
(MB->GB        ...)
```

</details>

---

### MB->kB

```
@param (MB) n
```

```
@usage
(MB->kB 420)
```

```
@return (kB)
```

<details>
<summary>Source code</summary>

```
(defn MB->kB
  [n]
  (* n 1000))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [MB->kB]]))

(io.api/MB->kB ...)
(MB->kB        ...)
```

</details>

---

### directory-name-invalid?

```
@param (string) directory-name
```

```
@example
(directory-name-invalid? "my-directory")
=>
false
```

```
@example
(directory-name-invalid? "my-directory/my-subdirectory")
=>
true
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn directory-name-invalid?
  [directory-name]
  (re-mismatch? directory-name config/DIRECTORY-NAME-PATTERN))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [directory-name-invalid?]]))

(io.api/directory-name-invalid? ...)
(directory-name-invalid?        ...)
```

</details>

---

### directory-name-valid?

```
@param (string) directory-name
```

```
@example
(directory-name-valid? "my-directory")
=>
true
```

```
@example
(directory-name-valid? "my-directory/my-subdirectory")
=>
false
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn directory-name-valid?
  [directory-name]
  (re-match? directory-name config/DIRECTORY-NAME-PATTERN))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [directory-name-valid?]]))

(io.api/directory-name-valid? ...)
(directory-name-valid?        ...)
```

</details>

---

### directory-path->directory-name

```
@param (string) directory-path
```

```
@example
(directory-path->directory-name "a/b")
=>
"b"
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn directory-path->directory-name
  [directory-path]
  (if-let [directory-name (string/after-last-occurence directory-path "/")]
          (return directory-name)
          (return directory-path)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [directory-path->directory-name]]))

(io.api/directory-path->directory-name ...)
(directory-path->directory-name        ...)
```

</details>

---

### extension->audio?

```
@param (string) extension
```

```
@usage
(extension->audio? "mp3")
```

```
@example
(extension->audio? "mp3")
=>
true
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn extension->audio?
  [extension]
  (-> extension mime-type/extension->mime-type mime-type/mime-type->audio?))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [extension->audio?]]))

(io.api/extension->audio? ...)
(extension->audio?        ...)
```

</details>

---

### extension->image?

```
@param (string) extension
```

```
@usage
(extension->image? "png")
```

```
@example
(extension->image? "png")
=>
true
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn extension->image?
  [extension]
  (-> extension mime-type/extension->mime-type mime-type/mime-type->image?))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [extension->image?]]))

(io.api/extension->image? ...)
(extension->image?        ...)
```

</details>

---

### extension->mime-type

```
@param (extension) 
```

```
@example
(extension->mime-type "xml")
=>
"text/xml"
```

```
@example
(extension->mime-type "bar")
=>
"unknown/unknown"
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn extension->mime-type
  [extension]
  (get config/MIME-TYPES (string/to-lowercase extension) "unknown/unknown"))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [extension->mime-type]]))

(io.api/extension->mime-type ...)
(extension->mime-type        ...)
```

</details>

---

### extension->text?

```
@param (string) extension
```

```
@usage
(extension->text? "txt")
```

```
@example
(extension->text? "txt")
=>
true
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn extension->text?
  [extension]
  (-> extension mime-type/extension->mime-type mime-type/mime-type->text?))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [extension->text?]]))

(io.api/extension->text? ...)
(extension->text?        ...)
```

</details>

---

### extension->video?

```
@param (string) extension
```

```
@usage
(extension->video? "mp4")
```

```
@example
(extension->video? "mp4")
=>
true
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn extension->video?
  [extension]
  (-> extension mime-type/extension->mime-type mime-type/mime-type->video?))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [extension->video?]]))

(io.api/extension->video? ...)
(extension->video?        ...)
```

</details>

---

### filename->audio?

```
@param (string) filename
```

```
@usage
(filename->audio? "my-audio.mp3")
```

```
@example
(filename->audio? "my-audio.mp3")
=>
true
```

```
@example
(filename->audio? "my-file.ext")
=>
false
```

```
@example
(filename->audio? "my-file")
=>
false
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn filename->audio?
  [filename]
  (filepath->audio? filename))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [filename->audio?]]))

(io.api/filename->audio? ...)
(filename->audio?        ...)
```

</details>

---

### filename->basename

```
@param (string) filename
```

```
@usage
(filename->basename "my-file.EXT")
```

```
@example
(filename->basename "my-file.EXT")
=>
"my-file"
```

```
@example
(filename->basename ".my-hidden-file.ext")
=>
".my-hidden-file"
```

```
@example
(filename->basename ".my-hidden-file")
=>
".my-hidden-file"
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn filename->basename
  [filename]
  (if-let [extension (filename->extension filename)]
          (string/before-last-occurence filename (str "." extension))
          (return filename)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [filename->basename]]))

(io.api/filename->basename ...)
(filename->basename        ...)
```

</details>

---

### filename->extension

```
@param (string) filename
```

```
@usage
(filename->extension "my-file.EXT")
```

```
@example
(filename->extension "my-file.EXT")
=>
"ext"
```

```
@example
(filename->extension ".my-hidden-file.ext")
=>
"ext"
```

```
@example
(filename->extension ".my-hidden-file")
=>
nil
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn filename->extension
  [filename]
  (filepath->extension filename))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [filename->extension]]))

(io.api/filename->extension ...)
(filename->extension        ...)
```

</details>

---

### filename->image?

```
@param (string) filename
```

```
@usage
(filename->image? "my-image.png")
```

```
@example
(filename->image? "my-image.png")
=>
true
```

```
@example
(filename->image? "my-file.ext")
=>
false
```

```
@example
(filename->image? "my-file")
=>
false
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn filename->image?
  [filename]
  (filepath->image? filename))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [filename->image?]]))

(io.api/filename->image? ...)
(filename->image?        ...)
```

</details>

---

### filename->mime-type

```
@param (string) filename
```

```
@usage
(filename->mime-type "my-image.png")
```

```
@example
(filename->mime-type "my-image.png")
=>
"image/png"
```

```
@example
(filename->mime-type "my-file")
=>
"unknown/unknown"
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn filename->mime-type
  [filename]
  (filepath->mime-type filename))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [filename->mime-type]]))

(io.api/filename->mime-type ...)
(filename->mime-type        ...)
```

</details>

---

### filename->text?

```
@param (string) filename
```

```
@usage
(filename->text? "my-text.txt")
```

```
@example
(filename->text? "my-text.txt")
=>
true
```

```
@example
(filename->text? "my-file.ext")
=>
false
```

```
@example
(filename->text? "my-file")
=>
false
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn filename->text?
  [filename]
  (filepath->text? filename))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [filename->text?]]))

(io.api/filename->text? ...)
(filename->text?        ...)
```

</details>

---

### filename->video?

```
@param (string) filename
```

```
@usage
(filename->video? "my-video.mp4")
```

```
@example
(filename->video? "my-video.mp4")
=>
true
```

```
@example
(filename->video? "my-file.ext")
=>
false
```

```
@example
(filename->video? "my-file")
=>
false
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn filename->video?
  [filename]
  (filepath->image? filename))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [filename->video?]]))

(io.api/filename->video? ...)
(filename->video?        ...)
```

</details>

---

### filename-invalid?

```
@param (string) filename
```

```
@example
(filename-invalid? "my-file.ext")
=>
false
```

```
@example
(filename-invalid? "my-directory/my-file.ext")
=>
true
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn filename-invalid?
  [filename]
  (re-mismatch? filename config/FILENAME-PATTERN))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [filename-invalid?]]))

(io.api/filename-invalid? ...)
(filename-invalid?        ...)
```

</details>

---

### filename-valid?

```
@param (string) filename
```

```
@example
(filename-valid? "my-file.ext")
=>
true
```

```
@example
(filename-valid? "my-directory/my-file.ext")
=>
false
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn filename-valid?
  [filename]
  (re-match? filename config/FILENAME-PATTERN))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [filename-valid?]]))

(io.api/filename-valid? ...)
(filename-valid?        ...)
```

</details>

---

### filepath->audio?

```
@param (string) filepath
```

```
@usage
(filepath->audio? "my-directory/my-audio.mp3")
```

```
@example
(filepath->audio? "my-directory/my-audio.mp3")
=>
true
```

```
@example
(filepath->audio? "my-directory/my-file.ext")
=>
false
```

```
@example
(filepath->audio? "my-directory/my-file")
=>
false
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn filepath->audio?
  [filepath]
  (-> filepath filepath->extension extension->audio?))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [filepath->audio?]]))

(io.api/filepath->audio? ...)
(filepath->audio?        ...)
```

</details>

---

### filepath->basename

```
@param (string) filepath
```

```
@usage
(filepath->basename "my-directory/my-file.EXT")
```

```
@example
(filepath->basename "my-directory/my-file.EXT")
=>
"my-file"
```

```
@example
(filepath->basename "my-directory/.my-hidden-file.ext")
=>
".my-hidden-file"
```

```
@example
(filepath->basename "my-directory/.my-hidden-file")
=>
".my-hidden-file"
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn filepath->basename
  [filepath]
  (-> filepath filepath->filename filename->basename))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [filepath->basename]]))

(io.api/filepath->basename ...)
(filepath->basename        ...)
```

</details>

---

### filepath->directory-path

```
@param (string) filepath
```

```
@usage
(filepath->directory-path "my-directory/my-subdirectory/my-file.ext")
```

```
@example
(filepath->directory-path "my-directory/my-subdirectory/my-file.ext")
=>
"my-directory/my-subdirectory"
```

```
@example
(filepath->directory-path "my-file.ext")
=>
nil
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn filepath->directory-path
  [filepath]
  (item-path->parent-path filepath))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [filepath->directory-path]]))

(io.api/filepath->directory-path ...)
(filepath->directory-path        ...)
```

</details>

---

### filepath->extension

```
@param (string) filepath
```

```
@usage
(filepath->extension "my-directory/my-file.EXT")
```

```
@example
(filepath->extension "my-directory/my-file.EXT")
=>
"ext"
```

```
@example
(filepath->extension "my-directory/.my-hidden-file.ext")
=>
"ext"
```

```
@example
(filepath->extension "my-directory/.my-hidden-file")
=>
nil
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn filepath->extension
  [filepath]
  (let [filename (-> filepath filepath->filename (string/not-starts-with! "."))]
       (if-let [extension (string/after-last-occurence filename "." {:return? false})]
               (string/to-lowercase extension))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [filepath->extension]]))

(io.api/filepath->extension ...)
(filepath->extension        ...)
```

</details>

---

### filepath->filename

```
@param (string) filepath
```

```
@usage
(filepath->filename "my-directory/my-file.ext")
```

```
@example
(filepath->filename "my-directory/my-file.ext")
=>
"my-file.ext"
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn filepath->filename
  [filepath]
  (string/after-last-occurence filepath "/" {:return? true}))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [filepath->filename]]))

(io.api/filepath->filename ...)
(filepath->filename        ...)
```

</details>

---

### filepath->image?

```
@param (string) filepath
```

```
@usage
(filepath->image? "my-directory/my-image.png")
```

```
@example
(filepath->image? "my-directory/my-image.png")
=>
true
```

```
@example
(filepath->image? "my-directory/my-file.ext")
=>
false
```

```
@example
(filepath->image? "my-directory/my-file")
=>
false
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn filepath->image?
  [filepath]
  (-> filepath filepath->extension extension->image?))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [filepath->image?]]))

(io.api/filepath->image? ...)
(filepath->image?        ...)
```

</details>

---

### filepath->mime-type

```
@param (string) filepath
```

```
@usage
(filepath->mime-type "my-directory/my-image.png")
```

```
@example
(filepath->mime-type "my-directory/my-image.png")
=>
"image/png"
```

```
@example
(filepath->mime-type "my-directory/my-file")
=>
"unknown/unknown"
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn filepath->mime-type
  [filepath]
  (-> filepath filepath->extension mime-type/extension->mime-type))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [filepath->mime-type]]))

(io.api/filepath->mime-type ...)
(filepath->mime-type        ...)
```

</details>

---

### filepath->text?

```
@param (string) filepath
```

```
@usage
(filepath->text? "my-directory/my-text.txt")
```

```
@example
(filepath->text? "my-directory/my-text.txt")
=>
true
```

```
@example
(filepath->text? "my-directory/my-file.ext")
=>
false
```

```
@example
(filepath->text? "my-directory/my-file")
=>
false
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn filepath->text?
  [filepath]
  (-> filepath filepath->extension extension->text?))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [filepath->text?]]))

(io.api/filepath->text? ...)
(filepath->text?        ...)
```

</details>

---

### filepath->video?

```
@param (string) filepath
```

```
@usage
(filepath->video? "my-directory/my-video.mp4")
```

```
@example
(filepath->video? "my-directory/my-video.mp4")
=>
true
```

```
@example
(filepath->video? "my-directory/my-file.ext")
=>
false
```

```
@example
(filepath->video? "my-directory/my-file")
=>
false
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn filepath->video?
  [filepath]
  (-> filepath filepath->extension extension->image?))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [filepath->video?]]))

(io.api/filepath->video? ...)
(filepath->video?        ...)
```

</details>

---

### item-path->parent-path

```
@param (string) item-path
```

```
@usage
(item-path->parent-path "my-directory/my-subdirectory/my-file.ext")
```

```
@example
(item-path->parent-path "my-directory/my-subdirectory/my-file.ext")
=>
"my-directory/my-subdirectory"
```

```
@example
(item-path->parent-path "my-file.ext")
=>
nil
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn item-path->parent-path
  [item-path]
  (string/before-last-occurence item-path "/" {:return? false}))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [item-path->parent-path]]))

(io.api/item-path->parent-path ...)
(item-path->parent-path        ...)
```

</details>

---

### kB->B

```
@param (kB) n
```

```
@usage
(kB->B 420)
```

```
@return (B)
```

<details>
<summary>Source code</summary>

```
(defn kB->B
  [n]
  (* n 1000))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [kB->B]]))

(io.api/kB->B ...)
(kB->B        ...)
```

</details>

---

### kB->GB

```
@param (kB) n
```

```
@usage
(kB->GB 420)
```

```
@return (GB)
```

<details>
<summary>Source code</summary>

```
(defn kB->GB
  [n]
  (/ n 1000000))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [kB->GB]]))

(io.api/kB->GB ...)
(kB->GB        ...)
```

</details>

---

### kB->MB

```
@param (kB) n
```

```
@usage
(kB->MB 420)
```

```
@return (MB)
```

<details>
<summary>Source code</summary>

```
(defn kB->MB
  [n]
  (/ n 1000))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [kB->MB]]))

(io.api/kB->MB ...)
(kB->MB        ...)
```

</details>

---

### mime-type->extension

```
@param (string) mime-type
```

```
@example
(mime-type->extension "text/xml")
=>
"xml"
```

```
@example
(mime-type->extension "foo/bar")
=>
"unknown"
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn mime-type->extension
  [mime-type]
  (get config/EXTENSIONS (string/to-lowercase mime-type) "unknown"))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [mime-type->extension]]))

(io.api/mime-type->extension ...)
(mime-type->extension        ...)
```

</details>

---

### mime-type->image?

```
@param (string) extension
```

```
@example
(mime-type->image? "image/png")
=>
true
```

```
@example
(mime-type->image? "application/pdf")
=>
false
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn mime-type->image?
  [mime-type]
  (string/starts-with? mime-type "image"))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [mime-type->image?]]))

(io.api/mime-type->image? ...)
(mime-type->image?        ...)
```

</details>

---

### unknown-mime-type?

```
@param (string) mime-type
```

```
@example
(unknown-mime-type? "text/xml")
=>
false
```

```
@example
(unknown-mime-type? "foo/bar")
=>
true
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn unknown-mime-type?
  [mime-type]
  (-> mime-type mime-type->extension nil?))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [unknown-mime-type?]]))

(io.api/unknown-mime-type? ...)
(unknown-mime-type?        ...)
```

</details>

---

This documentation is generated by the [docs-api](https://github.com/bithandshake/docs-api) engine


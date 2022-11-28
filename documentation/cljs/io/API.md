
# <strong>io.api</strong> namespace
<p>Documentation of the <strong>io/api.cljs</strong> file</p>

<strong>[README](../../../README.md) > [DOCUMENTATION](../../COVER.md) > io.api</strong>



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
(ns my-namespace (:require [io.api :as io :refer [B->GB]]))

(io/B->GB ...)
(B->GB    ...)
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
(ns my-namespace (:require [io.api :as io :refer [B->MB]]))

(io/B->MB ...)
(B->MB    ...)
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
(ns my-namespace (:require [io.api :as io :refer [B->kB]]))

(io/B->kB ...)
(B->kB    ...)
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
(ns my-namespace (:require [io.api :as io :refer [GB->B]]))

(io/GB->B ...)
(GB->B    ...)
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
(ns my-namespace (:require [io.api :as io :refer [GB->MB]]))

(io/GB->MB ...)
(GB->MB    ...)
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
(ns my-namespace (:require [io.api :as io :refer [GB->kB]]))

(io/GB->kB ...)
(GB->kB    ...)
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
(ns my-namespace (:require [io.api :as io :refer [MB->B]]))

(io/MB->B ...)
(MB->B    ...)
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
(ns my-namespace (:require [io.api :as io :refer [MB->GB]]))

(io/MB->GB ...)
(MB->GB    ...)
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
(ns my-namespace (:require [io.api :as io :refer [MB->kB]]))

(io/MB->kB ...)
(MB->kB    ...)
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
(ns my-namespace (:require [io.api :as io :refer [directory-name-invalid?]]))

(io/directory-name-invalid? ...)
(directory-name-invalid?    ...)
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
(ns my-namespace (:require [io.api :as io :refer [directory-name-valid?]]))

(io/directory-name-valid? ...)
(directory-name-valid?    ...)
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
(ns my-namespace (:require [io.api :as io :refer [directory-path->directory-name]]))

(io/directory-path->directory-name ...)
(directory-path->directory-name    ...)
```

</details>

---

### extension->audio?

```
@param (string) extension
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
(ns my-namespace (:require [io.api :as io :refer [extension->audio?]]))

(io/extension->audio? ...)
(extension->audio?    ...)
```

</details>

---

### extension->image?

```
@param (string) extension
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
(ns my-namespace (:require [io.api :as io :refer [extension->image?]]))

(io/extension->image? ...)
(extension->image?    ...)
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
(ns my-namespace (:require [io.api :as io :refer [extension->mime-type]]))

(io/extension->mime-type ...)
(extension->mime-type    ...)
```

</details>

---

### extension->text?

```
@param (string) extension
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
(ns my-namespace (:require [io.api :as io :refer [extension->text?]]))

(io/extension->text? ...)
(extension->text?    ...)
```

</details>

---

### extension->video?

```
@param (string) extension
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
(ns my-namespace (:require [io.api :as io :refer [extension->video?]]))

(io/extension->video? ...)
(extension->video?    ...)
```

</details>

---

### filename->audio?

```
@param (string) filename
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
(ns my-namespace (:require [io.api :as io :refer [filename->audio?]]))

(io/filename->audio? ...)
(filename->audio?    ...)
```

</details>

---

### filename->basename

```
@param (string) filename
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
(ns my-namespace (:require [io.api :as io :refer [filename->basename]]))

(io/filename->basename ...)
(filename->basename    ...)
```

</details>

---

### filename->extension

```
@param (string) filename
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
(ns my-namespace (:require [io.api :as io :refer [filename->extension]]))

(io/filename->extension ...)
(filename->extension    ...)
```

</details>

---

### filename->image?

```
@param (string) filename
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
(ns my-namespace (:require [io.api :as io :refer [filename->image?]]))

(io/filename->image? ...)
(filename->image?    ...)
```

</details>

---

### filename->mime-type

```
@param (string) filename
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
(ns my-namespace (:require [io.api :as io :refer [filename->mime-type]]))

(io/filename->mime-type ...)
(filename->mime-type    ...)
```

</details>

---

### filename->text?

```
@param (string) filename
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
(ns my-namespace (:require [io.api :as io :refer [filename->text?]]))

(io/filename->text? ...)
(filename->text?    ...)
```

</details>

---

### filename->video?

```
@param (string) filename
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
(ns my-namespace (:require [io.api :as io :refer [filename->video?]]))

(io/filename->video? ...)
(filename->video?    ...)
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
(ns my-namespace (:require [io.api :as io :refer [filename-invalid?]]))

(io/filename-invalid? ...)
(filename-invalid?    ...)
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
(ns my-namespace (:require [io.api :as io :refer [filename-valid?]]))

(io/filename-valid? ...)
(filename-valid?    ...)
```

</details>

---

### filepath->audio?

```
@param (string) filepath
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
(ns my-namespace (:require [io.api :as io :refer [filepath->audio?]]))

(io/filepath->audio? ...)
(filepath->audio?    ...)
```

</details>

---

### filepath->basename

```
@param (string) filepath
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
(ns my-namespace (:require [io.api :as io :refer [filepath->basename]]))

(io/filepath->basename ...)
(filepath->basename    ...)
```

</details>

---

### filepath->directory-path

```
@param (string) filepath
```

```
@example
(filepath->directory-path "my-directory/my-subdirectory/my-file.ext")
=>
"my-directory/my-subdirectory"
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn filepath->directory-path
  [filepath]
  (string/before-last-occurence filepath "/" {:return? false}))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :as io :refer [filepath->directory-path]]))

(io/filepath->directory-path ...)
(filepath->directory-path    ...)
```

</details>

---

### filepath->extension

```
@param (string) filepath
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
(ns my-namespace (:require [io.api :as io :refer [filepath->extension]]))

(io/filepath->extension ...)
(filepath->extension    ...)
```

</details>

---

### filepath->filename

```
@param (string) filepath
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
(ns my-namespace (:require [io.api :as io :refer [filepath->filename]]))

(io/filepath->filename ...)
(filepath->filename    ...)
```

</details>

---

### filepath->image?

```
@param (string) filepath
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
(ns my-namespace (:require [io.api :as io :refer [filepath->image?]]))

(io/filepath->image? ...)
(filepath->image?    ...)
```

</details>

---

### filepath->mime-type

```
@param (string) filepath
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
(ns my-namespace (:require [io.api :as io :refer [filepath->mime-type]]))

(io/filepath->mime-type ...)
(filepath->mime-type    ...)
```

</details>

---

### filepath->text?

```
@param (string) filepath
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
(ns my-namespace (:require [io.api :as io :refer [filepath->text?]]))

(io/filepath->text? ...)
(filepath->text?    ...)
```

</details>

---

### filepath->video?

```
@param (string) filepath
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
(ns my-namespace (:require [io.api :as io :refer [filepath->video?]]))

(io/filepath->video? ...)
(filepath->video?    ...)
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
(ns my-namespace (:require [io.api :as io :refer [kB->B]]))

(io/kB->B ...)
(kB->B    ...)
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
(ns my-namespace (:require [io.api :as io :refer [kB->GB]]))

(io/kB->GB ...)
(kB->GB    ...)
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
(ns my-namespace (:require [io.api :as io :refer [kB->MB]]))

(io/kB->MB ...)
(kB->MB    ...)
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
(ns my-namespace (:require [io.api :as io :refer [mime-type->extension]]))

(io/mime-type->extension ...)
(mime-type->extension    ...)
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
(ns my-namespace (:require [io.api :as io :refer [mime-type->image?]]))

(io/mime-type->image? ...)
(mime-type->image?    ...)
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
(ns my-namespace (:require [io.api :as io :refer [unknown-mime-type?]]))

(io/unknown-mime-type? ...)
(unknown-mime-type?    ...)
```

</details>

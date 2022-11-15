
# <strong>io/api.clj</strong>
<p>Documentation of the <strong>io.api</strong> namespace</p>

### B->GB

```
@require
(ns my-namespace (:require [io.api :as io :refer [B->GB]]))

(io/B->GB ...)
(B->GB    ...)
```

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

---

### B->KB

```
@require
(ns my-namespace (:require [io.api :as io :refer [B->KB]]))

(io/B->KB ...)
(B->KB    ...)
```

```
@param (B) n
```

```
@usage
(B->KB 420)
```

```
@return (KB)
```

---

### B->MB

```
@require
(ns my-namespace (:require [io.api :as io :refer [B->MB]]))

(io/B->MB ...)
(B->MB    ...)
```

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

---

### KB->B

```
@require
(ns my-namespace (:require [io.api :as io :refer [KB->B]]))

(io/KB->B ...)
(KB->B    ...)
```

```
@param (KB) n
```

```
@usage
(KB->B 420)
```

```
@return (B)
```

---

### KB->GB

```
@require
(ns my-namespace (:require [io.api :as io :refer [KB->GB]]))

(io/KB->GB ...)
(KB->GB    ...)
```

```
@param (KB) n
```

```
@usage
(KB->GB 420)
```

```
@return (GB)
```

---

### KB->MB

```
@require
(ns my-namespace (:require [io.api :as io :refer [KB->MB]]))

(io/KB->MB ...)
(KB->MB    ...)
```

```
@param (KB) n
```

```
@usage
(KB->MB 420)
```

```
@return (MB)
```

---

### MB->B

```
@require
(ns my-namespace (:require [io.api :as io :refer [MB->B]]))

(io/MB->B ...)
(MB->B    ...)
```

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

---

### MB->GB

```
@require
(ns my-namespace (:require [io.api :as io :refer [MB->GB]]))

(io/MB->GB ...)
(MB->GB    ...)
```

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

---

### MB->KB

```
@require
(ns my-namespace (:require [io.api :as io :refer [MB->KB]]))

(io/MB->KB ...)
(MB->KB    ...)
```

```
@param (MB) n
```

```
@usage
(MB->KB 420)
```

```
@return (KB)
```

---

### all-file-list

```
@require
(ns my-namespace (:require [io.api :as io :refer [all-file-list]]))

(io/all-file-list ...)
(all-file-list    ...)
```

```
@param (string) directory-path
```

```
@example
(all-file-list "my-directory")
=>
["my-directory/my-file.ext" ...]
```

```
@return (strings in vector)
```

---

### all-item-list

```
@require
(ns my-namespace (:require [io.api :as io :refer [all-item-list]]))

(io/all-item-list ...)
(all-item-list    ...)
```

```
@param (string) directory-path
```

```
@example
(all-item-list "my-directory")
=>
["my-directory/my-subdirectory" "my-directory/my-subdirectory/my-file.ext" ...]
```

```
@return (strings in vector)
```

---

### all-subdirectory-list

```
@require
(ns my-namespace (:require [io.api :as io :refer [all-subdirectory-list]]))

(io/all-subdirectory-list ...)
(all-subdirectory-list    ...)
```

```
@param (string) directory-path
```

```
@example
(all-subdirectory-list "my-directory")
=>
["my-directory/my-subdirectory" ...]
```

```
@return (strings in vector)
```

---

### append-to-file!

```
@require
(ns my-namespace (:require [io.api :as io :refer [append-to-file!]]))

(io/append-to-file! ...)
(append-to-file!    ...)
```

```
@param (string) filepath
@param (*) content
@param (map)(opt) options
```

```
@usage
(append-to-file! "my-directory/my-file.ext" "My content")
```

```
@usage
(append-to-file! "my-directory/my-file.ext" "My content" {...})
```

```
@return (nil)
```

---

### copy-file!

```
@require
(ns my-namespace (:require [io.api :as io :refer [copy-file!]]))

(io/copy-file! ...)
(copy-file!    ...)
```

```
@param (string) source-filepath
@param (string) destination-filepath
```

```
@usage
(copy-file! "my-directory/my-source-file.ext"
            "my-directory/my-destination-file.ext")
```

```
@return (nil)
```

---

### copy-uri-to-file!

```
@require
(ns my-namespace (:require [io.api :as io :refer [copy-uri-to-file!]]))

(io/copy-uri-to-file! ...)
(copy-uri-to-file!    ...)
```

```
@param (string) uri
@param (?) file
```

```
@return (nil)
```

---

### create-directory!

```
@require
(ns my-namespace (:require [io.api :as io :refer [create-directory!]]))

(io/create-directory! ...)
(create-directory!    ...)
```

```
@param (string) directory-path
```

```
@usage
(create-directory! "my-directory/my-subdirectory")
```

```
@return (boolean)
```

---

### create-file!

```
@require
(ns my-namespace (:require [io.api :as io :refer [create-file!]]))

(io/create-file! ...)
(create-file!    ...)
```

```
@param (string) filepath
```

```
@usage
(create-file! "my-directory/my-file.ext")
```

```
@return (nil)
```

---

### delete-directory!

```
@require
(ns my-namespace (:require [io.api :as io :refer [delete-directory!]]))

(io/delete-directory! ...)
(delete-directory!    ...)
```

```
@param (string) directory-path
```

```
@usage
(delete-directory! "my-directory/my-subdirectory")
```

```
@return (boolean)
```

---

### delete-empty-directory!

```
@require
(ns my-namespace (:require [io.api :as io :refer [delete-empty-directory!]]))

(io/delete-empty-directory! ...)
(delete-empty-directory!    ...)
```

```
@param (string) directory-path
```

```
@usage
(delete-empty-directory! "my-directory/my-subdirectory")
```

```
@return (boolean)
```

---

### delete-file!

```
@require
(ns my-namespace (:require [io.api :as io :refer [delete-file!]]))

(io/delete-file! ...)
(delete-file!    ...)
```

```
@param (string) filepath
```

```
@usage
(delete-file! "my-directory/my-file.ext")
```

```
@return (boolean)
```

---

### directory-exists?

```
@require
(ns my-namespace (:require [io.api :as io :refer [directory-exists?]]))

(io/directory-exists? ...)
(directory-exists?    ...)
```

```
@param (string) directory-path
```

```
@usage
(directory-exists? "my-directory/my-subdirectory")
```

```
@return (boolean)
```

---

### directory-name-invalid?

```
@require
(ns my-namespace (:require [io.api :as io :refer [directory-name-invalid?]]))

(io/directory-name-invalid? ...)
(directory-name-invalid?    ...)
```

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

---

### directory-name-valid?

```
@require
(ns my-namespace (:require [io.api :as io :refer [directory-name-valid?]]))

(io/directory-name-valid? ...)
(directory-name-valid?    ...)
```

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

---

### directory-path->directory-name

```
@require
(ns my-namespace (:require [io.api :as io :refer [directory-path->directory-name]]))

(io/directory-path->directory-name ...)
(directory-path->directory-name    ...)
```

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

---

### directory?

```
@require
(ns my-namespace (:require [io.api :as io :refer [directory?]]))

(io/directory? ...)
(directory?    ...)
```

```
@param (string) directory-path
```

```
@usage
(directory? "my-directory/my-subdirectory")
```

```
@return (boolean)
```

---

### empty-directory!

```
@require
(ns my-namespace (:require [io.api :as io :refer [empty-directory!]]))

(io/empty-directory! ...)
(empty-directory!    ...)
```

```
@param (string) directory-path
```

```
@usage
(empty-directory! "my-directory/my-subdirectory")
```

```
@return (boolean)
```

---

### empty-directory?

```
@require
(ns my-namespace (:require [io.api :as io :refer [empty-directory?]]))

(io/empty-directory? ...)
(empty-directory?    ...)
```

```
@param (string) directory-path
```

```
@usage
(empty-directory? "my-directory/my-subdirectory")
```

```
@return (boolean)
```

---

### extension->image?

```
@require
(ns my-namespace (:require [io.api :as io :refer [extension->image?]]))

(io/extension->image? ...)
(extension->image?    ...)
```

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

---

### extension->mime-type

```
@require
(ns my-namespace (:require [io.api :as io :refer [extension->mime-type]]))

(io/extension->mime-type ...)
(extension->mime-type    ...)
```

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

---

### file-exists?

```
@require
(ns my-namespace (:require [io.api :as io :refer [file-exists?]]))

(io/file-exists? ...)
(file-exists?    ...)
```

```
@param (string) filepath
```

```
@usage
(file-exists? "my-directory/my-file.ext")
```

```
@return (boolean)
```

---

### file-list

```
@require
(ns my-namespace (:require [io.api :as io :refer [file-list]]))

(io/file-list ...)
(file-list    ...)
```

```
@param (string) directory-path
```

```
@example
(file-list "my-directory")
=>
["my-directory/my-file.ext" ...]
```

```
@return (strings in vector)
```

---

### file-not-exists?

```
@require
(ns my-namespace (:require [io.api :as io :refer [file-not-exists?]]))

(io/file-not-exists? ...)
(file-not-exists?    ...)
```

```
@param (string) filepath
```

```
@usage
(file-not-exists? "my-directory/my-file.ext")
```

```
@return (boolean)
```

---

### filename->basename

```
@require
(ns my-namespace (:require [io.api :as io :refer [filename->basename]]))

(io/filename->basename ...)
(filename->basename    ...)
```

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

---

### filename->extension

```
@require
(ns my-namespace (:require [io.api :as io :refer [filename->extension]]))

(io/filename->extension ...)
(filename->extension    ...)
```

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

---

### filename->image?

```
@require
(ns my-namespace (:require [io.api :as io :refer [filename->image?]]))

(io/filename->image? ...)
(filename->image?    ...)
```

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

---

### filename->mime-type

```
@require
(ns my-namespace (:require [io.api :as io :refer [filename->mime-type]]))

(io/filename->mime-type ...)
(filename->mime-type    ...)
```

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

---

### filename-invalid?

```
@require
(ns my-namespace (:require [io.api :as io :refer [filename-invalid?]]))

(io/filename-invalid? ...)
(filename-invalid?    ...)
```

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

---

### filename-valid?

```
@require
(ns my-namespace (:require [io.api :as io :refer [filename-valid?]]))

(io/filename-valid? ...)
(filename-valid?    ...)
```

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

---

### filepath->basename

```
@require
(ns my-namespace (:require [io.api :as io :refer [filepath->basename]]))

(io/filepath->basename ...)
(filepath->basename    ...)
```

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

---

### filepath->directory-path

```
@require
(ns my-namespace (:require [io.api :as io :refer [filepath->directory-path]]))

(io/filepath->directory-path ...)
(filepath->directory-path    ...)
```

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

---

### filepath->extension

```
@require
(ns my-namespace (:require [io.api :as io :refer [filepath->extension]]))

(io/filepath->extension ...)
(filepath->extension    ...)
```

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

---

### filepath->filename

```
@require
(ns my-namespace (:require [io.api :as io :refer [filepath->filename]]))

(io/filepath->filename ...)
(filepath->filename    ...)
```

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

---

### filepath->image?

```
@require
(ns my-namespace (:require [io.api :as io :refer [filepath->image?]]))

(io/filepath->image? ...)
(filepath->image?    ...)
```

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

---

### filepath->mime-type

```
@require
(ns my-namespace (:require [io.api :as io :refer [filepath->mime-type]]))

(io/filepath->mime-type ...)
(filepath->mime-type    ...)
```

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

---

### get-filesize

```
@require
(ns my-namespace (:require [io.api :as io :refer [get-filesize]]))

(io/get-filesize ...)
(get-filesize    ...)
```

```
@param (string) filepath
```

```
@usage
(get-filesize "my-directory/my-file.ext")
```

```
@return (B)
```

---

### item-list

```
@require
(ns my-namespace (:require [io.api :as io :refer [item-list]]))

(io/item-list ...)
(item-list    ...)
```

```
@param (string) directory-path
```

```
@example
(item-list "my-directory")
=>
["my-directory/my-subdirectory" "my-directory/my-subdirectory/my-file.ext" ...]
```

```
@return (strings in vector)
```

---

### max-filesize-reached?

```
@require
(ns my-namespace (:require [io.api :as io :refer [max-filesize-reached?]]))

(io/max-filesize-reached? ...)
(max-filesize-reached?    ...)
```

```
@param (string) filepath
@param (B) max-filesize
```

```
@usage
(max-filesize-reached? "my-directory/my-file.ext" 420)
```

```
@return (boolean)
```

---

### mime-type->extension

```
@require
(ns my-namespace (:require [io.api :as io :refer [mime-type->extension]]))

(io/mime-type->extension ...)
(mime-type->extension    ...)
```

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

---

### mime-type->image?

```
@require
(ns my-namespace (:require [io.api :as io :refer [mime-type->image?]]))

(io/mime-type->image? ...)
(mime-type->image?    ...)
```

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

---

### prepend-to-file!

```
@require
(ns my-namespace (:require [io.api :as io :refer [prepend-to-file!]]))

(io/prepend-to-file! ...)
(prepend-to-file!    ...)
```

```
@param (string) filepath
@param (*) content
@param (map)(opt) options
```

```
@usage
(prepend-to-file! "my-directory/my-file.ext" "My content")
```

```
@usage
(prepend-to-file! "my-directory/my-file.ext" "My content" {...})
```

```
@return (nil)
```

---

### read-edn-file

```
@require
(ns my-namespace (:require [io.api :as io :refer [read-edn-file]]))

(io/read-edn-file ...)
(read-edn-file    ...)
```

```
@param (string) filepath
```

```
@usage
(read-edn-file "my-directory/my-file.edn")
```

```
@return (*)
```

---

### read-file

```
@require
(ns my-namespace (:require [io.api :as io :refer [read-file]]))

(io/read-file ...)
(read-file    ...)
```

```
@param (string) filepath
```

```
@usage
(read-file "my-directory/my-file.ext")
```

```
@return (string)
```

---

### subdirectory-list

```
@require
(ns my-namespace (:require [io.api :as io :refer [subdirectory-list]]))

(io/subdirectory-list ...)
(subdirectory-list    ...)
```

```
@param (string) directory-path
```

```
@example
(subdirectory-list "my-directory")
=>
["my-directory/my-subdirectory" ...]
```

```
@return (strings in vector)
```

---

### swap-edn-file!

```
@require
(ns my-namespace (:require [io.api :as io :refer [swap-edn-file!]]))

(io/swap-edn-file! ...)
(swap-edn-file!    ...)
```

```
@param (string) filepath
@param (function) f
@param (*) params
```

```
@usage
(swap-edn-file! "my-directory/my-file.edn" assoc-in [:items :xyz] "XYZ")
```

```
@usage
(swap-edn-file! "my-directory/my-file.edn" conj "XYZ")
```

```
@return (*)
```

---

### unknown-mime-type?

```
@require
(ns my-namespace (:require [io.api :as io :refer [unknown-mime-type?]]))

(io/unknown-mime-type? ...)
(unknown-mime-type?    ...)
```

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

---

### write-edn-file!

```
@require
(ns my-namespace (:require [io.api :as io :refer [write-edn-file!]]))

(io/write-edn-file! ...)
(write-edn-file!    ...)
```

```
@param (string) filepath
@param (*) content
@param (map)(opt) options
```

```
@usage
(write-edn-file! "my-directory/my-file.edn" {...})
```

```
@usage
(write-edn-file! "my-directory/my-file.edn" {...} {...})
```

```
@example
(write-edn-file! "my-directory/my-file.edn" {:b "B" :a "A" :d "D" :c "C"})
(read-file       "my-directory/my-file.edn")
=>
"{:b "B" :a "A" :d "D" :c "C"}"
```

```
@example
(write-edn-file! "my-directory/my-file.edn" {:b "B" :a "A" :d "D" :c "C"} {:abc? true})
(read-file       "my-directory/my-file.edn")
=>
"{:a "A" :b "B" :c "C" :d "D"}"
```

```
@return (string)
```

---

### write-file!

```
@require
(ns my-namespace (:require [io.api :as io :refer [write-file!]]))

(io/write-file! ...)
(write-file!    ...)
```

```
@param (string) filepath
@param (*) content
@param (map)(opt) options
```

```
@usage
(write-file! "my-directory/my-file.ext" "My content")
```

```
@usage
(write-file! "my-directory/my-file.ext" "My content" {...})
```

```
@return (nil)
```
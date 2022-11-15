
# <strong>io/api.clj</strong>
<p>Documentation of the <strong>io.api</strong> namespace</p>

---

### Require

```
(ns my-namespace
    (:require [io.api :as io]))
```

---

### create-directory!
###### clj/io/api.clj

```
@param (string) directory-path
```

```
@usage
  (create-directory! "my-directory/my-subdirectory")
```

```
@return (?)
```

---

### create-file!
###### clj/io/api.clj

```
@param (string) filepath
```

```
@usage
  (create-file! "my-directory/my-file.ext")
```

```
@return (?)
```

---

### delete-file!
###### clj/io/api.clj

```
@param (string) filepath
```

```
@usage
  (delete-file! "my-directory/my-file.ext")
```

```
@return (?)
```

---

### copy-file!
###### clj/io/api.clj

```
@param (string) source-filepath
@param (string) destination-filepath
```

```
@usage
  (copy-file! "my-directory/my-source-file.ext"
  ;              "my-directory/my-destination-file.ext")
```

```
@return (?)
```

---

### write-file!
###### clj/io/api.clj

---

### append-to-file!
###### clj/io/api.clj

---

### prepend-to-file!
###### clj/io/api.clj

---

### copy-uri-to-file!
###### clj/io/api.clj

```
@param (string) uri
@param (?) file
```

```
@return (?)
```

---

### delete-empty-directory!
###### clj/io/api.clj

```
@param (string) directory-path
```

```
@usage
  (delete-empty-directory! "my-directory/my-subdirectory")
```

```
@return (?)
```

---

### empty-directory!
###### clj/io/api.clj

```
@param (string) directory-path
```

```
@usage
  (empty-directory! "my-directory/my-subdirectory")
```

```
@return (?)
```

---

### delete-directory!
###### clj/io/api.clj

```
@param (string) directory-path
```

```
@usage
  (delete-directory! "my-directory/my-subdirectory")
```

```
@return (?)
```

---

### file-exists?
###### clj/io/api.clj

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

### file-not-exists?
###### clj/io/api.clj

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

### directory?
###### clj/io/api.clj

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

### directory-exists?
###### clj/io/api.clj

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

### directory-path->directory-name
###### clj/io/api.clj

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

### write-edn-file!
###### clj/io/api.clj

---

### read-edn-file
###### clj/io/api.clj

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

### swap-edn-file!
###### clj/io/api.clj

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

### extension->image?
###### clj/io/api.clj

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

### filepath->directory-path
###### clj/io/api.clj

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

### filepath->filename
###### clj/io/api.clj

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

### filepath->extension
###### clj/io/api.clj

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

### filename->extension
###### clj/io/api.clj

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

### filename->basename
###### clj/io/api.clj

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

### filepath->basename
###### clj/io/api.clj

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

### filepath->mime-type
###### clj/io/api.clj

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

### filename->mime-type
###### clj/io/api.clj

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

### filepath->image?
###### clj/io/api.clj

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

### filename->image?
###### clj/io/api.clj

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

### B->KB
###### clj/io/api.clj

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
###### clj/io/api.clj

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

### B->GB
###### clj/io/api.clj

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

### KB->B
###### clj/io/api.clj

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

### KB->MB
###### clj/io/api.clj

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

### KB->GB
###### clj/io/api.clj

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

### MB->B
###### clj/io/api.clj

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

### MB->KB
###### clj/io/api.clj

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

### MB->GB
###### clj/io/api.clj

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

### mime-type->extension
###### clj/io/api.clj

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

### extension->mime-type
###### clj/io/api.clj

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

### unknown-mime-type?
###### clj/io/api.clj

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

### mime-type->image?
###### clj/io/api.clj

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
@return (boolean)
```

---

### read-file
###### clj/io/api.clj

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

### file-list
###### clj/io/api.clj

```
@param (string) directory-path
```

```
@example
 (file-list "my-directory/my-subdirectory")
 =>
 ["my-directory/my-subdirectory/my-file.ext" ...]
```

```
@return (strings in vector)
```

---

### all-file-list
###### clj/io/api.clj

```
@param (string) directory-path
```

```
@example
 (all-file-list "my-directory/my-subdirectory")
 =>
 ["my-directory/my-subdirectory/my-file.ext" ...]
```

```
@return (strings in vector)
```

---

### subdirectory-list
###### clj/io/api.clj

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

### all-subdirectory-list
###### clj/io/api.clj

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

### item-list
###### clj/io/api.clj

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

### all-item-list
###### clj/io/api.clj

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

### empty-directory?
###### clj/io/api.clj

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

### get-filesize
###### clj/io/api.clj

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

### max-filesize-reached?
###### clj/io/api.clj

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

### filename-valid?
###### clj/io/api.clj

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

### filename-invalid?
###### clj/io/api.clj

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

### directory-name-valid?
###### clj/io/api.clj

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

### directory-name-invalid?
###### clj/io/api.clj

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
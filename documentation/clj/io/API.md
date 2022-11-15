
# <strong>io/api.clj</strong>
<p>Documentation of the <strong>io/api.clj</strong> namespace</p>

---

### Require

```
(ns my-namespace
    (:require [io.api :as io]))
```

---

### create-directory!

```
@param (string) directory-path
```

```
@return (?)
```

---

### create-file!

```
@param (string) filepath
```

```
@return (?)
```

---

### delete-file!

```
@param (string) filepath
```

```
@return (?)
```

---

### copy-file!

```
@param (string) source-filepath
@param (string) destination-filepath
```

```
@return (?)
```

---

### write-file!

---

### append-to-file!

---

### prepend-to-file!

---

### copy-uri-to-file!

```
@param (string) uri
@param (?) file
```

```
@return (?)
```

---

### delete-empty-directory!

```
@param (string) directory-path
```

```
@return (?)
```

---

### empty-directory!

```
@param (string) directory-path
```

```
@return (?)
```

---

### delete-directory!

```
@param (string) directory-path
```

```
@return (?)
```

---

### file-exists?

```
@param (string) filepath
```

```
@return (boolean)
```

---

### file-not-exists?

```
@param (string) filepath
```

```
@return (boolean)
```

---

### directory?

```
@param (string) directory-path
```

```
@return (boolean)
```

---

### directory-exists?

```
@param (string) directory-path
```

```
@return (boolean)
```

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

---

### write-edn-file!

---

### read-edn-file

```
@param (string) filepath
```

```
@return (*)
```

---

### swap-edn-file!

```
@param (string) filepath
@param (function) f
@param (*) params
```

```
@usage
  (swap-edn-file! "my-file.edn" assoc-in [:items :xyz] "XYZ")
```

```
@usage
  (swap-edn-file! "my-file.edn" vector/conj-item "XYZ")
```

```
@return (map)
```

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

---

### filepath->directory-path

```
@param (string) filepath
```

```
@example
 (filepath->directory-path "a/b.png")
 =>
 "a"
```

```
@return (string)
```

---

### filepath->filename

```
@param (string) filepath
```

```
@example
 (filepath->filename "a/b.png")
 =>
 "b.png"
```

```
@return (string)
```

---

### filepath->extension

```
@param (string) filepath
```

```
@example
 (filepath->extension "a/b.PNG")
 =>
 "png"
```

```
@example
 (filepath->extension "a/.hidden-file.txt")
 =>
 "txt"
```

```
@example
 (filepath->extension "a/.hidden-file")
 =>
 nil
```

```
@return (string)
```

---

### filename->extension

```
@param (string) filename
```

```
@return (string)
```

---

### filename->basename

```
@param (string) filename
```

```
@example
 (filename->basename "b.png")
 =>
 "b"
```

```
@example
 (filename->basename ".hidden-file.txt")
 =>
 ".hidden-file"
```

```
@example
 (filename->basename ".hidden-file")
 =>
 ".hidden-file"
```

```
@return (string)
```

---

### filepath->basename

```
@param (string) filepath
```

```
@example
 (filepath->basename "a/b.png")
 =>
 "b"
```

```
@example
 (filepath->basename "a/.hidden-file.txt")
 =>
 ".hidden-file"
```

```
@example
 (filepath->basename "a/.hidden-file")
 =>
 ".hidden-file"
```

```
@return (string)
```

---

### filepath->mime-type

```
@param (string) filepath
```

```
@example
 (filepath->mime-type "a/b.png")
 =>
 "image/png"
```

```
@example
 (filepath->mime-type "a/b")
 =>
 "unknown/unknown"
```

```
@return (string)
```

---

### filename->mime-type

```
@param (string) filename
```

```
@return (string)
```

---

### filepath->image?

```
@param (string) filepath
```

```
@usage
  (filepath->image? "a/b.png")
```

```
@return (boolean)
```

---

### filename->image?

```
@param (string) filename
```

```
@return (boolean)
```

---

### B->KB

```
@param (B) n
```

```
@return (KB)
```

---

### B->MB

```
@param (B) n
```

```
@return (MB)
```

---

### B->GB

```
@param (B) n
```

```
@return (GB)
```

---

### KB->B

```
@param (KB) n
```

```
@return (B)
```

---

### KB->MB

```
@param (KB) n
```

```
@return (MB)
```

---

### KB->GB

```
@param (KB) n
```

```
@return (GB)
```

---

### MB->B

```
@param (MB) n
```

```
@return (B)
```

---

### MB->KB

```
@param (MB) n
```

```
@return (KB)
```

---

### MB->GB

```
@param (MB) n
```

```
@return (GB)
```

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
@return (boolean)
```

---

### read-file

```
@param (string) filepath
```

```
@return (string)
```

---

### file-list

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

### all-file-list

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

### subdirectory-list

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

```
@param (string) directory-path
```

```
@example
 (item-list "my-directory")
 =>
 ["my-directory/my-file.ext" "my-directory/my-subdirectory" ...]
```

```
@return (strings in vector)
```

---

### all-item-list

```
@param (string) directory-path
```

```
@example
 (all-item-list "my-directory")
 =>
 ["my-directory/my-file.ext" "my-directory/my-subdirectory" ...]
```

```
@return (strings in vector)
```

---

### empty-directory?

```
@param (string) directory-path
```

```
@return (boolean)
```

---

### get-filesize

```
@param (string) filepath
```

```
@return (B)
```

---

### max-filesize-reached?

```
@param (string) filepath
@param (B) max-filesize
```

```
@return (boolean)
```

---

### filename-valid?

```
@param (string) filename
```

```
@return (boolean)
```

---

### filename-invalid?

```
@param (string) filename
```

```
@return (boolean)
```

---

### directory-name-valid?

```
@param (string) directory-name
```

```
@return (boolean)
```

---

### directory-name-invalid?

```
@param (string) directory-name
```

```
@return (boolean)
```
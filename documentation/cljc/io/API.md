
# <strong>io/api.cljc</strong>
<p>Documentation of the <strong>io.api</strong> namespace</p>

---

### Require

```
(ns my-namespace
    (:require [io.api :as io]))
```

---

### directory-path->directory-name
###### cljc/io/api.cljc

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

### extension->image?
###### cljc/io/api.cljc

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
###### cljc/io/api.cljc

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
###### cljc/io/api.cljc

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
###### cljc/io/api.cljc

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
###### cljc/io/api.cljc

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
###### cljc/io/api.cljc

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
###### cljc/io/api.cljc

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
###### cljc/io/api.cljc

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
###### cljc/io/api.cljc

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
###### cljc/io/api.cljc

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
###### cljc/io/api.cljc

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
###### cljc/io/api.cljc

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
###### cljc/io/api.cljc

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
###### cljc/io/api.cljc

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
###### cljc/io/api.cljc

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
###### cljc/io/api.cljc

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
###### cljc/io/api.cljc

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
###### cljc/io/api.cljc

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
###### cljc/io/api.cljc

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
###### cljc/io/api.cljc

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
###### cljc/io/api.cljc

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
###### cljc/io/api.cljc

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
###### cljc/io/api.cljc

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
###### cljc/io/api.cljc

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

### filename-valid?
###### cljc/io/api.cljc

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
###### cljc/io/api.cljc

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
###### cljc/io/api.cljc

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
###### cljc/io/api.cljc

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
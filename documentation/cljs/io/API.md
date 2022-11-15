
# <strong>io/api.cljs</strong>
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
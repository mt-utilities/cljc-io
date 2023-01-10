
# io.api Clojure namespace

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

- [all-file-list](#all-file-list)

- [all-item-list](#all-item-list)

- [all-resource-file-list](#all-resource-file-list)

- [all-subdirectory-list](#all-subdirectory-list)

- [append-to-file!](#append-to-file)

- [copy-file!](#copy-file)

- [copy-uri-to-file!](#copy-uri-to-file)

- [create-directory!](#create-directory)

- [create-edn-file!](#create-edn-file)

- [create-file!](#create-file)

- [create-path!](#create-path)

- [delete-directory!](#delete-directory)

- [delete-empty-directory!](#delete-empty-directory)

- [delete-file!](#delete-file)

- [directory-exists?](#directory-exists)

- [directory-not-exists?](#directory-not-exists)

- [directory-path->directory-name](#directory-path-directory-name)

- [directory?](#directory)

- [empty-directory!](#empty-directory)

- [empty-directory?](#empty-directory)

- [empty-file!](#empty-file)

- [extension->audio?](#extension-audio)

- [extension->image?](#extension-image)

- [extension->mime-type](#extension-mime-type)

- [extension->text?](#extension-text)

- [extension->video?](#extension-video)

- [file-exists?](#file-exists)

- [file-list](#file-list)

- [file-not-exists?](#file-not-exists)

- [file?](#file)

- [filename->audio?](#filename-audio)

- [filename->basename](#filename-basename)

- [filename->extension](#filename-extension)

- [filename->image?](#filename-image)

- [filename->mime-type](#filename-mime-type)

- [filename->text?](#filename-text)

- [filename->video?](#filename-video)

- [filepath->audio?](#filepath-audio)

- [filepath->basename](#filepath-basename)

- [filepath->directory-path](#filepath-directory-path)

- [filepath->extension](#filepath-extension)

- [filepath->filename](#filepath-filename)

- [filepath->image?](#filepath-image)

- [filepath->mime-type](#filepath-mime-type)

- [filepath->text?](#filepath-text)

- [filepath->video?](#filepath-video)

- [get-filesize](#get-filesize)

- [item-list](#item-list)

- [item-path->parent-path](#item-path-parent-path)

- [kB->B](#kb-b)

- [kB->GB](#kb-gb)

- [kB->MB](#kb-mb)

- [max-filesize-reached?](#max-filesize-reached)

- [mime-type->extension](#mime-type-extension)

- [mime-type->image?](#mime-type-image)

- [prepend-to-file!](#prepend-to-file)

- [read-edn-file](#read-edn-file)

- [read-edn-header](#read-edn-header)

- [read-file](#read-file)

- [read-resource-file](#read-resource-file)

- [resource-directory-exists?](#resource-directory-exists)

- [resource-directory-not-exists?](#resource-directory-not-exists)

- [resource-directory?](#resource-directory)

- [resource-file-exists?](#resource-file-exists)

- [resource-file-list](#resource-file-list)

- [resource-file-not-exists?](#resource-file-not-exists)

- [resource-file?](#resource-file)

- [subdirectory-list](#subdirectory-list)

- [swap-edn-file!](#swap-edn-file)

- [unknown-mime-type?](#unknown-mime-type)

- [valid-absolute-path](#valid-absolute-path)

- [valid-relative-path](#valid-relative-path)

- [write-edn-file!](#write-edn-file)

- [write-edn-header!](#write-edn-header)

- [write-file!](#write-file)

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

### all-file-list

```
@description
Returns with the filenames found on the given directory-path (recursive).
```

```
@param (string) directory-path
@param (map)(opt) options
{:keep-hidden? (boolean)(opt)
  Default: false
 :warn? (boolean)(opt)
  Default: true}
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

<details>
<summary>Source code</summary>

```
(defn all-file-list
  ([directory-path]
   (all-file-list directory-path {}))

  ([directory-path {:keys [keep-hidden? warn?] :or {warn? true}}]
   (try (if (check/directory-exists? directory-path)
            (let [file-seq (-> directory-path str clojure.java.io/file file-seq)]
                 (helpers/file-seq->file-list directory-path file-seq {:keep-hidden? keep-hidden?}))
            (throw (Exception. config/DIRECTORY-DOES-NOT-EXIST-ERROR)))
        (catch Exception e (if warn? (println (str e " \"" directory-path "\"")))))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [all-file-list]]))

(io.api/all-file-list ...)
(all-file-list        ...)
```

</details>

---

### all-item-list

```
@description
Returns with the subdirectories and files found on the given directory-path (recursive).
```

```
@param (string) directory-path
@param (map)(opt) options
{:keep-hidden? (boolean)(opt)
  Default: false
 :warn? (boolean)(opt)
  Default: true}
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

<details>
<summary>Source code</summary>

```
(defn all-item-list
  ([directory-path]
   (all-item-list directory-path {}))

  ([directory-path {:keys [keep-hidden? warn?] :or {warn? true}}]
   (try (if (check/directory-exists? directory-path)
            (let [file-seq (-> directory-path str clojure.java.io/file file-seq)]
                 (helpers/file-seq->item-list directory-path file-seq {:keep-hidden? keep-hidden?}))
            (throw (Exception. config/DIRECTORY-DOES-NOT-EXIST-ERROR)))
        (catch Exception e (if warn? (println (str e " \"" directory-path "\"")))))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [all-item-list]]))

(io.api/all-item-list ...)
(all-item-list        ...)
```

</details>

---

### all-resource-file-list

```
@param (string) directory-path
@param (map)(opt) options
{:warn? (boolean)(opt)
  Default: true}
```

```
@usage
(all-resource-file-list "my-directory")
```

```
@example
(all-resource-file-list "my-directory")
=>
["my-directory/my-file.ext" ...]
```

```
@return (strings in vector)
```

<details>
<summary>Source code</summary>

```
(defn all-resource-file-list
  ([directory-path]
   (all-resource-file-list directory-path {}))

  ([directory-path {:keys [warn?] :or {warn? true}}]
   (try (if-let [resource-url (clojure.java.io/resource directory-path)]
                (let [resource-root-url (helpers/get-resource-root-url directory-path)
                      directory         (-> resource-url clojure.java.io/file)]
                     (and (-> directory .isDirectory)
                          (let [file-seq (-> directory file-seq)]
                               (letfn [(f [%] (string/not-starts-with! (-> % .toURI .normalize) resource-root-url))]
                                      (helpers/file-seq->file-list (str directory-path "/") file-seq {:output-f f})))))
                (throw (Exception. config/RESOURCE-DOES-NOT-EXIST-ERROR)))
        (catch Exception e (if warn? (println (str e " \"" directory-path "\"")))))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [all-resource-file-list]]))

(io.api/all-resource-file-list ...)
(all-resource-file-list        ...)
```

</details>

---

### all-subdirectory-list

```
@description
Returns with the subdirectories found on the given directory-path (recursive).
```

```
@param (string) directory-path
@param (map)(opt) options
{:keep-hidden? (boolean)(opt)
  Default: false
 :warn? (boolean)(opt)
  Default: true}
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

<details>
<summary>Source code</summary>

```
(defn all-subdirectory-list
  ([directory-path]
   (all-subdirectory-list directory-path {}))

  ([directory-path {:keys [keep-hidden? warn?] :or {warn? true}}]
   (try (if (check/directory-exists? directory-path)
            (let [file-seq (-> directory-path str clojure.java.io/file file-seq)]
                 (helpers/file-seq->directory-list directory-path file-seq {:keep-hidden? keep-hidden?}))
            (throw (Exception. config/DIRECTORY-DOES-NOT-EXIST-ERROR)))
        (catch Exception e (if warn? (println (str e " \"" directory-path "\"")))))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [all-subdirectory-list]]))

(io.api/all-subdirectory-list ...)
(all-subdirectory-list        ...)
```

</details>

---

### append-to-file!

```
@param (string) filepath
@param (*) content
@param (map)(opt) options
{:create? (boolean)(opt)
  Default: false
 :max-line-count (integer)(opt)
 :return? (boolean)(opt)
  Default: true
 :warn? (boolean)(opt)
  Default: true}
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
@return (nil or string)
Returns with the file's content or with nil if the return? option is set to false.
```

<details>
<summary>Source code</summary>

```
(defn append-to-file!
  ([filepath content]
   (append-to-file! filepath content {}))

  ([filepath content {:keys [max-line-count] :as options}]
   (let [file-content (read/read-file filepath)
         output       (str file-content "\n" content)]
        (if max-line-count (let [output (string/max-lines output max-line-count)]
                                (write-file! filepath output options))
                           (write-file! filepath output options)))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [append-to-file!]]))

(io.api/append-to-file! ...)
(append-to-file!        ...)
```

</details>

---

### copy-file!

```
@param (string) source-filepath
@param (string) destination-filepath
@param (map)(opt) options
{:return? (boolean)(opt)
  Default: true
 :warn? (boolean)(opt)
  Default: true}
```

```
@usage
(copy-file! "my-directory/my-source-file.ext"
            "my-directory/my-destination-file.ext")
```

```
@return (nil or string)
Returns with the file's content or with nil if the return? option is set to false.
```

<details>
<summary>Source code</summary>

```
(defn copy-file!
  ([source-filepath destination-filepath]
   (copy-file! source-filepath destination-filepath {}))

  ([source-filepath destination-filepath {:keys [return? warn?] :or {return? true warn? true}}]
   (try (if (check/file-exists? source-filepath)
            (do (clojure.java.io/copy (-> source-filepath      str clojure.java.io/file)
                                      (-> destination-filepath str clojure.java.io/file))
                (if return? (read/read-file destination-filepath)))
            (throw (Exception. config/FILE-DOES-NOT-EXIST-ERROR)))
        (catch Exception e (if warn? (println (str e " \"" source-filepath "\"")))))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [copy-file!]]))

(io.api/copy-file! ...)
(copy-file!        ...)
```

</details>

---

### copy-uri-to-file!

```
@param (string) uri
@param (?) file
@param (map)(opt) options
{:warn? (boolean)(opt)
  Default: true}
```

```
@return (nil)
```

<details>
<summary>Source code</summary>

```
(defn copy-uri-to-file!
  ([uri file]
   (copy-uri-to-file! uri file {}))

  ([uri file {:keys [warn?] :or {warn? true}}]
   (try (with-open [input  (clojure.java.io/input-stream  uri)
                    output (clojure.java.io/output-stream file)]
                   (clojure.java.io/copy input output))
        (catch Exception e (if warn? (println e))))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [copy-uri-to-file!]]))

(io.api/copy-uri-to-file! ...)
(copy-uri-to-file!        ...)
```

</details>

---

### create-directory!

```
@param (string) directory-path
@param (map)(opt) options
{:warn? (boolean)(opt)
  Default: true}
```

```
@usage
(create-directory! "my-directory/my-subdirectory")
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn create-directory!
  ([directory-path]
   (create-directory! directory-path {}))

  ([directory-path {:keys [warn?] :or {warn? true}}]
   (if-not (check/directory-exists? directory-path)
           (do (if warn? (println (str config/CREATE-DIRECTORY-MESSAGE " \"" directory-path "\"")))
               (try (-> directory-path java.io.File. .mkdirs)
                    (catch Exception e (println e))))
           (return :directory-already-exists))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [create-directory!]]))

(io.api/create-directory! ...)
(create-directory!        ...)
```

</details>

---

### create-edn-file!

```
@param (string) filepath
@param (map)(opt) options
{:return? (boolean)(opt)
  Default: true
 :warn? (boolean)(opt)
  Default: true}
```

```
@usage
(create-edn-file! "my-directory/my-file.edn")
```

```
@return (nil or string)
Returns with the file's content (the reader procceses the content to data),
or with nil if the return? option is set to false.
```

<details>
<summary>Source code</summary>

```
(defn create-edn-file!
  ([filepath]
   (create-edn-file! filepath {}))

  ([filepath {:keys [return? warn?] :or {return? true warn? true} :as options}]
   (if-not (check/file-exists?  filepath)
           (actions/write-file! filepath "\n{}" {:create? true :warn? warn?}))
   (if return? (read-edn-file filepath {:warn? false}))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [create-edn-file!]]))

(io.api/create-edn-file! ...)
(create-edn-file!        ...)
```

</details>

---

### create-file!

```
@param (string) filepath
@param (map)(opt) options
{:return? (boolean)(opt)
  Default: true
 :warn? (boolean)(opt)
  Default: true}
```

```
@usage
(create-file! "my-directory/my-file.ext")
```

```
@return (nil or string)
Returns an empty string if the file is created or with the file's content
if it is already exists.
Returns nil if the return? option is set to false.
```

<details>
<summary>Source code</summary>

```
(defn create-file!
  ([filepath]
   (create-file! filepath {}))

  ([filepath {:keys [return? warn?] :or {return? true warn? true}}]
   (when-not (check/file-exists? filepath)
             (create-path!       filepath {:warn? false})
             (if warn? (println (str config/CREATE-FILE-MESSAGE " \"" filepath "\"")))
             (spit filepath nil))
   (if return? (read/read-file filepath))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [create-file!]]))

(io.api/create-file! ...)
(create-file!        ...)
```

</details>

---

### create-path!

```
@param (string) item-path
@param (map)(opt) options
{:warn? (boolean)(opt)
  Default: true}
```

```
@usage
(create-path! "my-directory/my-file.ext")
```

```
@example
(create-path! "my-directory/my-file.ext")
=>
It only creates the my-directory (if it does not exist),
to settle the path for the item.
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn create-path!
  ([item-path]
   (create-path! item-path {}))

  ([item-path {:keys [warn?] :or {warn? true} :as options}]

   (let [parent-path (file/item-path->parent-path item-path)])
   (when-let [parent-path (file/item-path->parent-path item-path)]
             (if-not (check/directory-exists? parent-path)
                     (create-directory!       parent-path options)
                     (return :path-already-exists)))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [create-path!]]))

(io.api/create-path! ...)
(create-path!        ...)
```

</details>

---

### delete-directory!

```
@param (string) directory-path
@param (map)(opt) options
{:warn? (boolean)(opt)
  Default: true}
```

```
@usage
(delete-directory! "my-directory/my-subdirectory")
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn delete-directory!
  ([directory-path]
   (empty-directory! directory-path {}))

  ([directory-path options]
   (empty-directory!        directory-path options)
   (delete-empty-directory! directory-path options)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [delete-directory!]]))

(io.api/delete-directory! ...)
(delete-directory!        ...)
```

</details>

---

### delete-empty-directory!

```
@param (string) directory-path
@param (map)(opt) options
{:warn? (boolean)(opt)
  Default: true}
```

```
@usage
(delete-empty-directory! "my-directory/my-subdirectory")
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn delete-empty-directory!
  ([directory-path]
   (delete-empty-directory! directory-path {}))

  ([directory-path {:keys [warn?] :or {warn? true}}]
   (try (if (check/directory-exists?     directory-path)
            (clojure.java.io/delete-file directory-path)
            (throw (Exception. config/DIRECTORY-DOES-NOT-EXIST-ERROR)))
        (catch Exception e (if warn? (println (str e " \"" directory-path "\"")))))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [delete-empty-directory!]]))

(io.api/delete-empty-directory! ...)
(delete-empty-directory!        ...)
```

</details>

---

### delete-file!

```
@param (string) filepath
@param (map)(opt) options
{:warn? (boolean)(opt)
  Default: true}
```

```
@usage
(delete-file! "my-directory/my-file.ext")
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn delete-file!
  ([filepath]
   (delete-file! filepath {}))

  ([filepath {:keys [warn?] :or {warn? true}}]
   (try (if (check/file-exists?          filepath)
            (clojure.java.io/delete-file filepath)
            (throw (Exception. config/FILE-DOES-NOT-EXIST-ERROR)))
       (catch Exception e (if warn? (println (str e " \"" filepath "\"")))))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [delete-file!]]))

(io.api/delete-file! ...)
(delete-file!        ...)
```

</details>

---

### directory-exists?

```
@description
Checks whether the directory exists on the given path.
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

<details>
<summary>Source code</summary>

```
(defn directory-exists?
  [directory-path]
  (let [directory (-> directory-path str clojure.java.io/file)]
       (and (-> directory .exists)
            (-> directory .isDirectory))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [directory-exists?]]))

(io.api/directory-exists? ...)
(directory-exists?        ...)
```

</details>

---

### directory-not-exists?

```
@description
Checks whether the directory does not exist on the given path.
```

```
@param (string) directory-path
```

```
@usage
(directory-not-exists? "my-directory/my-subdirectory")
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn directory-not-exists?
  [directory-path]
  (let [directory (-> directory-path str clojure.java.io/file)]
       (or (-> directory .exists      not)
           (-> directory .isDirectory not))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [directory-not-exists?]]))

(io.api/directory-not-exists? ...)
(directory-not-exists?        ...)
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

### directory?

```
@description
Checks whether the directory exists on the given path.
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

<details>
<summary>Source code</summary>

```
(defn directory?
  [directory-path]
  (directory-exists? directory-path))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [directory?]]))

(io.api/directory? ...)
(directory?        ...)
```

</details>

---

### empty-directory!

```
@param (string) directory-path
@param (map)(opt) options
{:warn? (boolean)(opt)
  Default: true}
```

```
@usage
(empty-directory! "my-directory/my-subdirectory")
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn empty-directory!
  ([directory-path]
   (empty-directory! directory-path {}))

  ([directory-path options]
   (doseq [item-path (read/item-list directory-path)]
          (if (check/directory? item-path)
              (do (empty-directory!        item-path options)
                  (delete-empty-directory! item-path options))
              (delete-file! item-path)))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [empty-directory!]]))

(io.api/empty-directory! ...)
(empty-directory!        ...)
```

</details>

---

### empty-directory?

```
@param (string) directory-path
@param (map)(opt) options
{:keep-hidden? (boolean)(opt)
  Default: false
 :warn? (boolean)(opt)
  Default: true}
```

```
@usage
(empty-directory? "my-directory/my-subdirectory")
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn empty-directory?
  ([directory-path]
   (empty-directory? directory-path {}))

  ([directory-path options]
   (-> directory-path (item-list options) empty?)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [empty-directory?]]))

(io.api/empty-directory? ...)
(empty-directory?        ...)
```

</details>

---

### empty-file!

```
@param (string) filepath
@param (map)(opt) options
{:create? (boolean)(opt)
  Default: false
 :return? (boolean)(opt)
  Default: true
 :warn? (boolean)(opt)
  Default: true}
```

```
@usage
(empty-file! "my-directory/my-file.ext")
```

```
@return (nil or string)
Returns with an empty string or with nil if the return? option is set to false.
```

<details>
<summary>Source code</summary>

```
(defn empty-file!
  ([filepath]
   (empty-file! filepath {}))

  ([filepath options]
   (write-file! filepath nil options)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [empty-file!]]))

(io.api/empty-file! ...)
(empty-file!        ...)
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

### file-exists?

```
@description
Checks whether the file exists on the given filepath.
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

<details>
<summary>Source code</summary>

```
(defn file-exists?
  [filepath]
  (let [file (-> filepath str clojure.java.io/file)]
       (and (-> file .exists)
            (-> file .isDirectory not))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [file-exists?]]))

(io.api/file-exists? ...)
(file-exists?        ...)
```

</details>

---

### file-list

```
@description
Returns with the filenames found on the given directory-path (non-recursive).
```

```
@param (string) directory-path
@param (map)(opt) options
{:keep-hidden? (boolean)(opt)
  Default: false
 :warn? (boolean)(opt)
  Default: true}
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

<details>
<summary>Source code</summary>

```
(defn file-list
  ([directory-path]
   (file-list directory-path {}))

  ([directory-path {:keys [keep-hidden? warn?] :or {warn? true}}]
   (try (if (check/directory-exists? directory-path)
            (let [file-seq (-> directory-path str clojure.java.io/file .listFiles)]
                 (helpers/file-seq->file-list directory-path file-seq {:keep-hidden? keep-hidden?}))
            (throw (Exception. config/DIRECTORY-DOES-NOT-EXIST-ERROR)))
       (catch Exception e (if warn? (println (str e " \"" directory-path "\"")))))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [file-list]]))

(io.api/file-list ...)
(file-list        ...)
```

</details>

---

### file-not-exists?

```
@description
Checks whether the file does not exist on the given filepath.
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

<details>
<summary>Source code</summary>

```
(defn file-not-exists?
  [filepath]
  (let [file (-> filepath str clojure.java.io/file)]
       (or (-> file .extists not)
           (-> file .isDirectory))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [file-not-exists?]]))

(io.api/file-not-exists? ...)
(file-not-exists?        ...)
```

</details>

---

### file?

```
@description
Checks whether the file exists on the given filepath.
```

```
@param (string) filepath
```

```
@usage
(file? "my-directory/my-file.ext")
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn file?
  [filepath]
  (file-exists? filepath))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [file?]]))

(io.api/file? ...)
(file?        ...)
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

### get-filesize

```
@param (string) filepath
@param (map)(opt) options
{:warn? (boolean)(opt)
  Default: true}
```

```
@usage
(get-filesize "my-directory/my-file.ext")
```

```
@return (B)
The length of the file in bytes
```

<details>
<summary>Source code</summary>

```
(defn get-filesize
  ([filepath]
   (get-filesize filepath {}))

  ([filepath {:keys [warn?] :or {warn? true}}]
   (try (if (check/file-exists? filepath)
            (->                 filepath str clojure.java.io/file .length)
            (throw (Exception. config/FILE-DOES-NOT-EXIST-ERROR)))
       (catch Exception e (if warn? (println (str e " \"" filepath "\"")))))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [get-filesize]]))

(io.api/get-filesize ...)
(get-filesize        ...)
```

</details>

---

### item-list

```
@description
Returns with the subdirectories and files found on the given directory-path (non-recursive).
```

```
@param (string) directory-path
@param (map)(opt) options
{:keep-hidden? (boolean)(opt)
  Default: false
 :warn? (boolean)(opt)
  Default: true}
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

<details>
<summary>Source code</summary>

```
(defn item-list
  ([directory-path]
   (item-list directory-path {}))

  ([directory-path {:keys [keep-hidden? warn?] :or {warn? true}}]
   (try (if (check/directory-exists? directory-path)
            (let [file-seq (-> directory-path str clojure.java.io/file .listFiles)]
                 (helpers/file-seq->item-list directory-path file-seq {:keep-hidden? keep-hidden?}))
            (throw (Exception. config/DIRECTORY-DOES-NOT-EXIST-ERROR)))
        (catch Exception e (if warn? (println (str e " \"" directory-path "\"")))))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [item-list]]))

(io.api/item-list ...)
(item-list        ...)
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

### max-filesize-reached?

```
@param (string) filepath
@param (B) max-filesize
@param (map)(opt) options
{:warn? (boolean)(opt)
  Default: true}
```

```
@usage
(max-filesize-reached? "my-directory/my-file.ext" 420)
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn max-filesize-reached?
  ([filepath max-filesize]
   (max-filesize-reached? filepath max-filesize {}))

  ([filepath max-filesize options]
   (if-let [filesize (get-filesize filepath options)]
           (>= filesize max-filesize))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [max-filesize-reached?]]))

(io.api/max-filesize-reached? ...)
(max-filesize-reached?        ...)
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

### prepend-to-file!

```
@param (string) filepath
@param (*) content
@param (map)(opt) options
{:create? (boolean)(opt)
  Default: false
 :max-line-count (integer)(opt)
 :return? (boolean)(opt)
  Default: true
 :warn? (boolean)(opt)
  Default: true}
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
@return (nil or string)
Returns with the file's content or with nil if the return? option is set to false.
```

<details>
<summary>Source code</summary>

```
(defn prepend-to-file!
  ([filepath content]
   (prepend-to-file! filepath content {}))

  ([filepath content {:keys [max-line-count] :as options}]
   (let [file-content (read/read-file filepath)
         output       (str content "\n" file-content)]
        (if max-line-count (let [output (string/max-lines output max-line-count)]
                                (write-file! filepath output options))
                           (write-file! filepath output options)))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [prepend-to-file!]]))

(io.api/prepend-to-file! ...)
(prepend-to-file!        ...)
```

</details>

---

### read-edn-file

```
@param (string) filepath
@param (map)(opt) options
{:warn? (boolean)(opt)
  Default: true}
```

```
@usage
(read-edn-file "my-directory/my-file.edn")
```

```
@return (*)
```

<details>
<summary>Source code</summary>

```
(defn read-edn-file
  ([filepath]
   (read-edn-file filepath {}))

  ([filepath options]
   (let [file-content (read/read-file filepath options)]
        (if (-> file-content string/trim some?)
            (-> file-content reader/string->mixed)))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [read-edn-file]]))

(io.api/read-edn-file ...)
(read-edn-file        ...)
```

</details>

---

### read-edn-header

```
@param (string) filepath
@param (map)(opt) options
{:warn? (boolean)(opt)
  Default: true}
```

```
@usage
(read-edn-header "my-directory/my-file.edn")
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn read-edn-header
  ([filepath]
   (read-edn-header filepath {}))

  ([filepath options]
   (let [file-content (read/read-file filepath options)]
        (letfn [(cut-row      [n]   (string/after-first-occurence n "\n"))
                (comment-row? [row] (-> row (string/trim)
                                            (string/starts-with? "                (empty-row?   [row] (-> row (string/trim)
                                            (= "")))
                (append-row   [result row]
                              (let [row (string/after-first-occurence row "                                   (if result (str result "\n" row)
                                              (str             row))))
                (f [result n] (if-let [first-row (string/before-first-occurence n "\n" {:return? false})]
                                      (cond (comment-row?         first-row)
                                            (f (append-row result first-row)
                                               (cut-row n))
                                            (empty-row? first-row)
                                            (f (str result "\n")
                                               (cut-row n))
                                            :else
                                            (return result))
                                      (return result)))]
               (f "" file-content)))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [read-edn-header]]))

(io.api/read-edn-header ...)
(read-edn-header        ...)
```

</details>

---

### read-file

```
@param (string) filepath
@param (map)(opt) options
{:warn? (boolean)(opt)
  Default: true}
```

```
@usage
(read-file "my-directory/my-file.ext")
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn read-file
  ([filepath]
   (read-file filepath {}))

  ([filepath {:keys [warn?] :or {warn? true}}]
   (try (if (check/file-exists? filepath)
            (slurp              filepath)
            (throw (Exception. config/FILE-DOES-NOT-EXIST-ERROR)))
       (catch Exception e (if warn? (println (str e " \"" filepath "\"")))))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [read-file]]))

(io.api/read-file ...)
(read-file        ...)
```

</details>

---

### read-resource-file

```
@param (string) resource-path
@param (map)(opt) options
{:warn? (boolean)(opt)
  Default: true}
```

```
@usage
(read-resource-file "my-directory/my-file.ext")
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn read-resource-file
  ([resource-path]
   (read-resource-file resource-path {}))

  ([resource-path {:keys [warn?] :or {warn? true}}]
   (try (if-let [resource-url (clojure.java.io/resource resource-path)]
                (slurp resource-url)
                (throw (Exception. config/RESOURCE-DOES-NOT-EXIST-ERROR)))
        (catch Exception e (if warn? (println (str e " \"" resource-path "\"")))))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [read-resource-file]]))

(io.api/read-resource-file ...)
(read-resource-file        ...)
```

</details>

---

### resource-directory-exists?

```
@description
Checks whether the resource directory exists on the given resource path.
```

```
@param (string) resource-path
```

```
@usage
(resource-directory-exists? "my-directory")
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn resource-directory-exists?
  [resource-path]
  (if-let [resource-url (clojure.java.io/resource resource-path)]
          (-> resource-url clojure.java.io/file .isDirectory)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [resource-directory-exists?]]))

(io.api/resource-directory-exists? ...)
(resource-directory-exists?        ...)
```

</details>

---

### resource-directory-not-exists?

```
@description
Checks whether the resource directory does not exist on the given resource path.
```

```
@param (string) resource-path
```

```
@usage
(resource-directory-not-exists? "my-directory")
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn resource-directory-not-exists?
  [resource-path]
  (if-let [resource-url (clojure.java.io/resource resource-path)]
          (-> resource-url clojure.java.io/file .isDirectory not)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [resource-directory-not-exists?]]))

(io.api/resource-directory-not-exists? ...)
(resource-directory-not-exists?        ...)
```

</details>

---

### resource-directory?

```
@description
Checks whether the resource directory exists on the given resource path.
```

```
@param (string) resource-path
```

```
@usage
(resource-directory? "my-directory")
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn resource-directory?
  [resource-path]
  (resource-directory-exists? resource-path))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [resource-directory?]]))

(io.api/resource-directory? ...)
(resource-directory?        ...)
```

</details>

---

### resource-file-exists?

```
@description
Checks whether the resource file exists on the given resource path.
```

```
@param (string) resource-path
```

```
@usage
(resource-file-exists? "my-directory/my-file.ext")
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn resource-file-exists?
  [resource-path]
  (if-let [resource-url (clojure.java.io/resource resource-path)]
          (-> resource-url clojure.java.io/file .isFile)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [resource-file-exists?]]))

(io.api/resource-file-exists? ...)
(resource-file-exists?        ...)
```

</details>

---

### resource-file-list

```
@param (string) directory-path
@param (map)(opt) options
{:warn? (boolean)(opt)
  Default: true}
```

```
@usage
(resource-file-list "my-directory")
```

```
@example
(resource-file-list "my-directory")
=>
["my-directory/my-file.ext" ...]
```

```
@return (strings in vector)
```

<details>
<summary>Source code</summary>

```
(defn resource-file-list
  ([directory-path]
   (resource-file-list directory-path {}))

  ([directory-path {:keys [warn?] :or {warn? true}}]
   (try (if-let [resource-url (clojure.java.io/resource directory-path)]
                (let [resource-root-url (helpers/get-resource-root-url directory-path)
                      directory         (-> resource-url clojure.java.io/file)]
                     (and (-> directory .isDirectory)
                          (let [file-seq (-> directory .listFiles)]
                               (letfn [(f [%] (string/not-starts-with! (-> % .toURI .normalize) resource-root-url))]
                                      (helpers/file-seq->file-list (str directory-path "/") file-seq {:output-f f})))))
                (throw (Exception. config/RESOURCE-DOES-NOT-EXIST-ERROR)))
        (catch Exception e (if warn? (println (str e " \"" directory-path "\"")))))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [resource-file-list]]))

(io.api/resource-file-list ...)
(resource-file-list        ...)
```

</details>

---

### resource-file-not-exists?

```
@description
Checks whether the resource file does not exist on the given resource path.
```

```
@param (string) resource-path
```

```
@usage
(resource-file-not-exists? "my-directory/my-file.ext")
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn resource-file-not-exists?
  [resource-path]
  (if-let [resource-url (clojure.java.io/resource resource-path)]
          (-> resource-url clojure.java.io/file .isFile not)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [resource-file-not-exists?]]))

(io.api/resource-file-not-exists? ...)
(resource-file-not-exists?        ...)
```

</details>

---

### resource-file?

```
@description
Checks whether the resource file exists on the given resource path.
```

```
@param (string) resource-path
```

```
@usage
(resource-file? "my-directory/my-file.ext")
```

```
@return (boolean)
```

<details>
<summary>Source code</summary>

```
(defn resource-file?
  [resource-path]
  (resource-file-exists? resource-path))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [resource-file?]]))

(io.api/resource-file? ...)
(resource-file?        ...)
```

</details>

---

### subdirectory-list

```
@description
Returns with the subdirectories found on the given directory-path (non-recursive).
```

```
@param (string) directory-path
@param (map)(opt) options
{:keep-hidden? (boolean)(opt)
  Default: false
 :warn? (boolean)(opt)
  Default: true}
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

<details>
<summary>Source code</summary>

```
(defn subdirectory-list
  ([directory-path]
   (subdirectory-list directory-path {}))

  ([directory-path {:keys [keep-hidden? warn?] :or {warn? true}}]
   (try (if (check/directory-exists? directory-path)
            (let [file-seq (-> directory-path str clojure.java.io/file .listFiles)]
                 (helpers/file-seq->directory-list directory-path file-seq {:keep-hidden? keep-hidden?}))
            (throw (Exception. config/DIRECTORY-DOES-NOT-EXIST-ERROR)))
        (catch Exception e (if warn? (println (str e " \"" directory-path "\"")))))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [subdirectory-list]]))

(io.api/subdirectory-list ...)
(subdirectory-list        ...)
```

</details>

---

### swap-edn-file!

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
Returns with the file's content (the reader procceses the content to data).
```

<details>
<summary>Source code</summary>

```
(defn swap-edn-file!
  [filepath f & params]
  (let [edn    (read-edn-file    filepath)
        params (vector/cons-item params edn)
        output (apply          f params)]
       (write-edn-file! filepath output {:create? true :warn? true})
       (read-edn-file   filepath {:warn? false})))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [swap-edn-file!]]))

(io.api/swap-edn-file! ...)
(swap-edn-file!        ...)
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

### valid-absolute-path

```
@param (string) n
```

```
@usage
(valid-absolute-path "my-directory")
```

```
@example
(valid-absolute-path "my-directory")
=>
"my-directory"
```

```
@example
(valid-absolute-path "/my-directory/")
=>
"my-directory"
```

```
@example
(valid-absolute-path "")
=>
""
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn valid-absolute-path
  [n]
  (-> n (string/not-ends-with!   "/")
        (string/not-starts-with! "/")))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [valid-absolute-path]]))

(io.api/valid-absolute-path ...)
(valid-absolute-path        ...)
```

</details>

---

### valid-relative-path

```
@param (string) n
```

```
@usage
(valid-relative-path "/my-directory")
```

```
@example
(valid-relative-path "/my-directory")
=>
"/my-directory"
```

```
@example
(valid-relative-path "my-directory/")
=>
"/my-directory"
```

```
@example
(valid-relative-path "")
=>
"/"
```

```
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn valid-relative-path
  [n]
  (-> n (string/not-ends-with! "/")
        (string/starts-with!   "/")))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [valid-relative-path]]))

(io.api/valid-relative-path ...)
(valid-relative-path        ...)
```

</details>

---

### write-edn-file!

```
@param (string) filepath
@param (*) content
@param (map)(opt) options
{:abc? (boolean)(opt)
  Default: false
 :create? (boolean)(opt)
  Default: false
 :return? (boolean)(opt)
  Default: true
 :warn? (boolean)(opt)
  Default: true}
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
@return (*)
Returns with the file's content (the reader procceses the content to data),
or with nil if the return? option is set to false.
```

<details>
<summary>Source code</summary>

```
(defn write-edn-file!
  ([filepath content]
   (write-edn-file! filepath content {}))

  ([filepath content {:keys [abc? return?] :or {return? true} :as options}]
   (let [output (pretty/mixed->string content {:abc? abc?})]
        (actions/write-file! filepath (str "\n" output "\n" ) options))
   (if return? (read-edn-file filepath {:warn? false}))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [write-edn-file!]]))

(io.api/write-edn-file! ...)
(write-edn-file!        ...)
```

</details>

---

### write-edn-header!

```
@param (string) filepath
@param (string) header
@param (map)(opt) options
@param (map)(opt) options
{:create? (boolean)(opt)
  Default: false
 :return? (boolean)(opt)
  Default: true
 :warn? (boolean)(opt)
  Default: true}
```

```
@usage
(write-edn-header! "my-directory/my-file.edn" "My header\nI love comments!")
```

```
@return (nil or string)
Returns with the file's content (as string) or with nil if the return? option is set to false.
```

<details>
<summary>Source code</summary>

```
(defn write-edn-header!
  ([filepath header]
   (write-edn-header! filepath header {}))

  ([filepath header options]
   (let [file-content (read/read-file filepath options)]
        (letfn [(f [result n]
                   (if-let [last-row (string/after-last-occurence n "\n")]
                           (f (str "                              (string/before-last-occurence n "\n" {:return? false}))
                           (return result)))]
               (let [file-content (str "\n" (f file-content header))]
                    (actions/write-file! filepath file-content options))))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [write-edn-header!]]))

(io.api/write-edn-header! ...)
(write-edn-header!        ...)
```

</details>

---

### write-file!

```
@param (string) filepath
@param (*) content
@param (map)(opt) options
{:create? (boolean)(opt)
  Default: false
 :return? (boolean)(opt)
  Default: true
 :warn? (boolean)(opt)
  Default: true}
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
@return (nil or string)
Returns with the file's content or with nil if the return? option is set to false.
```

<details>
<summary>Source code</summary>

```
(defn write-file!
  ([filepath content]
   (write-file! filepath content {}))

  ([filepath content {:keys [create? return? warn?] :or {return? true warn? true} :as options}]
   (if (check/file-exists? filepath)
       (spit filepath (str content))
       (if create? (do (create-path! filepath {:warn? false})
                       (if warn? (println (str config/CREATE-FILE-MESSAGE " \"" filepath "\"")))
                       (spit filepath (str content)))
                   (if warn? (println (str config/FILE-DOES-NOT-EXIST-ERROR " \"" filepath "\"")))))
   (if return? (read/read-file filepath))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :refer [write-file!]]))

(io.api/write-file! ...)
(write-file!        ...)
```

</details>

---

This documentation is generated by the [docs-api](https://github.com/bithandshake/docs-api) engine


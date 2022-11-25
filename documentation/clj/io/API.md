
# <strong>io.api</strong> namespace
<p>Documentation of the <strong>io/api.clj</strong> file</p>

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

### all-file-list

```
@param (string) directory-path
@param (map)(opt) options
{:warn? (boolean)(opt)
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

  ([directory-path {:keys [warn?] :or {warn? true}}]
   (try (if (check/directory-exists? directory-path)
            (let [directory (clojure.java.io/file directory-path)
                  file-seq  (file-seq             directory)]
                 (letfn [(f [%] (and (-> % .isFile)
                                     (-> % .isHidden not)))]
                        (mapv str (filter f file-seq))))
            (throw (Exception. config/DIRECTORY-DOES-NOT-EXIST-ERROR)))
        (catch Exception e (if warn? (println (str e " \"" directory-path "\"")))))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :as io :refer [all-file-list]]))

(io/all-file-list ...)
(all-file-list    ...)
```

</details>

---

### all-item-list

```
@param (string) directory-path
@param (map)(opt) options
{:warn? (boolean)(opt)
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

  ([directory-path {:keys [warn?] :or {warn? true}}]
   (try (if (check/directory-exists? directory-path)
            (vector/remove-item (mapv  str (-> directory-path clojure.java.io/file file-seq))
                                (param directory-path))
            (throw (Exception. config/DIRECTORY-DOES-NOT-EXIST-ERROR)))
        (catch Exception e (if warn? (println (str e " \"" directory-path "\"")))))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :as io :refer [all-item-list]]))

(io/all-item-list ...)
(all-item-list    ...)
```

</details>

---

### all-subdirectory-list

```
@param (string) directory-path
@param (map)(opt) options
{:warn? (boolean)(opt)
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

  ([directory-path {:keys [warn?] :or {warn? true}}]
   (try (if (check/directory-exists? directory-path)
            (let [directory (clojure.java.io/file directory-path)
                  file-seq  (file-seq             directory)]
                 (letfn [(f [%] (and (-> % .isDirectory)
                                     (-> % .isHidden not)))]
                        (mapv str (filter f file-seq))))
            (throw (Exception. config/DIRECTORY-DOES-NOT-EXIST-ERROR)))
        (catch Exception e (if warn? (println (str e " \"" directory-path "\"")))))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :as io :refer [all-subdirectory-list]]))

(io/all-subdirectory-list ...)
(all-subdirectory-list    ...)
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
@return (nil)
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
(ns my-namespace (:require [io.api :as io :refer [append-to-file!]]))

(io/append-to-file! ...)
(append-to-file!    ...)
```

</details>

---

### copy-file!

```
@param (string) source-filepath
@param (string) destination-filepath
@param (map)(opt) options
 {:warn? (boolean)(opt)
   Default: true}
```

```
@usage
(copy-file! "my-directory/my-source-file.ext"
            "my-directory/my-destination-file.ext")
```

```
@return (nil)
```

<details>
<summary>Source code</summary>

```
(defn copy-file!
  ([source-filepath destination-filepath]
   (copy-file! source-filepath destination-filepath {}))

  ([source-filepath destination-filepath {:keys [warn?] :or {warn? true}}]
   (try (if (check/file-exists? source-filepath)
            (clojure.java.io/copy (clojure.java.io/file      source-filepath)
                                  (clojure.java.io/file destination-filepath))
            (throw (Exception. config/FILE-DOES-NOT-EXIST-ERROR)))
        (catch Exception e (if warn? (println (str e " \"" source-filepath "\"")))))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :as io :refer [copy-file!]]))

(io/copy-file! ...)
(copy-file!    ...)
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
(ns my-namespace (:require [io.api :as io :refer [copy-uri-to-file!]]))

(io/copy-uri-to-file! ...)
(copy-uri-to-file!    ...)
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
   (when-not (check/directory-exists? directory-path)
             (if warn? (println (str config/CREATE-DIRECTORY-MESSAGE " \"" directory-path "\"")))
             (try (-> directory-path java.io.File. .mkdirs)
                  (catch Exception e (println e))))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :as io :refer [create-directory!]]))

(io/create-directory! ...)
(create-directory!    ...)
```

</details>

---

### create-edn-file!

```
@param (string) filepath
@param (map)(opt) options
 {:warn? (boolean)(opt)
   Default: true}
```

```
@usage
(create-edn-file! "my-directory/my-file.edn")
```

```
@return (nil)
```

<details>
<summary>Source code</summary>

```
(defn create-edn-file!
  ([filepath]
   (create-edn-file! filepath {}))

  ([filepath {:keys [warn?] :or {warn? true}}]
   (when-not (check/file-exists? filepath)
             (if warn? (println (str config/CREATE-FILE-MESSAGE " \"" filepath "\"")))
             (spit filepath "\n{}"))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :as io :refer [create-edn-file!]]))

(io/create-edn-file! ...)
(create-edn-file!    ...)
```

</details>

---

### create-file!

```
@param (string) filepath
@param (map)(opt) options
 {:warn? (boolean)(opt)
   Default: true}
```

```
@usage
(create-file! "my-directory/my-file.ext")
```

```
@return (nil)
```

<details>
<summary>Source code</summary>

```
(defn create-file!
  ([filepath]
   (create-file! filepath {}))

  ([filepath {:keys [warn?] :or {warn? true}}]
   (when-not (check/file-exists? filepath)
             (if warn? (println (str config/CREATE-FILE-MESSAGE " \"" filepath "\"")))
             (spit filepath nil))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :as io :refer [create-file!]]))

(io/create-file! ...)
(create-file!    ...)
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
(ns my-namespace (:require [io.api :as io :refer [delete-directory!]]))

(io/delete-directory! ...)
(delete-directory!    ...)
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
(ns my-namespace (:require [io.api :as io :refer [delete-empty-directory!]]))

(io/delete-empty-directory! ...)
(delete-empty-directory!    ...)
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
(ns my-namespace (:require [io.api :as io :refer [delete-file!]]))

(io/delete-file! ...)
(delete-file!    ...)
```

</details>

---

### directory-exists?

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
  (let [directory (clojure.java.io/file directory-path)]
       (and (.exists      directory)
            (.isDirectory directory))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :as io :refer [directory-exists?]]))

(io/directory-exists? ...)
(directory-exists?    ...)
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

### directory?

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
  (-> directory-path clojure.java.io/file .isDirectory))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :as io :refer [directory?]]))

(io/directory? ...)
(directory?    ...)
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
(ns my-namespace (:require [io.api :as io :refer [empty-directory!]]))

(io/empty-directory! ...)
(empty-directory!    ...)
```

</details>

---

### empty-directory?

```
@param (string) directory-path
@param (map)(opt) options
{:warn? (boolean)(opt)
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

  ([directory-path {:keys [warn?] :or {warn? true}}]
   (try (if (check/directory-exists? directory-path)
            (-> directory-path item-list empty?)
            (throw (Exception. config/DIRECTORY-DOES-NOT-EXIST-ERROR)))
        (catch Exception e (if warn? (println (str e " \"" directory-path "\"")))))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :as io :refer [empty-directory?]]))

(io/empty-directory? ...)
(empty-directory?    ...)
```

</details>

---

### empty-file!

```
@param (string) filepath
@param (map)(opt) options
 {:create? (boolean)(opt)
   Default: false
  :warn? (boolean)(opt)
   Default: true}
```

```
@usage
(empty-file! "my-directory/my-file.ext")
```

```
@return (nil)
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
(ns my-namespace (:require [io.api :as io :refer [empty-file!]]))

(io/empty-file! ...)
(empty-file!    ...)
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
  (get config/MIME-TYPES (string/lowercase extension) "unknown/unknown"))
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

### file-exists?

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
  (let [file (clojure.java.io/file filepath)]
       (and (-> file .exists)
            (-> file .isDirectory not))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :as io :refer [file-exists?]]))

(io/file-exists? ...)
(file-exists?    ...)
```

</details>

---

### file-list

```
@param (string) directory-path
@param (map)(opt) options
{:warn? (boolean)(opt)
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

  ([directory-path {:keys [warn?] :or {warn? true}}]
   (try (if (check/directory-exists? directory-path)
            (let [directory (clojure.java.io/file directory-path)
                  file-seq  (.listFiles           directory)]
                 (letfn [(f [%] (and (-> % .isFile)
                                     (-> % .isHidden not)))]
                        (mapv str (filter f file-seq))))
            (throw (Exception. config/DIRECTORY-DOES-NOT-EXIST-ERROR)))
       (catch Exception e (if warn? (println (str e " \"" directory-path "\"")))))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :as io :refer [file-list]]))

(io/file-list ...)
(file-list    ...)
```

</details>

---

### file-not-exists?

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
  (let [file (clojure.java.io/file filepath)]
       (or (-> file .extists not)
           (-> file .isDirectory))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :as io :refer [file-not-exists?]]))

(io/file-not-exists? ...)
(file-not-exists?    ...)
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
               (string/lowercase extension))))
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
            (->                 filepath clojure.java.io/file .length)
            (throw (Exception. config/FILE-DOES-NOT-EXIST-ERROR)))
       (catch Exception e (if warn? (println (str e " \"" filepath "\"")))))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :as io :refer [get-filesize]]))

(io/get-filesize ...)
(get-filesize    ...)
```

</details>

---

### item-list

```
@param (string) directory-path
@param (map)(opt) options
{:warn? (boolean)(opt)
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

  ([directory-path {:keys [warn?] :or {warn? true}}]
   (try (if (check/directory-exists? directory-path)
            (vector/remove-item (mapv  str (-> directory-path clojure.java.io/file .listFiles))
                                (param directory-path))
            (throw (Exception. config/DIRECTORY-DOES-NOT-EXIST-ERROR)))
        (catch Exception e (if warn? (println (str e " \"" directory-path "\"")))))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :as io :refer [item-list]]))

(io/item-list ...)
(item-list    ...)
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
(ns my-namespace (:require [io.api :as io :refer [max-filesize-reached?]]))

(io/max-filesize-reached? ...)
(max-filesize-reached?    ...)
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
  (get config/EXTENSIONS (string/lowercase mime-type) "unknown"))
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

### prepend-to-file!

```
@param (string) filepath
@param (*) content
@param (map)(opt) options
{:create? (boolean)(opt)
  Default: false
 :max-line-count (integer)(opt)
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
@return (nil)
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
(ns my-namespace (:require [io.api :as io :refer [prepend-to-file!]]))

(io/prepend-to-file! ...)
(prepend-to-file!    ...)
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
(ns my-namespace (:require [io.api :as io :refer [read-edn-file]]))

(io/read-edn-file ...)
(read-edn-file    ...)
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
(ns my-namespace (:require [io.api :as io :refer [read-file]]))

(io/read-file ...)
(read-file    ...)
```

</details>

---

### subdirectory-list

```
@param (string) directory-path
@param (map)(opt) options
{:warn? (boolean)(opt)
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

  ([directory-path {:keys [warn?] :or {warn? true}}]
   (try (if (check/directory-exists? directory-path)
            (let [directory (clojure.java.io/file directory-path)
                  file-seq  (.listFiles           directory)]
                 (letfn [(f [%] (and (-> % .isDirectory)
                                     (-> % .isHidden not)))]
                        (mapv str (filter f file-seq))))
            (throw (Exception. config/DIRECTORY-DOES-NOT-EXIST-ERROR)))
        (catch Exception e (if warn? (println (str e " \"" directory-path "\"")))))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :as io :refer [subdirectory-list]]))

(io/subdirectory-list ...)
(subdirectory-list    ...)
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
```

<details>
<summary>Source code</summary>

```
(defn swap-edn-file!
  [filepath f & params]
  (let [edn    (read-edn-file    filepath)
        params (vector/cons-item params edn)
        output (apply          f params)]
       (write-edn-file! filepath output)
       (return                   output)))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :as io :refer [swap-edn-file!]]))

(io/swap-edn-file! ...)
(swap-edn-file!    ...)
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

---

### write-edn-file!

```
@param (string) filepath
@param (*) content
@param (map)(opt) options
{:abc? (boolean)(opt)
  Default: false
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
@return (string)
```

<details>
<summary>Source code</summary>

```
(defn write-edn-file!
  ([filepath content]
   (write-edn-file! filepath content {}))

  ([filepath content {:keys [abc? warn?] :or {warn? true}}]
   (let [output (pretty/mixed->string content {:abc? abc?})]
        (actions/write-file! filepath (str "\n" output) {:create? true :warn? warn?})
        (return content))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :as io :refer [write-edn-file!]]))

(io/write-edn-file! ...)
(write-edn-file!    ...)
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
@return (nil)
```

<details>
<summary>Source code</summary>

```
(defn write-file!
  ([filepath content]
   (write-file! filepath content {}))

  ([filepath content {:keys [create? warn?] :or {warn? true} :as options}]
   (if (check/file-exists? filepath)
       (spit filepath (str content))
       (if create? (do (if warn? (println (str config/CREATE-FILE-MESSAGE " \"" filepath "\"")))
                       (if-let [directory-path (file/filepath->directory-path filepath)]
                               (if-not (check/directory-exists? directory-path)
                                       (create-directory!       directory-path options)))
                       (spit filepath (str content)))
                   (if warn? (println (str config/FILE-DOES-NOT-EXIST-ERROR " \"" filepath "\"")))))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [io.api :as io :refer [write-file!]]))

(io/write-file! ...)
(write-file!    ...)
```

</details>

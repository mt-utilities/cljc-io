
(ns io.read
    (:require [clojure.java.io]
              [io.check   :as check]
              [io.config  :as config]
              [io.helpers :as helpers]
              [noop.api   :refer [param return]]
              [string.api :as string]
              [vector.api :as vector]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn read-resource-file
  ; @param (string) resource-path
  ; @param (map)(opt) options
  ; {:warn? (boolean)(opt)
  ;   Default: true}
  ;
  ; @usage
  ; (read-resource-file "my-directory/my-file.ext")
  ;
  ; @return (string)
  ([resource-path]
   (read-resource-file resource-path {}))

  ([resource-path {:keys [warn?] :or {warn? true}}]
   (try (if-let [resource-url (clojure.java.io/resource resource-path)]
                (slurp resource-url)
                (throw (Exception. config/RESOURCE-DOES-NOT-EXIST-ERROR)))
        (catch Exception e (if warn? (println (str e " \"" resource-path "\"")))))))

(defn resource-file-list
  ; @param (string) directory-path
  ; @param (map)(opt) options
  ; {:warn? (boolean)(opt)
  ;   Default: true}
  ;
  ; @usage
  ; (resource-file-list "my-directory")
  ;
  ; @example
  ; (resource-file-list "my-directory")
  ; =>
  ; ["my-directory/my-file.ext" ...]
  ;
  ; @return (strings in vector)
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

(defn all-resource-file-list
  ; @param (string) directory-path
  ; @param (map)(opt) options
  ; {:warn? (boolean)(opt)
  ;   Default: true}
  ;
  ; @usage
  ; (all-resource-file-list "my-directory")
  ;
  ; @example
  ; (all-resource-file-list "my-directory")
  ; =>
  ; ["my-directory/my-file.ext" ...]
  ;
  ; @return (strings in vector)
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

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn read-file
  ; @param (string) filepath
  ; @param (map)(opt) options
  ; {:warn? (boolean)(opt)
  ;   Default: true}
  ;
  ; @usage
  ; (read-file "my-directory/my-file.ext")
  ;
  ; @return (string)
  ([filepath]
   (read-file filepath {}))

  ([filepath {:keys [warn?] :or {warn? true}}]
   (try (if (check/file-exists? filepath)
            (slurp              filepath)
            (throw (Exception. config/FILE-DOES-NOT-EXIST-ERROR)))
       (catch Exception e (if warn? (println (str e " \"" filepath "\"")))))))

(defn file-list
  ; @description
  ; Returns with the filenames found on the given directory-path (non-recursive).
  ;
  ; @param (string) directory-path
  ; @param (map)(opt) options
  ; {:keep-hidden? (boolean)(opt)
  ;   Default: false
  ;  :warn? (boolean)(opt)
  ;   Default: true}
  ;
  ; @example
  ; (file-list "my-directory")
  ; =>
  ; ["my-directory/my-file.ext" ...]
  ;
  ; @return (strings in vector)
  ([directory-path]
   (file-list directory-path {}))

  ([directory-path {:keys [keep-hidden? warn?] :or {warn? true}}]
   ; XXX#7440 (source-code/clj/io/README.md)
   (try (if (check/directory-exists? directory-path)
            (let [file-seq (-> directory-path str clojure.java.io/file .listFiles)]
                 (helpers/file-seq->file-list directory-path file-seq {:keep-hidden? keep-hidden?}))
            (throw (Exception. config/DIRECTORY-DOES-NOT-EXIST-ERROR)))
       (catch Exception e (if warn? (println (str e " \"" directory-path "\"")))))))

(defn all-file-list
  ; @description
  ; Returns with the filenames found on the given directory-path (recursive).
  ;
  ; @param (string) directory-path
  ; @param (map)(opt) options
  ; {:keep-hidden? (boolean)(opt)
  ;   Default: false
  ;  :warn? (boolean)(opt)
  ;   Default: true}
  ;
  ; @example
  ; (all-file-list "my-directory")
  ; =>
  ; ["my-directory/my-file.ext" ...]
  ;
  ; @return (strings in vector)
  ([directory-path]
   (all-file-list directory-path {}))

  ([directory-path {:keys [keep-hidden? warn?] :or {warn? true}}]
   ; XXX#7440 (source-code/clj/io/README.md)
   (try (if (check/directory-exists? directory-path)
            (let [file-seq (-> directory-path str clojure.java.io/file file-seq)]
                 (helpers/file-seq->file-list directory-path file-seq {:keep-hidden? keep-hidden?}))
            (throw (Exception. config/DIRECTORY-DOES-NOT-EXIST-ERROR)))
        (catch Exception e (if warn? (println (str e " \"" directory-path "\"")))))))

(defn subdirectory-list
  ; @description
  ; Returns with the subdirectories found on the given directory-path (non-recursive).
  ;
  ; @param (string) directory-path
  ; @param (map)(opt) options
  ; {:keep-hidden? (boolean)(opt)
  ;   Default: false
  ;  :warn? (boolean)(opt)
  ;   Default: true}
  ;
  ; @example
  ; (subdirectory-list "my-directory")
  ; =>
  ; ["my-directory/my-subdirectory" ...]
  ;
  ; @return (strings in vector)
  ([directory-path]
   (subdirectory-list directory-path {}))

  ([directory-path {:keys [keep-hidden? warn?] :or {warn? true}}]
   ; XXX#7440 (source-code/clj/io/README.md)
   (try (if (check/directory-exists? directory-path)
            (let [file-seq (-> directory-path str clojure.java.io/file .listFiles)]
                 (helpers/file-seq->directory-list directory-path file-seq {:keep-hidden? keep-hidden?}))
            (throw (Exception. config/DIRECTORY-DOES-NOT-EXIST-ERROR)))
        (catch Exception e (if warn? (println (str e " \"" directory-path "\"")))))))

(defn all-subdirectory-list
  ; @description
  ; Returns with the subdirectories found on the given directory-path (recursive).
  ;
  ; @param (string) directory-path
  ; @param (map)(opt) options
  ; {:keep-hidden? (boolean)(opt)
  ;   Default: false
  ;  :warn? (boolean)(opt)
  ;   Default: true}
  ;
  ; @example
  ; (all-subdirectory-list "my-directory")
  ; =>
  ; ["my-directory/my-subdirectory" ...]
  ;
  ; @return (strings in vector)
  ([directory-path]
   (all-subdirectory-list directory-path {}))

  ([directory-path {:keys [keep-hidden? warn?] :or {warn? true}}]
   ; XXX#7440 (source-code/clj/io/README.md)
   (try (if (check/directory-exists? directory-path)
            (let [file-seq (-> directory-path str clojure.java.io/file file-seq)]
                 (helpers/file-seq->directory-list directory-path file-seq {:keep-hidden? keep-hidden?}))
            (throw (Exception. config/DIRECTORY-DOES-NOT-EXIST-ERROR)))
        (catch Exception e (if warn? (println (str e " \"" directory-path "\"")))))))

(defn item-list
  ; @description
  ; Returns with the subdirectories and files found on the given directory-path (non-recursive).
  ;
  ; @param (string) directory-path
  ; @param (map)(opt) options
  ; {:keep-hidden? (boolean)(opt)
  ;   Default: false
  ;  :warn? (boolean)(opt)
  ;   Default: true}
  ;
  ; @example
  ; (item-list "my-directory")
  ; =>
  ; ["my-directory/my-subdirectory" "my-directory/my-subdirectory/my-file.ext" ...]
  ;
  ; @return (strings in vector)
  ([directory-path]
   (item-list directory-path {}))

  ([directory-path {:keys [keep-hidden? warn?] :or {warn? true}}]
   ; XXX#7440 (source-code/clj/io/README.md)
   (try (if (check/directory-exists? directory-path)
            (let [file-seq (-> directory-path str clojure.java.io/file .listFiles)]
                 (helpers/file-seq->item-list directory-path file-seq {:keep-hidden? keep-hidden?}))
            (throw (Exception. config/DIRECTORY-DOES-NOT-EXIST-ERROR)))
        (catch Exception e (if warn? (println (str e " \"" directory-path "\"")))))))

(defn all-item-list
  ; @description
  ; Returns with the subdirectories and files found on the given directory-path (recursive).
  ;
  ; @param (string) directory-path
  ; @param (map)(opt) options
  ; {:keep-hidden? (boolean)(opt)
  ;   Default: false
  ;  :warn? (boolean)(opt)
  ;   Default: true}
  ;
  ; @example
  ; (all-item-list "my-directory")
  ; =>
  ; ["my-directory/my-subdirectory" "my-directory/my-subdirectory/my-file.ext" ...]
  ;
  ; @return (strings in vector)
  ([directory-path]
   (all-item-list directory-path {}))

  ([directory-path {:keys [keep-hidden? warn?] :or {warn? true}}]
   ; XXX#7440 (source-code/clj/io/README.md)
   (try (if (check/directory-exists? directory-path)
            (let [file-seq (-> directory-path str clojure.java.io/file file-seq)]
                 (helpers/file-seq->item-list directory-path file-seq {:keep-hidden? keep-hidden?}))
            (throw (Exception. config/DIRECTORY-DOES-NOT-EXIST-ERROR)))
        (catch Exception e (if warn? (println (str e " \"" directory-path "\"")))))))

(defn empty-directory?
  ; @param (string) directory-path
  ; @param (map)(opt) options
  ; {:keep-hidden? (boolean)(opt)
  ;   Default: false
  ;  :warn? (boolean)(opt)
  ;   Default: true}
  ;
  ; @usage
  ; (empty-directory? "my-directory/my-subdirectory")
  ;
  ; @return (boolean)
  ([directory-path]
   (empty-directory? directory-path {}))

  ([directory-path options]
   (-> directory-path (item-list options) empty?)))

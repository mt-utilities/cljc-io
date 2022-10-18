
;; -- Namespace ---------------------------------------------------------------
;; ----------------------------------------------------------------------------

(ns io.read
    (:require [clojure.java.io]
              [io.check          :as check]
              [io.config         :as config]
              [mid-fruits.candy  :refer [param]]
              [mid-fruits.vector :as vector]))



;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn read-file
  ; @param (string) filepath
  ;
  ; @return (string)
  [filepath]
  (try (if (check/file-exists? filepath)
           (slurp              filepath)
           (throw (Exception. config/FILE-DOES-NOT-EXIST-ERROR)))
      (catch Exception e (println (str e " \"" filepath "\"")))))

(defn file-list
  ; @description
  ;  A directory-path paraméterként átadott elérési útvonalon található
  ;  mappa fájljainak listája (egy mélységben).
  ;
  ; @param (string) directory-path
  ;
  ; @example
  ;  (io/file-list "my-directory")
  ;  =>
  ;  ["my-directory/my-file.ext" ...]
  ;
  ; @return (strings in vector)
  [directory-path]
  (let [directory (clojure.java.io/file directory-path)
        file-seq  (.listFiles           directory)]
       (mapv str (filter #(and (-> % .isFile)
                               (-> % .isHidden not))
                          (param file-seq)))))

(defn all-file-list
  ; @description
  ;  A directory-path paraméterként átadott elérési útvonalon található
  ;  mappa fájljainak listája (több mélységben).
  ;
  ; @param (string) directory-path
  ;
  ; @example
  ;  (io/all-file-list "my-directory")
  ;  =>
  ;  ["my-directory/my-file.ext" ...]
  ;
  ; @return (strings in vector)
  [directory-path]
  (let [directory (clojure.java.io/file directory-path)
        file-seq  (file-seq             directory)]
       (mapv str (filter #(and (-> % .isFile)
                               (-> % .isHidden not))
                          (param file-seq)))))

(defn subdirectory-list
  ; @description
  ;  A directory-path paraméterként átadott elérési útvonalon található
  ;  mappa almappáinak listája (egy mélységben).
  ;
  ; @param (string) directory-path
  ;
  ; @example
  ;  (io/subdirectory-list "my-directory")
  ;  =>
  ;  ["my-directory/my-subdirectory" ...]
  ;
  ; @return (strings in vector)
  [directory-path]
  (let [directory (clojure.java.io/file directory-path)
        file-seq  (.listFiles           directory)]
       (mapv str (filter #(and (-> % .isDirectory)
                               (-> % .isHidden not))
                          (param file-seq)))))

(defn all-subdirectory-list
  ; @description
  ;  A directory-path paraméterként átadott elérési útvonalon található
  ;  mappa almappáinak listája (több mélységben).
  ;
  ; @param (string) directory-path
  ;
  ; @example
  ;  (io/all-subdirectory-list "my-directory")
  ;  =>
  ;  ["my-directory/my-subdirectory" ...]
  ;
  ; @return (strings in vector)
  [directory-path]
  (let [directory (clojure.java.io/file directory-path)
        file-seq  (file-seq             directory)]
       (mapv str (filter #(and (-> % .isDirectory)
                               (-> % .isHidden not))
                          (param file-seq)))))

(defn item-list
  ; @description
  ;  A directory-path paraméterként átadott elérési útvonalon található
  ;  mappa elemeinek listája (egy mélységben).
  ;
  ; @param (string) directory-path
  ;
  ; @example
  ;  (io/item-list "my-directory")
  ;  =>
  ;  ["my-directory/my-file.ext" "my-directory/my-subdirectory" ...]
  ;
  ; @return (strings in vector)
  [directory-path]
  (vector/remove-item (mapv str (-> directory-path clojure.java.io/file .listFiles))
                      (param directory-path)))

(defn all-item-list
  ; @description
  ;  A directory-path paraméterként átadott elérési útvonalon található
  ;  mappa elemeinek listája (több mélységben).
  ;
  ; @param (string) directory-path
  ;
  ; @example
  ;  (io/all-item-list "my-directory")
  ;  =>
  ;  ["my-directory/my-file.ext" "my-directory/my-subdirectory" ...]
  ;
  ; @return (strings in vector)
  [directory-path]
  (vector/remove-item (mapv str (-> directory-path clojure.java.io/file file-seq))
                      (param directory-path)))

(defn empty-directory?
  ; @param (string) directory-path
  ;
  ; @return (boolean)
  [directory-path]
  (-> directory-path item-list empty?))

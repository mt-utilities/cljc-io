
(ns io.read
    (:require [clojure.java.io]
              [candy.api  :refer [param]]
              [io.check   :as check]
              [io.config  :as config]
              [vector.api :as vector]))

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
  ; A directory-path paraméterként átadott elérési útvonalon található
  ; mappa fájljainak listája (egy mélységben).
  ;
  ; @param (string) directory-path
  ; @param (map)(opt) options
  ; {:warn? (boolean)(opt)
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

  ([directory-path {:keys [warn?] :or {warn? true}}]
   (try (if (check/directory-exists? directory-path)
            (let [directory (clojure.java.io/file directory-path)
                  file-seq  (.listFiles           directory)]
                 (letfn [(f [%] (and (-> % .isFile)
                                     (-> % .isHidden not)))]
                        (mapv str (filter f file-seq))))
            (throw (Exception. config/DIRECTORY-DOES-NOT-EXIST-ERROR)))
       (catch Exception e (if warn? (println (str e " \"" directory-path "\"")))))))

(defn all-file-list
  ; @description
  ; A directory-path paraméterként átadott elérési útvonalon található
  ; mappa fájljainak listája (több mélységben).
  ;
  ; @param (string) directory-path
  ; @param (map)(opt) options
  ; {:warn? (boolean)(opt)
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

  ([directory-path {:keys [warn?] :or {warn? true}}]
   (try (if (check/directory-exists? directory-path)
            (let [directory (clojure.java.io/file directory-path)
                  file-seq  (file-seq             directory)]
                 (letfn [(f [%] (and (-> % .isFile)
                                     (-> % .isHidden not)))]
                        (mapv str (filter f file-seq))))
            (throw (Exception. config/DIRECTORY-DOES-NOT-EXIST-ERROR)))
        (catch Exception e (if warn? (println (str e " \"" directory-path "\"")))))))

(defn subdirectory-list
  ; @description
  ; A directory-path paraméterként átadott elérési útvonalon található
  ; mappa almappáinak listája (egy mélységben).
  ;
  ; @param (string) directory-path
  ; @param (map)(opt) options
  ; {:warn? (boolean)(opt)
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

  ([directory-path {:keys [warn?] :or {warn? true}}]
   (try (if (check/directory-exists? directory-path)
            (let [directory (clojure.java.io/file directory-path)
                  file-seq  (.listFiles           directory)]
                 (letfn [(f [%] (and (-> % .isDirectory)
                                     (-> % .isHidden not)))]
                        (mapv str (filter f file-seq))))
            (throw (Exception. config/DIRECTORY-DOES-NOT-EXIST-ERROR)))
        (catch Exception e (if warn? (println (str e " \"" directory-path "\"")))))))

(defn all-subdirectory-list
  ; @description
  ; A directory-path paraméterként átadott elérési útvonalon található
  ; mappa almappáinak listája (több mélységben).
  ;
  ; @param (string) directory-path
  ; @param (map)(opt) options
  ; {:warn? (boolean)(opt)
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

  ([directory-path {:keys [warn?] :or {warn? true}}]
   (try (if (check/directory-exists? directory-path)
            (let [directory (clojure.java.io/file directory-path)
                  file-seq  (file-seq             directory)]
                 (letfn [(f [%] (and (-> % .isDirectory)
                                     (-> % .isHidden not)))]
                        (mapv str (filter f file-seq))))
            (throw (Exception. config/DIRECTORY-DOES-NOT-EXIST-ERROR)))
        (catch Exception e (if warn? (println (str e " \"" directory-path "\"")))))))

(defn item-list
  ; @description
  ; A directory-path paraméterként átadott elérési útvonalon található
  ; mappa elemeinek listája (egy mélységben).
  ;
  ; @param (string) directory-path
  ; @param (map)(opt) options
  ; {:warn? (boolean)(opt)
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

  ([directory-path {:keys [warn?] :or {warn? true}}]
   (try (if (check/directory-exists? directory-path)
            (vector/remove-item (mapv  str (-> directory-path clojure.java.io/file .listFiles))
                                (param directory-path))
            (throw (Exception. config/DIRECTORY-DOES-NOT-EXIST-ERROR)))
        (catch Exception e (if warn? (println (str e " \"" directory-path "\"")))))))

(defn all-item-list
  ; @description
  ; A directory-path paraméterként átadott elérési útvonalon található
  ; mappa elemeinek listája (több mélységben).
  ;
  ; @param (string) directory-path
  ; @param (map)(opt) options
  ; {:warn? (boolean)(opt)
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

  ([directory-path {:keys [warn?] :or {warn? true}}]
   (try (if (check/directory-exists? directory-path)
            (vector/remove-item (mapv  str (-> directory-path clojure.java.io/file file-seq))
                                (param directory-path))
            (throw (Exception. config/DIRECTORY-DOES-NOT-EXIST-ERROR)))
        (catch Exception e (if warn? (println (str e " \"" directory-path "\"")))))))

(defn empty-directory?
  ; @param (string) directory-path
  ; @param (map)(opt) options
  ; {:warn? (boolean)(opt)
  ;   Default: true}
  ;
  ; @usage
  ; (empty-directory? "my-directory/my-subdirectory")
  ;
  ; @return (boolean)
  ([directory-path]
   (empty-directory? directory-path {}))

  ([directory-path {:keys [warn?] :or {warn? true}}]
   (try (if (check/directory-exists? directory-path)
            (-> directory-path item-list empty?)
            (throw (Exception. config/DIRECTORY-DOES-NOT-EXIST-ERROR)))
        (catch Exception e (if warn? (println (str e " \"" directory-path "\"")))))))

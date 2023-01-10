
(ns io.helpers
    (:require [candy.api  :refer [return]]
              [string.api :as string]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-resource-root-path
  ; @param (string) resource-path
  ;
  ; @usage
  ; (get-resource-root-path "my-directory")
  ;
  ; @example
  ; (get-resource-root-path "my-directory")
  ; =>
  ; ".../resources"
  ;
  ; @return (string)
  [resource-path]
  (if-let [resource-url (clojure.java.io/resource resource-path)]
          (-> resource-url (string/not-ends-with! resource-path)
                           (string/not-starts-with! "file:"))))

(defn get-resource-root-url
  ; @param (string) resource-path
  ;
  ; @usage
  ; (get-resource-root-url "my-directory")
  ;
  ; @example
  ; (get-resource-root-url "my-directory")
  ; =>
  ; "file:/.../resources/"
  ;
  ; @return (string)
  [resource-path]
  (if-let [resource-url (clojure.java.io/resource resource-path)]
          (-> resource-url (string/not-ends-with! resource-path))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn file-seq->item-list
  ; @param (string) directory-path
  ; @param (vector) file-seq
  ; @param (map)(opt) options
  ; {:keep-hidden? (boolean)(opt)
  ;   Default: false
  ;  :output-f (function)(opt)
  ;   Default: str}
  ;
  ; @return (vector)
  ([directory-path file-seq]
   (file-seq->item-list directory-path file-seq {}))

  ([directory-path file-seq {:keys [keep-hidden? output-f] :or {output-f str}}]
   (letfn [(f0 [%] (-> % .isHidden not))
           (f1 [%] (or keep-hidden? (f0 %)))
           (f2 [%] (not= directory-path (output-f %)))
           (f3 [result %] (if (and (f1 %) (f2 %))
                              (conj   result (output-f %))
                              (return result)))]
          (reduce f3 [] file-seq))))

(defn file-seq->file-list
  ; @param (string) directory-path
  ; @param (vector) file-seq
  ; @param (map)(opt) options
  ; {:keep-hidden? (boolean)(opt)
  ;   Default: false
  ;  :output-f (function)(opt)
  ;   Default: str}
  ;
  ; @return (vector)
  ([directory-path file-seq]
   (file-seq->file-list directory-path file-seq {}))

  ([_ file-seq {:keys [keep-hidden? output-f] :or {output-f str}}]
   (letfn [(f0 [%] (and (-> % .isFile)))
           (f1 [%] (and (-> % .isFile)
                        (-> % .isHidden not)))
           (f2 [%] (if keep-hidden? (f0 %)
                                    (f1 %)))
           (f3 [result %] (if (f2 %)
                              (conj   result (output-f %))
                              (return result)))]
          (reduce f3 [] file-seq))))

(defn file-seq->directory-list
  ; @param (string) directory-path
  ; @param (vector) file-seq
  ; @param (map)(opt) options
  ; {:keep-hidden? (boolean)(opt)
  ;   Default: false
  ;  :output-f (function)(opt)
  ;   Default: str}
  ;
  ; @return (vector)
  ([directory-path file-seq]
   (file-seq->directory-list directory-path file-seq {}))

  ([directory-path file-seq {:keys [keep-hidden? output-f] :or {output-f str}}]
   (letfn [(f0 [%] (and (-> % .isDirectory)))
           (f1 [%] (and (-> % .isDirectory)
                        (-> % .isHidden not)))
           (f2 [%] (if keep-hidden? (f0 %)
                                    (f1 %)))
           (f3 [%] (not= directory-path (output-f %)))
           (f4 [result %] (if (and (f2 %) (f3 %))
                              (conj   result (output-f %))
                              (return result)))]
          (reduce f4 [] file-seq))))

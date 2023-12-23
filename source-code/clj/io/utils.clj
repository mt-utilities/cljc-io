
(ns io.utils
    (:require [fruits.regex.api :as regex]
              [fruits.string.api :as string]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn check-eol
  ; @param (*) file-content
  ;
  ; @usage
  ; (check-eol "Row #1\nRow #2")
  ; =>
  ; "Row #1\nRow #2\n"
  ;
  ; @usage
  ; (check-eol "Row #1\nRow #2\n")
  ; =>
  ; "Row #1\nRow #2\n"
  ;
  ; @return (string)
  [file-content]
  (if (-> file-content string/last-character (not= "\n"))
      (-> file-content (str "\n"))
      (-> file-content (str))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn file-seq->item-list
  ; @param (string) directory-path
  ; @param (strings in vector) file-seq
  ; @param (map)(opt) options
  ; {:filter-pattern (regex pattern)(opt)
  ;   Filters the output.
  ;  :ignore-hidden? (boolean)(opt)
  ;   Removes the hidden items from the output.
  ;   Default: false
  ;  :output-f (function)(opt)
  ;   Default: str}
  ;
  ; @return (strings in vector)
  ([directory-path file-seq]
   (file-seq->item-list directory-path file-seq {}))

  ([directory-path file-seq {:keys [filter-pattern ignore-hidden? output-f] :or {output-f str}}]
   (letfn [(f0 [%] (or (not filter-pattern)
                       (-> % output-f (regex/re-match? filter-pattern))))
           (f1 [%] (-> % .isHidden not))
           (f2 [%] (or (not ignore-hidden?) (f1 %)))
           (f3 [%] (not= directory-path (output-f %)))
           (f4 [result %] (if (and (f0 %) (f2 %) (f3 %))
                              (conj result (output-f %))
                              (->   result)))]
          (reduce f4 [] file-seq))))

(defn file-seq->file-list
  ; @param (string) directory-path
  ; @param (strings in vector) file-seq
  ; @param (map)(opt) options
  ; {:filter-pattern (regex pattern)(opt)
  ;   Filters the output.
  ;  :ignore-hidden? (boolean)(opt)
  ;   Removes the hidden files from the output.
  ;   Default: false
  ;  :output-f (function)(opt)
  ;   Default: str}
  ;
  ; @return (strings in vector)
  ([directory-path file-seq]
   (file-seq->file-list directory-path file-seq {}))

  ([_ file-seq {:keys [filter-pattern ignore-hidden? output-f] :or {output-f str}}]
   (letfn [(f0 [%] (or (not filter-pattern)
                       (-> % output-f (regex/re-match? filter-pattern))))
           (f1 [%] (and (-> % .isFile)))
           (f2 [%] (and (-> % .isFile)
                        (-> % .isHidden not)))
           (f3 [%] (if-not ignore-hidden? (f1 %)
                                          (f2 %)))
           (f4 [result %] (if (and (f0 %) (f3 %))
                              (conj result (output-f %))
                              (->   result)))]
          (reduce f4 [] file-seq))))

(defn file-seq->directory-list
  ; @param (string) directory-path
  ; @param (strings in vector) file-seq
  ; @param (map)(opt) options
  ; {:filter-pattern (regex pattern)(opt)
  ;   Filters the output.
  ;  :ignore-hidden? (boolean)(opt)
  ;   Removes the hidden directories from the output.
  ;   Default: false
  ;  :output-f (function)(opt)
  ;   Default: str}
  ;
  ; @return (strings in vector)
  ([directory-path file-seq]
   (file-seq->directory-list directory-path file-seq {}))

  ([directory-path file-seq {:keys [filter-pattern ignore-hidden? output-f] :or {output-f str}}]
   (letfn [(f0 [%] (or (not filter-pattern)
                       (-> % output-f (regex/re-match? filter-pattern))))
           (f1 [%] (and (-> % .isDirectory)))
           (f2 [%] (and (-> % .isDirectory)
                        (-> % .isHidden not)))
           (f3 [%] (if-not ignore-hidden? (f1 %)
                                          (f2 %)))
           (f4 [%] (not= directory-path (output-f %)))
           (f5 [result %] (if (and (f0 %) (f3 %) (f4 %))
                              (conj result (output-f %))
                              (->   result)))]
          (reduce f5 [] file-seq))))

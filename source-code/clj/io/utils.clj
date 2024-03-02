
(ns io.utils
    (:require [fruits.regex.api  :as regex]
              [fruits.string.api :as string]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn ensure-eol
  ; @description
  ; Returns the given file content and ensures it ends with a newline character.
  ;
  ; @param (*) file-content
  ;
  ; @usage
  ; (ensure-eol "Row #1\nRow #2")
  ; =>
  ; "Row #1\nRow #2\n"
  ;
  ; @usage
  ; (ensure-eol "Row #1\nRow #2\n")
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
  ; @description
  ; - Filters the given vector of file objects (possibly returned by the 'clojure.core/file-seq' or the 'clojure.java.io/file.listFiles' function).
  ;   - Removes the given parent directory path.
  ;   - Optionally removes hidden items.
  ;   - Optionally removes items that do not match the given pattern.
  ; - Applies the given 'output-f' function on the items of the result vector.
  ;
  ; @param (string) parent-path
  ; @param (java.io.File objects in vector) file-seq
  ; @param (map)(opt) options
  ; {:filter-pattern (regex pattern)(opt)
  ;   Filters the output.
  ;  :ignore-hidden? (boolean)(opt)
  ;   Removes the hidden items from the output.
  ;   Default: false
  ;  :output-f (function)(opt)
  ;   Default: str}
  ;
  ; @usage
  ; (file-seq->item-list "my-directory" [#object[java.io.File 0xd7dc4b0 my-directory]
  ;                                      #object[java.io.File 0xd7dc4b0 my-directory/my-subdirectory]
  ;                                      #object[java.io.File 0xd7dc4b0 my-directory/my-file.ext]])
  ; =>
  ; ["my-directory/my-subdirectory" "my-directory/my-file.ext"]
  ;
  ; @return (strings in vector)
  ([parent-path file-seq]
   (file-seq->item-list parent-path file-seq {}))

  ([parent-path file-seq {:keys [filter-pattern ignore-hidden? output-f] :or {output-f str}}]
   (letfn [(f0 [%] (or (not filter-pattern)
                       (-> % output-f (regex/re-match? filter-pattern))))
           (f1 [%] (-> % .isHidden not))
           (f2 [%] (or (not ignore-hidden?) (f1 %)))
           (f3 [%] (not= parent-path (output-f %)))
           (f4 [result %] (if (and (f0 %) (f2 %) (f3 %))
                              (conj result (output-f %))
                              (->   result)))]
          (reduce f4 [] file-seq))))

(defn file-seq->file-list
  ; @description
  ; - Filters the given vector of file objects (possibly returned by the 'clojure.core/file-seq' or the 'clojure.java.io/file.listFiles' function).
  ;   - Removes the given parent directory path.
  ;   - Removes non-file items.
  ;   - Optionally removes hidden items.
  ;   - Optionally removes items that do not match the given pattern.
  ; - Applies the given 'output-f' function on the items of the result vector.
  ;
  ; @param (string) parent-path
  ; @param (java.io.File objects in vector) file-seq
  ; @param (map)(opt) options
  ; {:filter-pattern (regex pattern)(opt)
  ;   Filters the output.
  ;  :ignore-hidden? (boolean)(opt)
  ;   Removes the hidden files from the output.
  ;   Default: false
  ;  :output-f (function)(opt)
  ;   Default: str}
  ;
  ; @usage
  ; (file-seq->file-list "my-directory" [#object[java.io.File 0xd7dc4b0 my-directory]
  ;                                      #object[java.io.File 0xd7dc4b0 my-directory/my-subdirectory]
  ;                                      #object[java.io.File 0xd7dc4b0 my-directory/my-file.ext]])
  ; =>
  ; ["my-directory/my-file.ext"]
  ;
  ; @return (strings in vector)
  ([parent-path file-seq]
   (file-seq->file-list parent-path file-seq {}))

  ([_ file-seq {:keys [filter-pattern ignore-hidden? output-f] :or {output-f str}}]
   (doseq [f file-seq]
          (println f))
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
  ; @description
  ; - Filters the given vector of file objects (possibly returned by the 'clojure.core/file-seq' or the 'clojure.java.io/file.listFiles' function).
  ;   - Removes the given parent directory path.
  ;   - Removes non-directory items.
  ;   - Optionally removes hidden items.
  ;   - Optionally removes items that do not match the given pattern.
  ; - Applies the given 'output-f' function on the items of the result vector.
  ;
  ; @param (string) parent-path
  ; @param (java.io.File objects in vector) file-seq
  ; @param (map)(opt) options
  ; {:filter-pattern (regex pattern)(opt)
  ;   Filters the output.
  ;  :ignore-hidden? (boolean)(opt)
  ;   Removes the hidden directories from the output.
  ;   Default: false
  ;  :output-f (function)(opt)
  ;   Default: str}
  ;
  ; @usage
  ; (file-seq->directory-list "my-directory" [#object[java.io.File 0xd7dc4b0 my-directory]
  ;                                           #object[java.io.File 0xd7dc4b0 my-directory/my-subdirectory]
  ;                                           #object[java.io.File 0xd7dc4b0 my-directory/my-file.ext]])
  ; =>
  ; ["my-directory/my-subdirectory"]
  ;
  ; @return (strings in vector)
  ([parent-path file-seq]
   (file-seq->directory-list parent-path file-seq {}))

  ([parent-path file-seq {:keys [filter-pattern ignore-hidden? output-f] :or {output-f str}}]
   (doseq [f file-seq]
          (println f))
   (letfn [(f0 [%] (or (not filter-pattern)
                       (-> % output-f (regex/re-match? filter-pattern))))
           (f1 [%] (and (-> % .isDirectory)))
           (f2 [%] (and (-> % .isDirectory)
                        (-> % .isHidden not)))
           (f3 [%] (if-not ignore-hidden? (f1 %)
                                          (f2 %)))
           (f4 [%] (not= parent-path (output-f %)))
           (f5 [result %] (if (and (f0 %) (f3 %) (f4 %))
                              (conj result (output-f %))
                              (->   result)))]
          (reduce f5 [] file-seq))))

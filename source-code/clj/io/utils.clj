
(ns io.utils)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn file-seq->item-list
  ; @ignore
  ;
  ; @param (string) directory-path
  ; @param (strings in vector) file-seq
  ; @param (map)(opt) options
  ; {:keep-hidden? (boolean)(opt)
  ;   Default: false
  ;  :output-f (function)(opt)
  ;   Default: str}
  ;
  ; @return (strings in vector)
  ([directory-path file-seq]
   (file-seq->item-list directory-path file-seq {}))

  ([directory-path file-seq {:keys [keep-hidden? output-f] :or {output-f str}}]
   (letfn [(f0 [%] (-> % .isHidden not))
           (f1 [%] (or keep-hidden? (f0 %)))
           (f2 [%] (not= directory-path (output-f %)))
           (f3 [result %] (if (and (f1 %) (f2 %))
                              (conj result (output-f %))
                              (->   result)))]
          (reduce f3 [] file-seq))))

(defn file-seq->file-list
  ; @ignore
  ;
  ; @param (string) directory-path
  ; @param (strings in vector) file-seq
  ; @param (map)(opt) options
  ; {:keep-hidden? (boolean)(opt)
  ;   Default: false
  ;  :output-f (function)(opt)
  ;   Default: str}
  ;
  ; @return (strings in vector)
  ([directory-path file-seq]
   (file-seq->file-list directory-path file-seq {}))

  ([_ file-seq {:keys [keep-hidden? output-f] :or {output-f str}}]
   (letfn [(f0 [%] (and (-> % .isFile)))
           (f1 [%] (and (-> % .isFile)
                        (-> % .isHidden not)))
           (f2 [%] (if keep-hidden? (f0 %)
                                    (f1 %)))
           (f3 [result %] (if (f2 %)
                              (conj result (output-f %))
                              (->   result)))]
          (reduce f3 [] file-seq))))

(defn file-seq->directory-list
  ; @ignore
  ;
  ; @param (string) directory-path
  ; @param (strings in vector) file-seq
  ; @param (map)(opt) options
  ; {:keep-hidden? (boolean)(opt)
  ;   Default: false
  ;  :output-f (function)(opt)
  ;   Default: str}
  ;
  ; @return (strings in vector)
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
                              (conj result (output-f %))
                              (->   result)))]
          (reduce f4 [] file-seq))))


(ns io.blob)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn blob->object-url
  ; @description
  ; Converts the given Blob object into an object URL.
  ;
  ; @param (Blob object) n
  ;
  ; @usage
  ; (to-object-url #object[Blob])
  ; =>
  ; "..."
  ;
  ; @return (string)
  [n]
  (.createObjectURL js/URL n))

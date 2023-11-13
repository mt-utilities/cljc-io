
(ns io.blob)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn blob->object-url
  ; @param (object) n
  ;
  ; @usage
  ; (to-object-url ...)
  ;
  ; @return (object)
  [n]
  (.createObjectURL js/URL n))

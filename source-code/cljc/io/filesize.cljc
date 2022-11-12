
(ns io.filesize)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn B->KB
  ; @param (number) n
  ;
  ; @return (number)
  [n]
  (/ n 1000))

(defn B->MB
  ; @param (number) n
  ;
  ; @return (number)
  [n]
  (/ n 1000000))

(defn B->GB
  ; @param (number) n
  ;
  ; @return (number)
  [n]
  (/ n 1000000000))

(defn KB->B
  ; @param (number) n
  ;
  ; @return (number)
  [n]
  (* n 1000))

(defn KB->MB
  ; @param (number) n
  ;
  ; @return (number)
  [n]
  (/ n 1000))

(defn KB->GB
  ; @param (number) n
  ;
  ; @return (number)
  [n]
  (/ n 1000000))

(defn MB->B
  ; @param (number) n
  ;
  ; @return (number)
  [n]
  (* n 1000000))

(defn MB->KB
  ; @param (number) n
  ;
  ; @return (number)
  [n]
  (* n 1000))

(defn MB->GB
  ; @param (number) n
  ;
  ; @return (number)
  [n]
  (/ n 1000))

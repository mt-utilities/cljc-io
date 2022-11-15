
(ns io.filesize)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn B->KB
  ; @param (B) n
  ;
  ; @return (KB)
  [n]
  (/ n 1000))

(defn B->MB
  ; @param (B) n
  ;
  ; @return (MB)
  [n]
  (/ n 1000000))

(defn B->GB
  ; @param (B) n
  ;
  ; @return (GB)
  [n]
  (/ n 1000000000))

(defn KB->B
  ; @param (KB) n
  ;
  ; @return (B)
  [n]
  (* n 1000))

(defn KB->MB
  ; @param (KB) n
  ;
  ; @return (MB)
  [n]
  (/ n 1000))

(defn KB->GB
  ; @param (KB) n
  ;
  ; @return (GB)
  [n]
  (/ n 1000000))

(defn MB->B
  ; @param (MB) n
  ;
  ; @return (B)
  [n]
  (* n 1000000))

(defn MB->KB
  ; @param (MB) n
  ;
  ; @return (KB)
  [n]
  (* n 1000))

(defn MB->GB
  ; @param (MB) n
  ;
  ; @return (GB)
  [n]
  (/ n 1000))

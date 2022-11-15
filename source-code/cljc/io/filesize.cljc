
(ns io.filesize)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn B->KB
  ; @param (B) n
  ;
  ; @usage
  ;  (B->KB 420)
  ;
  ; @return (KB)
  [n]
  (/ n 1000))

(defn B->MB
  ; @param (B) n
  ;
  ; @usage
  ;  (B->MB 420)
  ;
  ; @return (MB)
  [n]
  (/ n 1000000))

(defn B->GB
  ; @param (B) n
  ;
  ; @usage
  ;  (B->GB 420)
  ;
  ; @return (GB)
  [n]
  (/ n 1000000000))

(defn KB->B
  ; @param (KB) n
  ;
  ; @usage
  ;  (KB->B 420)
  ;
  ; @return (B)
  [n]
  (* n 1000))

(defn KB->MB
  ; @param (KB) n
  ;
  ; @usage
  ;  (KB->MB 420)
  ;
  ; @return (MB)
  [n]
  (/ n 1000))

(defn KB->GB
  ; @param (KB) n
  ;
  ; @usage
  ;  (KB->GB 420)
  ;
  ; @return (GB)
  [n]
  (/ n 1000000))

(defn MB->B
  ; @param (MB) n
  ;
  ; @usage
  ;  (MB->B 420)
  ;
  ; @return (B)
  [n]
  (* n 1000000))

(defn MB->KB
  ; @param (MB) n
  ;
  ; @usage
  ;  (MB->KB 420)
  ;
  ; @return (KB)
  [n]
  (* n 1000))

(defn MB->GB
  ; @param (MB) n
  ;
  ; @usage
  ;  (MB->GB 420)
  ;
  ; @return (GB)
  [n]
  (/ n 1000))

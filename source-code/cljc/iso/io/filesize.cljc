
(ns iso.io.filesize)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn B->kB
  ; @param (B) n
  ;
  ; @usage
  ; (B->kB 420)
  ; =>
  ; 0.42
  ;
  ; @return (kB)
  [n]
  ; https://en.wikipedia.org/wiki/Byte
  ; The unit symbol for the byte was designated as the upper-case letter B ...
  (/ n 1000))

(defn B->MB
  ; @param (B) n
  ;
  ; @usage
  ; (B->MB 420)
  ; =>
  ; 0.00042
  ;
  ; @return (MB)
  [n]
  (/ n 1000000))

(defn B->GB
  ; @param (B) n
  ;
  ; @usage
  ; (B->GB 420)
  ; =>
  ; 0.00000042
  ;
  ; @return (GB)
  [n]
  (/ n 1000000000))

(defn kB->B
  ; @param (kB) n
  ;
  ; @usage
  ; (kB->B 420)
  ; =>
  ; 420000
  ;
  ; @return (B)
  [n]
  ; https://en.wikipedia.org/wiki/Kilobyte
  ; The internationally recommended unit symbol for the kilobyte is kB.
  (* n 1000))

(defn kB->MB
  ; @param (kB) n
  ;
  ; @usage
  ; (kB->MB 420)
  ; =>
  ; 0.42
  ;
  ; @return (MB)
  [n]
  (/ n 1000))

(defn kB->GB
  ; @param (kB) n
  ;
  ; @usage
  ; (kB->GB 420)
  ; =>
  ; 0.00042
  ;
  ; @return (GB)
  [n]
  (/ n 1000000))

(defn MB->B
  ; @param (MB) n
  ;
  ; @usage
  ; (MB->B 420)
  ; =>
  ; 420000000
  ;
  ; @return (B)
  [n]
  ; https://en.wikipedia.org/wiki/Megabyte
  ; ... its recommended unit symbol is MB.
  (* n 1000000))

(defn MB->kB
  ; @param (MB) n
  ;
  ; @usage
  ; (MB->kB 420)
  ; =>
  ; 420000
  ;
  ; @return (kB)
  [n]
  (* n 1000))

(defn MB->GB
  ; @param (MB) n
  ;
  ; @usage
  ; (MB->GB 420)
  ; =>
  ; 0.42
  ;
  ; @return (GB)
  [n]
  (/ n 1000))

(defn GB->B
  ; @param (GB) n
  ;
  ; @usage
  ; (GB->B 420)
  ; =>
  ; 420000000000
  ;
  ; @return (B)
  [n]
  ; https://en.wikipedia.org/wiki/Gigabyte
  ; The unit symbol for the gigabyte is GB.
  (* n 1000000000))

(defn GB->kB
  ; @param (GB) n
  ;
  ; @usage
  ; (GB->kB 420)
  ; =>
  ; 420000000
  ;
  ; @return (kB)
  [n]
  ; https://en.wikipedia.org/wiki/Byte
  ; The unit symbol for the byte was designated as the upper-case letter B ...
  (* n 1000000))

(defn GB->MB
  ; @param (GB) n
  ;
  ; @usage
  ; (GB->MB 420)
  ; =>
  ; 420000
  ;
  ; @return (MB)
  [n]
  (* n 1000))

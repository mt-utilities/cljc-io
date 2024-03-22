
(ns iso.io.filesize)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn B->kB
  ; @description
  ; Converts the given byte value into kilobyte.
  ;
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
  ; @description
  ; Converts the given byte value into megabyte.
  ;
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
  ; @description
  ; Converts the given byte value into gigabyte.
  ;
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
  ; @description
  ; Converts the given kilobyte value into byte.
  ;
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
  ; @description
  ; Converts the given kilobyte value into megabyte.
  ;
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
  ; @description
  ; Converts the given kilobyte value into gigabyte.
  ;
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
  ; @description
  ; Converts the given megabyte value into byte.
  ;
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
  ; @description
  ; Converts the given megabyte value into kilobyte.
  ;
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
  ; @description
  ; Converts the given megabyte value into gigabyte.
  ;
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
  ; @description
  ; Converts the given gigabyte value into byte.
  ;
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
  ; @description
  ; Converts the given gigabyte value into kilobyte.
  ;
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
  ; @description
  ; Converts the given gigabyte value into megabyte.
  ;
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

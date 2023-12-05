
(ns io.base64
    (:require [clojure.data.codec.base64]
              [clojure.java.io]
              [base64.api :as base64]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn base64->byte-array
  ; @param (string) n
  ;
  ; @usage
  ; (base64->byte-array "data:application/pdf;base64,...")
  ;
  ; @return (byte array)
  [n]
  (if-let [body (base64/to-body n)]
          (-> body (.getBytes)
                   (clojure.data.codec.base64/decode))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn encode-base64!
  ; @warning
  ; This function does not create the directory path for the output if it does not exist!
  ;
  ; @description
  ; Reads the file from the source filepath, encodes the file's content to base64,
  ; and writes the encoded content to the destination filepath.
  ;
  ; @param (string) source-filepath
  ; @param (string) destination-filepath
  ;
  ; @usage
  ; (encode-base64! "my-document.pdf" "my-document.b64")
  ;
  ; @example
  ; (encode-base64! "my-document.pdf" "my-document.b64")
  ; =>
  ; "data:application/pdf;base64,..."
  ;
  ; @return (string)
  ; Returns the encoded content.
  [source-filepath destination-filepath]
  (when source-filepath (with-open [i (clojure.java.io/input-stream       source-filepath)
                                    o (clojure.java.io/output-stream destination-filepath)]
                                   (clojure.data.codec.base64/encoding-transfer i o))
                        (slurp destination-filepath)))

(defn decode-base64!
  ; @warning
  ; This function does not create the directory path of the output if it does not exist!
  ;
  ; @description
  ; Reads the file from the source filepath, decodes the file's content to byte array,
  ; and writes the decoded content to the destination filepath.
  ;
  ; @param (string) source-filepath
  ; @param (string) destination-filepath
  ;
  ; @usage
  ; (decode-base64! "my-document.b64" "my-document.pdf")
  ;
  ; @return (boolean)
  [source-filepath destination-filepath]
  ; The 'base64->byte-array' function works with wrapped (header + body) base64 strings.
  (if-let [base64-body (slurp source-filepath)]
          (let [base64 (str "data:decoder/b64;base64," base64-body)]
               (clojure.java.io/copy (base64->byte-array base64)
                                     (java.io.File. destination-filepath))
               (-> destination-filepath slurp boolean))))

(defn save-base64!
  ; @warning
  ; This function does not create the directory path of the output if it does not exist!
  ;
  ; @description
  ; Decodes the given 'n' base64 string to byte array, and writes the decoded content to the destination filepath.
  ;
  ; @param (string) n
  ; @param (string) destination-filepath
  ;
  ; @usage
  ; (save-base64! "data:application/pdf;base64,..." "my-document.pdf")
  ;
  ; @return (boolean)
  [n destination-filepath]
  (do (clojure.java.io/copy (base64->byte-array n)
                            (java.io.File. destination-filepath))
      (-> destination-filepath slurp boolean)))

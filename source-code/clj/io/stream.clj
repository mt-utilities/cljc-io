
(ns io.stream
    (:require [clojure.java.io]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn input-stream
  ; @links
  ; [clojuredocs.org/clojure.java.io/input-stream](https://clojuredocs.org/clojure.java.io/input-stream)
  ;
  ; @description
  ; Attempts to coerce its argument into an open 'java.io.InputStream' object.
  ;
  ; @usage
  ; (input-stream "my-file.ext")
  ; =>
  ; #object[java.io.InputStream]
  ;
  ; @return (java.io.InputStream object)
  [& params]
  (apply clojure.java.io/input-stream params))

(defn output-stream
  ; @links
  ; [clojuredocs.org/clojure.java.io/output-stream](https://clojuredocs.org/clojure.java.io/output-stream)
  ;
  ; @description
  ; Attempts to coerce its argument into an open 'java.io.OutputStream' object.
  ;
  ; @usage
  ; (output-stream "my-file.ext")
  ; =>
  ; #object[java.io.OutputStream]
  ;
  ; @return (java.io.OutputStream object)
  [& params]
  (apply clojure.java.io/output-stream params))


;; -- Namespace ---------------------------------------------------------------
;; ----------------------------------------------------------------------------

(ns io.edn
    (:require [io.actions        :as actions]
              [io.read           :as read]
              [mid-fruits.candy  :refer [return]]
              [mid-fruits.pretty :as pretty]
              [mid-fruits.reader :as reader]
              [mid-fruits.string :as string]
              [mid-fruits.vector :as vector]))



;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn write-edn-file!
  ; @param (string) filepath
  ; @param (*) content
  ; @param (map) options
  ;  {:abc? (boolean)(opt)
  ;    Default: false}
  ;
  ; @usage
  ;  (io/write-edn-file! "my-file.edn" {...})
  ;
  ; @return (map)
  [filepath content & [options]]
  (let [output (pretty/mixed->string content options)]
       (actions/write-file! filepath (str "\n" output))
       (return content)))

(defn read-edn-file
  ; @param (string) filepath
  ;
  ; @return (*)
  [filepath]
  (let [file-content (read/read-file filepath)]
       (if (-> file-content string/trim some?)
           (-> file-content reader/string->mixed))))
           ; Az .edn fájl tartalma lehet string, map, vektor, stb. típus,
           ; ezért a read-edn-file függvény kimenetén nem lehetséges típusvizsgálatot végezni!

(defn swap-edn-file!
  ; @param (string) filepath
  ; @param (function) f
  ; @param (*) params
  ;
  ; @usage
  ;  (io/swap-edn-file! "my-file.edn" assoc-in [:items :xyz] "XYZ")
  ;
  ; @usage
  ;  (io/swap-edn-file! "my-file.edn" vector/conj-item "XYZ")
  ;
  ; @return (map)
  [filepath f & params]
  (let [edn    (read-edn-file    filepath)
        params (vector/cons-item params edn)
        output (apply          f params)]
       (write-edn-file! filepath output)
       (return output)))

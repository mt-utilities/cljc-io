
(ns io.edn
    (:require [candy.api    :refer [return]]
              [io.actions   :as actions]
              [io.read      :as read]
              [pretty.print :as pretty]
              [reader.api   :as reader]
              [string.api   :as string]
              [vector.api   :as vector]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn write-edn-file!
  ; @param (string) filepath
  ; @param (*) content
  ; @param (map)(opt) options
  ; {:abc? (boolean)(opt)
  ;   Default: false
  ;  :warn? (boolean)(opt)
  ;   Default: true}
  ;
  ; @usage
  ; (write-edn-file! "my-directory/my-file.edn" {...})
  ;
  ; @usage
  ; (write-edn-file! "my-directory/my-file.edn" {...} {...})
  ;
  ; @example
  ; (write-edn-file! "my-directory/my-file.edn" {:b "B" :a "A" :d "D" :c "C"})
  ; (read-file       "my-directory/my-file.edn")
  ; =>
  ; "{:b "B" :a "A" :d "D" :c "C"}"
  ;
  ; @example
  ; (write-edn-file! "my-directory/my-file.edn" {:b "B" :a "A" :d "D" :c "C"} {:abc? true})
  ; (read-file       "my-directory/my-file.edn")
  ; =>
  ; "{:a "A" :b "B" :c "C" :d "D"}"
  ;
  ; @return (string)
  ([filepath content]
   (write-edn-file! filepath content {}))

  ([filepath content {:keys [abc? warn?] :or {warn? true}}]
   (let [output (pretty/mixed->string content {:abc? abc?})]
        (actions/write-file! filepath (str "\n" output) {:create? true :warn? warn?})
        (return content))))

(defn read-edn-file
  ; @param (string) filepath
  ; @param (map)(opt) options
  ; {:warn? (boolean)(opt)
  ;   Default: true}
  ;
  ; @usage
  ; (read-edn-file "my-directory/my-file.edn")
  ;
  ; @return (*)
  ([filepath]
   (read-edn-file filepath {}))

  ([filepath options]
   (let [file-content (read/read-file filepath options)]
        (if (-> file-content string/trim some?)
            (-> file-content reader/string->mixed)))))
            ; Az .edn fájl tartalma lehet string, map, vektor, stb. típus,
            ; ezért a read-edn-file függvény kimenetén nem lehetséges típusvizsgálatot végezni!

(defn swap-edn-file!
  ; @param (string) filepath
  ; @param (function) f
  ; @param (*) params
  ;
  ; @usage
  ; (swap-edn-file! "my-directory/my-file.edn" assoc-in [:items :xyz] "XYZ")
  ;
  ; @usage
  ; (swap-edn-file! "my-directory/my-file.edn" conj "XYZ")
  ;
  ; @return (*)
  [filepath f & params]
  (let [edn    (read-edn-file    filepath)
        params (vector/cons-item params edn)
        output (apply          f params)]
       (write-edn-file! filepath output)
       (return                   output)))

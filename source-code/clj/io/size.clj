
(ns io.size
    (:require [clojure.java.io]
              [io.config :as config]
              [io.check  :as check]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-filesize
  ; @param (string) filepath
  ; @param (map)(opt) options
  ; {:warn? (boolean)(opt)
  ;   Default: true}
  ;
  ; @usage
  ; (get-filesize "my-directory/my-file.ext")
  ;
  ; @return (B)
  ; The length of the file in bytes
  ([filepath]
   (get-filesize filepath {}))

  ([filepath {:keys [warn?] :or {warn? true}}]
   (try (if (check/file-exists? filepath)
            (->                 filepath clojure.java.io/file .length)
            (throw (Exception. config/FILE-DOES-NOT-EXIST-ERROR)))
       (catch Exception e (if warn? (println (str e " \"" filepath "\"")))))))

(defn max-filesize-reached?
  ; @param (string) filepath
  ; @param (B) max-filesize
  ; @param (map)(opt) options
  ; {:warn? (boolean)(opt)
  ;   Default: true}
  ;
  ; @usage
  ; (max-filesize-reached? "my-directory/my-file.ext" 420)
  ;
  ; @return (boolean)
  ([filepath max-filesize]
   (max-filesize-reached? filepath max-filesize {}))

  ([filepath max-filesize options]
   (if-let [filesize (get-filesize filepath options)]
           (>= filesize max-filesize))))

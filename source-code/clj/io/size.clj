
;; -- Namespace ---------------------------------------------------------------
;; ----------------------------------------------------------------------------

(ns io.side-effects
    (:require [clojure.java.io]
              [io.config :as config]
              [io.check  :as check]))



;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-filesize
  ; @param (string) filepath
  ;
  ; @return (B)
  ;  The length of the file in bytes
  [filepath]
  (try (if (check/file-exists? filepath)
           (->                 filepath clojure.java.io/file .length)
           (throw (Exception. config/FILE-DOES-NOT-EXIST-ERROR)))
      (catch Exception e (println (str e " \"" filepath "\"")))))

(defn max-filesize-reached?
  ; @param (string) filepath
  ; @param (B) max-filesize
  ;
  ; @return (boolean)
  [filepath max-filesize]
  (let [filesize (get-filesize filepath)]
       (>= filesize max-filesize)))

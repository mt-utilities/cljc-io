
(ns io.env
    (:require [string.api :as string]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-resource-root-path
  ; @param (string) resource-path
  ;
  ; @usage
  ; (get-resource-root-path "my-directory")
  ;
  ; @example
  ; (get-resource-root-path "my-directory")
  ; =>
  ; ".../resources"
  ;
  ; @return (string)
  [resource-path]
  (if-let [resource-url (clojure.java.io/resource resource-path)]
          (-> resource-url (string/not-ends-with! resource-path)
                           (string/not-starts-with! "file:"))))

(defn get-resource-root-url
  ; @param (string) resource-path
  ;
  ; @usage
  ; (get-resource-root-url "my-directory")
  ;
  ; @example
  ; (get-resource-root-url "my-directory")
  ; =>
  ; "file:/.../resources/"
  ;
  ; @return (string)
  [resource-path]
  (if-let [resource-url (clojure.java.io/resource resource-path)]
          (-> resource-url (string/not-ends-with! resource-path))))


(ns io.env
    (:require [fruits.string.api :as string]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-resource-root-path
  ; @description
  ; - Returns the absolute path of the parent directory of the given resource file or directory path.
  ; - Resource file and directory paths are relative to the Java resources directory.
  ;
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
  ; @description
  ; - Returns the absolute URI of the parent directory of the given resource file or directory path.
  ; - Resource file and directory paths are relative to the Java resources directory.
  ;
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


(ns io.edn
    (:require [io.actions :as actions]
              [io.check   :as check]
              [io.read    :as read]
              [pretty.api :as pretty]
              [reader.api :as reader]
              [string.api :as string]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn read-edn-file
  ; @param (string) filepath
  ; @param (map)(opt) options
  ; {:warn? (boolean)(opt)
  ;   If TRUE, the function prints the error message to the console in case of any error.
  ;   Default: true}
  ;
  ; @usage
  ; (read-edn-file "my-directory/my-file.edn")
  ;
  ; @return (*)
  ([filepath]
   (read-edn-file filepath {}))

  ([filepath options]
   ; The content of an EDN file might be string ("..."), vector ("[...]"), map ("{...}"), etc.
   (let [file-content (read/read-file filepath options)]
        (if (-> file-content string/trim some?)
            (-> file-content reader/read-edn)))))

(defn create-edn-file!
  ; @param (string) filepath
  ; @param (map)(opt) options
  ; {:return? (boolean)(opt)
  ;   If TRUE, the function returns the file content.
  ;   Default: true
  ;  :warn? (boolean)(opt)
  ;   If TRUE, the function prints the error message to the console in case of any error.
  ;   Default: true}
  ;
  ; @usage
  ; (create-edn-file! "my-directory/my-file.edn")
  ;
  ; @return (nil or string)
  ; Returns with the file's content (the reader procceses the content to data),
  ; or with nil if the return? option is set to false.
  ([filepath]
   (create-edn-file! filepath {}))

  ([filepath {:keys [return? warn?] :or {return? true warn? true} :as options}]
   (if-not (check/file-exists?  filepath)
           (actions/write-file! filepath "\n{}" {:create? true :warn? warn?}))
   (if return? (read-edn-file filepath {:warn? false}))))

(defn write-edn-file!
  ; @param (string) filepath
  ; @param (*) content
  ; @param (map)(opt) options
  ; {:abc? (boolean)(opt)
  ;   Default: false
  ;  :create? (boolean)(opt)
  ;   If TRUE, the function creates the file in case if it doesn't exist.
  ;   Default: false
  ;  :return? (boolean)(opt)
  ;   If TRUE, the function returns the file content.
  ;   Default: true
  ;  :warn? (boolean)(opt)
  ;   If TRUE, the function prints the error message to the console in case of any error.
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
  ; @return (*)
  ; Returns with the file's content (the reader procceses the content to data),
  ; or with nil if the return? option is set to false.
  ([filepath content]
   (write-edn-file! filepath content {}))

  ([filepath content {:keys [abc? return?] :or {return? true} :as options}]
   (let [output (pretty/mixed->string content {:abc? abc?})]
        (actions/write-file! filepath (str "\n" output "\n" ) options))
   (if return? (read-edn-file filepath {:warn? false}))))

(defn update-edn-file!
  ; @param (string) filepath
  ; @param (function) f
  ; @param (*) params
  ;
  ; @usage
  ; (update-edn-file! "my-directory/my-file.edn" assoc-in [:items :xyz] "XYZ")
  ;
  ; @usage
  ; (update-edn-file! "my-directory/my-file.edn" conj "XYZ")
  ;
  ; @return (*)
  ; Returns the file's content (as parsed EDN data).
  [filepath f & params]
  ; Unlike other file handling functions, the 'update-edn-file!' function, (because
  ; of the variadic parameters) ...
  ; ... does not take the 'options' parameter.
  ; ... always creates the file if it does not exist!
  ; ... always prints a warning message when the file does not exist!
  (let [edn    (read-edn-file filepath)
        output (apply f edn params)]
       (write-edn-file! filepath output {:create? true :warn? true})
       (read-edn-file   filepath {:warn? false})))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn read-edn-header
  ; @param (string) filepath
  ; @param (map)(opt) options
  ; {:warn? (boolean)(opt)
  ;   If TRUE, the function prints the error message to the console in case of any error.
  ;   Default: true}
  ;
  ; @usage
  ; (read-edn-header "my-directory/my-file.edn")
  ;
  ; @return (string)
  ([filepath]
   (read-edn-header filepath {}))

  ([filepath options]
   (let [file-content (read/read-file filepath options)]
        (letfn [(cut-row      [n]   (string/after-first-occurence n "\n"))
                (comment-row? [row] (-> row (string/trim)
                                            (string/starts-with? ";")))
                (empty-row?   [row] (-> row (string/trim)
                                            (= "")))
                (append-row   [result row]
                              (let [row (string/after-first-occurence row ";" {:return? false})]
                                   (if result (str result "\n" row)
                                              (str             row))))
                (f0 [result n] (if-let [first-row (string/before-first-occurence n "\n" {:return? false})]
                                       (cond (comment-row?         first-row)
                                             (f0 (append-row result first-row)
                                                 (cut-row n))
                                             (empty-row? first-row)
                                             (f0 (str result "\n")
                                                 (cut-row n))
                                             :else
                                             (-> result))
                                       (-> result)))]
               (f0 "" file-content)))))

(defn write-edn-header!
  ; @param (string) filepath
  ; @param (string) header
  ; @param (map)(opt) options
  ; @param (map)(opt) options
  ; {:create? (boolean)(opt)
  ;   If TRUE, the function creates the file in case if it doesn't exist.
  ;   Default: false
  ;  :return? (boolean)(opt)
  ;   If TRUE, the function returns the file content.
  ;   Default: true
  ;  :warn? (boolean)(opt)
  ;   If TRUE, the function prints the error message to the console in case of any error.
  ;   Default: true}
  ;
  ; @usage
  ; (write-edn-header! "my-directory/my-file.edn" "My header\nMy comment!")
  ;
  ; @return (string)
  ([filepath header]
   (write-edn-header! filepath header {}))

  ([filepath header options]
   (let [file-content (read/read-file filepath options)]
        (letfn [(f0 [result n]
                    (if-let [last-row (string/after-last-occurence n "\n")]
                            (f0 (str "; " last-row "\n" result)
                                (string/before-last-occurence n "\n" {:return? false}))
                            (-> result)))]
               (let [file-content (str "\n" (f0 file-content header))]
                    (actions/write-file! filepath file-content options))))))

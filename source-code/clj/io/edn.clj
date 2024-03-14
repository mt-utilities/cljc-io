
(ns io.edn
    (:require [fruits.pretty.api :as pretty]
              [fruits.reader.api :as reader]
              [fruits.regex.api  :as regex]
              [fruits.string.api :as string]
              [io.actions        :as actions]
              [io.check          :as check]
              [io.read           :as read]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn read-edn-file
  ; @description
  ; Returns the parsed content of the EDN file at the given filepath.
  ;
  ; @param (string) filepath
  ; @param (map)(opt) options
  ; {:warn? (boolean)(opt)
  ;   If TRUE, prints the error message (if any) to the console.
  ;   Default: true}
  ;
  ; @usage
  ; (read-edn-file "my-directory/my-file.edn")
  ; =>
  ; {:my-key "My value"}
  ;
  ; @return (*)
  ([filepath]
   (read-edn-file filepath {}))

  ([filepath options]
   ; The content of an EDN file might be string ("..."), vector ("[...]"), map ("{...}"), etc.
   (let [file-content (read/read-file filepath options)]
        (if (-> file-content string/trim some?)
            (-> file-content reader/parse-edn)))))

(defn create-edn-file!
  ; @description
  ; Creates an EDN file to given filepath.
  ;
  ; @param (string) filepath
  ; @param (map)(opt) options
  ; {:return? (boolean)(opt)
  ;   If TRUE, returns the file content.
  ;   Default: true
  ;  :warn? (boolean)(opt)
  ;   If TRUE, prints the error message (if any) to the console.
  ;   Default: true}
  ;
  ; @usage
  ; (create-edn-file! "my-directory/my-file.edn")
  ; =>
  ; nil
  ;
  ; @return (*)
  ([filepath]
   (create-edn-file! filepath {}))

  ([filepath {:keys [return? warn?] :or {return? true warn? true} :as options}]
   (if-not (check/file-exists?  filepath)
           (actions/write-file! filepath "\n{}" {:create? true :warn? warn?}))
   (if return? (read-edn-file filepath {:warn? false}))))

(defn write-edn-file!
  ; @description
  ; Overwrites the EDN file at the given filepath with the given content.
  ;
  ; @param (string) filepath
  ; @param (*) content
  ; @param (map)(opt) options
  ; {:abc? (boolean)(opt)
  ;   Default: false
  ;  :create? (boolean)(opt)
  ;   If TRUE, creates the file in case if it does not exist.
  ;   Default: false
  ;  :return? (boolean)(opt)
  ;   If TRUE, returns the file content.
  ;   Default: true
  ;  :warn? (boolean)(opt)
  ;   If TRUE, prints the error message (if any) to the console.
  ;   Default: true}
  ;
  ; @usage
  ; (write-edn-file! "my-directory/my-file.edn" {:b "B" :a "A" :d "D" :c "C"})
  ; =>
  ; {:b "B" :a "A" :d "D" :c "C"}
  ;
  ; @usage
  ; (write-edn-file! "my-directory/my-file.edn" {:b "B" :a "A" :d "D" :c "C"} {:abc? true})
  ; =>
  ; {:a "A" :b "B" :c "C" :d "D"}
  ;
  ; @return (*)
  ([filepath content]
   (write-edn-file! filepath content {}))

  ([filepath content {:keys [abc? return?] :or {return? true} :as options}]
   (let [output (pretty/mixed->string content {:abc? abc?})]
        (actions/write-file! filepath (str "\n" output "\n" ) options))
   (if return? (read-edn-file filepath {:warn? false}))))

(defn update-edn-file!
  ; @description
  ; Updates the EDN file at the given filepath by applying the given 'f' function on its content.
  ;
  ; @param (string) filepath
  ; @param (function) f
  ; @param (*) params
  ;
  ; @usage
  ; (update-edn-file! "my-directory/my-file.edn" assoc :another-key "Another value")
  ; =>
  ; {:my-key      "My value"
  ;  :another-key "Another value"}
  ;
  ; @return (*)
  [filepath f & params]
  ; Unlike other file handling functions, the 'update-edn-file!' function, (because of the variadic parameters) ...
  ; ... does not take the 'options' parameter.
  ; ... always creates the file in case it does not exist!
  ; ... always prints warning message when the file does not exist!
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
  ;   If TRUE, prints the error message (if any) to the console.
  ;   Default: true}
  ;
  ; @usage
  ; (read-edn-header "my-directory/my-file.edn")
  ; =>
  ; "My header"
  ;
  ; @return (string)
  ([filepath]
   (read-edn-header filepath {}))

  ([filepath options]
   (let [file-content (read/read-file filepath options)]
        (-> filepath (read/read-file options)
                     (regex/re-all   #"(?<=\n\;)[^\n]*(?=\n)")
                     (string/join    "\n")))))

(defn write-edn-header!
  ; @description
  ; Prepends the given header as commented lines to the EDN file at the given filepath.
  ;
  ; @param (string) filepath
  ; @param (string) header
  ; @param (map)(opt) options
  ; @param (map)(opt) options
  ; {:create? (boolean)(opt)
  ;   If TRUE, creates the file in case if it does not exist.
  ;   Default: false
  ;  :return? (boolean)(opt)
  ;   If TRUE, returns the file content.
  ;   Default: true
  ;  :warn? (boolean)(opt)
  ;   If TRUE, prints the error message (if any) to the console.
  ;   Default: true}
  ;
  ; @usage
  ; (write-edn-header! "my-directory/my-file.edn" "My header")
  ; =>
  ; "\n;My header\n{:my-key "My value"}"
  ;
  ; @return (string)
  ([filepath header]
   (write-edn-header! filepath header {}))

  ([filepath header options]
   (let [file-content (read/read-file filepath options)]
        (letfn [(f0 [%] (string/replace-part % "\n" "\n;"))
                (f1 [%] (str "\n" %))
                (f2 [%] (str % "\n" file-content))]
               (let [file-content (-> header f1 f0 f2)]
                    (actions/write-file! filepath file-content options))))))

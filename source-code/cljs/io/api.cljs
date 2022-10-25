
;; -- Namespace ---------------------------------------------------------------
;; ----------------------------------------------------------------------------

(ns io.api
    (:require [io.helpers :as helpers]))



;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; io.helpers
(def MIME-TYPES                     helpers/MIME-TYPES)
(def EXTENSIONS                     helpers/EXTENSIONS)
(def IMAGE-EXTENSIONS               helpers/IMAGE-EXTENSIONS)
(def B->KB                          helpers/B->KB)
(def B->MB                          helpers/B->MB)
(def KB->B                          helpers/KB->B)
(def KB->MB                         helpers/KB->MB)
(def MB->B                          helpers/MB->B)
(def MB->KB                         helpers/MB->KB)
(def mime-type->extension           helpers/mime-type->extension)
(def extension->mime-type           helpers/extension->mime-type)
(def unknown-mime-type?             helpers/unknown-mime-type?)
(def extension->image?              helpers/extension->image?)
(def mime-type->image?              helpers/mime-type->image?)
(def filepath->directory-path       helpers/filepath->directory-path)
(def filepath->filename             helpers/filepath->filename)
(def filepath->extension            helpers/filepath->extension)
(def filename->extension            helpers/filename->extension)
(def filename->basename             helpers/filename->basename)
(def filepath->basename             helpers/filepath->basename)
(def filepath->mime-type            helpers/filepath->mime-type)
(def filename->mime-type            helpers/filename->mime-type)
(def filepath->image?               helpers/filepath->image?)
(def filename->image?               helpers/filename->image?)
(def directory-path->directory-name helpers/directory-path->directory-name)
(def filename-valid?                helpers/filename-valid?)
(def filename-invalid?              helpers/filename-invalid?)
(def directory-name-valid?          helpers/directory-name-valid?)
(def directory-name-invalid?        helpers/directory-name-invalid?)

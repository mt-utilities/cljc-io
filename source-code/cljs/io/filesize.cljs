
(ns io.filesize
    (:require [iso.io.filesize :as filesize]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @redirect (iso.io.filesize/*)
(def B->kB  filesize/B->kB)
(def B->MB  filesize/B->MB)
(def B->GB  filesize/B->GB)
(def kB->B  filesize/kB->B)
(def kB->MB filesize/kB->MB)
(def kB->GB filesize/kB->GB)
(def MB->B  filesize/MB->B)
(def MB->kB filesize/MB->kB)
(def MB->GB filesize/MB->GB)
(def GB->B  filesize/GB->B)
(def GB->kB filesize/GB->kB)
(def GB->MB filesize/GB->MB)

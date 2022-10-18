
;; -- Namespace ---------------------------------------------------------------
;; ----------------------------------------------------------------------------

(ns io.config)



;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; A hibaüzenetek kiírásakor a fájlok/mappák neveit idézőjelek között szükséges
; kiírni, hogy a nil értékű nevek is egyértelműen felismerhetők legyenek!

; @constant (string)
(def FILE-DOES-NOT-EXIST-ERROR "File does not exist:")

; @constant (string)
(def DIRECTORY-DOES-NOT-EXIST-ERROR "Directory does not exist:")

; @constant (string)
;  Ha a swap-edn-file! függvény egy nem létező fájl tartalmát próbálja beolvasni,
;  akkor megjelenik a FILE-DOES-NOT-EXIST-ERROR hibaüzenet, majd ezután a tartalom
;  fájlba írásakor, amikor létrejön az addig nem létező fájl megjelenik a CREATE-FILE-MESSAGE
;  üzenet, így egyértelmű, hogy a FILE-DOES-NOT-EXIST-ERROR hibaüzenet ignorálható,
;  mivel az addig hiányzó fájl létrehozása megtörtént.
(def CREATE-FILE-MESSAGE "Creating file:")

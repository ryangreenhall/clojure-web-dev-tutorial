(ns clojure-web-dev-tutorial.hello-world
  (:use [ring.util.response]))


;; Hand rolled routing
;; Introduce helpers for generating a response
;; Generating json
;; Static Resources
;; Parameters


(comment
  (use 'ring.adapter.jetty)
  (use 'clojure-web-dev-tutorial.hello-world)

  (run-jetty handler {:port 3000}))

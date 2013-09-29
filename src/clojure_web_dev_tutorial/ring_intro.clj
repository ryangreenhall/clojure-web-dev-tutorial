(ns clojure-web-dev-tutorial.ring-intro
  (:require [ring.adapter.jetty :as jetty-adapter]))

(defn handler
  [request]
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body "Welcome to FPDays 2013"
   })

(defn -main [& args]
  (println "An introduction to Ring")
  (jetty-adapter/run-jetty handler {:port 8888}))
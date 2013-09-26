(ns clojure-web-dev-tutorial.compojure-routes
  (:require [compojure.core     :as compojure :refer [GET]]
            [ring.adapter.jetty :as jetty]))

(compojure/defroutes app
  ;; Define you routes here

  ;; 1. Define a route which responds to requests to "/" and returns a response with the body set to "hello world"


  ;; 2. Define a route which responds to /greet/(any-name) where any name is a url parameter, and returns a response
  ;;    with the body set to a "Hello (any-name)",
  ;;    e.g. request  -> /greet/jon
  ;;         response -> "hello jon"


  ;; 3. Define a route which responds to /error-name which returns a status code of 500 and a body containing a friendly
  ;;    error message

)


(defn -main [& args]
  (println (str "Starting the switch-api on port 8080...."))
  (jetty/run-jetty app {:port 8080}))

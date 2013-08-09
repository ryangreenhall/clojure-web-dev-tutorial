(ns clojure-web-dev-tutorial.compojure-routes
  (:require [compojure.core     :as compojure :refer [GET]]
            [ring.adapter.jetty :as jetty]
            [clojure.data.json  :refer [json-str]]))

(compojure/defroutes app
  ;;http://localhost:8080
  (GET "/"
    []
    "Hello World")

  ;;http://localhost:8080/greet/jon
  (GET "/greet/:name"
    [name]
    (str "Hello " name))

  (GET "/error-name"
    []
    {:status 500
     :body "Sorry, there has been a problem. Please try again with a different name"}))




(defn -main [& args]
  (println (str "Starting the switch-api on port 8080...."))
  (jetty/run-jetty app {:port 8080}))

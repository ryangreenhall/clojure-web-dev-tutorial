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

  ;;http://localhost:8080/greet/jon
  ;;Query string example - needs middleware
  (GET "/greeting"
    [salutation name]
    (format "Hello %s %s" salutation name))

  (GET "/error-name"
    []
    {:status 500
     :body "Sorry, there has been a problem. Please try again with a different name"})

  (GET "/greeting.json"
    [salutation name]
    (let [name (format "Hello %s %s" salutation name)]
      {:status 200
       :headers {"Content-Type"   "application/json"
                 "Vary"           "Accept-Encoding"
                 "Content-Length" (str (.length name))}
       :body (json-str {:greetings
                        {:salutation salutation
                         :name       name}})})))

(defn -main [& args]
  (println (str "Starting the switch-api on port 8080...."))
  (jetty/run-jetty app {:port 8080}))

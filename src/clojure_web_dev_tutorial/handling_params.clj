(ns clojure-web-dev-tutorial.handling-params
  (:require [compojure.core     :as compojure :refer [GET POST]]
            [compojure.route                                                       :as route]
            [ring.middleware.params :as params]
            [ring.adapter.jetty :as jetty]
            [clojure.data.json  :refer [json-str]]))

(compojure/defroutes app

  ;;Query string example - needs middleware
  (GET "/greeting"
    [title name]
    (format "Hello %s %s" title name))

  (GET "/greeting.json"
    [title name]
    (let [name (format "Hello %s %s" title name)]
      {:status 200
       :headers {"Content-Type"   "application/json"
                 "Vary"           "Accept-Encoding"
                 "Content-Length" (str (.length name))}
       :body (json-str {:title      title
                        :name       name})}))

  (GET "/interactive"
    []
    "<h1>Hi!</h1>
     <form action='/greeting' method='POST'>
        <label for='name-box'>Why don't you tell me your name?</label>
        <input type='text' name='name-box' id='name-box'/>
        <br/>
        <button>OK</button>
     </form>")

  (POST "/greeting"
    [name-box]
    (format "Hello %s" name-box))

  (route/not-found
   "<h1>Sorry, page not found</h1>"))

(defn -main [& args]
  (println (str "Starting the switch-api on port 8080...."))
  (jetty/run-jetty (params/wrap-params app) {:port 8080}))

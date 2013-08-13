(ns clojure-web-dev-tutorial.hiccup-templating
  (:require [compojure.core     :as compojure :refer [GET]]
            [ring.adapter.jetty :as jetty]
            [clojure.data.json  :refer [json-str]]
            [hiccup.core                :as hiccup]
            [hiccup.page                :as page]))

(compojure/defroutes app

  ;;http://localhost:8080
  (GET "/"
    []
    (hiccup/html
     (page/doctype :html5)
     [:html
      [:head
       [:title "Clojure web development tutorial"]]
      [:body
       [:div.header
        [:h1 "Hello World"]]]]))

  (GET "/error-name"
    []
    {:status 500
     :body "Sorry, there has been a problem. Please try again with a different name"}))




(defn -main [& args]
  (println (str "Starting the switch-api on port 8080...."))
  (jetty/run-jetty app {:port 8080}))

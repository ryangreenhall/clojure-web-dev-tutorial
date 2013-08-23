(ns clojure-web-dev-tutorial.step-6-working-app
  (:require [clojure-web-dev-tutorial.views.dashboard :as dashboard]
            [compojure.core                           :as compojure :refer [GET POST]]
            [clj-http.client                          :as client]
            [compojure.route                          :as route]
            [ring.middleware.params                   :as params]
            [ring.adapter.jetty                       :as jetty]
            [clojure.data.json                        :as json :refer [json-str read-json]]))

(def download_url "http://localhost:8888/status.json")


(compojure/defroutes app

  (GET "/status.json"
    []
    (let [requests (int (* 100 (Math/random)))]
      {:status 200
       :headers {"Content-Type"   "application/json"
                 "Vary"           "Accept-Encoding"}
       :body (json-str {:requests   requests
                        :status     (if (< requests 10) "error" "ok")
                        :messages   (int (* 1000 (Math/random)))})}))


  (GET "/"
    []
    (let [data (json/read-json (:body (client/get download_url)))]
      (dashboard/show data)))

  (route/resources "/"))

(defn -main [& args]
  (println (str "Starting the switch-api on port 8888...."))
  (jetty/run-jetty app {:port 8888}))

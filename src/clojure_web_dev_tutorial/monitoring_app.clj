(ns clojure-web-dev-tutorial.monitoring-app
  (:require [clojure-web-dev-tutorial.views.dashboard :as dashboard]
            [compojure.core                           :as compojure :refer [GET POST]]
            [clj-http.client                          :as client]
            [compojure.route                          :as route]
            [ring.middleware.params                   :as params]
            [ring.adapter.jetty                       :as jetty]
            [clojure.data.json                        :as json :refer [json-str read-json]]))

(def app-1-url "http://localhost:8888/status.json")

(def app-2-url "http://localhost:8888/another-application-status.json")



(compojure/defroutes app

  (GET "/status.json"
    []
    (let [requests (int (* 100 (Math/random)))]
      {:status 200
       :headers {"Content-Type"   "application/json"
                 "Vary"           "Accept-Encoding"}
       :body (json-str {:name       "Cool but useless app"
                        :requests   requests
                        :status     (if (< requests 10) "error" "ok")
                        :messages   (int (* 1000 (Math/random)))})}))

    (GET "/another-application-status.json"
    []
    (let [requests (int (* 100 (Math/random)))]
      {:status 200
       :headers {"Content-Type"   "application/json"
                 "Vary"           "Accept-Encoding"}
       :body (json-str {:name       "Super boring but important mission critical app"
                        :requests   requests
                        :status     (if (< requests 50) "error" "ok")
                        :messages   (int (* 1000 (Math/random)))})}))


  (GET "/"
    []
    ;; Fill this bit in
    ;; Should request data from the two urls defined above
    ;; Should pass that data through to the dashboard view (defined in clojure-web-dev-tutorial.views.dashboard)
    ;; Hint - check out the documentation for clj-http.client and clojure.data.json
    (let [status-1 (json/read-json (:body (client/get app-1-url)))
          status-2 (json/read-json (:body (client/get app-2-url)))]
      (dashboard/show status-1 status-2)))

  (route/resources "/"))

(defn -main [& args]
  (println (str "Starting the switch-api on port 8888...."))
  (jetty/run-jetty app {:port 8888}))

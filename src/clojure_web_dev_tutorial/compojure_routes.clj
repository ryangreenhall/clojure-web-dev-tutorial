(ns clojure-web-dev-tutorial.compojure-routes
  (:require [compojure.core     :as compojure :refer [GET]]
            [ring.adapter.jetty :as jetty]
            [ring.middleware.basic-authentication :as auth]
            [clojure.data.json  :refer [json-str]]
            [clojure.data.codec.base64 :as base64]))

(defn encode
  ;;Do not do this!
  [secret]
  (when secret
    (reduce str (map char
                     (clojure.data.codec.base64/encode
                      (.getBytes secret))))))

;;username is hello
;;password is world
(defn authenticated?
  [name pass]
  (and (= (encode name) "aGVsbG8=")
       (= (encode pass) "d29ybGQ=")))

(compojure/defroutes private-routes
  (GET "/top-secret"
    []
    "For your eyes only"))

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
     :body "Sorry, there has been a problem. Please try again with a different name"})

  (auth/wrap-basic-authentication private-routes authenticated?))


(defn -main [& args]
  (println (str "Starting the switch-api on port 8080...."))
  (jetty/run-jetty app {:port 8080}))

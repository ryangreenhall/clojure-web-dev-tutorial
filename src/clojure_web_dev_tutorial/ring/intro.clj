(ns clojure-web-dev-tutorial.ring.intro
  (:require [ring.adapter.jetty :as jetty-adapter]
            [ring.middleware.resource :as resource]))


; 3. Use response helpers. 


; 7. Parameter passing

; 1. Write the request params to the response.
(defn request-in-response-handler
  [request]
  {
   :body (str request)
   })

; 2. Write "Welcome to FPDays to the response"
;    - Set status to 200
;    - Set Content-Type to "text/plain"   
(defn welcome-to-fp-days-handler
  [request]
  {
    :status 200
    :headers {"Content-Type" "text/plain"}
    :body (str "Welcome to FPDays")
   })

; 4. Routing / => "Hello FP Days", anything else returns 404   
(defn routing-handler
  [request]
  (let [uri (:uri request)]
    (if (= uri "/")
        {:status 200
         :body "Hello FP Days"}
        {:status 404
         :body "Not Found!"})))
   

; 5. Middleware
;    - Write a simple middleware function that logs the request to the console.      
(defn wrap-logging
  [handler]
  (fn [request]
    (println request)
    (handler request)))
    
(def logging-enabled-welcome-app
  (-> welcome-to-fp-days-handler
      wrap-logging))

; 6. Static resources
;    - Configure the app to serve the css in the public dir. Hint: resource middleware
(def app-with-resources
  (-> welcome-to-fp-days-handler
      (resource/wrap-resource "public")))


(defn -main [& args]
  (println "Starting server...")
  (jetty-adapter/run-jetty logging-enabled-welcome-app {:port 8888}))

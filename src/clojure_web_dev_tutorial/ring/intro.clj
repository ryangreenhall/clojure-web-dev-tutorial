(ns clojure-web-dev-tutorial.ring.intro
  (:require [ring.adapter.jetty :as jetty-adapter]))

; 1. Write the request params to the response.

; 2. Write "Welcome to FPDays to the response"
;    - Set status to 200
;    - Set Content-Type to "text/plain"

; 3. Use response helpers. 

; 4. Routing / => "Hello FP Days", anything else returns 404

; 5. Static resources

; 6. Middleware
;    - Write a simple middleware function that logs the request to the console.

; 7. Parameter passing


(defn request-in-response-handler
  [request]
  {
   :body (str request)
   })
   
(defn welcome-to-fp-days-handler
  [request]
  {
    :status 200
    :headers {"Content-Type" "text/plain"}
    :body (str "Welcome to FPDays")
   })
   
(defn routing-handler
  [request]
  (let [uri (:uri request)]
    (if (= uri "/")
        {:status 200
         :body "Hello FP Days"}
        {:status 404
         :body "Not Found!"})))
   

(defn -main [& args]
  (println "Starting server...")
  (jetty-adapter/run-jetty routing-handler {:port 8888}))

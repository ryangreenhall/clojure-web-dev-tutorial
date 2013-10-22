(ns clojure-web-dev-tutorial.ring.intro
  (:require [ring.adapter.jetty :as jetty-adapter]))

; 1. Write the request params to the response.
; 2. Write "Welcome to FPDays to the response"
; 3. Use response helpers. 
; 4. Routing / => "Hello FP Days", anything else returns 404

; 5. Static resources
; 6. Middleware
; 7. Parameter passing. 


(defn handler
  [request]
  {
   })

(defn -main [& args]
  (println "Starting server...")
  (jetty-adapter/run-jetty handler {:port 8888}))

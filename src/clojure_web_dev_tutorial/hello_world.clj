(ns clojure-web-dev-tutorial.hello-world
  (:use [ring.util.response]))

(comment
  ;; request
  {:ssl-client-cert nil,
   :remote-addr "127.0.0.1",
   :scheme :http,
   :request-method :get,
   :query-string nil,
   :content-type nil,
   :uri "/",
   :server-name "localhost"
   :headers {:user-agent "Mozilla/5.0" }})

(defn handler
  "Handler that writes a simple sentance"
  [request]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body "FPDays 2013"

   })

(defn show-request-handler
  "Handler that writes the contents of the request"
  [request]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body (str request)})

(defn routing-handler
  [request]
  (if (= "/" (:uri request))
    {:status 200
     :headers {"Content-Type" "text/html"}
     :body (str "Hello FPDays 2013")}
    {:status 404
     :body (str "Not Found")}))

(defn handler-with-response-helpers
  [request]
  (if (= "/" (:uri request))
    (->
     (response "FPDays 2013")
     (content-type "text/plain"))
    (->
     (response "Not Found")
     (content-type "text/plain")
     (status 404))))



;; Hand rolled routing
;; Introduce helpers for generating a response
;; Generating json

(comment
  (use 'ring.adapter.jetty)
  (use 'clojure-web-dev-tutorial.hello-world)

  (run-jetty handler {:port 3000}))

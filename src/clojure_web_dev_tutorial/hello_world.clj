(ns clojure-web-dev-tutorial.hello-world)

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
  "Handler that says hello"
  [request]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body "Hello World"})


;; Hand rolled routing
;; Introduce helpers for generating a response

(comment
  (use 'ring.adapter.jetty)
  (use 'clojure-web-dev-tutorial.hello-world)

  (run-jetty handler {:port 3000}))

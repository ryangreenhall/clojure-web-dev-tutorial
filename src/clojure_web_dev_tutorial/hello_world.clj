(ns clojure-web-dev-tutorial.hello-world)

(defn handler
  "Handler that says hello"
  [request]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body "Hello World"})

(comment
  (use 'ring.adapter.jetty)
  (use 'clojure-web-dev-tutorial.hello-world)

  (run-jetty handler {:port 3000}))

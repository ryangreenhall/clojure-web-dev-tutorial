(ns clojure-web-dev-tutorial.app-test
  (:use clojure.test
        net.cgrand.enlive-html
        ring.mock.request
        clojure-web-dev-tutorial.app))

(defn html-from
  [app-response]
  (html-resource (html-snippet (:body app-response))))

(defn title
  [page]
  (first (select page [:h1 text])))

(deftest the-app
  (testing "the root says hello"

    (let [page (html-from (app (request :get "/")))
          title (title page)]

     (is (= "Hello World" title)))))

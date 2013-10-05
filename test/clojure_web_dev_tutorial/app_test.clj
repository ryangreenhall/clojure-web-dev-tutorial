(ns clojure-web-dev-tutorial.app-test
  (:use clojure.test
        net.cgrand.enlive-html
        ring.mock.request
        clojure-web-dev-tutorial.app))

(deftest the-app
  (testing "the root says hello"
    (html-resource (html-snippet "<html></html>"))
    (is (= "<h1>Hello World</h1>" (:body (app (request :get "/")))))))

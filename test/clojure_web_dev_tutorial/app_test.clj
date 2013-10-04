(ns clojure-web-dev-tutorial.app-test
  (:use clojure.test
        ring.mock.request
        clojure-web-dev-tutorial.app))

(deftest the-app
  (testing "the root says hello"
    (is (= "<h1>Hello World</h1>" (:body (app (request :get "/")))))))

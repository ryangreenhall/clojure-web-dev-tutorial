(ns clojure-web-dev-tutorial.app-test
  (:use clojure.test
        ring.mock.request
        clojure-web-dev-tutorial.app))

(deftest the-app
  (testing "the root says hello"
    (is (= 0 1))))
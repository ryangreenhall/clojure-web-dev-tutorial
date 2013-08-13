(ns clojure-web-dev-tutorial.views.hello-world
  (:require [hiccup.core                :as hiccup]
            [hiccup.page                :as page]))

(defn layout
  [& content]
  `[:html
    [:head
     [:title "Clojure web development tutorial"]]
    [:body
     [:h1 "Greeting"]
     ~content]])

(defn show
  [name]
  (hiccup/html
     (layout [:h2 (str "Hello " name)])))

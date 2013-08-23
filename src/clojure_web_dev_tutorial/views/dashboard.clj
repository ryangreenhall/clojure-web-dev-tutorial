(ns clojure-web-dev-tutorial.views.dashboard
  (:require [hiccup.core                :as hiccup]
            [hiccup.page                :as page]))

(defn layout
  [& content]
  `[:html
    [:head
     [:title "Clojure web development tutorial"]
     [:link {:rel "stylesheet" :href "/stylesheets/bootstrap.min.css"}]]
    [:body
     [:h1 "Greeting"]
     ~content]])

(defn show
  [{:keys [requests status messages]}]
  (hiccup/html
   (layout
    [:div.container
     [:div.row-fluid
      [:div.content.span9
       [:h1 status]
       [:ol
        [:li requests]
        [:li messages]]]]])))

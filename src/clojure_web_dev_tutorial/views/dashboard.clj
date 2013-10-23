(ns clojure-web-dev-tutorial.views.dashboard
  (:require [hiccup.core                :as hiccup]
            [hiccup.page                :as page]))

(defn layout
  [& content]
  `[:html
    [:head
     [:title "Clojure web development tutorial"]
     [:link {:rel "stylesheet" :href "/stylesheets/bootstrap.min.css"}]
     [:link {:rel "stylesheet" :href "/stylesheets/app.css"}]]
    [:body
     ~content]])

(defn show
  [& statuses]
  (hiccup/html
   (layout
    [:div.container
     [:div.page-header
      [:h1 "Current Status"]
      [:p.lead "This application will monitor a number of smaller applications"]]
     ;; Fill this bit in
     ;; Here you have a collection of status maps, each with a number of keys
     ;; Try and render all of the information in an informative way
     ])))

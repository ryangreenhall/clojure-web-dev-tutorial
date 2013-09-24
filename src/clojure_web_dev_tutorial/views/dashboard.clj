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
     (for [{:keys [name status messages requests]} statuses]
       [:div.status
        [:h3 name]
        [:div.row {:class status}
         [:div.col-md-4 status]
         [:div.col-md-4 messages]
         [:div.col-md-4 requests]]])])))

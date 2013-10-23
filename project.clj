(defproject clojure-web-dev-tutorial "0.1.0-SNAPSHOT"
  :description "Hands on introduction to web development in Clojure"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.5"]
                 [ring "1.2.0"]
                 [ring-mock "0.1.5"]
                 [enlive "1.1.4"]
				 [clj-http "0.7.7"]
				 [org.clojure/data.json "0.2.3"]]
  :plugins [[lein-ring "0.8.5"]]
  :ring {:handler clojure-web-dev-tutorial.monitoring-app/app})

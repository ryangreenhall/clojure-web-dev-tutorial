(defproject clojure-web-dev-tutorial "0.1.0-SNAPSHOT"
  :description "Hands on introduction to web development in Clojure"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [ring/ring-core "1.2.0"]
                 [ring/ring-jetty-adapter "1.1.0"]
                 [ring-basic-authentication "1.0.0"]
                 [compojure "1.0.4"]
                 [hiccup "1.0.3"]
                 [org.clojure/data.json "0.1.3"]
                 [clj-http "0.4.3" :exclusions [commons-codec]]]
  :plugins [[lein-ring "0.8.5"]]
  :ring {:handler clojure-web-dev-tutorial.handling-params/app})

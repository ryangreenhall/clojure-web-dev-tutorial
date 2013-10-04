(ns clojure-web-dev-tutorial.app
  (:use compojure.core)
  (:require [compojure.route :as route]))

(defroutes app
  (GET "/" [] "<h1>Hello World</h1>")
  (route/not-found "<h1>Page not found</h1>"))

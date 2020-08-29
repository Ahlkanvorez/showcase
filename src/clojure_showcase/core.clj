(ns clojure-showcase.core
  (:require [clojure-showcase.views.index :as index]
            [clojure-showcase.views.not-found :as not-found]
            [clojure-showcase.views.projects :as projects]
            [clojure-showcase.views.about :as about]
            [clojure-showcase.views.blog :as blog]
            [ring.adapter.jetty :as jetty]
            [ring.util.response :as ring-util]
            [compojure.core :as compojure]
            [compojure.route :as route]
            [hiccup.core :as h]
            [hiccup.page :as page]
            [clojure-showcase.views.article :as article])
  (:gen-class))

(def server
  (compojure/routes
   (compojure/GET "/showcase" [] (index/view))
   (compojure/GET "/showcase/projects" [] (projects/view))
   (compojure/GET "/showcase/about" [] (about/view))
   (compojure/GET "/showcase/blog" [] (blog/view))
   (compojure/GET "/showcase/blog/:title" [title] (article/view title))
   (route/resources "/showcase/")
   (route/not-found (not-found/view))))

(defn -main [& args]
  (jetty/run-jetty server {:port 3000 :join? false}))

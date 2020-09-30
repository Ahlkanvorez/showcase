(ns clojure-showcase.core
  (:require [clojure-showcase.views.index :as index]
            [clojure-showcase.views.not-found :as not-found]
            [clojure-showcase.views.projects :as projects]
            [clojure-showcase.views.article :as article]
            [clojure-showcase.views.about :as about]
            [clojure-showcase.views.blog :as blog]
            [ring.adapter.jetty :as jetty]
            [ring.util.response :as ring-util]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [hiccup.core :as h]
            [hiccup.page :as page]
            [clojure.edn :as edn]
            [clj-statsd :as stats])
  (:gen-class))

(def server-api
  (routes
   (GET "/" [] (ring-util/redirect "/showcase"))
   (context "/showcase" []
            (GET "/" [] (index/view))
            (GET "/projects" [] (projects/view))
            (GET "/about" [] (about/view))
            (GET "/blog" [] (blog/view))
            (GET "/blog/:title" [title] (article/view title)))
   (route/resources "/")
   (route/not-found (not-found/view))))

(def server (atom nil))

(defn start [port]
  (reset! server (jetty/run-jetty server-api {:port port :join? false})))

(defn stop []
  (.stop @server)
  (reset! server nil))

(defn -main [& args]
  (stats/setup "graphite" 8125)
  (stats/increment :showcase.server.started)
  (start 3000))

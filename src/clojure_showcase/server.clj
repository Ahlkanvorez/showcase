(ns clojure-showcase.server
  (:require [clojure.tools.logging :as log]
            [clojure.edn :as edn]
            [clojure-showcase.views.index :as index]
            [clojure-showcase.views.not-found :as not-found]
            [clojure-showcase.views.projects :as projects]
            [clojure-showcase.views.article :as article]
            [clojure-showcase.views.about :as about]
            [clojure-showcase.views.blog :as blog]
            [clojure-showcase.utils :as utils]
            [ring.adapter.jetty :as jetty]
            [ring.util.response :as ring-util]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [hiccup.core :as h]
            [hiccup.page :as page]
            [com.stuartsierra.component :as component]))

(defn server-api []
  (routes
   (GET "/" [] (index/view))
   (GET "/projects" [] (projects/view))
   (GET "/about" [] (about/view))
   (GET "/blog" [] (blog/view))
   (GET "/blog/:title" [title]
        (article/view title))
   (route/resources "/")
   (route/not-found (not-found/view))))

(defrecord Server [port server]
  component/Lifecycle
  (start [this]
    (if server
      (do (log/warn "Server already running")
          this)
      (do (log/info "Starting server on port" port)
          (assoc this :server
                 (jetty/run-jetty (server-api)
                                  {:port port :join? false})))))
  (stop [this]
    (if-not server
      (do (log/warn "Server not running")
          this)
      (do (log/info "Stopping server")
          (.stop server)
          (assoc this :server nil)))))

(defn make-with [port]
  (map->Server {:port (Integer/parseInt port)}))


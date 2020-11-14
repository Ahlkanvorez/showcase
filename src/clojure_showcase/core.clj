(ns clojure-showcase.core
  (:require [clojure-showcase.server :as server]
            [com.stuartsierra.component :as component]
            [clj-statsd :as stats])
  (:gen-class))

(defonce server (atom nil))

(defn start
  "Start the webserver using the given port with all urls
having the given prefix"
  [port prefix]
  (reset! server
          (component/start
           (server/make-with port prefix))))

(defn stop []
  (reset! server (component/stop @server)))

(defn restart []
  (when-not (nil? @server)
    (stop))
  (start (:port @server) (:prefix @server)))

(defn -main [& args]
  (stats/setup "graphite" 8125)
  (stats/increment :showcase.server.started)
  (start 3000 (System/getenv "HTTP_PREFIX")))

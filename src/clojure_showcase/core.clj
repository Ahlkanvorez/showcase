(ns clojure-showcase.core
  (:require [clojure-showcase.server :as server]
            [com.stuartsierra.component :as component])
  (:gen-class))

(defonce server (atom nil))

(defn start
  "Start the webserver using the given port."
  [port]
  (reset! server
          (component/start
           (server/make-with port))))

(defn stop []
  (reset! server (component/stop @server)))

(defn restart []
  (when-not (nil? @server)
    (stop))
  (start (:port @server)))

(defn -main [& args]
  (start (or (System/getenv "PORT") "3000")))

(ns clojure-showcase.views.about
  (:require [clojure-showcase.views.article :as article]
            [clj-statsd :as stats]))

(defn content []
  (article/content "about"))

(defn view []
  (stats/increment :showcase.pages-viewed.about)
  (article/view "about"))

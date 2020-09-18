(ns clojure-showcase.views.index
  (:require [clojure-showcase.views.layout :as layout]
            [hiccup.core :as h]
            [clj-statsd :as stats]))

(defn view []
  (stats/increment :showcase.pages-viewed.index)
  (layout/base
   :title "Hello World"
   :content [:ul
             [:li "Lots"]
             [:li "Of"]
             [:li "Cheese"]]))

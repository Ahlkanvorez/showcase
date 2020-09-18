(ns clojure-showcase.views.index
  (:require [clojure-showcase.views.layout :as layout]
            [hiccup.core :as h]))

(defn view []
  (layout/base
   :title "Hello World"
   :content [:ul
             [:li "Lots"]
             [:li "Of"]
             [:li "Cheese"]]))

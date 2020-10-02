(ns clojure-showcase.views.index
  (:require [clojure-showcase.views.layout :as layout]
            [hiccup.core :as h]
            [clj-statsd :as stats]
            [clojure-showcase.views.projects :as projects]
            [clojure-showcase.views.about :as about]
            [clojure-showcase.views.blog :as blog]))

(defn view []
  (stats/increment :showcase.pages-viewed.index)
  (layout/base
   :title "Robert Mitchell"
   :content
   [:div
    [:div (projects/content)]
    [:div {:class "bg-light"}
     [:h1 {:class "display-3"}
      "Hello Coding Projects"]]
    [:div
     [:h1 {:class "display-3"}
      "More stuff"]]]))

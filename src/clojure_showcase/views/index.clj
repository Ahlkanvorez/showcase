(ns clojure-showcase.views.index
  (:require [clojure-showcase.views.layout :as layout]
            [hiccup.core :as h]
            [clojure-showcase.views.projects :as projects]
            [clojure-showcase.views.about :as about]
            [clojure-showcase.views.blog :as blog]))

(defn view []
  (layout/base
   :title "Robert Mitchell"
   :content
   [:div
    [:div (projects/content)]
    [:div {:class "d-flex flex-wrap"}
     [:div {:class "container-fluid bg-light"}
      [:h4 {:class "display-4"}
       "Another Section"]]
     [:div {:class "container-fluid"}
      [:h4 {:class "display-4"}
       "More stuff"]]]]))

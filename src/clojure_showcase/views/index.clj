(ns clojure-showcase.views.index
  (:require [hiccup.core :as h]
            [clojure-showcase.utils :as utils]
            [clojure-showcase.views.about :as about]
            [clojure-showcase.views.blog :as blog]
            [clojure-showcase.views.layout :as layout]
            [clojure-showcase.views.projects :as projects]))

(defn view []
  (layout/base
   :title "Robert Mitchell"
   :content
   [:div
    (projects/content)
    (about/work-history)]))

(ns clojure-showcase.views.projects
  (:require [clojure-showcase.views.layout :as layout]
            [hiccup.core :as h]
            [clj-statsd :as stats]))

(defn view []
  (stats/increment :showcase.pages-viewed.projects)
  (layout/base
   :title "Projects"
   :content [:div
             [:h1 "I need to actually put projects here"]
             [:p "But this works for now"]
             [:ul
              [:li "Even"]
              [:li "More"]
              [:li "Cheese"]]]))

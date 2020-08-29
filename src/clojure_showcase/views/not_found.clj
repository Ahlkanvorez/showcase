(ns clojure-showcase.views.not-found
  (:require [clojure-showcase.views.layout :as layout]
            [hiccup.core :as h]))

(defn view []
  (layout/base
   :title "Page not found"
   :content [:div
             [:h3 "Got a 404"]
             [:p "This is not the page you're looking for. You will go about your browsing"]]))

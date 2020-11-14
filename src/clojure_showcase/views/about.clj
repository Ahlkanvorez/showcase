(ns clojure-showcase.views.about
  (:require [clojure-showcase.views.article :as article]))

(defn content []
  (article/content "about"))

(defn view []
  (article/view "about"))

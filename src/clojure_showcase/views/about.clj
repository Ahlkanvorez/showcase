(ns clojure-showcase.views.about
  (:require [clojure-showcase.views.article :as article]))

(defn view []
  (article/view "about"))

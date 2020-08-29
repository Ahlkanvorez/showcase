(ns clojure-showcase.layout
  (:require [hiccup.page :as h]))

(defn base [title & body]
  (h/html5
   [:head
    [:meta {:charset "utf-8"}]
    [:meta {:name "viewport"
            :content "width=device-width, initial-scale=1, maximum-scale=1"}]
    [:title title]
    (h/include-css "/stylesheets/base.css")]
   [:body
    [:div {:id "header"}
     [:h1 {:class "container"} "Hello"]]
    [:div {:id "content" :class "container"} body]]))

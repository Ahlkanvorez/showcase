(ns clojure-showcase.views.layout
  (:require [hiccup.page :as h]))

(defn nav-link [url name]
  [:li {:class "nav-item"}
   [:a {:href url} name]])

(defn header []
  [:div {:class "header"}
   [:div {:class "row"}
    [:nav {:id "navbar" :class "navbar navbar-fixed-top"}
     [:div {:class "container"}
      [:div {:class "navbar-header"}
       [:button {:class "navbar-toggle"
                 :data-toggle "collapse"
                 :data-target "#navbar-collapse"}
        [:span {:class "sr-only"} "Toggle Navigation"]
        [:span {:class "icon-bar"}]
        [:span {:class "icon-bar"}]
        [:span {:class "icon-bar"}]]
       [:a {:id "blog-title" :class "navbar-brand" :href "/showcase"}
        "Robert Mitchell"]]
      [:div {:id "navbar-collapse" :class "collapse navbar-collapse"}
       [:ul {:class "nav navbar-nav"}
        (nav-link "/showcase/about" "About")
        (nav-link "/showcase/blog" "Blog")
        (nav-link "/showcase/projects" "Projects")]]]]]])

(defn base [& {:keys [title content]}]
  (h/html5
   [:head
    [:meta {:charset "utf-8"}]
    [:meta {:name "viewport"
            :content "width=device-width, initial-scale=1, maximum-scale=1"}]
    [:title title]
    (h/include-css "/showcase/css/styles.css")
    (h/include-css
     "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
     "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css")
    (h/include-js
     "https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"
     "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js")]
   [:body
    [:div {:class "container"}
     (header)
     [:div {:class "row" :style "margin-top: 60px"}
      [:div {:class "col-lg-12"} content]]]]))

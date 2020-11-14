(ns clojure-showcase.views.layout
  (:require [hiccup.page :as h]))

(defn nav-link [name]
  [:li {:class "nav-item"}
   [:a {:class "nav-link"
        :href (str "/" (.toLowerCase name))}
    name]])

(defn header []
  [:div {:class "header"}
   [:nav
    {:class "navbar fixed-top navbar-expand-lg navbar-light bg-light"
     :id "navbar"}
    [:a {:class "navbar-brand blog-title"
         :href "/"}
     "Robert Mitchell"]
    [:button {:class "navbar-toggler"
              :type "button"
              :data-toggle "collapse"
              :data-target "#navbarSupportedContent"
              :aria-controls "navbarSupportedContent"
              :aria-expanded "false"
              :aria-label "Toggle navigation"}
     [:span {:class "navbar-toggler-icon"}]]
    [:div {:class "collapse navbar-collapse"
           :id "navbarSupportedContent"}
     [:ul {:class "navbar-nav mr-auto"}
      (for [page ["Projects" "Blog" "About"]]
        (nav-link page))]]]])

(defn footer []
  [:footer {:class "footer bg-light"}
   [:div {:class "jumbotron bg-transparent"}
    [:div {:class "container"}
     [:h5 {:class "display-5"}
      "Contact Me"]
     [:a {:class "btn btn-secondary btn-large"}
      "Github"]
     [:a {:class "btn btn-secondary btn-large"}
      "Bitbucket"]
     [:a {:class "btn btn-secondary btn-large"}
      "LinkedIn"]]]])

(defn head [title]
  [:head
   [:meta {:charset "utf-8"}]
   [:meta {:name "viewport"
           :content "width=device-width, initial-scale=1, shrink-to-fit=no"}]
   [:title title]
   (h/include-css "/css/styles.css")
   (h/include-css
    "https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css")
   (h/include-js
    "https://code.jquery.com/jquery-3.5.1.slim.min.js"
    "https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
    "https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js")])

(defn base [& {:keys [title content]}]
  (h/html5 (head title)
           [:body
            [:div {:class "wrapper"}
             (header)
             content
             (footer)]]))

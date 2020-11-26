(ns clojure-showcase.views.about
  (:require [clojure-showcase.utils :as utils]
            [clojure-showcase.views.article :as article]
            [clojure-showcase.views.layout :as layout]))

(defn role-content [role]
  [:div {:class "p-2 d-flex flex-row"}
   [:h5 {:class "h5 mr-auto"} (:title role)]
   [:span (:dates role)]])

(defn work-history-for [job]
  [:div {:class "jumbotron"}
   [:h4 {:class "h4"} (:company job)]
   [:div {:class "d-flex flex-column"}
    (for [role (:roles job)]
      (role-content role))]
   (:description job)])

(defn work-history []
  [:div {:class "container-fluid bg-light"}
   [:h4 {:class "display-4 mt-3"}
    "Work History"]
   (for [job (utils/work-history)]
     (work-history-for job))])

(defn content []
  [:div
   (article/content "about")
   (work-history)])

(defn view []
  (layout/base
   :title (str "Robert Mitchell | About")
   :content (content)))

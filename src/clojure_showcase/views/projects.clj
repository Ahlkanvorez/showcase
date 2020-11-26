(ns clojure-showcase.views.projects
  (:require [clojure-showcase.views.layout :as layout]
            [clojure-showcase.utils :as utils]
            [hiccup.core :as h]))

(defn projects [] (utils/read-projects-list))

(defn projects-content []
  [:div {:class "d-flex flex-wrap bg-transparent w-auto project-list-container"
         :style (str
                 "margin-top: 30px;"
                 "margin-left: 0px;"
                 "margin-right: 0px;")}
   (for [[r row] (map-indexed vector (partition-all 2 (projects)))]
     (for [[c project] (map-indexed vector row)]
       [:div {:class "project-container"
              :style (str "background-image: url(\"" (project :img) "\");"
                          "flex: auto;")}
        [:div {:class "card text-light"
               :style (str "background-color: rgba(0, 0, 0, 0.5); "
                           "height: 100%;"
                           "border-radius: 0;"
                           "padding-left: 30px;"
                           "padding-right: 30px;")}
         [:h1 {:class "card-title"}
          (if-let [demo-url (get project :demo-url)]
            [:a {:class "text-decoration-none text-reset"
                 :href demo-url
                 :target "_blank"
                 :rel "noreferrer noopener"}
             (project :name)]
            (project :name))]
         [:p {:class "card-text lead"}
          (project :description)]]]))])

(defn technologies-content []
  [:div {:class "d-flex flex-wrap"}
   [:div {:class "container-fluid"}
    [:h4 {:class "display-4 mt-3"}
     "Technologies"]
    (let [tech (utils/project-technologies)]
      (for [group (keys tech)]
        [:div {:class "d-flex flex-wrap rounded-sm border-top mb-2"}
         [:span {:class "p-2 lead text-white bg-secondary"
                 :style "width: 130px"}
          group]
         (for [item (group tech)]
           [:span {:class "p-2 lead"} item])]))]])

(defn content []
  [:div
   [:div (projects-content)]
   [:div (technologies-content)]])

(defn view []
  (layout/base
   :title "Projects"
   :content (content)))

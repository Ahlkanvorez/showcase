(ns clojure-showcase.views.projects
  (:require [clojure-showcase.views.layout :as layout]
            [hiccup.core :as h]
            [clj-statsd :as stats]))

(defn view []
  (stats/increment :showcase.pages-viewed.projects)
  (layout/base
   :title "Projects"
   :content
   [:div {:class "jumbotron jumbotron-fluid"}
    [:div {:class "container"}
     [:div {:class "row"}
      [:div {:class "col"}
       [:h1 {:class "display-2"}
        "Project A"]
       [:p {:class "lead"}
        "Exciting one-liner about project a that definitely makes someone want to look into it with a positive impression"]]
      [:div {:class "col"}
       [:h1 {:class "display-2"}
        "Service B"]
       [:p {:class "lead"}
        "Eye-catching sentence on service b"]]
      [:div {:class "w-100"}]
      [:div {:class "col"}
       [:h1 {:class "display-2"}
        "Web App C"]
       [:p {:class "lead"}
        "Lots of memorable cliches for Web App C"]]
      [:div {:class "col"}
       [:h1 {:class "display-2"}
        "Library D"]
       [:p {:class "lead"}
        "Even more text, probably too much, but oh well; there needs to be at least one example of a sentence with non-trivial length in order to get a feel for styling."]]]]]))

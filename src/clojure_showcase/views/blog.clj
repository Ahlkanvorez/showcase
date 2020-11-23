(ns clojure-showcase.views.blog
  (:require [clojure.java.io :as io]
            [clojure-showcase.views.layout :as layout]
            [clojure-showcase.utils :as utils]
            [hiccup.core :as h]
            [clojure.edn :as edn]))

(defn articles []
  (->> (transduce
        (comp (map (juxt utils/read-article identity))
              (map
               #(assoc
                 (update (first %) :content (comp vec (partial take 3)))
                 :name (second %))))
        conj
        (utils/read-blog-list))
       (sort-by :date)
       reverse))

(defn content []
  [:div {:class "jumbotron jumbotron-fluid bg-transparent"
         :style "margin-top: 30px;"}
   [:div {:class "d-flex flex-column container"}
    (for [article (articles)]
      [:div {:style "text-align: justify"
             :onclick
             (str "location.href='"
                  (if (= (:name article) "about")
                    "/about"
                    (str "/blog/" (:name article)))
                  "'")}
       (:content article)])]])

(defn view []
  (layout/base
   :title "Robert Mitchell | Blog"
   :content (content)))

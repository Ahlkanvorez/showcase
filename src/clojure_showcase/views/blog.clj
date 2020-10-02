(ns clojure-showcase.views.blog
  (:require [clojure.java.io :as io]
            [clojure-showcase.views.layout :as layout]
            [clojure-showcase.utils :as utils]
            [hiccup.core :as h]
            [clojure.edn :as edn]
            [clj-statsd :as stats]))

(defn articles []
  (->> (utils/article-root)
       io/file
       file-seq
       (filter #(.isFile %))
       (map (fn [path]
              (let [name (-> path
                             str
                             (clojure.string/split #"/")
                             last
                             (clojure.string/split #"\.")
                             first)
                    {date :date [div & contents] :content}
                    (utils/read-article name)]
                {:name name
                 :date date
                 :content (vec (conj (take 2 contents)
                                     div))})))
       (sort-by :date)
       reverse))

(defn content []
  [:div {:class "jumbotron jumbotron-fluid bg-transparent"
         :style "margin-top: 30px;"}
   [:div {:class "d-flex flex-column container"}
    (for [article (articles)]
      [:div {:onclick
             (str "location.href='"
                  (if (= (:name article) "about")
                    "/showcase/about"
                    (str "/showcase/blog/" (:name article)))
                  "'")}
       (:content article)])]])

(defn view []
  (stats/increment :showcase.pages-viewed.blog)
  (layout/base
   :title "Robert Mitchell | Blog"
   :content (content)))

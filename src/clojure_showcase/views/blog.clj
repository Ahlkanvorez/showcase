(ns clojure-showcase.views.blog
  (:require [clojure-showcase.views.article :as article]
            [clojure-showcase.views.layout :as layout]
            [clojure.java.io :as io]
            [hiccup.core :as h]
            [clojure.edn :as edn]
            [clj-statsd :as stats]))

(defn articles []
  (->> (article/root-path) io/file file-seq
       (filter #(.isFile %))
       (map (fn [name]
              (let [{date :date [div & contents] :content}
                    (-> name slurp edn/read-string)]
                {:name (-> name .getName (clojure.string/split #"\.") first)
                 :date date
                 :content (vec (conj (take 2 contents)
                                     div))})))
       (sort-by :date)
       reverse))

(defn view []
  (stats/increment :showcase.pages-viewed.blog)
  (layout/base
   :title "Robert Mitchell | Blog"
   :content [:div {:id "article-list"}
             (for [article (articles)]
               [:div {:onclick
                      (str "location.href='"
                           (if (= (:name article) "about")
                             "/showcase/about"
                             (str "/showcase/blog/" (:name article)))
                           "'")}
                [:div {:class "article-summary"}
                 (:content article)]])]))

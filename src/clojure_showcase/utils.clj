(ns clojure-showcase.utils
  (:require [clojure.edn :as edn]))

(defn prefix-with [prefix s]
  (if (.startsWith s prefix) s (str prefix s)))

(defn suffix-with [suffix s]
  (if (.endsWith s suffix) s (str s suffix)))

(defn wrap-with [prefix suffix s]
  (->> s (prefix-with prefix) (suffix-with suffix)))

(defn articles-uri []
  (or (System/getenv "ARTICLES_REPO")
      "https://raw.githubusercontent.com/Ahlkanvorez/blog-articles/master/"))

(defn projects-uri []
  (or (System/getenv "PROJECTS_REPO")
      "https://raw.githubusercontent.com/Ahlkanvorez/showcase-projects/master/"))

(defn article-root []
  (str (articles-uri) "articles/"))

(defn slurp-edn [path] (-> path slurp edn/read-string))

(defn read-article [name]
  (->> name (wrap-with (article-root) ".edn") slurp-edn))

(defn read-projects-list []
  (-> (projects-uri) (str "projects.edn") slurp-edn))

(defn read-blog-list []
  (-> (articles-uri) (str "index.edn") slurp-edn :articles))

(defn project-technologies []
  (->> (read-projects-list)
       (map :technologies)
       (apply merge-with (comp sort set concat))))

(defn work-history []
  (-> (projects-uri) (str "work.edn") slurp-edn))

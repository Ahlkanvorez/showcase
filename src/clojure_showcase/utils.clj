(ns clojure-showcase.utils
  (:require [clojure.edn :as edn]))

(defn prefix-with [prefix s]
  (if (.startsWith s prefix) s (str prefix s)))

(defn suffix-with [suffix s]
  (if (.endsWith s suffix) s (str s suffix)))

(defn wrap-with [prefix suffix s]
  (->> s (prefix-with prefix) (suffix-with suffix)))

(defn article-root []
  (str (System/getenv "ARTICLES_REPO") "articles/"))

(defn slurp-edn [path] (-> path slurp edn/read-string))

(defn read-article [name]
  (->> name (wrap-with (article-root) ".edn") slurp-edn))

(defn projects-root []
  (str (System/getenv "PROJECTS_REPO")))

(defn read-projects-list []
  (-> (projects-root) (str "projects.edn") slurp-edn))

(defn read-blog-list []
  (-> (System/getenv "ARTICLES_REPO") (str "index.edn") slurp-edn :articles))

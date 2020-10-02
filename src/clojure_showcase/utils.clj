(ns clojure-showcase.utils
  (:require [clojure.edn :as edn]))

(defn prefix-with [p s]
  (if (.startsWith s p)
    s
    (str p s)))

(defn root-path []
  (str (System/getProperty "user.dir")
       "/resources/public/showcase/edn/"))

(defn article-root []
  (str (root-path) "/articles/"))

(defn path [name]
  (str (root-path) "/" name ".edn"))

(defn read-edn-file [name]
  (-> name path slurp edn/read-string))

(defn read-article [name]
  (read-edn-file (str "articles/" name)))

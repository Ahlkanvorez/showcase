(ns clojure-showcase.views.article
  (:import (java.time LocalDateTime ZoneId)
           (java.time.format DateTimeFormatter))
  (:require [clojure-showcase.views.layout :as layout]
            [clojure.edn :as edn]
            [hiccup.core :as h]
            [clj-statsd :as stats]))

(defn root-path []
  (str (System/getProperty "user.dir")
       "/resources/public/showcase/edn/"))

(defn path [name]
  (str (root-path) "/" name ".edn"))

(defn date [d]
  (-> (DateTimeFormatter/ofPattern "yyyy/MM/dd hh:mm:ss a")
      (.format (.. d toInstant
                   (atZone (ZoneId/systemDefault))
                   toLocalDateTime))))

(defn view [name]
  (stats/increment (keyword (str "showcase.pages-viewed.article." name)))
  (layout/base
   :title (str "Robert Mitchell | " (clojure.string/capitalize name))
   :content
   (let [article (-> name path slurp edn/read-string)]
     [:article {:style "text-align: justify"}
      [:header {:style "float: right"}
       [:time (date (:date article))]]
      (:content article)])))

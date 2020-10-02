(ns clojure-showcase.views.article
  (:import (java.time LocalDateTime ZoneId)
           (java.time.format DateTimeFormatter))
  (:require [clojure.string :as string]
            [clojure-showcase.views.layout :as layout]
            [clojure-showcase.utils :as utils]
            [hiccup.core :as h]
            [clj-statsd :as stats]))

(defn date [d]
  (-> (DateTimeFormatter/ofPattern "yyyy/MM/dd hh:mm a")
      (.format (.. d toInstant
                   (atZone (ZoneId/systemDefault))
                   toLocalDateTime))))

(defn content [name]
  (let [article (utils/read-article name)]
    [:article {:style "margin-top: 30px; text-align: justify"}
     [:div {:class "jumbotron jumbotron-fluid bg-transparent"}
      [:div {:class "container"}
       (:content article)
       [:header {:style "float: right"}
        "Last Updated " [:time (date (:date article))]]]]]))

(defn view [name]
  (stats/increment (keyword (str "showcase.pages-viewed.article." name)))
  (layout/base
   :title (str "Robert Mitchell | " (clojure.string/capitalize name))
   :content (content name)))

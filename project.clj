(defproject clojure-showcase "1.1.1"
  :description "A site to showcase projects and share articles"
  :url "https://ahlk.io/showcase"
  :license {:name "BSD 3-Clause License"
            :url "https://choosealicense.com/licenses/bsd-3-clause/"}
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [com.stuartsierra/component "1.0.0"]

                 ;; webserver
                 [javax.servlet/servlet-api "2.5"]
                 [ring/ring-core "1.8.1"]
                 [ring/ring-jetty-adapter "1.6.3"]
                 [compojure "1.6.2"]
                 [hiccup "1.0.5"]

                 ;; logging
                 [org.slf4j/slf4j-simple "1.7.30"]
                 [org.clojure/tools.logging "1.1.0"]]
  :plugins [[lein-ring "0.12.5"]]
  :ring {:handler clojure-showcase.core/server}
  :target-path "target/%s"
  :uberjar-name "showcase-standalone.jar"
  :profiles {:uberjar {:aot :all :main clojure-showcase.core}
             :dev {:main clojure-showcase.core}})

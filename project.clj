(defproject clojure-showcase "1.0.5"
  :description "A site to showcase projects and share articles"
  :url "https://ahlk.io/showcase"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [javax.servlet/servlet-api "2.5"]
                 [ring/ring-core "1.8.1"]
                 [ring/ring-jetty-adapter "1.6.3"]
                 [compojure "1.6.2"]
                 [hiccup "1.0.5"]]
  :plugins [[lein-ring "0.12.5"]]
  :ring {:handler clojure-showcase.core/server}
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all :main clojure-showcase.core}})

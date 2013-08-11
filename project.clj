(defproject clojure-my-friend "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [postgresql/postgresql "8.4-702.jdbc4"]
                 [korma "0.3.0-RC5"]
                 [ring/ring-jetty-adapter "1.1.6"]
                 [hiccup "1.0.2"]
                 [compojure "1.1.5"]]
  :plugins [[lein-ring "0.8.3"]]
  :main clojure-my-friend.core
  :ring {:auto-refresh? true
         :handler clojure-my-friend.core/application})

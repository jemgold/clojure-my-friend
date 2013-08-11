(ns clojure-my-friend.core
  (:use [compojure.core :only (defroutes)]
        [ring.adapter.jetty :as ring])
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
            [clojure-my-friend.controllers.people :as people]
            [clojure-my-friend.views.layout :as layout]))

(defroutes routes
  people/routes
  (route/resources "/")
  (route/not-found (layout/four-oh-four)))

(def application (handler/site routes))

(defn -main []
    (run-jetty #'application {:port 8080 :join? false}))

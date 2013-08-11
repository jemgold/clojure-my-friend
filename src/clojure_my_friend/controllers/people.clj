(ns clojure-my-friend.controllers.people
  (:use [compojure.core :only (defroutes GET)])
  (:require [clojure-my-friend.views.people :as view]
            [clojure-my-friend.models.person :as model]))

(defn index []
  (view/index (model/all)))

(defn popular [num]
  (view/index (model/popular (read-string num))))

(defn location []
  (view/index (model/location)))

(defn location
  ([] (view/index (model/location)))
  ([loc] (view/index (model/location loc)))
  )

(defroutes routes
  (GET "/" [] (index))
  (GET "/popular/:num" [num] (popular num))
  (GET "/location" [] (location))
  (GET "/location/:loc" [loc] (location loc)))

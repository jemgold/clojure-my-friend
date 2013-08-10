(ns clojure-my-friend.models.person
  (:use clojure-my-friend.config
        korma.core))

(defentity people)

(defn all []
  (select people))

(defn total []
  (count (all)))


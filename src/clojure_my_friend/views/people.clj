(ns clojure-my-friend.views.people
  (:use [hiccup.core :only (h)])
  (:require [clojure-my-friend.views.layout :as layout]))

(defn display_person [person]
  (let [tags (:tags (first(:profiles person)))]
    [:tr
     [:td (:slug person)]
     [:td (:followers_count person)]
     [:td (:location person)]
     [:td (:endorsers person)]
     [:td tags]
     ;; [:td (for [tag tags] tag)]
     ]
   ))

(defn index [people]
  (layout/common "people"
    [:table.table.table-striped
     [:thead
      [:th "Profile"]
      [:th "Followers"]
      [:th "Location"]
      [:th "Endorsers"]
      [:th "Tags"]]
     [:tbody
      (for [person people] (display_person person) )
     ]]))

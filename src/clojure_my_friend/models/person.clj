(ns clojure-my-friend.models.person
  (:use clojure-my-friend.config
        korma.core))
(defentity profiles)

(defentity people
  (has-many profiles {:fk :person_id}))

(defn all []
  (select people
    (with profiles)
    (order :created_at :ASC)))

(defn popular [num]
  (filter
    (fn [p] ( > (:followers_count p) num))
  (select people
    (order :followers_count :DESC)
      )))

(defn location
  ([] (filter
    (fn [p] ((complement clojure.string/blank?) (:location p) ))
    (all)))
  ([loc] (filter
    (fn [p] ( clojure.core/re-find #"(London)" (:location p) ))
    ;; (fn [p] ( clojure.string/re-find #"\London" (:location p) ))
    (all)))
  )

(defn has-location? [person]
  (filter
    (fn [p] (  ))
    person))

(defn total []
  (count (all)))

(defn first-profile [p]
  (if (count (:profiles p))
    (first (:profiles p))))

;;(first-profile (first (all)))

;;(for [p (all)] (first-profile p))
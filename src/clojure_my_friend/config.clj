(ns clojure-my-friend.config
  (:use korma.core
        korma.db))

(defdb prod (postgres {:db "hire_my_friend_production"}))

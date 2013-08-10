(ns clojure-my-friend.models.person
  (:require [clojure.java.jdbc :as sql]))

(let [db-host "localhost"
      db-port 5432
      db-name "hire_my_friend_production"]

  (def db {:classname "org.postgresql.Driver" ; must be in classpath
           :subprotocol "postgresql"
           :subname (str "//" db-host ":" db-port "/" db-name)
           ; Any additional keys are passed to the driver
           ; as driver-specific properties.
           ;:user "a_user"
           ;:password "secret"
           }))

(defn all []
    (sql/with-connection db
      (sql/with-query-results results
        ["select * from people order by id desc"]
        (into [] results))))

(ns sms.handler.api
  (:require [compojure.core :refer [context GET]]
            [integrant.core :as ig]))

(defmethod ig/init-key :sms.handler/api [_ options]
  (context "/messages" []
    (GET "/" []
      {:body {:example "data"}})))

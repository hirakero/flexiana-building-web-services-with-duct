(ns sms.domain.message.impl
  (:require [sms.domain.message.service :refer [MessageService]]))

(defrecord MessageServiceImpl []
  MessageService
  (send! [_ message]))
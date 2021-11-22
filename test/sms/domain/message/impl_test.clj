(ns sms.domain.message.impl-test
  (:require [clojure.test :as t]
            [sms.domain.message.impl :refer
             [map->MessageServiceImpl]]
            [sms.domain.message.sender :refer [Sender]]
            [sms.domain.message.service :as service])
  (:import [java.util UUID])
  )

(t/deftest send!-test
  (t/testing "should successfully send a message"
    (let [id (UUID/randomUUID)
          expected-message {:id id
                            :receiver "+420700000000"
                            :text "Hej Clojure!"}
          conf {:sender
                (reify Sender
                  (send! [_ message]
                    (t/is (= expected-message message))))}
          request (select-keys expected-message [:receiver :text])
          result (service/send! (map->MessageServiceImpl conf)
                                request)]
      (t/is (= expected-message result))))
           
         )
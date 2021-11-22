(ns sms.handler.api-test
  (:require [clojure.test :refer :all]
            [integrant.core :as ig]
            [ring.mock.request :as mock]
            [sms.handler.api :as api]))

(deftest smoke-test
  (testing "api page exists"
    (let [handler  (ig/init-key :sms.handler/api {})
          response (handler (mock/request :get "/messages"))]
      (is (= 200 (:status response)) "response ok"))))

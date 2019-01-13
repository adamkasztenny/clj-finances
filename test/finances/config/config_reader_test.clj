(ns finances.config.config_reader_test
  (:require [clojure.test :refer :all])
  (:require [finances.config.config_reader :as config_reader])
  (:gen-class))

(deftest read-config
  (def config {:a "b"
               :c ["d" "e"]
              })
  (is (= config (config_reader/read-config "test/resources/test.edn")))
)

(ns finances.records.record_aggregator_test
  (:require [clojure.test :refer :all])
  (:require [finances.records.record_aggregator :as record_aggregator])
  (:require [finances.records.record_test_data :refer :all])
  (:gen-class))

(deftest aggregate-one
  (def aggregation (record_aggregator/aggregate-records grouped-records))
  (is (= (first aggregation) {:food {:total 25.16 :records (grouped-records :food)}}))
)

(deftest aggregate-multiple
  (def aggregation (record_aggregator/aggregate-records grouped-records))
  (is (= (last aggregation) {:insurance {:total 62.84 :records (grouped-records :insurance)}}))
)


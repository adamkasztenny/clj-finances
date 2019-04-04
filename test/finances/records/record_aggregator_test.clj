(ns finances.records.record_aggregator_test
  (:require [clojure.test :refer :all])
  (:require [finances.records.record_aggregator :as record_aggregator])
  (:require [finances.records.record_test_data :refer :all])
  (:gen-class))

(deftest aggregate-one
  (def aggregation (record_aggregator/aggregate-records grouped-records))
  (is (= (aggregation :food) (aggregated-records :food))))

(deftest aggregate-one-with-gain
  (def aggregation (record_aggregator/aggregate-records grouped-records))
  (is (= (aggregation :pay) (aggregated-records :pay))))

(deftest aggregate-multiple
  (def aggregation (record_aggregator/aggregate-records grouped-records))
  (is (= (aggregation :insurance) (aggregated-records :insurance))))


(ns finances.records.record_aggregator_test
  (:require [clojure.test :refer :all])
  (:require [finances.records.record_aggregator :as record_aggregator])
  (:require [finances.records.record_test_data :refer :all])
  (:gen-class))

(deftest aggregate-one
  (def aggregation (record_aggregator/aggregate-records [{:food (grouped-records :food)}]))
  (is (= (first aggregation) (first aggregated-records))))

(deftest aggregate-one-with-gain
  (def aggregation (record_aggregator/aggregate-records [{:pay (grouped-records :pay)}]))
  (is (= (last aggregation) (last aggregated-records))))

(deftest aggregate-multiple
  (def aggregation (record_aggregator/aggregate-records [{:insurance (grouped-records :insurance)}]))
  (is (= (last aggregation) (nth aggregated-records 1))))


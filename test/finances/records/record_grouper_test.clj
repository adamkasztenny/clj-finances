(ns finances.records.record_grouper_test
  (:require [clojure.test :refer :all])
  (:require [finances.records.record_grouper :as record_grouper])
  (:require [finances.records.record_test_data :refer :all])
  (:gen-class))

(deftest group-one-based-on-configuration
  (def grouping (record_grouper/group-records records configuration))
  (is (= (grouping :food) (grouped-records :food))))

(deftest group-multiple-based-on-configuration
  (def grouping (record_grouper/group-records records configuration))
  (is (= (grouping :insurance) (grouped-records :insurance))))

(deftest group-uncategorized-records
  (def grouping (record_grouper/group-records records configuration))
  (is (= (grouping :uncategorized) (grouped-records :uncategorized))))

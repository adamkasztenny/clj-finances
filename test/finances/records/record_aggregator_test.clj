(ns finances.records.record_aggregator_test
  (:require [clojure.test :refer :all])
  (:require [finances.records.record_aggregator :as record_aggregator])
  (:gen-class))

(def records [{:date "2019/01/01",
                    :description "PHO"
                    :out 25.16
                    :in 0
                    :account_total 103.54}

                    {:date "2019/01/31",
                    :description "INSURANCE"
                    :out 31.42 
                    :in 0
                    :account_total 72.12}

                    {:date "2019/02/31",
                    :description "INSURANCE"
                    :out 31.42 
                    :in 0
                    :account_total 40.70}])

(def grouped-records {:food (subvec records 0 1)
                      :insurance (subvec records 1 3)})

(deftest aggregate-one
  (def aggregation (record_aggregator/aggregate-records grouped-records))
  (is (= (first aggregation) {:food {:total 25.16 :records (grouped-records :food)}}))
)

(deftest aggregate-multiple
  (def aggregation (record_aggregator/aggregate-records grouped-records))
  (is (= (last aggregation) {:insurance {:total 62.84 :records (grouped-records :insurance)}}))
)


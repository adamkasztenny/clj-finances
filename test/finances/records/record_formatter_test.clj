(ns finances.records.record_formatter_test
  (:require [clojure.test :refer :all])
  (:require [finances.records.record_formatter :as record_formatter])
  (:require [finances.records.record_test_data :refer :all])
  (:require [clojure.string :as string])
  (:gen-class))

(deftest format-aggregates-includes-headers
  (def formatting (record_formatter/format-records aggregated-records))
  (is (= true (string/includes? formatting "Food")))
  (is (= true (string/includes? formatting "Insurance")))
  (is (= true (string/includes? formatting "======================")))
)

(deftest format-aggregates-includes-totals
  (def formatting (record_formatter/format-records aggregated-records))
  (is (= true (string/includes? formatting (str ((first aggregated-records) :total)))))
  (is (= true (string/includes? formatting (str ((last aggregated-records) :total)))))
)

(deftest format-aggregates-includes-records
  (def formatting (record_formatter/format-records aggregated-records))
  (is (= true (string/includes? formatting (str ((first aggregated-records) :records)))))
  (is (= true (string/includes? formatting (str ((last aggregated-records) :records)))))
)

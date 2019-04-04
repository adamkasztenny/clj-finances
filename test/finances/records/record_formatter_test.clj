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
  (is (= true (string/includes? formatting "Pay")))
  (is (= true (string/includes? formatting "======================"))))

(deftest format-aggregates-includes-total-outs
  (def formatting (record_formatter/format-records aggregated-records))
  (is (= true (string/includes? formatting (str ((aggregated-records :food) :total-out)))))
  (is (= true (string/includes? formatting (str ((aggregated-records :insurance) :total-out)))))
  (is (= true (string/includes? formatting (str ((aggregated-records :pay) :total-out))))))

(deftest format-aggregates-includes-total-ins
  (def formatting (record_formatter/format-records aggregated-records))
  (is (= true (string/includes? formatting (str ((aggregated-records :food) :total-in)))))
  (is (= true (string/includes? formatting (str ((aggregated-records :insurance) :total-in)))))
  (is (= true (string/includes? formatting (str ((aggregated-records :pay) :total-in))))))

(deftest format-aggregates-includes-records
  (def formatting (record_formatter/format-records aggregated-records))
  (is (= true (string/includes? formatting (string/join "\n" ((aggregated-records :food) :records)))))
  (is (= true (string/includes? formatting (string/join "\n" ((aggregated-records :insurance) :records)))))
  (is (= true (string/includes? formatting (string/join "\n" ((aggregated-records :pay) :records))))))

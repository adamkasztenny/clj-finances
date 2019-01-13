(ns finances.csv.csv_reader_test
  (:require [clojure.test :refer :all])
  (:require [finances.csv.csv_reader :as csv_reader])
  (:gen-class))

(deftest empty-csv
  (is (= [] (csv_reader/read-csv "test/resources/empty.csv")))
)

(deftest nonempty-csv
  (is (= [["a" "b" "c" "d"]
          ["e" "f" "g" "h"]] 
         (csv_reader/read-csv "test/resources/test.csv")))
)

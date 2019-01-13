(ns finances.csv.csv_adapter_test
  (:require [clojure.test :refer :all])
  (:require [finances.csv.csv_adapter :as csv_adapter])
  (:gen-class))

(deftest csv-to-maps
  (def csv [["2019/01/01" "PHO" "25.16" "" "103.54"]
            ["2019/01/31" "INSURANCE" "31.42" "" "72.12"]])

  (def converted-maps [{:date "2019/01/01",
                      :description "PHO"
                      :out "25.16"
                      :in ""
                      :account_total "103.54"}

  					  {:date "2019/01/31",
                      :description "INSURANCE"
                      :out "31.42" 
                      :in ""
                      :account_total "72.12"}])

  (is (= converted-maps (csv_adapter/adapt csv)))
)

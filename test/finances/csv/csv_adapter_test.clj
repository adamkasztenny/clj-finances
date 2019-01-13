(ns finances.csv.csv_adapter_test
  (:require [clojure.test :refer :all])
  (:require [finances.csv.csv_adapter :as csv_adapter])
  (:gen-class))

(deftest csv-to-map
  (def csv ["2019/01/01" "PHO" "25.16" "" "103.54" ])
  (def converted-map {:date "2019/01/01",
                      :description "PHO"
                      :out "25.16"
                      :in ""
                      :account_total "103.54"})
  (is (= converted-map (csv_adapter/adapt csv)))
)

(ns finances.records.record_grouper_test
  (:require [clojure.test :refer :all])
  (:require [finances.records.record_grouper :as record_grouper])
  (:gen-class))

(def records [{:date "2019/01/01",
                    :description "PHO"
                    :out "25.16"
                    :in ""
                    :account_total "103.54"}

                    {:date "2019/01/31",
                    :description "INSURANCE"
                    :out "31.42" 
                    :in ""
                    :account_total "72.12"}

                    {:date "2019/02/31",
                    :description "INSURANCE"
                    :out "31.42" 
                    :in ""
                    :account_total "40.70"}])

(def configuration {:food ["PHO" "BANH MI"]
                    :insurance ["INSURANCE"]})

(deftest group-one-based-on-configuration
  (def grouping (record_grouper/group-records records configuration))
  (is ( = (first grouping) {:food [(nth records 0)]}))
)

(deftest group-multiple-based-on-configuration
  (def grouping (record_grouper/group-records records configuration))
  (is ( = (last grouping) {:insurance (subvec records 1 3)}))
)

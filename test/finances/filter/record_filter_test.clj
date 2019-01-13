(ns finances.filter.record_filter_test
  (:require [clojure.test :refer :all])
  (:require [finances.filter.record_filter :as record_filter])
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

(deftest filter-one-based-on-configuration
  (def filterResult (record_filter/filter-records records configuration))
  (is ( = (first filterResult) {:food [(nth records 0)]}))
)

(deftest filter-multiple-based-on-configuration
  (def filterResult (record_filter/filter-records records configuration))
  (is ( = (last filterResult) {:insurance (subvec records 1 3)}))
)

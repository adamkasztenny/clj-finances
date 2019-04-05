(ns finances.api_test
  (:require [clojure.test :refer :all])
  (:require [finances.api :as api])
  (:require [finances.csv.csv_reader :as csv_reader])
  (:require [finances.csv.csv_adapter :as csv_adapter])
  (:require [finances.config.config_reader :as config_reader])
  (:require [finances.records.record_grouper :as record_grouper])
  (:require [finances.records.record_aggregator :as record_aggregator])
  (:require [finances.records.record_formatter :as record_formatter])
  (:require [finances.records.record_test_data :refer :all])
  (:gen-class))

(deftest returns-formatted-finances-aggregation
  (def formatted-records "Formatted Records Mock")

  (with-redefs [csv_reader/read-csv (fn [file] ["some" "csv" "values"])
                csv_adapter/adapt (fn [csv] records)

                config_reader/read-config (fn [config] configuration)

                record_grouper/group-records (fn [records configuration] grouped-records)
                record_aggregator/aggregate-records (fn [records] aggregated-records)
                record_formatter/format-records (fn [records] formatted-records)]

    (is (= (api/formatted-finances-aggregation "some-csv-file.csv" "some-config-file.csv") formatted-records))))

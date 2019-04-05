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
  (def csv-file-name "some-csv-file.csv")
  (def csv-values [["some" "csv" "values"]])

  (def configuration-file-name "some-config-file.edn")

  (def formatted-records "Formatted Records Mock")

  (with-redefs [csv_reader/read-csv (fn [file-name]
                                      (is (= file-name csv-file-name))
                                      csv-values)
                csv_adapter/adapt (fn [csv]
                                    (is (= csv csv-values))
                                    records)

                config_reader/read-config (fn [file-name]
                                            (is (= file-name configuration-file-name))
                                            configuration)

                record_grouper/group-records (fn [raw-records config]
                                               (is (= raw-records records))
                                               (is (= config configuration))
                                               grouped-records)
                record_aggregator/aggregate-records (fn [records]
                                                      (is (= records grouped-records))
                                                      aggregated-records)
                record_formatter/format-records (fn [records]
                                                  (is (= records aggregated-records))
                                                  formatted-records)]

    (is (= (api/formatted-finances-aggregation csv-file-name configuration-file-name) formatted-records))))

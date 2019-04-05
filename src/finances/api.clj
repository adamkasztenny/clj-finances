(ns finances.api
  (:require [finances.csv.csv_reader :as csv_reader])
  (:require [finances.csv.csv_adapter :as csv_adapter])
  (:require [finances.config.config_reader :as config_reader])
  (:require [finances.records.record_grouper :as record_grouper])
  (:require [finances.records.record_aggregator :as record_aggregator])
  (:require [finances.records.record_formatter :as record_formatter])
  (:gen-class))

(defn formatted-finances-aggregation [csv-file-name configuration-file-name]
  (def csv (csv_reader/read-csv csv-file-name))
  (def configuration (config_reader/read-config configuration-file-name))

  (def records (csv_adapter/adapt csv))
  (def grouped-records (record_grouper/group-records records configuration))
  (def aggregated-records (record_aggregator/aggregate-records grouped-records))
  (record_formatter/format-records aggregated-records))

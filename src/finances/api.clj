(ns finances.api
  (:require [finances.csv.csv_reader :as csv_reader])
  (:require [finances.csv.csv_adapter :as csv_adapter])
  (:require [finances.config.config_reader :as config_reader])
  (:require [finances.records.record_grouper :as record_grouper])
  (:require [finances.records.record_aggregator :as record_aggregator])
  (:require [finances.records.record_formatter :as record_formatter])
  (:gen-class))

(defn formatted-finances-aggregation [csv_file_name configuration_file_name] "")

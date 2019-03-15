(ns finances.core
  (:require [finances.csv.csv_reader :as csv_reader])
  (:require [finances.csv.csv_adapter :as csv_adapter])
  (:require [finances.config.config_reader :as config_reader])
  (:require [finances.records.record_grouper :as record_grouper])
  (:require [finances.records.record_aggregator :as record_aggregator])
  (:require [finances.records.record_formatter :as record_formatter])
  (:gen-class))

(defn- usage []
  (println "USAGE: finances [CSV input file] [EDN configuration input file]"))

(defn- run-finances [args]
  (def csv-file (first args))
  (def configuration-file (last args))

  (def csv (csv_reader/read-csv csv-file))
  (def configuration (config_reader/read-config configuration-file))

  (def records (csv_adapter/adapt csv))
  (def grouped-records (record_grouper/group-records records configuration))
  (def aggregated-records (record_aggregator/aggregate-records grouped-records))
  (record_formatter/format-records aggregated-records))

(defn -main [& args]
  (when (< (count args) 2)
    (usage)
    (System/exit 1))

  (println (run-finances args)))

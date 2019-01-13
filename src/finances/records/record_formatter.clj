(ns finances.records.record_formatter
  (:require [clojure.string :as string])
  (:gen-class))

(defn format-records [aggregated-records]
  (defn format-aggregation [[grouping aggregation]] (string/join "\n" 
    [
      (string/capitalize (subs (str grouping) 1))
      "======================\n"
      "Total:" (aggregation :total)
      "\nRecords: " (aggregation :records)
    ]))

  (string/join "\n" (map format-aggregation aggregated-records))
)

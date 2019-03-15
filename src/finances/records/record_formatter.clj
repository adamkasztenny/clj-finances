(ns finances.records.record_formatter
  (:require [clojure.string :as string])
  (:gen-class))

(defn format-records [aggregated-records]
  (defn format-aggregation [[grouping aggregation]] (string/join "\n"
                                                                 [(string/capitalize (subs (str grouping) 1))
                                                                  "======================\n"
                                                                  "Total Out:" (aggregation :total-out)
                                                                  "Total In:" (aggregation :total-in)
                                                                  "\nRecords: " (string/join "\n" (aggregation :records))
                                                                  "\n"]))

  (defn format-record [record] (string/join "\n" (map format-aggregation record)))

  (string/join "" (map format-record aggregated-records)))

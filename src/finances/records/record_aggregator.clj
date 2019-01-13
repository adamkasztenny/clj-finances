(ns finances.records.record_aggregator
  (:gen-class))

(defn aggregate-records [grouped-records]
  (defn total-cost [records] (reduce + (map (fn [record] (record :out)) records)))

  (map (fn [[group records]] {group {:total (total-cost records) :records records}}) grouped-records) 
)

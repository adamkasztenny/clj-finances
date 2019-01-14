(ns finances.records.record_aggregator
  (:gen-class))

(defn aggregate-records [grouped-records]
  (defn total-cost [records] (reduce + (map (fn [record] (record :out)) records)))

  (defn aggregate-record [record]
    (map (fn [[group records]] {group {:total (total-cost records) :records records}}) record))

  (mapcat aggregate-record grouped-records)
)

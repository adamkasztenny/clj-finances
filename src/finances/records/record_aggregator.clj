(ns finances.records.record_aggregator
  (:gen-class))

(defn aggregate-records [grouped-records]
  (defn total-cost [records] (reduce + (map (fn [record] (record :out)) records)))
  (defn total-gain [records] (reduce + (map (fn [record] (record :in)) records)))

  (defn aggregate-record [[group records]]
    {group {:total-out (total-cost records)
            :total-in (total-gain records)
            :records records}})

  (into {} (map aggregate-record grouped-records)))

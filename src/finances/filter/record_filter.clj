(ns finances.filter.record_filter
  (:gen-class))

;; contains? was clausing me problems...
;; thanks to https://stackoverflow.com/questions/3249334/test-whether-a-list-contains-a-specific-value-in-clojure
;; for clearing this up
(defn- in? [coll x] (if (some #{x} coll) true false))

(defn filter-records [records configuration]
  (defn records-for-descriptions [descriptions]
    (filter (fn [record] (in? descriptions (record :description))) records)
  ) 

  (map (fn [[group descriptions]] {group (records-for-descriptions descriptions)})
       configuration) 
)

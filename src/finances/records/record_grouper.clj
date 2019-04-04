(ns finances.records.record_grouper
  (:require [clojure.string :as string])
  (:require [clojure.set :as set])
  (:gen-class))

(defn- in? [descriptions description] (not (empty? (filter (fn [d] (string/includes? description d)) descriptions))))

(defn group-records [records configuration]
  (defn records-for-descriptions [descriptions]
    (filter (fn [record] (in? descriptions (record :description))) records))

  (def grouped-records (map (fn [[group descriptions]] {group (records-for-descriptions descriptions)})
                            configuration))

  (def records-with-a-group (flatten (map vals grouped-records)))
  (def ungrouped-records (into () (set/difference (set records) (set records-with-a-group))))
  (def uncategorized-records {:uncategorized ungrouped-records})

  (into {} (concat grouped-records [uncategorized-records])))

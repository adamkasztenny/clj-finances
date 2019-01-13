(ns finances.records.record_grouper
  (:require [clojure.string :as string])
  (:gen-class))

;;(defn- in? [coll x] (string/includes? x (string/join " " coll)))

(defn- in? [descriptions description] (not (empty? (filter (fn [d] (string/includes? description d)) descriptions))))

(defn group-records [records configuration]
  (defn records-for-descriptions [descriptions]
    (filter (fn [record] (in? descriptions (record :description))) records)
  ) 

  (map (fn [[group descriptions]] {group (records-for-descriptions descriptions)})
       configuration) 
)

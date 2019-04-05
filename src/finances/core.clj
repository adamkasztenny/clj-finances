(ns finances.core
  (:require [finances.api :as api])
  (:gen-class))

(defn- usage []
  (println "USAGE: finances [CSV input file] [EDN configuration input file]"))

(defn- run-finances [args]
  (def csv-file-name (first args))
  (def configuration-file-name (last args))

  (api/formatted-finances-aggregation csv-file-name configuration-file-name))

(defn -main [& args]
  (when (< (count args) 2)
    (usage)
    (System/exit 1))

  (println (run-finances args)))

(ns finances.config.config_reader
  (:require [clojure.edn :as edn])
  (:gen-class))

(defn read-config [filename]
  (edn/read-string (slurp filename))
)

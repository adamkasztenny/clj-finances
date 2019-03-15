(ns finances.csv.csv_reader
  (:require [clojure.data.csv :as csv])
  (:require [clojure.java.io :as io])
  (:gen-class))

(defn read-csv [filename]
  (with-open [opened-file (io/reader filename)]
    (doall
     (csv/read-csv opened-file))))

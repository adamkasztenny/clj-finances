(ns finances.csv.csv_adapter
  (:gen-class))

(def ^:private columns
  {:date 0
   :description 1
   :out 2
   :in 3
   :account_total 4})

(defn- string-to-number [string] (if (not (empty? string)) (read-string string) 0))

(defn- adapt-row [csv-row]
  {:date (nth csv-row (get columns :date))
   :description (nth csv-row (get columns :description))
   :out (string-to-number (nth csv-row (get columns :out)))
   :in (string-to-number (nth csv-row (get columns :in)))
   :account_total (string-to-number (nth csv-row (get columns :account_total)))})

(defn adapt [csv]
  (map adapt-row csv))

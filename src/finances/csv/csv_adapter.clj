(ns finances.csv.csv_adapter 
  (:gen-class))

(def columns 
	{:date 0
	 :description 1
	 :out 2
	 :in 3
	 :account_total 4
	}
)

(defn adapt [csv-row]
	{:date (nth csv-row (get columns :date))
	 :description (nth csv-row (get columns :description))
	 :out (nth csv-row (get columns :out))
	 :in (nth csv-row (get columns :in))
	 :account_total (nth csv-row (get columns :account_total))
	}
)

(ns finances.records.record_test_data
  (:gen-class))

(def records [
                    {:date "2019/01/01",
                    :description "PHO"
                    :out 25.16
                    :in 0
                    :account_total 103.54}

                    {:date "2019/01/31",
                    :description "INSURANCE"
                    :out 31.42 
                    :in 0
                    :account_total 72.12}

                    {:date "2019/02/31",
                    :description "INSURANCE"
                    :out 31.42 
                    :in 0
                    :account_total 40.70}])

(def configuration {:food ["PHO" "BANH MI"]
                    :insurance ["INSURANCE"]})

(def grouped-records {:food (subvec records 0 1)
                      :insurance (subvec records 1 3)})

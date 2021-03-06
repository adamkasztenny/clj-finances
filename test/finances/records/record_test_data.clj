(ns finances.records.record_test_data
  (:gen-class))

(def records [{:date "2019/01/01",
               :description "PHO 42"
               :out 25.16
               :in 0
               :account_total 103.54}

              {:date "2019/01/31",
               :description "INSURANCE COMPANY #1"
               :out 31.42
               :in 0
               :account_total 72.12}

              {:date "2019/02/31",
               :description "INSURANCE COMPANY #2"
               :out 31.42
               :in 0
               :account_total 40.70}

              {:date "2019/03/15",
               :description "CLOJURE BOOK"
               :out 16.31
               :in 0
               :account_total 24.39}

              {:date "2019/04/01"
               :description "PAY"
               :out 0
               :in 103.14}])

(def configuration {:food ["PHO" "BANH MI"]
                    :insurance ["INSURANCE"]
                    :pay ["PAY"]})

(def grouped-records {:food (subvec records 0 1)
                      :insurance (subvec records 1 3)
                      :pay (subvec records 4 5)
                      :uncategorized (subvec records 3 4)})

(def aggregated-records {:food {:total-out 25.16 :total-in 0 :records (grouped-records :food)}
                         :insurance {:total-out 62.84 :total-in 0 :records (grouped-records :insurance)}
                         :pay {:total-out 0 :total-in 103.14 :records (grouped-records :pay)}
                         :uncategorized {:total-out 16.31 :total-in 0 :records (grouped-records :uncategorized)}})

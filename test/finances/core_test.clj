(ns finances.core_test
  (:require [clojure.test :refer :all])
  (:require [finances.api :as api])
  (:require [finances.core :as core])
  (:require [clojure.string :as string])
  (:gen-class))

(deftest runs-finances-and-prints-result
  (def csv-file-name "some-csv-file.csv")
  (def config-file-name "some-config-file.edn")

  (def finances-result "some result")

  (with-redefs [api/formatted-finances-aggregation (fn [csv config]
                                                     (is (= csv csv-file-name))
                                                     (is (= config config-file-name))
                                                     finances-result)

                println (fn [result] (is (= result finances-result)))]
    (core/-main csv-file-name config-file-name)))

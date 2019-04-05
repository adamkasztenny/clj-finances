(defproject clj-finances "0.1.0"
  :description "Takes in a CSV file and groups expenses together"
  :license {:name "GNU GPL v2"
            :url "https://www.gnu.org/licenses/gpl-2.0.txt"}
  :dependencies [
                 [org.clojure/clojure "1.10.0"]
                 [org.clojure/data.csv "0.1.4"]]
  :plugins [[lein-cljfmt "0.6.4"] [lein-cloverage "1.1.1"]]
  :main finances.core
)


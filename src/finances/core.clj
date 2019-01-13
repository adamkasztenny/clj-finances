(ns finances.core
  (:gen-class))

(defn- usage []
  (println "USAGE: finances [CSV input] [EDN configuration]") 
)

(defn -main [& args]
  (when (< (count args) 2)
    (usage)
    (System/exit 1))
)

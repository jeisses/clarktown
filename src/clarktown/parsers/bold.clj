(ns clarktown.parsers.bold
  (:require
    [clojure.string :as string]))


(defn render
  "Renders all occuring bold text as bold."
  [block]
  (loop [block block
         matches (-> (re-seq #"\*\*.*?\*\*" block)
                     distinct)]
    (if (empty? matches)
      block
      (let [match (first matches)
            value (subs match 2 (- (count match) 2))
            replacement (str "<strong>" value "</strong>")]
        (recur (string/replace block match replacement)
               (drop 1 matches))))))

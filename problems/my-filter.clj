;;Write your own version of filter.
(def numbers [1 -2 7 3 -4])

(defn my-filter
  [f coll]
  (when (first coll)
    (if (f (first coll))
      (cons (first coll)
            (my-filter f (rest coll)))
      (my-filter f (rest coll)))))

(my-filter pos? numbers)

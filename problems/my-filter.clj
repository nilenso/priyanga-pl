;;Write your own version of filter.

;Returns sequence of item in the collection for which (f item) returns true
;if collection is empty it returns empty list
(defn my-filter
  [f coll]
  (if (first coll)
    (if (f (first coll))
      (cons (first coll)
            (my-filter f (rest coll)))
      (my-filter f (rest coll)))
    (list)))

;Test Cases
(my-filter pos? [1 -2 7 3 -4])
(my-filter pos? [1 -2 7 3 -4])
(my-filter pos? [])

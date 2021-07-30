;;contol flow
(if-not (vector? (list 1 2 3))
  :a
  :b)

(if true
  (do
    (println "one")
    (println "two"))
  nil)

(when true
  (prn :hi)
  (prn :there))

(when-not (number? "a string")
  :here)

(when-let [pos-nums (filter pos? [-1 -2 1 2])]
  (prn pos-nums)
  (println "one")
  (println "two"))

(defn case-test
  [num]
  (case num
    1 "n is 1"
    2 "n is 2"
    "n is other"))

(defn positive-numbers
  "Returns a list of pos-nums in the arg vector else 'no positive number' "
  [numbers]
  (if-let [pos-nums (not-empty (filter pos? numbers))] ;() is not falsey in clojure
    pos-nums
    "no positive number"))

(defn cond-test
  [n]
  (cond
    (= n 1) "n is 1"
    (and (> n 3) (< n 10)) "n is over 3 and under 10"
    :else "n is other"))

(defn condp-test
  [n]
  (condp contains? n
    #{0 1 2 3} "n is either 0 or 1 or 2 or 3"
    #{4 5 6} "n is either 4 or 5 or 6"
    "n > 6"))

;test case
(positive-numbers [-1 -3 4 -5])

(case-test 1)
(case-test 2)
(case-test 3)

(cond-test 1)
(cond-test 2)
(cond-test 4)

(condp-test 3)
(condp-test 5)
(condp-test 9)

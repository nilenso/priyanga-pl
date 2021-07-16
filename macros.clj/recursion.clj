;;Returns nth fibonacci series
(defn fibo-recursive [n]
  (if (or (= n 0) (= n 1))
    n
    (+ (fibo-recursive (- n 1)) (fibo-recursive (- n 2)))))

;test cases
(fibo-recursive 0)
(fibo-recursive 1)
(fibo-recursive 8)


;;Returns nth fibonacci series using recur
(defn fibo-recur [iteration]
  (let [fibo (fn [one two n]
               (if (= iteration n)
                 one
                 (recur two (+ one two) (inc n))))]
    (fibo 0N 1N 0)))

;test case
(fibo-recur 8)


;;Returns nth fibonacci series using recur and loop
(defn fibo-recur-loop [iteration]
  (loop [fibo (fn [one two n]
               (if (= iteration n)
                 one
                 (recur two (+ one two) (inc n))))]
    (fibo 0N 1N 0)))

;test case
(fibo-recur-loop 8)

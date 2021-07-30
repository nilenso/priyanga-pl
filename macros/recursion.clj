(defn fibo-recursive 
  "Returns nth fibonacci series"
  [n]
  (if (or (= n 0) (= n 1))
    n
    (+ (fibo-recursive (- n 1)) (fibo-recursive (- n 2)))))

(defn fibo-recur 
  "Returns nth fibonacci series using recur"
  [iteration]
  (let [fibo (fn [one two n]
               (if (= iteration n)
                 one
                 (recur two (+ one two) (inc n))))]
    (fibo 0N 1N 0)))

(defn fibo-recur-loop 
  "Returns nth fibonacci series using recur and loop"
  [iteration]
  (loop [fibo (fn [one two n]
               (if (= iteration n)
                 one
                 (recur two (+ one two) (inc n))))]
    (fibo 0N 1N 0)))


;test case
(fibo-recur 8)

(fibo-recursive 0)
(fibo-recursive 1)
(fibo-recursive 8)

(fibo-recur-loop 8)

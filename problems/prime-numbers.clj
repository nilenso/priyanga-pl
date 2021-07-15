;;Find the first 100 prime numbers
(def n 1001)

(defn prime?
  [num]
  (nil? (first (filter
                #(zero? (rem num %))
                (range 2
                       (inc (long (Math/sqrt num))))))))
(defn prime-numbers
  [n]
  (filter prime? (range 2 n)))

(prime-numbers n)
;;Find the first 100 prime numbers

;Defines a constant for saving the count of prime numbers
(def counter 100)

;Returns true if a number is prime else false
(defn prime?
  [num]
  (empty? (->> num
               Math/sqrt
               long
               inc
               (range 2)
               (filter
                #(zero? (rem num %))))))

;Returns a list of prime numbers having length equal to counter
(defn prime-numbers [counter]
  (take counter (filter prime? (iterate inc 0))))

;Test case
(prime-numbers counter)




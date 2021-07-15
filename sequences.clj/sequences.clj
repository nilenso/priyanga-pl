(ns user
  (:require [clojure.repl]))
;; direct approach for incrementing each element in a vector
(def numbers [1 2 3])
(inc (nth numbers 0))
(inc (nth numbers 1))
(inc (nth numbers 2))

;;recursion
(cons 1 [2])

(defn inc-first
  [numbers]
  (cons (inc (first numbers))
        (rest numbers)))
(inc-first numbers)
(inc-first [5])
;(inc-first [])
;(inc nil)

(defn increment-first
  [numbers]
  (if (first numbers)
    (cons (inc (first numbers))
          (rest numbers))
    (list)))
(increment-first [])
(increment-first [1 2 3])

(defn inc-more
  [numbers]
  (if (first numbers)
    (cons (inc (first numbers))
          (inc-more (rest numbers)))
    (list)))
(inc-more [])
(inc-more [1 2 3])
(inc-more [1 2 3 4 5 6 7 8 9 10 11 12])

(defn transform-all
  [f coll]
  (if (first coll)
    (cons (f (first coll))
          (transform-all f (rest coll)))
    (list)))

(transform-all inc [])
(transform-all inc [1 2 3 4])
(transform-all str [])
(transform-all str [1 2 3 4])
(transform-all keyword [])
(transform-all keyword ["jack" "jill"])
(transform-all list ["jack" "jill"])


;map
(map inc [])
(map inc [1 2 3 4])
(map keyword ["jack" "jill"])
(map str [1 2 3 4])
(map list [1 2 3 4])
(map (fn [n vehicle] (str "I've got " n " " vehicle "s"))
     [0 200 9]
     ["car" "train" "kiteboard"])
(map + [1 2 3]
     [4 5 6]
     [7 8 9])
(map (fn [index element] (str index ". " element))
     (iterate inc 0)
     ["erlang" "ruby" "haskell"])
(map-indexed (fn [i element] (str i ". " element))
             ["erlang" "ruby" "haskell"])


;pos? - returns true if num is greater than zero, else false
(pos? 3)
(pos? 0)

(when (pos? 4) (prn 4))
(when (pos? 0) (prn "this part not executed"))


(defn expand
  [f start count]
  (when (pos? count)
    (cons start (expand f (f start) (dec count)))))
(expand inc 0 10)

(take 10 (iterate inc 0))
(take 10 (iterate (fn [x] (if (odd? x) (inc x) (/ x 2))) 1))
(take 5 (iterate (fn [x] (str x "o")) "y"))

(take 3 (repeat :hi))
(repeat 3 :hi)

(rand)
(take 3 (repeatedly rand))
(take 3 (repeatedly rand))

(range 5)
(range 2 5)
(range 2 100 10)
(take 10 (cycle [1 2 3]))

;;transforming sequences
(concat [1 2 3] [:a :b :c] [4 5 6])
(interleave [:a :b :c] [1 2 3])
(interpose :and [1 2 3 4])
(reverse [1 2 3])
(reverse "woolf")
(apply str (reverse "woolf"))
(seq (apply str (reverse "woolf")))
(shuffle (seq "woolf"))
(apply str (shuffle (seq "abracadabra")))

;;subsequences
(take 3 (range 10))
(drop 3 (range 10))

(take-last 3 (range 10))
(drop-last 3 (range 10))

(take-while pos? [3 2 1 0 -1 -2 10])
(drop-while pos? [3 2 1 0 -1 -2 10])

(split-at 4 (range 10))
(split-at 10 (range 10))
(split-with number? [1 2 3 :mark 4 5 6 :make 7])
(take-while number? [1 2 3 :mark 4 5 6 :make 7])
(drop-while number? [1 2 3 :mark 4 5 6 :make 7])

(filter number? [1 2 3 :mark 4 5 6 :make 7])
(remove number? [1 2 3 :mark 4 5 6 :make 7])

(partition 3 2  [:cats 5 :bats 27 :crocodiles 0])
(partition-all 3 [:cats 5 :bats 27 :crocodiles 0])
(partition 2 [:cats 5 :bats 27 :crocodiles 0])
(partition-by number? [:cats 5 :bats 27 :crocodiles 0])

;;collapsing sequences
(frequencies [:meow :mrrrow :meow :meow])

(prn (group-by :first [{:first "Li"    :last "Zhou"}
                       {:first "Sarah" :last "Lee"}
                       {:first "Sarah" :last "Dunn"}
                       {:first "Li"    :last "O'Toole"}]))
(prn (group-by :last [{:first "Li"    :last "Zhou"}
                      {:first "Sarah" :last "Lee"}
                      {:first "Sarah" :last "Dunn"}
                      {:first "Li"    :last "O'Toole"}]))
(reduce + [1 2 3 4])
(reductions + [1 2 3 4])
(reduce conj #{} [:a :b :b :b :a :a])
(into {} [[:a 2] [:b 3]])
(into (list) [1 2 3 4])
(reduce conj [] [1 2 3 4 5])

(defn my-map [f coll]
  (reduce (fn [output element]
            (conj output (f element)))
          []
          coll))
(my-map inc [1 2 3 4])

(defn my-take-while [f coll]
  (reduce (fn [out elem]
            (if (f elem)
              (conj out elem)
              (reduced out)))
          []
          coll))
(my-take-while pos? [2 1 0 -1 0 1 2])

(def infseq (map inc (iterate inc 0)))
(realized? infseq)
(take 10 infseq)
(realized? infseq)

;;putting it all together
(partition 2 1
           (filter odd?
                   (iterate inc 0)))
(map (fn [pair]
       (* (first pair) (second pair)))
     (partition 2 1
                (filter odd?
                        (iterate inc 0))))

(reduce +
        (take 10
        (map (fn [pair]
               (* (first pair) (second pair)))
             (partition 2 1
                        (filter odd?
                                (iterate inc 0))))))
(->> 0
     (iterate inc)
     (filter odd?)
     (partition 2 1)
     (map (fn [pair]
            (* (first pair) (second pair))))
     (take 10)
     (reduce +))
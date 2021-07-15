(ns user
  (:require [clojure.repl]))

;; let bindings
;; let - assign a value to a symbol
;; limited to the scope of let
;;overrides any existing definitions for symbols at that point in the program
(let [+ -] (+ 2 3))
(+ 2 3)

(let [name "priyanga" num-of-cats 2] (str name " has " num-of-cats " cats "))
(let [cats 3 legs (* 4 cats)] (str legs " legs all together"))


;;functions - verbs
(inc 1)
(let [x 1] 
  (+ x 1))
((fn [x]
   (+ x 1))
 1) ;; (fn [x] (+ x 1)) equivalent to #(+ % 1)
(#(+ % 1) 1)
(let [increment #(+ % 1)] 
  (increment 1))

(let [twice #(* 2 %)] 
  (+ (twice 1) (twice 3)))
;; equivalent to
(+ (* 2 1) (* 2 3))


;;var
(def color "red")
(str "My hat is " color)

'inc;synmbol=>var=>function
(resolve 'inc);points to var
(eval 'inc);points to function

(def numbers [])
(count numbers)
(def numbers [2 3]) ;re-defined var 
(conj numbers 4 5)
(conj numbers 5)
(conj numbers 4)
(conj (conj numbers 4) 5)


(prn numbers)
(count numbers)


;;named functions
(defn twice 
  ([number] 
   (* 2 number)) 
  ([] (* 2)))
(twice 3)
(twice)

(defn vargs 
  [x y & more-args] 
  {:x x :y y :more more-args})
(vargs 1 3)
(vargs 1 3 5 7 9)

(defn add 
  "Takes two args and return sum" 
  {:added "1.0"
   :static true}
  [x y] 
  (+ x y))
(add 1 2 )
(meta #'user/add)
(doc add)



;;types
(type type)
(fn? type)
(supers (type type))
(doc type)
(meta #'type)
(source type)
(source +)
(source def)
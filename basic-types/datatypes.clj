;;increment
(inc 0)
(inc (inc 0))

;;decrement
(dec 8)

nil

;;Comparison b/w == and =
(== 3 (+ '3 '2))
(= 3 (+ '3 '2))
(= 3.0 (+ '3 '2))
(== 3 (- 5 2))
(= 3 (- 5 2))
(== 3.0 (- 5 2))
(= 3.0 (- 5 2))

(= 2 2 2)
(= 8 8 9)

;; different types
(type 3)
(Long/MAX_VALUE)
(inc (bigint Long/MAX_VALUE))
(type 5N)
(Integer/MAX_VALUE)
(type (short 0))
(type (byte 0))
(type (bigint 0))
(type (long 0))
(type 1.23)
(type (float 1.23))
(type 1/3)

;;fractions
0.9
0.9999999999999999

;;expressions with multiple operands and single operator
(* 2 3 1/5) ;2*3 * 1/5
(- 2 3 1/5)  ;2-3  - 1/5
(/ 2 3 1/5)
(+ 2 3 1/5)

(+ 1 (- 5 2) (+ 3 4))

;;interpretations for numeric operations with just a single number 
;;( other number is implicitly taken as 1)
(+ 2)
(* 2)
(- 2)
(/ 2)

;; additive identity
(+)

;; multiplicative identity
(*)

;; <= and >=
(<= 1 2 3)
(< 1 2 3)
(<= 1 1 2 3)
(< 1 1 2 3)

(>= 8 7 0)
(> 8 7 7 0)

;;string convertion

(type 'cat)
(type (str 'cat))
(str 1)
(str true)
(str '(1 2 3))
(str nil)

;; string concatenation
(str "meow " 3 " times")

;;regex
;;re-find/re-matches for finding regex
;;re-find => finds substring
;;re-matches => find matches specified in regex 
(re-find #"cat" "concatenation, caterpiller")
(re-matches #".*(cat)(.*)" "concatenation, caterpiller")

(rest (re-matches #"(.+):(.+)" "string:concatenation"))
(rest (re-matches #"(.+):(.+)" "concat:"))
(rest (re-matches #"(.+):(.+)" "concat:"))

(re-matches #"hello" "hello, world")
(re-find #"hello" "hello, world")

(re-matches #"hello.*" "hello, world")
(re-matches #"hello(.*)" "hello, world")


;;booleans 
(boolean true)
(boolean nil);false
(boolean false)
(boolean 0) ; false
(boolean 1)
(boolean str)

;;logic
;and => returns first negative value or last value
;or => returns first positive value or last value
(and true false true)
(and "false" true  0 false nil)
(and "false" true 0 nil)

(or false "false")
(or false 0 "false")
(or false nil)

(not 0)
(not nil)

;;symbols - to point to other values, replaced by thier corresponding values during program evaluation
(type 'cat)
(class 'cat)
(= str clojure.core/str) ;fully qualified name of str => clojure.core/str

(name 'cat)
(= "cat" (name 'cat))

;;lists

'(1 2 3)
(type '(1 2 3))
(list 1 2 3)

(= (list 1 2) (list 1 2))
(= (list 1 2) (list 1 9))

(conj '(1 2 3) 4) ;Adds new value to the beginning of the list(linkedlist)
(conj '(1 2 3) "dfd") ;Adds new value to the beginning of the list( represented as linkedlist)

(first (list 1 2 3 4 5))
(second (list 1 2 3 4 5))
(nth (list 1 2 3 4 5) 2)
(nth (list 1 2 3 4 5) 0)

;;vectors
[1 2 3]
(vector 1 3 4)
(vec (list 2 "fdf" 8.0))
(conj [1 2 3] 4);Adds new value at the end (represented as trees with 32 branch each)

(rest [1 2 3])
(next [1 2 3])
(rest [1])
(next [1])
(last [1 2 3])
(count [1 2 "foo" 3])
([:a :b :c] 1)
([1 2 4 "dfdf"] 3)
(= '(1 2 3) [1 2 3])

;;sets
#{1 2 3}
(vec #{3 :f "fvf"})
(sort #{14 3 2 5})

(conj #{:d :b :c} :a :e)
(conj #{:a :b :c} :a)

(disj #{:a :b :c} :a)
(disj #{:b :c} :a)

(contains? #{:a :b :c} :a)
(contains? #{:b :c} :a)

(set [:a :b :c])
(set '(:a :b :c))

;;maps
{:name "priyanga" :cgpa 8.85 :color "brown"}
(get {:name "priyanga" :cgpa 8.85 :color "brown"} :name)
(get {:name "priyanga" :cgpa 8.85 :color "brown"} :weight)
({:name "priyanga" :cgpa 8.85 :color "brown"} :name)

(assoc {:bolts 1088} :camshafts 3)
(assoc  nil :bolts 1088 :camshafts 3)
(assoc {:camshafts 3} :camshafts 2)

(merge {:a 1 :b 2} {:c 3})

(dissoc {:camshafts 3} :camshafts 2)
(dissoc {} :camshafts 2)

;;putting all together

{:title "Tea"
 :ingredients {"Milk" [1/2 :cup]
                "Water" [1/2 :cup]
                "Sugar" [1 :teaspoon]}}

{:name "Priyanga"
 :fav-movies #{"Iron Man", "Captain America", "Thor 3"}}


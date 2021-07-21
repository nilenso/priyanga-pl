(ns user
  (:require [clojure.repl]))

;;macros
(defmacro rev [fun & args]
  (cons fun (reverse args)))

(rev + 2 3)

(macroexpand '(rev str "hi" (+ 1 2)))

(eval (macroexpand '(rev str "hi" (+ 1 2))))

;;Evaluates then when test evaluates to be falsey
(defmacro unless [test then]
  (list 'if (list 'not test)
        then))

(unless false (prn "falsey!!"))

(macroexpand '(unless false (println "hi")))

;;quotes
'(+ 2 3)
(quote (+ 2 3))
(let [x 2] (list 'clojure.core/inc x))

;;syntax-quotes
(let [x 2] `(inc x))

;;unquotes
(let [x 2] `(inc ~x))

;;unquote-splice
`(+ ~@(list 1 2 3))

;;comparison b/w quotes, syntax-quotes, unquotes
'(dec (inc 1))
`(dec (inc 1))

'(+ 1 ~(inc 1))
`(+ 1 ~(inc 1))

`(+ ~(list 1 2 3))
`(+ ~@(list 1 2 3))

;generate symbol
(gensym "hi")


;;threading macros
;-> thread-first macro
(conj (conj (conj [] 1) 2) 3)
(-> []
    (conj 1)
    (conj 2)
    (conj 3))

;thread-last macro
(->> ["Japan" "China" "Korea"]
     (map clojure.string/upper-case)
     (map #(str "Hello " % "!")))

;;list comprehension

(for [x (range 10)] (* x x))

(for [x [1 2 3] y [:a :b]] [x y])

(for [x     (range 5)
      y     (range 5)
      :when (and (even? x) (odd? y))]
  [x y])

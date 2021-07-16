;; Write a macro id which takes a function and a list of args: (id f a b c), 
;; and returns an expression which calls that function with the given args: (f a b c).

(defmacro id [fun & args]
  (cons fun args))

(macroexpand '(id * 2 3 7))
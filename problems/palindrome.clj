;;Write a function to find out if a string is a palindrome–that is, if it looks the same forwards and backwards.

;Retuns true if given string is palindrome else false
(defn palidrome?
  [word]
  (= word (apply str (reverse word))))

;test cases
(palidrome? "uhn");=>false
(palidrome? "xox");=>true

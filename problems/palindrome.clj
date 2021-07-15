;;Write a function to find out if a string is a palindrome–that is, if it looks the same forwards and backwards.

(defn palidrome?
  [s]
  (= s (apply str (reverse s))))
(palidrome? "uhn")
(palidrome? "xox")

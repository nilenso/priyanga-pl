;;Find the number of ’c’s in “abracadabra”.

;Returns the frequency of a given character in the given string
(defn num-of-char 
  [key word]
  ((frequencies word) key))

;test cases
(num-of-char \c "abracadabra") ;=>1
(num-of-char \a "abracadabra") ;=>5

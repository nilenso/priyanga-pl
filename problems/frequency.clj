;;Find the number of ’c’s in “abracadabra”.

(defn num-of-char 
  [key word]
  ((frequencies word) key))
(num-of-char \c "abracadabra")
;;Using the control flow constructs we’ve learned, 
;;write a schedule function which, given an hour of the day, returns what you’ll be doing at that time. 
;;(schedule 18), for me, returns :dinner.


;; Takes a set of test/exprs pairs. It evaluates each test one at a
;; time.  If a test returns logical true, cond evaluates and returns
;; the value of the corresponding expr and doesn't evaluate any of the
;; other tests or exprs 
(defn schedule
  [time]
  (cond
    (or (< time 6) (> time 21)) "sleep"
    (or (= time 6) (and (> time 6) (< time 7))) "morning routine"
    (or (= time 7) (and (> time 7) (< time 8))) "breakfast"
    (or (= time 8) (and (> time 8) (< time 13))) "study time"
    (or (= time 13) (and (> time 13) (< time 14))) "lunch"
    (or (= time 14) (and (> time 14) (< time 18))) "study time"
    (or (= time 18) (and (> time 18) (< time 19))) "dinner"
    (or (= time 19) (and (> time 19) (< time 21))) "fun time"
    :else "invalid time!"))

;; test case
(schedule 18)
(schedule 6)
(schedule 13)
(schedule 9)
(schedule 20)

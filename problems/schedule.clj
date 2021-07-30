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
    (or (= time 6) (< 6 time 7)) "morning routine"
    (or (= time 7) (< 7 time 8)) "breakfast"
    (or (= time 8) (< 8 time 13)) "study time"
    (or (= time 13) (< 13 time 14))"lunch"
    (or (= time 14) (< 14 time 18)) "study time"
    (or (= time 18) (< 18 time 19)) "dinner"
    (or (= time 19) (< 19 time 21)) "fun time"
    :else "invalid time!"))

(def schedule-1
  {{:start 21 :end 24} "sleep"
   {:start 0 :end 6} "sleep"
   {:start 6 :end 7} "morning routine"
   {:start 7 :end 8} "breakfast"
   {:start 8 :end 13} "study time"
   {:start 13 :end 14} "lunch"
   {:start 14 :end 18} "study time"
   {:start 18 :end 19} "dinner"
   {:start 19 :end 21} "fun time"})

(defn check-schedule?
  "Returns schedule if start <= time < end else false"
  [[{:keys [start end]} value] time]
  (if (or (= time start) (< start time end))
    value
    false))
  
(defn get-schedule
  "Returns the schedule at a given time"
  [time]
  (loop [kv schedule-1]
    (let [value (#(check-schedule? % time) (first kv))]
      (if value
        value
        (recur (rest kv))))))

;; test case
(schedule 18)
(schedule 6)
(schedule 13)
(schedule 9)
(schedule 20)

(get-schedule 2)
(get-schedule 7)

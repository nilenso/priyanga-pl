;; Build a binary search tree
;; The tree should support the following operations:
;; - Inserting an integer into the tree
;; - Finding if a given integer is present in the tree
;; - Deleting an integer from the tree
;; The code must have the following characteristics
;; - The tree must be immutable
;; - The tree must be thread safe (two threads can modify the tree simultaneously)
;; - All functions in the code must have a single exit point
;; - Pay attention to memory usage
;; Extra credit:
;; - The tree must be self balancing
;; - Use your tree to find the count of the words in a huge text file


(defn insert-node
  "Returns a bst after inserting a new node"
  [{:keys [root] :as tree} value]
  (cond
    (nil? root) {:root value :left nil :right nil}
    (< value root) (update tree :left insert-node value)
    (> value root) (update tree :right insert-node value)
    :else tree))

(defn create-bst
  "Returns a bst when given a list of node values "
  [values]
  (reduce insert-node {} values))

(defn has?
  "Returns true if if a given integer is present in the tree else false"
  [{:keys [root left right]} value]
  (cond
    (nil? root) false
    (= value root) true
    (< value root) (has? left value)
    :else (has? right value)))

;; test case
(create-bst '(9 2 1 5 7 4 6 8 10))

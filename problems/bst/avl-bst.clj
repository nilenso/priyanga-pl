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
  [{:keys [root left right] :as tree} value]
  (cond
    (nil? root) (into {} {:root value :left nil :right nil})
    (< value root) (merge tree {:left (insert-node left value)})
    (> value root) (merge tree {:right (insert-node right value)})
    :else tree))

;; test case
(def tree (reduce insert-node {} '(5 3 2 4 1)))

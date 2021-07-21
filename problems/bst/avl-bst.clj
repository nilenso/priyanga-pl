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

;;             5                          5
;;            / \                        / \
;;           3   nil                    3   nil
;;          /                          / \ 
;;         2                         nil  4
;;        /                              / \
;;       nil                            nil nil


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

(defn min-node
  "Find the minimun value in a given tree"
  [{:keys [root left] :as tree}]
  (cond
    (nil? tree) nil
    (nil? left) root
    :else (min-node left)))

(defn remove-node
  "Returns a tree after removing the given node from the given tree"
  [{:keys [root left right] :as tree} value]
  (cond
    (nil? tree) nil
    (< value root) (update tree :left remove-node value)
    (> value root) (update tree :right remove-node value)
    (nil? left) right
    (nil? right) left
    :else (let [min (min-node right)]
            (-> (update tree :right remove-node min)
                (assoc :root min)))))

(defn height
  ([tree] (height tree 0))
  ([tree count]
   (if tree
     (max (height (:left tree) (inc count))
          (height (:right tree) (inc count)))
     count)))

(defn factor [{:keys [left right]}]
  (- (height left) (height right)))

;; test case
(def tree (create-bst '(9 2 1 5 7 3 4 6 8 10)))
(has? tree 0)
(has? tree 3)
(min-node tree)
(remove-node tree 5)
(height tree)
(factor tree)

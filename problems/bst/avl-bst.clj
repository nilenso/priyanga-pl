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

(ns user
  (:require [clojure.string]))
(defrecord Node [root left right])

(defn height
  "Returns the height of the tree"
  ([tree] (height tree 0))
  ([tree count]
   (if tree
     (max (height (:left tree) (inc count))
          (height (:right tree) (inc count)))
     count)))

(defn factor 
  "Returns the balance factor i.e difference between height of left and right subtree"
  [{:keys [left right]}]
  (- (height left) (height right)))

(defn rotate-left 
  "Rotates the subtree to left"
  [{:keys [root left right] :as tree}]
  (if right
    (->Node (:root right) (->Node root left (:left right)) (:right right))
    tree))

(defn rotate-right 
  "Rotates the subtree to right"
  [{:keys [root left right] :as tree}]
  (if left
    (->Node (:root left) (:left left) (->Node root (:right left) right))
    tree))

(defn is-left-case? 
  "Returns true if left subtree is unbalanced otherwise false"
  [tree]
  (< (factor tree) -1))

(defn is-left-right-case? 
  "Returns true if right child of left subtree is unbalanced otherwise false"
  [tree]
  (and (is-left-case? tree) (> (factor (:right tree)) 0)))

(defn is-right-case? 
  "Returns true if right subtree is unbalanced otherwise false"
  [tree]
  (> (factor tree) 1))

(defn is-right-left-case? 
  "Returns true if left child of right subtree is unbalanced otherwise false"
  [tree]
  (and (is-right-case? tree) (< (factor (:left tree)) 0)))

(defn balance 
  "Returns balanced binary search tree"
  [{:keys [root left right] :as tree}]
  (cond
    (is-right-left-case? tree) (rotate-right (->Node root (rotate-left left) right))
    (is-left-right-case? tree) (rotate-left (->Node root left (rotate-right right)))
    (is-right-case? tree) (rotate-right tree)
    (is-left-case? tree) (rotate-left tree)
    :else tree))

(defn contains-node? 
  "Returns true if any of the tree node has the given value else false"
  [{:keys [root left right] :as tree} value]
  (cond
    (nil? tree) false
    (< value root) (recur left value)
    (> value root) (recur right value)
    :else true))

(defn min-node 
  "Returns the value node of the tree having minimum value"
  [{:keys [root left]}]
  (if left
    (recur left)
    root))

(defn remove-node
  "Removes the node having given value from the tree"
  [{:keys [root left right] :as tree} value]
  (cond
    (nil? tree) nil
    (neg? (compare value root)) (Node. root (remove-node left value) right)
    (pos? (compare value root)) (Node. root left (remove-node right value))
    (nil? left) right
    (nil? right) left
    :else (let [min-value (min-node right)]
            (Node. min-value left (remove-node right min-value)))))

(defn insert-node 
  "Adds a new node with the given value"
  [{:keys [root left right] :as tree} value]
  (cond
    (nil? tree) (Node. value nil nil)
    (neg? (compare value root)) (Node. root (insert-node left value) right)
    (pos? (compare value root)) (Node. root left (insert-node right value))
    :else tree))

(def avl-insert (comp balance insert-node))

(def avl-remove (comp balance remove-node))

(def to-balanced-tree #(reduce avl-insert nil %))

(defn to-list 
  "Returns tree as a list"
  [{:keys [root left right] :as tree}]
  (when tree
    `(~@(to-list left) ~root ~@(to-list right))))

(defn read-file 
  "Returns a vector containing all the words in a file"
  [file-path]
  (def content (slurp file-path))
  (clojure.string/split content #" "))

(defn count-nodes 
  "Returns the number of nodes in a tree"
  [{:keys [left right] :as tree}]
  (if tree
    (+ 1 (count left) (count right))
    0))

(def file-path "/Users/priyangapkini/Clojure/Learning/problems/text.txt")

(def word-tree (to-balanced-tree (read-file file-path)))
(def tree (to-balanced-tree '(5 8 2 3 4 1)))
;; test cases
(to-list tree)
(to-list (avl-remove tree 3))
(contains-node? tree 2)
(to-list word-tree)
(count-nodes word-tree)




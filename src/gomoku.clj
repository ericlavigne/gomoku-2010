(ns gomoku
  (:require [clojure.contrib.combinatorics :as combinatorics])
  (:require [clojure.contrib.seq-utils :as seq-utils])
  (:use [clojure.contrib.def defmemo]))

(defn empty-board [size]
  (vec (repeat size (vec (repeat size 0)))))

(defn read-board [board position]
  ((board (position 0)) (position 1)))

(defn alter-board [board position piece]
  (assoc board
    (position 0)
    (assoc (board (position 0))
      (position 1)
      piece)))

(def directions [[0 1] [1 1] [1 0] [1 -1]])

(defn positions [size]
  (combinatorics/cartesian-product
    (range size) (range size))

(defn random-positions [size]
  (seq-utils/shuffle (positions size)))

; Iterate over positions and directions, giving points for each potential X-in-a-row.
; 1 point if one of the spots is filled in
; twice as many points for filling in (N+1) as for filling in N
; negative points if player -1 filling in spots instead of player 1
;(defn estimate-advantage [board in-a-row]
;  ...)



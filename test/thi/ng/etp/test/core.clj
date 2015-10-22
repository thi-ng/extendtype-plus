(ns thi.ng.etp.test.core
  (:require
   [thi.ng.etp.core :refer [extend-type+]]
   [clojure.test :refer :all])
  (:import
   [foo Vec2]))

(defprotocol IMath
  (add [_] [_ a] [_ a b]))

(extend-type+
 Vec2
 IMath
 (add
  [[[addIdent]]
   [[Vec2 addV2] [:double addD]]
   [[Vec2 Vec2 addV2V2]
    [Vec2 :double addV2D]
    [:double :double addDD]]]))

(deftest test-all
  (prn (add (Vec2. 1 2)))
  (prn (add (Vec2. 1 2) (Vec2. 100 200)))
  (prn (add (Vec2. 1 2) 100 200))
  (prn (add (Vec2. 1 2) (Vec2. 100 200) 1000))
  (prn (add (Vec2. 1 2) 1000))
  (prn (meta (add (with-meta (Vec2. 1 2) {:foo true}) 1000))))

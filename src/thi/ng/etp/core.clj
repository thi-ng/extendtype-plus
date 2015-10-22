(ns thi.ng.etp.core)

(defn- build-type-check
  [args types]
  (let [check (map
               (fn [a type]
                 (if (#{:double :long} type)
                   (list 'number? a)
                   (list 'instance? type a)))
               args types)]
    (if (< 1 (count check))
      (cons 'thi.ng.etp.core/and* check)
      (first check))))

(defn- build-ast
  [parent args spec]
  (reduce
   (fn [ast opt]
     (let [branch (build-type-check args opt)
           args   (map
                   #(if (keyword? %2)
                      (list (symbol (name %2)) %)
                      (with-meta % {:tag (name %2)}))
                   args opt)
           invoke (->> args
                       (cons (with-meta '_ {:tag (name parent)}))
                       (cons (symbol (str \. (last opt)))))]
       (list (reduce #(cons %2 %) ast [invoke branch 'if]))))
   nil (reverse spec)))

(defn- method-impl
  [parent spec]
  (let [args (take (dec (count (first spec))) '(a b c d e f g h))
        ast  (first (build-ast parent args spec))]
    (list (into ['_] args) ast)))

(defn- method-arities
  [parent]
  (fn [[f specs]]
    `(~f ~@(map #(method-impl parent %) specs))))

(defmacro and*
  "Like clojure.core/and, but avoids intermediate let bindings and
  only ever returns either result of last form (if all previous ones
  succeeded) or else nil."
  ([x] x)
  ([x & more] `(if ~x (thi.ng.etp.core/and* ~@more))))

(defmacro extend-type+
  [type proto & m-specs]
  `(extend-type
       ~type ~proto
       ~@(map (method-arities type) m-specs)))

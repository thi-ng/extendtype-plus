(defproject thi.ng/extend-type-plus "0.1.0-SNAPSHOT"
  :description  "Clojure/Clojurescript extend-type additions"
  :url          "http://example.com/FIXME"

  :license      {:name "Apache Software License"
                 :url  "http://www.apache.org/licenses/LICENSE-2.0"
                 :distribution :repo}

  :scm          {:name "git"
                 :url  "https://github.com/thi-ng/extendtype-plus"}

  :dependencies [[org.clojure/clojure "1.7.0"]]

  :profiles     {:dev {:dependencies      [[criterium "0.4.3"]]
                       :java-source-paths ["src-java"]
                       :jvm-opts          ^:replace []
                       :global-vars       {*warn-on-reflection* true}
                       :main              thi.ng.etp.core}})

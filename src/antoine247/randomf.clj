(ns antoine247.randomf
(:require [clj-figlet.core :as ascii]
          [clojure.string :as string]
          [clojure.java.io :as io])
  (:gen-class))

(def flf (ascii/load-flf (io/resource "doh.flf")))
(defn get-random-f
  "gets a map of a random function of the clojure.core namespace with the keys name, arglists and doc"
  []
  (rand-nth (as-> 'clojure.core x
              (ns-map x)
              (seq x)
              (map second x)
              (map meta x)
              (filter (complement :private) x)
              (keep identity x)
              (map #(select-keys % [:name :arglists :doc]) x))))

(defn print-f
  "prints in the standard output the random function"
  [{:keys [namef arglists doc] :as map}]
  (println "Funcion del dia!")
  (println
   (clojure.string/join
    \newline
    (ascii/render flf (str (:name map))))) 
  (println "Argumentos")
  (println arglists)
  (println "Documentacion")
  (println doc))



(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (print-f (get-random-f)))


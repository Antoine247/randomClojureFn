(ns antoine247.randomf
(:require [colorize.core :as color])
  (:gen-class))

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
  [{:keys [name arglists doc]}]
  (println "Funcion del dia!")
  (color/color :red (println name)) 
  (println "Argumentos")
  (println arglists)
  (println "Documentacion")
  (println doc))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (print-f (get-random-f)))
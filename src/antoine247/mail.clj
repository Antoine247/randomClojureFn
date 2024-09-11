(ns antoine247.mail
  (:require [postal.core :as postal]))

(postal/send-message {:host "smtp.mail.yahoo.com"
                      :user "antoine.chamoun@yahoo.com"
                      :pass "96004712Leti"
                      :port 465
                      :ssl true
                      :tls true}
                     {:from "antoine.chamoun@yahoo.com"
                      :to "chamoun863@gmail.com"
                      :subject "hi"
                      :body "test"})
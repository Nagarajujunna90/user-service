# user-service
From kafka base localtion need to run below commands
------------------------------------------------------------
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
.\bin\windows\kafka-server-start.bat .\config\server.properties

.\bin\windows\kafka-topics.bat --create --topic tutorial-topic --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1

.\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic tutorial-topic

.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic tutorial-topic --from-beginning

.\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic tutorial-topic
.\bin\windows\kafka-console-consumer -bootstrap-server localhost:9092 -topic  tutorial-topic -group nagaraju

kafka-topics.bat --bootstrap-server=localhost:9092 --list
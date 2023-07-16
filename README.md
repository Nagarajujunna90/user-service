# user-service
# Kafka commands to start kafka and bootstrap in windows
=======================================================
1.From kafka base localtion need to run below commands
    .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
    .\bin\windows\kafka-server-start.bat .\config\server.properties
    
    .\bin\windows\kafka-topics.bat --create --topic tutorial-topic --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1
    
    .\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic tutorial-topic
    
    .\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic tutorial-topic --from-beginning
    
    .\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic tutorial-topic
    .\bin\windows\kafka-console-consumer -bootstrap-server localhost:9092 -topic  tutorial-topic -group nagaraju
    
    kafka-topics.bat --bootstrap-server=localhost:9092 --list


# Spring Cloud config implementation:
=====================================
1.Below dependencies need to add
    spring-boot-starter-actuator
    spring-boot-starter-config

2.configuration in yml file
  sring:
    config:
        import: configserver:http://localhost:8888.

3.Call any endpoint with @Value annotation as non static field and print it .

4.To get updated changes from git we need to hit this endpoint 
    http://localhost:8082/actuator/refresh POST endpoint 

and @RefreshScope annotation need to add at controller level.



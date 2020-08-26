https://lucasgauk.com/Change-Streams-and-Reactive-Spring/
#to enable changestream
- mongod.cfg
replication:
  replSetName: replocal
-restart mongod and run
  rs.initiate({_id: "replocal", members: [{_id: 0, host: "127.0.0.1:27017"}] })
  	
https://www.baeldung.com/spring-server-sent-events
The EventSource interface is web content's interface to server-sent events. 


https://www.toptal.com/java/stomp-spring-boot-websocket

#add 3 users
curl -X POST -H "Content-Type:application/json" -d '{ "username" : "Dheeraj Tyagi"}' localhost:8080/user/add

#add channels for userid 1
curl -X POST -H "Content-Type:application/json" -d '{ "userId" : "1" , "channel" : "WEB"}' localhost:8080/channel/add
curl -X POST -H "Content-Type:application/json" -d '{ "userId" : "1" , "channel" : "SMS"}' localhost:8080/channel/add
curl -X POST -H "Content-Type:application/json" -d '{ "userId" : "1" , "channel" : "EMAIL"}' localhost:8080/channel/add

#add notificaition types for userid 1
curl -X POST -H "Content-Type:application/json" -d '{ "userId" : "1" , "notificationType" : "SHIPMENT_IS_CREATED"}' localhost:8080/notification/add
curl -X POST -H "Content-Type:application/json" -d '{ "userId" : "1" , "notificationType" : "PACKAGED"}' localhost:8080/notification/add
curl -X POST -H "Content-Type:application/json" -d '{ "userId" : "1" , "notificationType" : "SHIPPED"}' localhost:8080/notification/add
curl -X POST -H "Content-Type:application/json" -d '{ "userId" : "1" , "notificationType" : "DELIEVERED"}' localhost:8080/notification/add
curl -X POST -H "Content-Type:application/json" -d '{ "userId" : "1" , "notificationType" : "RUNNING_LATE"}' localhost:8080/notification/add

#add item types for userid 1
curl -X POST -H "Content-Type:application/json" -d '{ "userId" : "1" , "name" : "RADIO"}' localhost:8080/item/add
curl -X POST -H "Content-Type:application/json" -d '{ "userId" : "1" , "name" : "AC"}' localhost:8080/item/add
curl -X POST -H "Content-Type:application/json" -d '{ "userId" : "1" , "name" : "TV"}' localhost:8080/item/add
curl -X POST -H "Content-Type:application/json" -d '{ "userId" : "1" , "name" : "MOBILE"}' localhost:8080/item/add
curl -X POST -H "Content-Type:application/json" -d '{ "userId" : "1" , "name" : "CAR"}' localhost:8080/item/add



#remove notification for userid 1
#curl -X POST -H "Content-Type:application/json" -d '{ "userId" : "1" , "notificationType" : "RUNNING_LATE"}' localhost:8080/notification/remove


#remove channel for userid1
#curl -X POST -H "Content-Type:application/json" -d '{ "userId" : "1" , "channel" : "WEB"}' localhost:8080/channel/remove

#send notificaiton to user id 1
curl -X POST -H "Content-Type:application/json" -d '{ "itemId" : "1" , "notificationEvent" : "SHIPMENT_IS_CREATED"}' localhost:8080/notification/send
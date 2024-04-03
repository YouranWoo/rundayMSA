# 

## Model
www.msaez.io/#/storming/runday-240403

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd infra
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- Running
- Rank
- FriendRelation
- Logging
- Notification
- Dashboard


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- Running
```
 http :8088/runnings id="id" userId="userId" startTime="startTime" pauseStartTime="pauseStartTime" endTime="endTime" startLatitude=" startLatitude" endLatitude="endLatitude" endLongitude="endLongitude" pauseEndTime="pauseEndTime" runningTime="runningTime" totalPauseTime="totalPauseTime" startLongitude="startLongitude" 
```
- Rank
```
 http :8088/rankings id="id" userId="userId" totalRunningTime="totalRunningTime" userRank="userRank" 
```
- FriendRelation
```
 http :8088/friends friendUserId="friendUserId" status="status" id="id" 
 http :8088/likes id="id" userReceivedId="userReceivedId" userSendingId="userSendingId" runningId="runningId" likeScore="likeScore" isLike="isLike" 
```
- Logging
```
 http :8088/logs id="id" userId="userId" startTime="startTime" startLatitude="startLatitude" startLongitude="startLongitude" endTime="endTime" endLatitude="endLatitude" endLongitude="endLongitude" runningTime="runningTime" userDiary="userDiary" likesCount="likesCount" runningPhoto="runningPhoto" 
```
- Notification
```
 http :8088/messages id="id" userId="userId" message="message" 
```
- Dashboard
```
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```


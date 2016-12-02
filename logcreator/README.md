# logcreator
## Prelert Demo Environment


> docker run -p 8080:8080 --log-driver=syslog --log-opt syslog-address=tcp://192.168.10.70:5140 --log-opt syslog-format=rfc3164  -d --name logcreator codecentric/logcreator
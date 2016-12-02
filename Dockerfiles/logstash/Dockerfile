FROM logstash
MAINTAINER Author Rainer Gregulla

# logstash.conf 
COPY logstash.conf /tmp

CMD ["-f", "/tmp/logstash.conf", "--verbose"]




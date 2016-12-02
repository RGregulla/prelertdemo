package de.codecentric;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by sierra on 30.11.16.
 */
@Component
public class NormalAccessLogProducer {
    Logger log = LoggerFactory.getLogger(this.getClass());

    private String[] ipaddr = {"192.168.10.1","192.168.10.2","192.168.10.3","192.168.10.4","192.168.10.5","192.168.10.6","192.168.10.7","192.168.10.8","192.168.10.9","192.168.10.10"};
    private String[] requests = {"/shop/login", "/shop/addtocart", "/shop/search", "/shop/payment", "/shop/logout", "/shop/order" };

    @Scheduled(fixedRate = 5000)
    public void doAccessLog() {

        // 192.168.125.1 - - [21/Aug/2013:23:53:28 +0200] "GET /wps/PA_Blurb_1/jsp/oob/css/v8001/welcomePage.css HTTP/1.1" 200 80
        DateFormat df = new SimpleDateFormat("dd/MMM/yyyy:hh:mm:ss Z");
        String accesslog = ipaddr[new Random().nextInt(9)] + " - - [" + df.format(new Date()) + "] \"GET " + requests[new Random().nextInt(5)]+ " HTTP/1.1\" 200 " + new Random().nextInt(1000);
        log.info(accesslog);
    }
}

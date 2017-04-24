package com.diegorubin.datacenter.notifications.gateways;

import com.diegorubin.datacenter.notifications.domain.Notification;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

/**
 * Created by diegorubin on 24/04/17.
 */
@FeignClient("notify")
public interface NotifyClient {

    @RequestMapping(method = RequestMethod.POST, value = "/api/notify", consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    Notification notify(@RequestBody Notification notification);

}

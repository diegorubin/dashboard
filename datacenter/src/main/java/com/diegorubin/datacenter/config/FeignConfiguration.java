package com.diegorubin.datacenter.config;

import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * Feign Configuration
 *
 * @author diegorubin
 */
@Configuration
@EnableFeignClients(basePackages = "com.diegorubin.datacenter")
public class FeignConfiguration {
}

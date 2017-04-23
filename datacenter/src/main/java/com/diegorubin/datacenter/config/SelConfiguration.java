package com.diegorubin.datacenter.config;

import lang.sel.core.SelContext;
import lang.sel.springboot.SelLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Sel Configuration
 *
 * @author diegorubin
 */
@Configuration
public class SelConfiguration {

  @Bean
  public SelContext selContext() {
    SelLoader selLoader = new SelLoader();
    SelContext selContext = new SelContext();
    selLoader.load(selContext, "com.diegorubin.dashboard");
    return selContext;
  }

}

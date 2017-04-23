package com.diegorubin.datacenter.orders.domain;

import com.diegorubin.datacenter.config.serializers.LocalDateTimeDeserializer;
import com.diegorubin.datacenter.config.serializers.LocalDateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * Order entity
 *
 * @author diegorubin
 */
@Document
public class Order {

  private String id;

  private String source;

  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonSerialize(using = LocalDateTimeSerializer.class)
  private LocalDateTime receivedIn;

  private String orderCode;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public LocalDateTime getReceivedIn() {
    return receivedIn;
  }

  public void setReceivedIn(LocalDateTime receivedIn) {
    this.receivedIn = receivedIn;
  }

  public String getOrderCode() {
    return orderCode;
  }

  public void setOrderCode(String orderCode) {
    this.orderCode = orderCode;
  }
}

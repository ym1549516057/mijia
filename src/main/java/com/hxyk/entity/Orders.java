package com.hxyk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
  private Long order_id;
  private Long user_id;
  private String order_num;
  private java.sql.Timestamp creat_time;
  private java.sql.Date send_time; //String
  private Double order_total;
  private String order_adress;
  private Long order_state;
  private int market_id;

  public Orders(Long user_id, int market_id, String order_num, Timestamp creat_time, Date send_time, Double order_total, String order_adress, Long order_state) {
    this.user_id = user_id;
    this.market_id = market_id;
    this.order_num = order_num;
    this.creat_time = creat_time;
    this.send_time = send_time;
    this.order_total = order_total;
    this.order_adress = order_adress;
    this.order_state = order_state;
  }

  public Long getOrder_id() {
    return order_id;
  }

  public void setOrder_id(Long order_id) {
    this.order_id = order_id;
  }

  public Long getUser_id() {
    return user_id;
  }

  public void setUser_id(Long user_id) {
    this.user_id = user_id;
  }

  public String getOrder_num() {
    return order_num;
  }

  public void setOrder_num(String order_num) {
    this.order_num = order_num;
  }

  public java.sql.Timestamp getCreat_time() {
    return creat_time;
  }

  public void setCreat_time(java.sql.Timestamp creat_time) {
    this.creat_time = creat_time;
  }

  public java.sql.Date getSend_time() {
    return send_time;
  }

  public void setSend_time(java.sql.Date send_time) {
    this.send_time = send_time;
  }

  public Double getOrder_total() {
    return order_total;
  }

  public void setOrder_total(Double order_total) {
    this.order_total = order_total;
  }

  public String getOrder_adress() {
    return order_adress;
  }

  public void setOrder_adress(String order_adress) {
    this.order_adress = order_adress;
  }

  public Long getOrder_state() {
    return order_state;
  }

  public void setOrder_state(Long order_state) {
    this.order_state = order_state;
  }



}

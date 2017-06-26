package com.hxyk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Repairs {
  private int repairs_id;
  private String repairs_dis;
  private String repairs_img;
  private int user_id;
  private java.sql.Timestamp repairs_commit_time;
  private int repairs_state;   //0:提交  1：正在处理  2 维修完成

  public Repairs(String repairs_dis, String repairs_img, int user_id, Timestamp repairs_commit_time, int repairs_state) {
    this.repairs_dis = repairs_dis;
    this.repairs_img = repairs_img;
    this.user_id = user_id;
    this.repairs_commit_time = repairs_commit_time;
    this.repairs_state = repairs_state;
  }
}

package com.hxyk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vote {
  private int vote_id;
  private String vote_name;
  private int vote_state;
  private java.sql.Timestamp vote_creat_time;
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
  private java.util.Date vote_finish;
  private int community_id;
  private int vote_count;//总票数
  private int vote_type;//投票类型

  public Vote(String vote_name, int vote_state, Timestamp vote_creat_time, Timestamp vote_finish,int community_id,int vote_count,int vote_type) {
    this.vote_name = vote_name;
    this.vote_state = vote_state;
    this.vote_creat_time = vote_creat_time;
    this.vote_finish = vote_finish;
    this.community_id=community_id;
    this.vote_count=vote_count;
    this.vote_type=vote_type;
  }
}

package com.hxyk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vote {
  private int vote_id;
  private String vote_name;
  private int vote_state;
  private java.sql.Timestamp vote_creat_time;
  private java.sql.Timestamp vote_finish;
  private int community_id;

  public Vote(String vote_name, int vote_state, Timestamp vote_creat_time, Timestamp vote_finish,int community_id) {
    this.vote_name = vote_name;
    this.vote_state = vote_state;
    this.vote_creat_time = vote_creat_time;
    this.vote_finish = vote_finish;
    this.community_id=community_id;
  }
}

package com.hxyk.service;

import com.hxyk.entity.Vote;

import java.util.List;
import java.util.Map;

/**
 * Created by YM on 2017/6/21.
 */
public interface VoteService {
    List<Vote> getAll(int community_id);
    Map getVoteByOption(int community_id,int offset,int pageSize);
    void addVote(Vote vote);
}

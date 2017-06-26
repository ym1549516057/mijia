package com.hxyk.service.impl;

import com.hxyk.dao.VoteDao;
import com.hxyk.entity.Vote;
import com.hxyk.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YM on 2017/6/21.
 */
@Service
public class VoteServiceImpl implements VoteService{
    @Autowired
    VoteDao voteDao;

    @Override
    public List<Vote> getAll(int community_id) {
        return voteDao.getAll(community_id);
    }

    @Override
    public Map getVoteByOption(int community_id, int offset, int pageSize) {
        Map map = new HashMap<>();
        List<Vote> voteList = voteDao.getVoteByOption(community_id,offset,pageSize);
        int total = voteDao.getTotalByOption(community_id);
        map.put("total",total);
        map.put("rows",voteList);
        return map;
    }
}

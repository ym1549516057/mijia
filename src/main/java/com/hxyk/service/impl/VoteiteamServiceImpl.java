package com.hxyk.service.impl;

import com.hxyk.dao.VoteiteamDao;
import com.hxyk.entity.Voteiteam;
import com.hxyk.service.VoteiteamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by YM on 2017/6/27.
 */
@Service
public class VoteiteamServiceImpl implements VoteiteamService{

    @Autowired
    VoteiteamDao voteiteamDao;

    @Override
    public void addVoteiteam(Voteiteam voteiteam) {
        voteiteamDao.addVoteiteam(voteiteam);
    }
}

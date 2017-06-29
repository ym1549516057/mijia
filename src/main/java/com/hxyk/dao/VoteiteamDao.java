package com.hxyk.dao;

import com.hxyk.entity.Voteiteam;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by YM on 2017/6/27.
 */
@Mapper
@Repository
public interface VoteiteamDao {
    void addVoteiteam(Voteiteam voteiteam);
}

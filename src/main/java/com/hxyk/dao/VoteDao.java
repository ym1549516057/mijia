package com.hxyk.dao;

import com.hxyk.entity.Vote;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by YM on 2017/6/21.
 */
@Mapper
@Repository
public interface VoteDao {
    List<Vote> getAll(@Param("community_id") int community_id);
    List<Vote> getVoteByOption(@Param("community_id") int community_id, @Param("offset") int offset, @Param("pageSize")int pageSize);
    int getTotalByOption(@Param("community_id") int community_id);
    int addVote(Vote vote);
}

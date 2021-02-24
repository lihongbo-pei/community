package com.lhb.community.dao.elasticsearch;

import com.lhb.community.entity.DiscussPost;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author littlelee
 * @date 2021/2/22 14:50
 */
@Repository
public interface DiscussPostRepository extends ElasticsearchRepository<DiscussPost, Integer> {



}

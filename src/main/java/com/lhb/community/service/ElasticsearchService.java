package com.lhb.community.service;

import com.lhb.community.dao.elasticsearch.DiscussPostRepository;
import com.lhb.community.entity.DiscussPost;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author littlelee
 * @date 2021/2/26 14:26
 */
@Service
public class ElasticsearchService {

    @Autowired
    private DiscussPostRepository discussPostRepository;

    @Autowired
    private ElasticsearchRestTemplate elasticTemplate;

    public void saveDiscussPost(DiscussPost post) {
        discussPostRepository.save(post);
    }

    public void deleteDiscussPost(int id) {
        discussPostRepository.deleteById(id);
    }

    public Page<DiscussPost> searchDiscussPost(String keyword, int current, int limit) {
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.multiMatchQuery(keyword,"title","content"))
                .withSort(SortBuilders.fieldSort("type").order(SortOrder.DESC))
                .withSort(SortBuilders.fieldSort("score").order(SortOrder.DESC))
                .withSort(SortBuilders.fieldSort("createTime").order(SortOrder.DESC))
                .withPageable(PageRequest.of(current,limit))
                .withHighlightFields(
                        new HighlightBuilder.Field("title").preTags("<em>").postTags("</em>"),
                        new HighlightBuilder.Field("content").preTags("<em>").postTags("</em>")
                ).build();
        SearchHits<DiscussPost> hits = elasticTemplate.search(searchQuery, DiscussPost.class);
        if (hits.getTotalHits() <= 0){
            return null;
        }
        List<DiscussPost> list = new ArrayList<>();
        for (SearchHit<DiscussPost> hit : hits) {
            DiscussPost post = hit.getContent();
            // 处理高亮显示的结果
            Map<String, List<String>> highlightFields = hit.getHighlightFields();
            List<String> title = highlightFields.get("title");
            System.out.println(title);
            if (title != null && title.size() != 0){
                post.setTitle(title.get(0));
            }
            List<String> content = highlightFields.get("content");
            System.out.println(content);
            if (content != null && content.size() != 0){
                post.setContent(content.get(0));
            }
            list.add(post);
        }
        return new AggregatedPageImpl(list);
    }

}

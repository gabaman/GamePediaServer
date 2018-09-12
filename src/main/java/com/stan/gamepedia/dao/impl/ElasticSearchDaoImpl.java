package com.stan.gamepedia.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.stan.gamepedia.dao.ElasticSearchDao;
import com.stan.gamepedia.model.*;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilder;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.fasterxml.jackson.databind.ObjectMapper;


@Repository
public class ElasticSearchDaoImpl implements ElasticSearchDao {
    @Autowired
    private TransportClient transportClient;
	private static final ObjectMapper mapper = new ObjectMapper();

	private final static String gameContentIndex="zeldatemple";
	private final static String gameContentType="templedetail";



	@Override
	public GameContent save(GameContent gameContent) {

		BulkRequestBuilder bulkRequestBuilder = transportClient.prepareBulk();

		IndexRequest indexRequest = transportClient.prepareIndex(gameContentIndex,gameContentType,gameContent.getId()).setSource(gameContent.toMap()).request();
		bulkRequestBuilder.add(indexRequest);
		BulkResponse bulkResponse = bulkRequestBuilder.execute().actionGet();
		if (bulkResponse.hasFailures()) {
			System.out.println("批量创建索引错误！");
		}
		System.out.println("批量创建索引成功");
		return gameContent;
	}





	@Override
	public void delete(GameContent gameContent) {

	}

	@Override
	public EsResult searchAll(String name, Integer
			start, Integer size) {
		long startTime = System.currentTimeMillis();
		ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		QueryBuilder multiMatch = QueryBuilders.multiMatchQuery(name, "title", "content").operator(Operator.AND);
		HighlightBuilder highlightBuilder = new HighlightBuilder()
				.preTags("<span style=\"color:red\">")
				.postTags("</span>")
				.field("title")
				.field("content");

		SearchResponse response = transportClient.prepareSearch(gameContentIndex)
				.setTypes(gameContentType)
				.setQuery(multiMatch)
				.highlighter(highlightBuilder)
				.setFrom(start * size)
				.setSize(size)
				.execute()
				.actionGet();
		SearchHits hits = response.getHits();

		if (hits.getTotalHits() > 0) {
			System.out.println("共搜索到" + hits.getTotalHits() + "条结果!");
			for (SearchHit hit : hits) {

				Map<String, Object> map = hit.sourceAsMap();

				HighlightField hTitle = hit.getHighlightFields().get("title");
				HighlightField hContent = hit.getHighlightFields().get("content");
				if (hTitle != null) {
					String highlightTitle = "";
					Text[] fragments = hTitle.fragments();
					for (Text text : fragments) {
						highlightTitle += text;
					}
					map.put("title", highlightTitle);
				}
				if (hContent != null) {
					String highlightContent = "";
					Text[] fragments = hContent.fragments();
					for (Text text : fragments) {
						highlightContent += text;
					}
					map.put("content", highlightContent);
				}
				list.add(map);

			}
		} else {
			System.out.println("搜到0条结果");
		}
		System.out.println("newslist" + list);
		System.out.println(list.size());
		long endTime = System.currentTimeMillis();

		EsResult result = new EsResult();
		result.list = list;
		result.totalHits = String.valueOf(hits.getTotalHits());
		result.totalTime = String.valueOf((endTime - startTime));

		return result;

	}

	@Override
	public ZeldaTemple saveTemple(ZeldaTemple zeldaTemple) {

		BulkRequestBuilder bulkRequestBuilder = transportClient.prepareBulk();

		Map tmp = zeldaTemple.toMap();
		tmp.put("type","principleline");
		IndexRequest indexRequest = transportClient.prepareIndex(gameContentIndex,gameContentType,zeldaTemple.getTypeid().toString()).setSource(tmp).request();
		bulkRequestBuilder.add(indexRequest);
		BulkResponse bulkResponse = bulkRequestBuilder.execute().actionGet();
		if (bulkResponse.hasFailures()) {
			System.out.println("批量创建索引错误！");
		}
		System.out.println("批量创建索引成功");
		return zeldaTemple;

	}


	public void saveType(String type,Object object) {




		BulkRequestBuilder bulkRequestBuilder = transportClient.prepareBulk();

		Map tmp = null;

		IndexRequest indexRequest = null;
		if (type.equals("zeldaweapon") ){
			ZeldaWeapon wp = (ZeldaWeapon)object;
			tmp = wp.toMap();
			tmp.put("type",type);
			indexRequest = transportClient.prepareIndex(gameContentIndex,gameContentType,wp.getTypeid().toString()).setSource(tmp).request();

		}else if(type.equals("zeldashield")){
			ZeldaShield wp = (ZeldaShield)object;
			tmp = wp.toMap();
			tmp.put("type",type);
			indexRequest = transportClient.prepareIndex(gameContentIndex,gameContentType,wp.getTypeid().toString()).setSource(tmp).request();

		}else if(type.equals("zeldaarmor") ){
			ZeldaArmor wp = (ZeldaArmor)object;
			tmp = wp.toMap();
			tmp.put("type",type);
			indexRequest = transportClient.prepareIndex(gameContentIndex,gameContentType,wp.getTypeid().toString()).setSource(tmp).request();

		}else if(type.equals("zeldamaterial") ){
			ZeldaMaterial wp = (ZeldaMaterial)object;
			tmp = wp.toMap();
			tmp.put("type",type);
			indexRequest = transportClient.prepareIndex(gameContentIndex,gameContentType,wp.getTypeid().toString()).setSource(tmp).request();

		}else if(type.equals("zeldafood") ){
			ZeldaFood wp = (ZeldaFood) object;
			tmp = wp.toMap();
			tmp.put("type",type);
			indexRequest = transportClient.prepareIndex(gameContentIndex,gameContentType,wp.getTypeid().toString()).setSource(tmp).request();

		}


		bulkRequestBuilder.add(indexRequest);
		BulkResponse bulkResponse = bulkRequestBuilder.execute().actionGet();
		if (bulkResponse.hasFailures()) {
			System.out.println("批量创建索引错误！");
		}
		System.out.println("批量创建索引成功");

	}

}

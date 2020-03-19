package com.hfut.douban;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hfut.douban.bean.AllInfo;
import com.hfut.douban.service.AllInfoService;
import com.hfut.douban.service.CommentService;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@SpringBootTest
class DoubanApplicationTests {

    @Resource
    CommentService commentService;

    @Resource
    AllInfoService allInfoService;

    @Test
    void getComment() {
        List<AllInfo> allInfos = allInfoService.queryAllInfos();
        for (AllInfo allInfo : allInfos) {
            String dId = allInfo.getDId();
            CloseableHttpClient httpclient = HttpClients.createDefault();
            try {
                String key = "0df993c66c0c636e29ecbb5344252a4a";
                String requestUrl = "https://api.douban.com/v2/book/" + dId + "/comments?count=100&apikey=" + key;
                HttpGet httpget = new HttpGet(requestUrl);
                System.out.println("executing request " + httpget.getURI());
                try (CloseableHttpResponse response = httpclient.execute(httpget)) {
                    HttpEntity entity = response.getEntity();
                    if (entity != null) {
                        JSONObject jsonObject = JSONObject.parseObject(EntityUtils.toString(entity));
                        String total = jsonObject.getString("total");
                        JSONArray comments = jsonObject.getJSONArray("comments");
                        for (int j = 0; j < comments.size(); j++) {
                            JSONObject comment = comments.getJSONObject(j);
                            JSONObject rating = comment.getJSONObject("rating");
                            String ratingMax = null;
                            String ratingValue = null;
                            String ratingMin = null;
                            if (rating != null) {
                                ratingMax = rating.getString("max");
                                ratingValue = rating.getString("value");
                                ratingMin = rating.getString("min");
                            }
                            String votes = comment.getString("votes");
                            JSONObject author = comment.getJSONObject("author");
                            String authorName = null;
                            String authorIsBanned = null;
                            String authorIsSuicide = null;
                            String authorUrl = null;
                            String authorAvatar = null;
                            String authorUid = null;
                            String authorAlt = null;
                            String authorType = null;
                            String authorId = null;
                            String authorLargeAvatar = null;
                            if (author != null) {
                                authorName = author.getString("name");
                                authorIsBanned = author.getString("is_banned");
                                authorIsSuicide = author.getString("is_suicide");
                                authorUrl = author.getString("url");
                                authorAvatar = author.getString("avatar");
                                authorUid = author.getString("uid");
                                authorAlt = author.getString("alt");
                                authorType = author.getString("type");
                                authorId = author.getString("id");
                                authorLargeAvatar = author.getString("large_avatar");
                            }
                            String summary = comment.getString("summary");
                            String published = comment.getString("published");
                            String alt = comment.getString("alt");
                            String cId = comment.getString("id");
                        /*System.out.println(total + " " + ratingMax + " " + ratingValue + " " +
                                ratingMin + " " + votes + " " + authorName + " " + authorIsBanned +
                                " " + authorIsSuicide + " " + authorUrl + " " + authorAvatar + " " + authorUid +
                                " " + authorAlt + " " + authorType + " " + authorId + " " + authorLargeAvatar +
                                " " + summary + " " + published + " " + alt + " " + cId);*/
                            commentService.preserve(dId, total, ratingMax, ratingValue,
                                    ratingMin, votes, authorName, authorIsBanned, authorIsSuicide, authorUrl, authorAvatar, authorUid,
                                    authorAlt, authorType, authorId, authorLargeAvatar, summary, published,
                                    alt, cId);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

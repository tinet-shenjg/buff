package com.shenjg.admin.controller;

import com.alibaba.fastjson.JSON;
import com.shenjg.admin.model.AdminUserModel;
import com.shenjg.admin.model.UserModel;
import com.shenjg.auth.api.AdminUserApi;
import com.shenjg.auth.entity.AdminUser;
import com.shenjg.core.data.ResponseModel;
import io.swagger.annotations.ApiOperation;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 用户controller
 *
 * @author shenjg
 * @date 2018/11/01
 */
@RestController
@RequestMapping("/adminUser")
public class AdminUserController {

    Logger logger = LoggerFactory.getLogger(AdminUserController.class);

    @Autowired
    private RestHighLevelClient restHighLevelClient;


    @Autowired
    private AdminUserApi adminUserApi;

    /**
     * 获取用户信息
     *
     * @param username
     * @return
     */
    @ApiOperation(value = "获取用户名", notes = "不要乱用")
    @GetMapping
    public List<UserModel> getUser(String username) {
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.from(0);
        sourceBuilder.size(10);
        sourceBuilder.fetchSource(new String[]{"address", "name"}, new String[]{});
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("name", username);

        BoolQueryBuilder boolBuilder = QueryBuilders.boolQuery();
        boolBuilder.must(matchQueryBuilder);
        sourceBuilder.query(boolBuilder);
        SearchRequest searchRequest = new SearchRequest("user");
        searchRequest.types("student");
        searchRequest.source(sourceBuilder);

        SearchResponse response = null;
        try {
            response = restHighLevelClient.search(searchRequest);
        } catch (IOException e) {
            logger.info("es查用户信息发生异常" + e.getMessage(), e);
        }

        List<UserModel> userModelList = new ArrayList<>();
        if (Objects.nonNull(response)) {
            SearchHits searchHits = response.getHits();
            SearchHit[] searchHits1 = searchHits.getHits();
            for (SearchHit searchHit : searchHits1) {
                // 将map转为user对象
                UserModel userModel = JSON.parseObject(JSON.toJSONString(searchHit.getSource()), UserModel.class);
                userModelList.add(userModel);
            }
        }
        return userModelList;
    }

    @ApiOperation(value = "新增用户", notes = "不要乱用")
    @PostMapping
    public ResponseModel save(@RequestBody AdminUserModel adminUserModel) {
        AdminUser adminUser = new AdminUser();
        BeanUtils.copyProperties(adminUserModel, adminUser);
        adminUserApi.save(adminUser);
        return new ResponseModel(HttpStatus.OK,"创建成功", adminUser);
    }

    @ApiOperation(value = "修改用户信息", notes = "不要乱用")
    @PostMapping
    public ResponseModel update(@RequestBody AdminUserModel adminUserModel) {
        AdminUser adminUser = new AdminUser();
        BeanUtils.copyProperties(adminUserModel, adminUser);
        adminUserApi.update(adminUser);
        return new ResponseModel(HttpStatus.OK,"修改成功", adminUser);
    }


}
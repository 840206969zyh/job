package com.heryoos.job.controller;

import com.heryoos.job.mapper.DataMapper;
import com.heryoos.job.pojo.DataItem;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class DataController {

    @Autowired
    private DataMapper dataMapper;
    /**
     * 修改之前先查询商品信息
     * @param userId
     * @return
     */
    @PostMapping("/getData")
    public Map apiSelectProductSingle(Integer userId){
        Map<String,Integer> data = dataMapper.getItem(userId);
        return data;
    }

}

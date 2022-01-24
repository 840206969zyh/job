package com.heryoos.job.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heryoos.job.mapper.StatisticElementOrderMapper;
import com.heryoos.job.pojo.StatisticsElementOrderitem;
import com.heryoos.job.service.StatisticElementOrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class StatisticElementOrderServiceImpl extends ServiceImpl<StatisticElementOrderMapper, StatisticsElementOrderitem> implements StatisticElementOrderService {

    @Autowired
    private StatisticElementOrderMapper statisticElementOrderMapper;

    @Override
    public List<StatisticsElementOrderitem> getDataList() {
        return statisticElementOrderMapper.getDataList();
    }
}

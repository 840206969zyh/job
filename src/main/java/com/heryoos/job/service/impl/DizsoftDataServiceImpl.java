package com.heryoos.job.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heryoos.job.mapper.DizsoftDataMapper;
import com.heryoos.job.pojo.DizsoftData;
import com.heryoos.job.pojo.DizsoftNode;
import com.heryoos.job.service.DizsoftDataService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DizsoftDataServiceImpl extends ServiceImpl<DizsoftDataMapper, DizsoftData> implements DizsoftDataService {
    @Autowired
    private DizsoftDataMapper dizsoftDataMapper;

    @Override
    public List<DizsoftNode> getMasterTask() {
        return dizsoftDataMapper.getMasterTask();
    }

    @Override
    public List<DizsoftNode> getCommonTotal() {
        return dizsoftDataMapper.getCommonTotal();
    }

    @Override
    public List<DizsoftNode> getQuotaTask() {
        return dizsoftDataMapper.getQuotaTask();
    }
}

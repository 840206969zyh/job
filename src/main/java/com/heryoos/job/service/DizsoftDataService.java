package com.heryoos.job.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heryoos.job.pojo.DizsoftData;
import com.heryoos.job.pojo.DizsoftNode;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DizsoftDataService extends IService<DizsoftData> {

    /**
     * 代理爆品出货量
     * @return
     */
    List<DizsoftNode> getMasterTask();

    /**
     * 精品出货金额
     * @return
     */
    List<DizsoftNode> getCommonTotal();

    /**
     * 配额销量
     * @return
     */
    List<DizsoftNode> getQuotaTask();
}

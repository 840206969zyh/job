package com.heryoos.job.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heryoos.job.pojo.DizsoftNode;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface NodeService extends IService<DizsoftNode> {


    /**
     * 根据代理用户
     *
     * @return 节点
     */
    List<DizsoftNode> getMasterNode();
}

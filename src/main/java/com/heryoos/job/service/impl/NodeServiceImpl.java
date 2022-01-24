package com.heryoos.job.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heryoos.job.mapper.NodeMapper;
import com.heryoos.job.pojo.DizsoftNode;
import com.heryoos.job.pojo.NodeItem;
import com.heryoos.job.service.NodeService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NodeServiceImpl extends ServiceImpl<NodeMapper, DizsoftNode> implements NodeService
{
    @Autowired
    private NodeMapper nodeMapper;


    @Override
    public List<DizsoftNode> getMasterNode() {
        return nodeMapper.getMasterNode();
    }
}

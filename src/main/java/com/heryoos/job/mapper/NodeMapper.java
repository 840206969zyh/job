package com.heryoos.job.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.heryoos.job.pojo.DizsoftNode;
import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface NodeMapper extends BaseMapper<DizsoftNode>
{

    /**
     * 获取代理节点
     * @return
     */
    @Select("select a.user_id as uid,b.`name` as username from dizsoft_node a left join Users b on a.user_id = b.id where a.`level`=52")
    List<DizsoftNode> getMasterNode();

}

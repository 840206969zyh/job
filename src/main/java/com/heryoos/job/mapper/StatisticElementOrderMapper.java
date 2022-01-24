package com.heryoos.job.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heryoos.job.pojo.StatisticsElementOrderitem;
import java.util.List;
import org.apache.ibatis.annotations.Select;

public interface StatisticElementOrderMapper extends BaseMapper<StatisticsElementOrderitem> {

    @Select("select * from statistic_element_orderitem where sku_id=6369 and create_date>'2022-01-15 00:00:00' and create_date<='2022-01-15 22:58:00' and refunded=0 and deleted=0")
    List<StatisticsElementOrderitem> getDataList();
}

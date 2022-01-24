package com.heryoos.job.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heryoos.job.pojo.DataItem;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DataMapper {

    @Select(" select " +
            " IFNULL((SELECT" +
            " sum( sale_num_change ) AS total" +
            " FROM" +
            " dizsoft_task_log " +
            " WHERE" +
            " create_date >= '2021-12-01 00:00:00' " +
            " AND create_date < '2022-01-01 00:00:00' " +
            " AND type IN ( 1, 7 ) " +
            " AND deleted = 0 " +
            " AND user_id =#{userId}),0)" +
            "  taskNum,IFNULL(( SELECT sum(b.quantity) FROM statistic_element_order a left join statistic_element_orderitem b on a.order_id=b.order_id where a.master_user_id=#{userId} and a.create_date >= '2021-12-01 00:00:00' AND a.create_date < '2022-01-01 00:00:00' and b.order_item_type in(3,5)),0) orderNum," +
            " IFNULL((SELECT sum(b.quantity) FROM statistic_element_order a left join statistic_element_orderitem b on a.order_id=b.order_id where a.master_user_id= #{userId} and a.create_date >= '2021-12-01 00:00:00' AND a.create_date < '2022-01-01 00:00:00' and b.order_item_type in (3,5) and b.refunded=1 and b.deleted=1),0) refundNum" +
            " from dual")
    Map<String,Integer> getItem(@Param("userId") Integer userId);

}

package com.heryoos.job.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heryoos.job.pojo.DizsoftData;
import com.heryoos.job.pojo.DizsoftNode;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DizsoftDataMapper extends BaseMapper<DizsoftData> {

    @Select("select a.user_id as uid,sum(c.quantity) as total from dizsoft_node a left join statistic_element_order b on a.user_id=b.member_user_id left join statistic_element_orderitem c on b.order_id=c.order_id   where b.create_date>='2021-12-01 00:00:00' and b.create_date<'2022-01-01 00:00:00' and c.order_item_type=3 and a.`level`=52 and b.deleted=0 and b.refunded=0 group by a.user_id order by total desc")
    List<DizsoftNode> getMasterTask();

    @Select("select a.master_user_id as uid,sum(b.platform_commission) as commonTotal from dizsoft_node n left join statistic_element_order a on n.user_id=a.master_user_id left join statistic_element_orderitem b on a.order_id=b.order_id where a.create_date>='2021-12-01 00:00:00' and a.create_date<'2022-01-01 00:00:00' and b.order_item_type=4 and b.deleted=0 and b.refunded=0 and n.`level`=52 group by n.user_id order by commonTotal desc")
    List<DizsoftNode> getCommonTotal();

    @Select("select a.master_user_id as uid,sum(a.num) as total from dizsoft_branch_num_log a left join dizsoft_node b on a.master_user_id=b.user_id where a.type=4 and a.date>='2021-12-01 00:00:00' and a.date<'2022-01-01 00:00:00' and b.`level`=52 group by a.master_user_id order by total desc")
    List<DizsoftNode> getQuotaTask();
}

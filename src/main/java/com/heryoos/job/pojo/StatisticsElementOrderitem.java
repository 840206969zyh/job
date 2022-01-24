package com.heryoos.job.pojo;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

//统计从表信息

@Data
@Table(name="statistic_element_orderitem")
public class StatisticsElementOrderitem {
    /**
     * 构造方法
     */
    public StatisticsElementOrderitem() {
    }

    @Id
    @Column(insertable = false, updatable = false)
    private Integer id;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 取消时间
     */
    private Date deleteDate;

    /**
     * 关联订单Id
     */
    private Integer relatedOrder;

    /**
     * 关联订单Id
     */
    private Integer orderId;

    /**
     * 关联订单Id
     */
    private Integer orderItemId;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 订单项类型
     */
    private Integer orderItemType;

    /**
     * 订单项价格
     */
    private BigDecimal price;

    /**
     * 余额
     */
    private BigDecimal balance;

    /**
     * 现金
     */
    private BigDecimal cash;

    /**
     * 平台佣金收入
     */
    private BigDecimal platformCommission;

    /**
     * 净收入
     */
    private BigDecimal netIncome;

    /**
     * 佣金
     */
    private BigDecimal commission;

    /**
     * 数量
     */
    private Integer quantity;

    /**
     * 规格主键
     */
    private Integer skuId;

    /**
     * 订单项内容
     */
    private String name;

    /**
     * 删除标记位
     */
    private Integer deleted;

    /**
     * 更新标记位
     */
    private Integer upversion;

    /**
     * 扣除返佣标记位
     */
    private Boolean deducted;

}

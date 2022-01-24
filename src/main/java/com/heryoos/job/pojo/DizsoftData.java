package com.heryoos.job.pojo;

import com.baomidou.mybatisplus.annotation.*;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@TableName(value = "dizsoft_data", autoResultMap = true)
public class DizsoftData {

    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户主键 ID，微信昵称
     */
    @TableField(updateStrategy = FieldStrategy.NEVER)
    private Integer userId;

    /**
     * 微信昵称
     */
    @TableField(updateStrategy = FieldStrategy.NEVER)
    @Length(max = 255)
    private String userName;

    /**
     * 爆品出货量（不含配额）
     */
    @TableField(updateStrategy = FieldStrategy.NEVER)
    private Integer memberTask;

    /**
     * 精品出货金额
     */
    @TableField(updateStrategy = FieldStrategy.NEVER)
    private BigDecimal commonTotal;

    /**
     * 配额销量
     */
    @TableField(updateStrategy = FieldStrategy.NEVER)
    private Integer quotaTask;
}

package com.heryoos.job.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataItem {
    private Integer taskNum;

    private Integer orderNum;

    private Integer refundNum;
}

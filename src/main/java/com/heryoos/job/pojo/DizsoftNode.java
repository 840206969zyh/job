package com.heryoos.job.pojo;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DizsoftNode {
    private Integer uid;
    private String username;
    private Integer total;

    private BigDecimal commonTotal;
}

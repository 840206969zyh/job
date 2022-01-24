package com.heryoos.job.pojo;

import com.baomidou.mybatisplus.annotation.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("dizsoft_node")
public class NodeItem implements Serializable
{

    // 根据系统生成的ID值进行调整
    public static final int NODE_LEVEL_COMMON_USER = 55;// 普通用户

    public static final int NODE_LEVEL_MEMBER = 54;// 会员

    public static final int NODE_LEVEL_BRANCH = 53;// 门店

    public static final int NODE_LEVEL_MASTER = 52;// 总代

    public static final int NODE_LEVEL_LEVEL_BRANCH = 56;// 平级门店

    public static final int NODE_LEVEL_AFTER_MASTER = 58;// 总代后
    // 定义会员、门店、总代自己购买的情况下，在分配链中的级别

    public static final int NODE_LEVEL_NODE_START = 0;// 自己购买，分配链中无级别。做起点标记。

    public static final int NODE_LEVEL_NODE_BUYSELF = 1;// 自己购买，消耗余额。

    private static final long serialVersionUID = -1889313072087803817L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("user_id")
    private Integer userId;

    /**
     * 上级节点ID值
      */
    private Integer pid;

    /**
     *  上级节点的用户ID值
     */
    @TableField("user_pid")
    private Integer userPid;

    /**
     *  节点当前等级
     */
    private NodeLevel level;

    /**
     * 节点创建时间
     */
    @TableField("n_create_date")
    private Date nCreateDate;

    /**
     * 节点过期时间
     */
    @TableField(value = "n_expired_date", updateStrategy = FieldStrategy.IGNORED)
    private Date nExpiredDate;//

    /**
     * 门店升级为总代，新生成的总代的节点ID值。
     */
    private Integer nid;

    /**
     * 任务量
     */
    @TableField("task_num")
    private Integer taskNum;

    /**
     * 销售量
     */
    @TableField("sale_num")
    private Integer saleNum;

    /**
     * 该节点所属的门店的ID值
     */
    @TableField(value = "branch_id", updateStrategy = FieldStrategy.IGNORED)
    private Integer branchId;

    /**
     *  该节点所处的门店的用户ID值
     */
    @TableField(value = "branch_user_id", updateStrategy = FieldStrategy.IGNORED)
    private Integer branchUserId;

    /**
     * 该节点所属的总代的ID值
     */
    @TableField(value = "master_id", updateStrategy = FieldStrategy.IGNORED)
    private Integer masterId;

    /**
     * 该节点所属总代的用户ID值
     */
    @TableField(value = "master_user_id", updateStrategy = FieldStrategy.IGNORED)
    private Integer masterUserId;

    /**
     * 总代结算价标记
     * 0:结算价139，返佣20
     * 1:结算价149，返佣10
     * 2:结算价临时159
     * 3:结算价永久159
     */
    @TableField("user_tag")
    private Integer userTag;

    /**
     * 清零之前的销售量（总代在20210901之前过期且未完成任务量，记录此时销售量）
     */
    @TableField("sale_num_new")
    private Integer saleNumNew;

    // public static final int NODE_LEVEL_COMMON_USER = 1;//普通用户
    // public static final int NODE_LEVEL_MEMBER = 2;//会员
    // public static final int NODE_LEVEL_BRANCH = 3;//门店
    // public static final int NODE_LEVEL_MASTER = 4;//总代
    // public static final int NODE_LEVEL_LEVEL_BRANCH = 5;//平级门店
    // public static final int NODE_LEVEL_AFTER_MASTER = 6;//总代后
    @TableField("depart_id")
    private Integer departId;// 该节点所属部的编号值

    @TableField("trans_master")
    private Integer transMaster;// 是否转换过所属总代，用在门店升级总代，下属的门店转换总代的情况。0：表示未转换过；1：表示转换过。

    @TableField("default_task_num")
    private Integer defaultTaskNum;

    @TableField(value = "up_branch_date", updateStrategy = FieldStrategy.IGNORED)
    private Date upBranchDate;// 门店升级时间

    @TableField("up_master_date")
    private Date upMasterDate;// 总代升级时间

    @TableField(exist = false)
    private String departName;// 所属部名称

    @TableField(exist = false)
    private String departChief;// 所属部部长

    @TableField(exist = false)
    private NodeLevel chainLevel;// 记录该节点在分配链中的级别

    public static String getLevelPriceName(NodeLevel chainLevel) {
        switch (chainLevel) {
            case COMMON_USER:
                return "price";
            case MEMBER:
                return "memberPrice";
            case BRANCH:
                return "branchPrice";
            case MASTER:
                return "masterPrice";
            case LEVEL_BRANCH:
            case AFTER_MASTER:
                return "levelPrice";
            default:
                return "";
        }

    }

    public boolean isExpired() {
        if (getNCreateDate() == null) {
            return false;
        }
        return new Date().compareTo(getNExpiredDate()) > 0;
    }

    /**
     * 用户等级
     */
    public enum NodeLevel implements IEnum<Integer>
    {

        /**
         * 起点，暂时不知道干什么用
         */
        START(0, "起点", "START"),
        /**
        * 自己购买
        */
        BUYSELF(1, "自己购买", "BUYSELF"),
        /**
         * 普通用户
         */
        COMMON_USER(55, "用户", "COMMON_USER"),
        /**
         * 用户
         */
        MEMBER(54, "用户", "MEMBER"),
        /**
         * VIP
         */
        BRANCH(53, "VIP", "BRANCH"),
        /**
         * 代理
         */
        MASTER(52, "代理", "MASTER"),
        /**
         * 平级VIP
         */
        LEVEL_BRANCH(56, "平级门店", "LEVEL_BRANCH"),
        /**
         * 平级代理
         */
        AFTER_MASTER(58, "总代后", "AFTER_MASTER");

        private final int levelCode;

        private final String name;

        private final String EnglishName;

        NodeLevel(int levelCode, String name, String EnglishName) {
            this.levelCode = levelCode;
            this.name = name;
            this.EnglishName = EnglishName;
        }

        public int getLevelCode() {
            return levelCode;
        }

        public String getName() {
            return name;
        }

        public String getEnglishName() {
            return EnglishName;
        }

        @Override
        public Integer getValue() {
            return levelCode;
        }
    }

    @Data
    public static class NodeItemTableInfo
    {

        private String userName;

        private String headPortrait;

        private Integer userId;

        private String code;

        private String merchantCode;

        private Integer nodeId;

        private Integer pid;

        private Integer nodeLevel;

        private Date createDate;

        private Date expiredDate;

        private Integer nid;

        private Integer taskNum;

        private Integer saleNum;

        private String pUserName;

        private String pCode;

        private Integer branchId;

        private Integer branchUserId;

        private String branchName;

        private Integer masterId;

        private Integer masterUserId;

        private String masterName;

        private String departName;

        private String departChief;

    }

    @Data
    public static class MemberInfo
    {
        private Integer id;

        private String name;

        private String code;

    }

    @Data
    public static class MemberCodeInfo
    {
        private Integer pid;

        private Integer pUserId;

        private String pUserName;

        private String pCode;

    }

    @Data
    public static class OrderMemberInfo
    {
        private Long userId;

        private Integer memberRankId;

    }

    @Data
    public static class PNodeInfo
    {
        private Integer branchId;

        private Integer branchUserId;

        private Integer masterId;

        private Integer masterUserId;

    }

    @Data
    public static class UserBalanceInfo
    {
        private Integer userId;

        private String code;

        private BigDecimal balance;

    }

    @Data
    public static class MasterIdAndDepartId
    {
        private Integer masterId;

        private Integer departId;

    }

    @Data
    public static class RankItem
    {
        private String userName;

        private String imgUrl;

        private Integer num;

    }
}

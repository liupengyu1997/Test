//import com.jd.middleware.model.model.EnumItem;
//
//import java.util.Date;
//
//public class OpbotSchedule {
//    /**
//     * 立即执行的调度
//     */
//    public static final String TYPE_IMMEDIATE = "immediate";
//    /**
//     * 周期性的
//     */
//    public static final String TYPE_PERIOD ="period";
//    /**
//     * 新建状态
//     */
//    public static final  int STATUS_NEW = 1;
//    /**
//     * 执行状态
//     */
//    public static final int STATUS_PROCESSING = 4;
//    /**
//     * 挂起状态
//     */
//    public static final int STATUS_SUSPEND = 5;
//    /**
//     * 部分成功
//     */
//    public static final int STATUS_PART_SUCCESS = 6;
//    /**
//     * 失败状态
//     */
//    public static final int STATUS_FAIL = 7;
//    /**
//     * 成功状态
//     */
//    public static final int STATUS_SUCCESS = 8;
//
//    /**
//     * 取消状态
//     */
//    public static final int STATUS_CANCEL = 9;
//    /**
//     * 主键
//     */
//    protected long id;
//
//    /**
//     * 通知的用户类型
//     */
//    private String applyType;
//
//    /**
//     * 调度类型
//     */
//    private String type;
//
//    /**
//     * 触发器ID
//     */
//    private Long triggerId;
//
//    /**
//     * 触发时间
//     */
//    private Date fireTime;
//
//    /**
//     * 调度任务的成功条数
//     */
//    private int successCount;
//
//    /**
//     * 调度任务的失败条数
//     */
//    private int failCount;
//
//    /**
//     * 调度任务的总等待条数
//     */
//    private int waitCount;
//    /**
//     * 额外的信息，根据不同的申请类型不同JSON内容
//     */
//    private String payload;
//    /**
//     * 审批人信息(可以设置多个审批人，用指定的分割符分割即可)
//     */
//    private String auditor;
//    /**
//     * 父子任务
//     */
//    private boolean parent;
//
//    /**
//     * 状态(默认启用)
//     */
//    protected int status;
//
//    /**
//     * 申请
//     */
//    private long applyId;
//
//    /*
//     * 业务id  一般为spaceId
//     * */
//    private String businessId;
//
//    /*
//     * shardId
//     * */
//    private  String shardId;
//    /**
//     *  拓扑检测开关
//     * */
//    private Boolean checkTopoSwitch;
//    /**
//     * 创建时间
//     */
//    protected Date createTime;
//    /**
//     * 创建人
//     */
//    protected int createBy;
//    /**
//     * 修改时间
//     */
//    protected Date updateTime;
//    /**
//     * 修改人
//     */
//    protected int updateBy;
//
//    public Date getCreateTime() {
//        return createTime;
//    }
//
//    public void setCreateTime(Date createTime) {
//        this.createTime = createTime;
//    }
//
//    public int getCreateBy() {
//        return createBy;
//    }
//
//    public void setCreateBy(int createBy) {
//        this.createBy = createBy;
//    }
//
//    public Date getUpdateTime() {
//        return updateTime;
//    }
//
//    public void setUpdateTime(Date updateTime) {
//        this.updateTime = updateTime;
//    }
//
//    public int getUpdateBy() {
//        return updateBy;
//    }
//
//    public void setUpdateBy(int updateBy) {
//        this.updateBy = updateBy;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public Long getTriggerId() {
//        return triggerId;
//    }
//
//    public void setTriggerId(Long triggerId) {
//        this.triggerId = triggerId;
//    }
//
//    public Date getFireTime() {
//        return fireTime;
//    }
//
//    public void setFireTime(Date fireTime) {
//        this.fireTime = fireTime;
//    }
//
//    public int getSuccessCount() {
//        return successCount;
//    }
//
//    public void setSuccessCount(int successCount) {
//        this.successCount = successCount;
//    }
//
//    public int getFailCount() {
//        return failCount;
//    }
//
//    public void setFailCount(int failCount) {
//        this.failCount = failCount;
//    }
//
//    public int getWaitCount() {
//        return waitCount;
//    }
//
//    public void setWaitCount(int waitCount) {
//        this.waitCount = waitCount;
//    }
//
//    public String getPayload() {
//        return payload;
//    }
//
//    public void setPayload(String payload) {
//        this.payload = payload;
//    }
//
//    public String getAuditor() {
//        return auditor;
//    }
//
//    public void setAuditor(String auditor) {
//        this.auditor = auditor;
//    }
//
//
//
//    public boolean isParent() {
//        return parent;
//    }
//
//    public void setParent(boolean parent) {
//        this.parent = parent;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//
//
//    public Boolean getCheckTopoSwitch() {
//        return checkTopoSwitch;
//    }
//
//    public void setCheckTopoSwitch(Boolean checkTopoSwitch) {
//        this.checkTopoSwitch = checkTopoSwitch;
//    }
//
//
//
//    private int pageIndex;
//    private int startIndex;
//    private int pageSize;
//
//    public String getApplyType() {
//        return applyType;
//    }
//
//    public void setApplyType(String applyType) {
//        this.applyType = applyType;
//    }
//
//    public OpbotSchedule() { }
//
//    public OpbotSchedule(long id) {  this.id = id;    }
//
//    public long getApplyId() {
//        return applyId;
//    }
//
//    public void setApplyId(long applyId) {
//        this.applyId = applyId;
//    }
//
//    public String getBusinessId() {
//        return businessId;
//    }
//
//    public void setBusinessId(String businessId) {
//        this.businessId = businessId;
//    }
//
//    public String getShardId() {
//        return shardId;
//    }
//
//    public void setShardId(String shardId) {
//        this.shardId = shardId;
//    }
//
//    public int getPageIndex() {
//        return pageIndex;
//    }
//
//    public void setPageIndex(int pageIndex) {
//        this.pageIndex = pageIndex;
//    }
//
//    public int getStartIndex() {
//        return startIndex;
//    }
//
//    public void setStartIndex(int startIndex) {
//        this.startIndex = startIndex;
//    }
//
//    public int getPageSize() {
//        return pageSize;
//    }
//
//    public void setPageSize(int pageSize) {
//        this.pageSize = pageSize;
//    }
//
//    public int getStatus() {
//        return status;
//    }
//
//    public void setStatus(int status) {
//        this.status = status;
//    }
//
//    /**
//     * Schedule的状态枚举
//     */
//    public enum Status implements EnumItem {
//        /**
//         * 新建
//         */
//        NEW(STATUS_NEW, "新建"),
//        /**
//         * 正在执行
//         */
//        PROCESSING(STATUS_PROCESSING, "正在执行"),
//        /**
//         * 执行中断
//         */
//        SUSPEND(STATUS_SUSPEND, "执行中断"),
//        /**
//         * 部分成功
//         */
//        PART_SUCCESS(STATUS_PART_SUCCESS, "部分成功"),
//        /**
//         * 失败
//         */
//        FAIL(STATUS_FAIL, "失败"),
//        /**
//         * 成功
//         */
//        SUCCESS(STATUS_SUCCESS, "成功"),
//
//        CANCEL(STATUS_CANCEL,"取消");
//
//        /**
//         * 申请状态值
//         */
//        private int value;
//
//        /**
//         * 申请状态描述
//         */
//        private String description;
//
//        /**
//         * 构造函数
//         *
//         * @param value       值
//         * @param description 描述
//         */
//        Status(int value, String description) {
//            this.value = value;
//            this.description = description;
//        }
//
//
//
//
//        /**
//         * 工厂方法。将调度状态值转变为{@code Schedule.Status}
//         *
//         * @param value 值
//         *
//         * @return 申请状态枚举。如果{@code value}为定义，返回 null
//         */
//        public static Status valueOf(int value) {
//            switch (value) {
//                case STATUS_NEW:
//                    return NEW;
//                case STATUS_PROCESSING:
//                    return PROCESSING;
//                case STATUS_SUSPEND:
//                    return SUSPEND;
//                case STATUS_PART_SUCCESS:
//                    return PART_SUCCESS;
//                case STATUS_FAIL:
//                    return FAIL;
//                case STATUS_SUCCESS:
//                    return SUCCESS;
//                case STATUS_CANCEL:
//                    return CANCEL;
//                default:
//                    return null;
//            }
//        }
//
//        @Override
//        public int value() {
//            return value;
//        }
//
//        @Override
//        public String description() {
//            return description;
//        }
//    }
//
//
//}

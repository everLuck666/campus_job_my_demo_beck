package net.seehope.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "`station`")
public class Station implements Serializable {
    /**
     * 主键
     */
    @Id
    @Column(name = "`id`")
    private String id;

    /**
     * 岗位名称
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 行业
     */
    @Column(name = "`industry`")
    private String industry;

    /**
     * 上班地点
     */
    @Column(name = "`address`")
    private String address;

    /**
     * 学历要求 0本科及以上 1研究生及以上 3专科生及以上
     */
    @Column(name = "`education`")
    private String education;

    /**
     * 岗位要求
     */
    @Column(name = "`demand`")
    private String demand;

    /**
     * 招聘人数
     */
    @Column(name = "`num`")
    private Integer num;

    /**
     * 工资最低
     */
    @Column(name = "`salary_min`")
    private Long salaryMin;

    /**
     * 工资最高
     */
    @Column(name = "`salary_max`")
    private Long salaryMax;

    /**
     * 企业名
     */
    @Column(name = "`enterprise_id`")
    private String enterpriseId;

    @Column(name = "`provider_phone`")
    private String providerPhone;

    /**
     * 开始上班时间
     */
    @Column(name = "`work_begin`")
    private Date workBegin;

    /**
     * 结束上班时间
     */
    @Column(name = "`work_end`")
    private Date workEnd;

    /**
     * 职责
     */
    @Column(name = "`responsibility`")
    private String responsibility;

    /**
     * 状态
     */
    @Column(name = "`status`")
    private Integer status;

    @Column(name = "`create_time`")
    private Date createTime;

    @Column(name = "`update_time`")
    private Date updateTime;

    /**
     * 删除标识，0未删，1删除
     */
    @Column(name = "`delete_flag`")
    private Short deleteFlag;

    /**
     * 月份
     */
    @Column(name = "`month`")
    private Integer month;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取岗位名称
     *
     * @return name - 岗位名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置岗位名称
     *
     * @param name 岗位名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取行业
     *
     * @return industry - 行业
     */
    public String getIndustry() {
        return industry;
    }

    /**
     * 设置行业
     *
     * @param industry 行业
     */
    public void setIndustry(String industry) {
        this.industry = industry;
    }

    /**
     * 获取上班地点
     *
     * @return address - 上班地点
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置上班地点
     *
     * @param address 上班地点
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取学历要求 0本科及以上 1研究生及以上 3专科生及以上
     *
     * @return education - 学历要求 0本科及以上 1研究生及以上 3专科生及以上
     */
    public String getEducation() {
        return education;
    }

    /**
     * 设置学历要求 0本科及以上 1研究生及以上 3专科生及以上
     *
     * @param education 学历要求 0本科及以上 1研究生及以上 3专科生及以上
     */
    public void setEducation(String education) {
        this.education = education;
    }

    /**
     * 获取岗位要求
     *
     * @return demand - 岗位要求
     */
    public String getDemand() {
        return demand;
    }

    /**
     * 设置岗位要求
     *
     * @param demand 岗位要求
     */
    public void setDemand(String demand) {
        this.demand = demand;
    }

    /**
     * 获取招聘人数
     *
     * @return num - 招聘人数
     */
    public Integer getNum() {
        return num;
    }

    /**
     * 设置招聘人数
     *
     * @param num 招聘人数
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * 获取工资最低
     *
     * @return salary_min - 工资最低
     */
    public Long getSalaryMin() {
        return salaryMin;
    }

    /**
     * 设置工资最低
     *
     * @param salaryMin 工资最低
     */
    public void setSalaryMin(Long salaryMin) {
        this.salaryMin = salaryMin;
    }

    /**
     * 获取工资最高
     *
     * @return salary_max - 工资最高
     */
    public Long getSalaryMax() {
        return salaryMax;
    }

    /**
     * 设置工资最高
     *
     * @param salaryMax 工资最高
     */
    public void setSalaryMax(Long salaryMax) {
        this.salaryMax = salaryMax;
    }

    /**
     * 获取企业名
     *
     * @return enterprise_id - 企业名
     */
    public String getEnterpriseId() {
        return enterpriseId;
    }

    /**
     * 设置企业名
     *
     * @param enterpriseId 企业名
     */
    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    /**
     * @return provider_phone
     */
    public String getProviderPhone() {
        return providerPhone;
    }

    /**
     * @param providerPhone
     */
    public void setProviderPhone(String providerPhone) {
        this.providerPhone = providerPhone;
    }

    /**
     * 获取开始上班时间
     *
     * @return work_begin - 开始上班时间
     */
    public Date getWorkBegin() {
        return workBegin;
    }

    /**
     * 设置开始上班时间
     *
     * @param workBegin 开始上班时间
     */
    public void setWorkBegin(Date workBegin) {
        this.workBegin = workBegin;
    }

    /**
     * 获取结束上班时间
     *
     * @return work_end - 结束上班时间
     */
    public Date getWorkEnd() {
        return workEnd;
    }

    /**
     * 设置结束上班时间
     *
     * @param workEnd 结束上班时间
     */
    public void setWorkEnd(Date workEnd) {
        this.workEnd = workEnd;
    }

    /**
     * 获取职责
     *
     * @return responsibility - 职责
     */
    public String getResponsibility() {
        return responsibility;
    }

    /**
     * 设置职责
     *
     * @param responsibility 职责
     */
    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取删除标识，0未删，1删除
     *
     * @return delete_flag - 删除标识，0未删，1删除
     */
    public Short getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置删除标识，0未删，1删除
     *
     * @param deleteFlag 删除标识，0未删，1删除
     */
    public void setDeleteFlag(Short deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    /**
     * 获取月份
     *
     * @return month - 月份
     */
    public Integer getMonth() {
        return month;
    }

    /**
     * 设置月份
     *
     * @param month 月份
     */
    public void setMonth(Integer month) {
        this.month = month;
    }
}
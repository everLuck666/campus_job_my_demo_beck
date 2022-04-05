package net.seehope.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "`schoolmanager`")
public class Schoolmanager implements Serializable {
    /**
     * 主键
     */
    @Id
    @Column(name = "`id`")
    private String id;

    /**
     * 用户实名
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 手机号码
     */
    @Column(name = "`phone`")
    private String phone;

    @Column(name = "`delete_flag`")
    private Short deleteFlag;

    @Column(name = "`department`")
    private String department;

    /**
     * 入职时间
     */
    @Column(name = "`hiredate`")
    private Date hiredate;

    /**
     * 累计审核岗位数量
     */
    @Column(name = "`job_num`")
    private Integer jobNum;

    /**
     * 累计审核公司数量
     */
    @Column(name = "`company_num`")
    private Integer companyNum;

    /**
     * 年龄
     */
    @Column(name = "`ages`")
    private Integer ages;

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
     * 获取用户实名
     *
     * @return name - 用户实名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置用户实名
     *
     * @param name 用户实名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取手机号码
     *
     * @return phone - 手机号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号码
     *
     * @param phone 手机号码
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return delete_flag
     */
    public Short getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * @param deleteFlag
     */
    public void setDeleteFlag(Short deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    /**
     * @return department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * @param department
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * 获取入职时间
     *
     * @return hiredate - 入职时间
     */
    public Date getHiredate() {
        return hiredate;
    }

    /**
     * 设置入职时间
     *
     * @param hiredate 入职时间
     */
    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    /**
     * 获取累计审核岗位数量
     *
     * @return job_num - 累计审核岗位数量
     */
    public Integer getJobNum() {
        return jobNum;
    }

    /**
     * 设置累计审核岗位数量
     *
     * @param jobNum 累计审核岗位数量
     */
    public void setJobNum(Integer jobNum) {
        this.jobNum = jobNum;
    }

    /**
     * 获取累计审核公司数量
     *
     * @return company_num - 累计审核公司数量
     */
    public Integer getCompanyNum() {
        return companyNum;
    }

    /**
     * 设置累计审核公司数量
     *
     * @param companyNum 累计审核公司数量
     */
    public void setCompanyNum(Integer companyNum) {
        this.companyNum = companyNum;
    }

    /**
     * 获取年龄
     *
     * @return ages - 年龄
     */
    public Integer getAges() {
        return ages;
    }

    /**
     * 设置年龄
     *
     * @param ages 年龄
     */
    public void setAges(Integer ages) {
        this.ages = ages;
    }
}
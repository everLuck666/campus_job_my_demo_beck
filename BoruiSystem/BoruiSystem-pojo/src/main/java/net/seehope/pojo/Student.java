package net.seehope.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "`student`")
public class Student implements Serializable {
    /**
     * 学号
     */
    @Column(name = "`sno`")
    private String sno;

    /**
     * 学校名字
     */
    @Column(name = "`school_name`")
    private String schoolName;

    /**
     * 手机号码
     */
    @Column(name = "`phone`")
    private String phone;

    /**
     * 实习经历
     */
    @Column(name = "`achieve`")
    private String achieve;

    /**
     * 爱好
     */
    @Column(name = "`hobby`")
    private String hobby;

    /**
     * 是否是应届生
     */
    @Column(name = "`graduate`")
    private Short graduate;

    /**
     * 是否存在就业困难
     */
    @Column(name = "`is_hard`")
    private Short isHard;

    /**
     * 座右铭
     */
    @Column(name = "`mutto`")
    private String mutto;

    @Column(name = "`update_time`")
    private Date updateTime;

    @Column(name = "`delete_flag`")
    private Short deleteFlag;

    /**
     * 姓名
     */
    @Column(name = "`user_name`")
    private String userName;

    /**
     * 上学开始时间
     */
    @Column(name = "`begin_school_time`")
    private Date beginSchoolTime;

    /**
     * 项目经历
     */
    @Column(name = "`project`")
    private String project;

    @Column(name = "`intention`")
    private String intention;

    private static final long serialVersionUID = 1L;

    /**
     * 获取学号
     *
     * @return sno - 学号
     */
    public String getSno() {
        return sno;
    }

    /**
     * 设置学号
     *
     * @param sno 学号
     */
    public void setSno(String sno) {
        this.sno = sno;
    }

    /**
     * 获取学校名字
     *
     * @return school_name - 学校名字
     */
    public String getSchoolName() {
        return schoolName;
    }

    /**
     * 设置学校名字
     *
     * @param schoolName 学校名字
     */
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
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
     * 获取实习经历
     *
     * @return achieve - 实习经历
     */
    public String getAchieve() {
        return achieve;
    }

    /**
     * 设置实习经历
     *
     * @param achieve 实习经历
     */
    public void setAchieve(String achieve) {
        this.achieve = achieve;
    }

    /**
     * 获取爱好
     *
     * @return hobby - 爱好
     */
    public String getHobby() {
        return hobby;
    }

    /**
     * 设置爱好
     *
     * @param hobby 爱好
     */
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    /**
     * 获取是否是应届生
     *
     * @return graduate - 是否是应届生
     */
    public Short getGraduate() {
        return graduate;
    }

    /**
     * 设置是否是应届生
     *
     * @param graduate 是否是应届生
     */
    public void setGraduate(Short graduate) {
        this.graduate = graduate;
    }

    /**
     * 获取是否存在就业困难
     *
     * @return is_hard - 是否存在就业困难
     */
    public Short getIsHard() {
        return isHard;
    }

    /**
     * 设置是否存在就业困难
     *
     * @param isHard 是否存在就业困难
     */
    public void setIsHard(Short isHard) {
        this.isHard = isHard;
    }

    /**
     * 获取座右铭
     *
     * @return mutto - 座右铭
     */
    public String getMutto() {
        return mutto;
    }

    /**
     * 设置座右铭
     *
     * @param mutto 座右铭
     */
    public void setMutto(String mutto) {
        this.mutto = mutto;
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
     * 获取姓名
     *
     * @return user_name - 姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置姓名
     *
     * @param userName 姓名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取上学开始时间
     *
     * @return begin_school_time - 上学开始时间
     */
    public Date getBeginSchoolTime() {
        return beginSchoolTime;
    }

    /**
     * 设置上学开始时间
     *
     * @param beginSchoolTime 上学开始时间
     */
    public void setBeginSchoolTime(Date beginSchoolTime) {
        this.beginSchoolTime = beginSchoolTime;
    }

    /**
     * 获取项目经历
     *
     * @return project - 项目经历
     */
    public String getProject() {
        return project;
    }

    /**
     * 设置项目经历
     *
     * @param project 项目经历
     */
    public void setProject(String project) {
        this.project = project;
    }

    /**
     * @return intention
     */
    public String getIntention() {
        return intention;
    }

    /**
     * @param intention
     */
    public void setIntention(String intention) {
        this.intention = intention;
    }
}
package net.seehope.pojo.vo;

import javax.persistence.Column;
import java.util.Date;

public class InterestJobVo {
    private String time;




    private String sno;

    /**
     * 学校名字
     */
    private String schoolName;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 实习经历
     */
    private String achieve;

    /**
     * 爱好
     */
    private String hobby;

    /**
     * 是否是应届生
     */
    private Short graduate;

    /**
     * 是否存在就业困难
     */
    private Short isHard;

    /**
     * 座右铭
     */
    private String mutto;

    private Date updateTime;

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

    private String status;

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAchieve() {
        return achieve;
    }

    public void setAchieve(String achieve) {
        this.achieve = achieve;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Short getGraduate() {
        return graduate;
    }

    public void setGraduate(Short graduate) {
        this.graduate = graduate;
    }

    public Short getIsHard() {
        return isHard;
    }

    public void setIsHard(Short isHard) {
        this.isHard = isHard;
    }

    public String getMutto() {
        return mutto;
    }

    public void setMutto(String mutto) {
        this.mutto = mutto;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Short getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Short deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getBeginSchoolTime() {
        return beginSchoolTime;
    }

    public void setBeginSchoolTime(Date beginSchoolTime) {
        this.beginSchoolTime = beginSchoolTime;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

package net.seehope.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "`apply`")
public class Apply implements Serializable {
    @Id
    @Column(name = "`id`")
    private Integer id;

    /**
     * 学生id
     */
    @Column(name = "`student_id`")
    private String studentId;

    /**
     * 岗位id
     */
    @Column(name = "`station_id`")
    private String stationId;

    /**
     * 鐘舵€? 0鏈鏍革紝1宸插鏍?
     */
    @Column(name = "`status`")
    private String status;

    /**
     * 创建时间
     */
    @Column(name = "`create_time`")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "`update_time`")
    private Date updateTime;

    /**
     * 0未删 1删除
     */
    @Column(name = "`delete_flag`")
    private Short deleteFlag;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取学生id
     *
     * @return student_id - 学生id
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * 设置学生id
     *
     * @param studentId 学生id
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * 获取岗位id
     *
     * @return station_id - 岗位id
     */
    public String getStationId() {
        return stationId;
    }

    /**
     * 设置岗位id
     *
     * @param stationId 岗位id
     */
    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    /**
     * 获取鐘舵€? 0鏈鏍革紝1宸插鏍?
     *
     * @return status - 鐘舵€? 0鏈鏍革紝1宸插鏍?
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置鐘舵€? 0鏈鏍革紝1宸插鏍?
     *
     * @param status 鐘舵€? 0鏈鏍革紝1宸插鏍?
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取0未删 1删除
     *
     * @return delete_flag - 0未删 1删除
     */
    public Short getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置0未删 1删除
     *
     * @param deleteFlag 0未删 1删除
     */
    public void setDeleteFlag(Short deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
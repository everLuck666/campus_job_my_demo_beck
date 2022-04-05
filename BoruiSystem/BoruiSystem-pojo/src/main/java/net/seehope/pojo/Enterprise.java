package net.seehope.pojo;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "`enterprise`")
public class Enterprise implements Serializable {
    @Id
    @Column(name = "`id`")
    private String id;

    /**
     * 机构名称
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 图片url
     */
    @Column(name = "`img`")
    private String img;

    /**
     * 审核状态
     */
    @Column(name = "`status`")
    private Integer status;

    /**
     * 提供方类型，个人，企业，学校机构
     */
    @Column(name = "`type`")
    private String type;

    /**
     * 介绍信息
     */
    @Column(name = "`info`")
    private String info;

    @Column(name = "`delete_flag`")
    private String deleteFlag;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取机构名称
     *
     * @return name - 机构名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置机构名称
     *
     * @param name 机构名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取图片url
     *
     * @return img - 图片url
     */
    public String getImg() {
        return img;
    }

    /**
     * 设置图片url
     *
     * @param img 图片url
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * 获取审核状态
     *
     * @return status - 审核状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置审核状态
     *
     * @param status 审核状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取提供方类型，个人，企业，学校机构
     *
     * @return type - 提供方类型，个人，企业，学校机构
     */
    public String getType() {
        return type;
    }

    /**
     * 设置提供方类型，个人，企业，学校机构
     *
     * @param type 提供方类型，个人，企业，学校机构
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取介绍信息
     *
     * @return info - 介绍信息
     */
    public String getInfo() {
        return info;
    }

    /**
     * 设置介绍信息
     *
     * @param info 介绍信息
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * @return delete_flag
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * @param deleteFlag
     */
    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
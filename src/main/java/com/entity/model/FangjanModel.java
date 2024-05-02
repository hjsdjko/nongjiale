package com.entity.model;

import com.entity.FangjanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 房间信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FangjanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 商家
     */
    private Integer shangjiaId;


    /**
     * 房间标题
     */
    private String fangjanName;


    /**
     * 房间类型
     */
    private Integer fangjanTypes;


    /**
     * 房间照片
     */
    private String fangjanPhoto;


    /**
     * 房间原价
     */
    private Double fangjanOldMoney;


    /**
     * 现价
     */
    private Double fangjanNewMoney;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer fangjanDelete;


    /**
     * 房间简介
     */
    private String fangjanContent;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：商家
	 */
    public Integer getShangjiaId() {
        return shangjiaId;
    }


    /**
	 * 设置：商家
	 */
    public void setShangjiaId(Integer shangjiaId) {
        this.shangjiaId = shangjiaId;
    }
    /**
	 * 获取：房间标题
	 */
    public String getFangjanName() {
        return fangjanName;
    }


    /**
	 * 设置：房间标题
	 */
    public void setFangjanName(String fangjanName) {
        this.fangjanName = fangjanName;
    }
    /**
	 * 获取：房间类型
	 */
    public Integer getFangjanTypes() {
        return fangjanTypes;
    }


    /**
	 * 设置：房间类型
	 */
    public void setFangjanTypes(Integer fangjanTypes) {
        this.fangjanTypes = fangjanTypes;
    }
    /**
	 * 获取：房间照片
	 */
    public String getFangjanPhoto() {
        return fangjanPhoto;
    }


    /**
	 * 设置：房间照片
	 */
    public void setFangjanPhoto(String fangjanPhoto) {
        this.fangjanPhoto = fangjanPhoto;
    }
    /**
	 * 获取：房间原价
	 */
    public Double getFangjanOldMoney() {
        return fangjanOldMoney;
    }


    /**
	 * 设置：房间原价
	 */
    public void setFangjanOldMoney(Double fangjanOldMoney) {
        this.fangjanOldMoney = fangjanOldMoney;
    }
    /**
	 * 获取：现价
	 */
    public Double getFangjanNewMoney() {
        return fangjanNewMoney;
    }


    /**
	 * 设置：现价
	 */
    public void setFangjanNewMoney(Double fangjanNewMoney) {
        this.fangjanNewMoney = fangjanNewMoney;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 设置：是否上架
	 */
    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getFangjanDelete() {
        return fangjanDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setFangjanDelete(Integer fangjanDelete) {
        this.fangjanDelete = fangjanDelete;
    }
    /**
	 * 获取：房间简介
	 */
    public String getFangjanContent() {
        return fangjanContent;
    }


    /**
	 * 设置：房间简介
	 */
    public void setFangjanContent(String fangjanContent) {
        this.fangjanContent = fangjanContent;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }

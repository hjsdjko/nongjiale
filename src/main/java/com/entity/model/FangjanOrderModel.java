package com.entity.model;

import com.entity.FangjanOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 房间订单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FangjanOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 订单号
     */
    private String fangjanOrderUuidNumber;


    /**
     * 房间
     */
    private Integer fangjanId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 预定时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date fangjanTime;


    /**
     * 订单类型
     */
    private Integer fangjanOrderTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3
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
	 * 获取：订单号
	 */
    public String getFangjanOrderUuidNumber() {
        return fangjanOrderUuidNumber;
    }


    /**
	 * 设置：订单号
	 */
    public void setFangjanOrderUuidNumber(String fangjanOrderUuidNumber) {
        this.fangjanOrderUuidNumber = fangjanOrderUuidNumber;
    }
    /**
	 * 获取：房间
	 */
    public Integer getFangjanId() {
        return fangjanId;
    }


    /**
	 * 设置：房间
	 */
    public void setFangjanId(Integer fangjanId) {
        this.fangjanId = fangjanId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：预定时间
	 */
    public Date getFangjanTime() {
        return fangjanTime;
    }


    /**
	 * 设置：预定时间
	 */
    public void setFangjanTime(Date fangjanTime) {
        this.fangjanTime = fangjanTime;
    }
    /**
	 * 获取：订单类型
	 */
    public Integer getFangjanOrderTypes() {
        return fangjanOrderTypes;
    }


    /**
	 * 设置：订单类型
	 */
    public void setFangjanOrderTypes(Integer fangjanOrderTypes) {
        this.fangjanOrderTypes = fangjanOrderTypes;
    }
    /**
	 * 获取：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：订单创建时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }

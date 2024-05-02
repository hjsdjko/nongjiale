package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 房间订单
 *
 * @author 
 * @email
 */
@TableName("fangjan_order")
public class FangjanOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public FangjanOrderEntity() {

	}

	public FangjanOrderEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 订单号
     */
    @TableField(value = "fangjan_order_uuid_number")

    private String fangjanOrderUuidNumber;


    /**
     * 房间
     */
    @TableField(value = "fangjan_id")

    private Integer fangjanId;


    /**
     * 用户
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 预定时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "fangjan_time")

    private Date fangjanTime;


    /**
     * 订单类型
     */
    @TableField(value = "fangjan_order_types")

    private Integer fangjanOrderTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：订单号
	 */
    public String getFangjanOrderUuidNumber() {
        return fangjanOrderUuidNumber;
    }


    /**
	 * 获取：订单号
	 */

    public void setFangjanOrderUuidNumber(String fangjanOrderUuidNumber) {
        this.fangjanOrderUuidNumber = fangjanOrderUuidNumber;
    }
    /**
	 * 设置：房间
	 */
    public Integer getFangjanId() {
        return fangjanId;
    }


    /**
	 * 获取：房间
	 */

    public void setFangjanId(Integer fangjanId) {
        this.fangjanId = fangjanId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：预定时间
	 */
    public Date getFangjanTime() {
        return fangjanTime;
    }


    /**
	 * 获取：预定时间
	 */

    public void setFangjanTime(Date fangjanTime) {
        this.fangjanTime = fangjanTime;
    }
    /**
	 * 设置：订单类型
	 */
    public Integer getFangjanOrderTypes() {
        return fangjanOrderTypes;
    }


    /**
	 * 获取：订单类型
	 */

    public void setFangjanOrderTypes(Integer fangjanOrderTypes) {
        this.fangjanOrderTypes = fangjanOrderTypes;
    }
    /**
	 * 设置：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "FangjanOrder{" +
            "id=" + id +
            ", fangjanOrderUuidNumber=" + fangjanOrderUuidNumber +
            ", fangjanId=" + fangjanId +
            ", yonghuId=" + yonghuId +
            ", fangjanTime=" + fangjanTime +
            ", fangjanOrderTypes=" + fangjanOrderTypes +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}

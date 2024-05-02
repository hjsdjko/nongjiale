package com.entity.vo;

import com.entity.FangjanOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 房间订单
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("fangjan_order")
public class FangjanOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
	 * 设置：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

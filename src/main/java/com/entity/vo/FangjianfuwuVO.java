package com.entity.vo;

import com.entity.FangjianfuwuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 房间服务
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("fangjianfuwu")
public class FangjianfuwuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


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
     * 服务类型
     */

    @TableField(value = "fangjianfuwu_types")
    private Integer fangjianfuwuTypes;


    /**
     * 预定时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "fangjianfuwu_time")
    private Date fangjianfuwuTime;


    /**
     * 创建时间
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
	 * 设置：服务类型
	 */
    public Integer getFangjianfuwuTypes() {
        return fangjianfuwuTypes;
    }


    /**
	 * 获取：服务类型
	 */

    public void setFangjianfuwuTypes(Integer fangjianfuwuTypes) {
        this.fangjianfuwuTypes = fangjianfuwuTypes;
    }
    /**
	 * 设置：预定时间
	 */
    public Date getFangjianfuwuTime() {
        return fangjianfuwuTime;
    }


    /**
	 * 获取：预定时间
	 */

    public void setFangjianfuwuTime(Date fangjianfuwuTime) {
        this.fangjianfuwuTime = fangjianfuwuTime;
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

}

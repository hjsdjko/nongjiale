package com.entity.vo;

import com.entity.FangjanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 房间信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("fangjan")
public class FangjanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 商家
     */

    @TableField(value = "shangjia_id")
    private Integer shangjiaId;


    /**
     * 房间标题
     */

    @TableField(value = "fangjan_name")
    private String fangjanName;


    /**
     * 房间类型
     */

    @TableField(value = "fangjan_types")
    private Integer fangjanTypes;


    /**
     * 房间照片
     */

    @TableField(value = "fangjan_photo")
    private String fangjanPhoto;


    /**
     * 房间原价
     */

    @TableField(value = "fangjan_old_money")
    private Double fangjanOldMoney;


    /**
     * 现价
     */

    @TableField(value = "fangjan_new_money")
    private Double fangjanNewMoney;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "fangjan_delete")
    private Integer fangjanDelete;


    /**
     * 房间简介
     */

    @TableField(value = "fangjan_content")
    private String fangjanContent;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：商家
	 */
    public Integer getShangjiaId() {
        return shangjiaId;
    }


    /**
	 * 获取：商家
	 */

    public void setShangjiaId(Integer shangjiaId) {
        this.shangjiaId = shangjiaId;
    }
    /**
	 * 设置：房间标题
	 */
    public String getFangjanName() {
        return fangjanName;
    }


    /**
	 * 获取：房间标题
	 */

    public void setFangjanName(String fangjanName) {
        this.fangjanName = fangjanName;
    }
    /**
	 * 设置：房间类型
	 */
    public Integer getFangjanTypes() {
        return fangjanTypes;
    }


    /**
	 * 获取：房间类型
	 */

    public void setFangjanTypes(Integer fangjanTypes) {
        this.fangjanTypes = fangjanTypes;
    }
    /**
	 * 设置：房间照片
	 */
    public String getFangjanPhoto() {
        return fangjanPhoto;
    }


    /**
	 * 获取：房间照片
	 */

    public void setFangjanPhoto(String fangjanPhoto) {
        this.fangjanPhoto = fangjanPhoto;
    }
    /**
	 * 设置：房间原价
	 */
    public Double getFangjanOldMoney() {
        return fangjanOldMoney;
    }


    /**
	 * 获取：房间原价
	 */

    public void setFangjanOldMoney(Double fangjanOldMoney) {
        this.fangjanOldMoney = fangjanOldMoney;
    }
    /**
	 * 设置：现价
	 */
    public Double getFangjanNewMoney() {
        return fangjanNewMoney;
    }


    /**
	 * 获取：现价
	 */

    public void setFangjanNewMoney(Double fangjanNewMoney) {
        this.fangjanNewMoney = fangjanNewMoney;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getFangjanDelete() {
        return fangjanDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setFangjanDelete(Integer fangjanDelete) {
        this.fangjanDelete = fangjanDelete;
    }
    /**
	 * 设置：房间简介
	 */
    public String getFangjanContent() {
        return fangjanContent;
    }


    /**
	 * 获取：房间简介
	 */

    public void setFangjanContent(String fangjanContent) {
        this.fangjanContent = fangjanContent;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

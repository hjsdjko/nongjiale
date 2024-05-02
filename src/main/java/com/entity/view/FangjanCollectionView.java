package com.entity.view;

import com.entity.FangjanCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 房间收藏
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("fangjan_collection")
public class FangjanCollectionView extends FangjanCollectionEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 类型的值
		*/
		private String fangjanCollectionValue;



		//级联表 fangjan
			/**
			* 房间标题
			*/
			private String fangjanName;
			/**
			* 房间类型
			*/
			private Integer fangjanTypes;
				/**
				* 房间类型的值
				*/
				private String fangjanValue;
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
				* 是否上架的值
				*/
				private String shangxiaValue;
			/**
			* 逻辑删除
			*/
			private Integer fangjanDelete;
			/**
			* 房间简介
			*/
			private String fangjanContent;

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 头像
			*/
			private String yonghuPhoto;
			/**
			* 用户手机号
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 余额
			*/
			private Double newMoney;
			/**
			* 假删
			*/
			private Integer yonghuDelete;

	public FangjanCollectionView() {

	}

	public FangjanCollectionView(FangjanCollectionEntity fangjanCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, fangjanCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 类型的值
			*/
			public String getFangjanCollectionValue() {
				return fangjanCollectionValue;
			}
			/**
			* 设置： 类型的值
			*/
			public void setFangjanCollectionValue(String fangjanCollectionValue) {
				this.fangjanCollectionValue = fangjanCollectionValue;
			}







				//级联表的get和set fangjan
					/**
					* 获取： 房间标题
					*/
					public String getFangjanName() {
						return fangjanName;
					}
					/**
					* 设置： 房间标题
					*/
					public void setFangjanName(String fangjanName) {
						this.fangjanName = fangjanName;
					}
					/**
					* 获取： 房间类型
					*/
					public Integer getFangjanTypes() {
						return fangjanTypes;
					}
					/**
					* 设置： 房间类型
					*/
					public void setFangjanTypes(Integer fangjanTypes) {
						this.fangjanTypes = fangjanTypes;
					}


						/**
						* 获取： 房间类型的值
						*/
						public String getFangjanValue() {
							return fangjanValue;
						}
						/**
						* 设置： 房间类型的值
						*/
						public void setFangjanValue(String fangjanValue) {
							this.fangjanValue = fangjanValue;
						}
					/**
					* 获取： 房间照片
					*/
					public String getFangjanPhoto() {
						return fangjanPhoto;
					}
					/**
					* 设置： 房间照片
					*/
					public void setFangjanPhoto(String fangjanPhoto) {
						this.fangjanPhoto = fangjanPhoto;
					}
					/**
					* 获取： 房间原价
					*/
					public Double getFangjanOldMoney() {
						return fangjanOldMoney;
					}
					/**
					* 设置： 房间原价
					*/
					public void setFangjanOldMoney(Double fangjanOldMoney) {
						this.fangjanOldMoney = fangjanOldMoney;
					}
					/**
					* 获取： 现价
					*/
					public Double getFangjanNewMoney() {
						return fangjanNewMoney;
					}
					/**
					* 设置： 现价
					*/
					public void setFangjanNewMoney(Double fangjanNewMoney) {
						this.fangjanNewMoney = fangjanNewMoney;
					}
					/**
					* 获取： 是否上架
					*/
					public Integer getShangxiaTypes() {
						return shangxiaTypes;
					}
					/**
					* 设置： 是否上架
					*/
					public void setShangxiaTypes(Integer shangxiaTypes) {
						this.shangxiaTypes = shangxiaTypes;
					}


						/**
						* 获取： 是否上架的值
						*/
						public String getShangxiaValue() {
							return shangxiaValue;
						}
						/**
						* 设置： 是否上架的值
						*/
						public void setShangxiaValue(String shangxiaValue) {
							this.shangxiaValue = shangxiaValue;
						}
					/**
					* 获取： 逻辑删除
					*/
					public Integer getFangjanDelete() {
						return fangjanDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setFangjanDelete(Integer fangjanDelete) {
						this.fangjanDelete = fangjanDelete;
					}
					/**
					* 获取： 房间简介
					*/
					public String getFangjanContent() {
						return fangjanContent;
					}
					/**
					* 设置： 房间简介
					*/
					public void setFangjanContent(String fangjanContent) {
						this.fangjanContent = fangjanContent;
					}






















				//级联表的get和set yonghu
					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}
					/**
					* 获取： 头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}
					/**
					* 获取： 用户手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 用户手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}
					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}
					/**
					* 获取： 余额
					*/
					public Double getNewMoney() {
						return newMoney;
					}
					/**
					* 设置： 余额
					*/
					public void setNewMoney(Double newMoney) {
						this.newMoney = newMoney;
					}
					/**
					* 获取： 假删
					*/
					public Integer getYonghuDelete() {
						return yonghuDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setYonghuDelete(Integer yonghuDelete) {
						this.yonghuDelete = yonghuDelete;
					}



}

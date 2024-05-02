package com.dao;

import com.entity.FangjianfuwuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.FangjianfuwuView;

/**
 * 房间服务 Dao 接口
 *
 * @author 
 */
public interface FangjianfuwuDao extends BaseMapper<FangjianfuwuEntity> {

   List<FangjianfuwuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

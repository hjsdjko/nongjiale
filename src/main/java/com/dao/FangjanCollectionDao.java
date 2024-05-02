package com.dao;

import com.entity.FangjanCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.FangjanCollectionView;

/**
 * 房间收藏 Dao 接口
 *
 * @author 
 */
public interface FangjanCollectionDao extends BaseMapper<FangjanCollectionEntity> {

   List<FangjanCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

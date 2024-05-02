package com.dao;

import com.entity.FangjanCommentbackEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.FangjanCommentbackView;

/**
 * 房间评论 Dao 接口
 *
 * @author 
 */
public interface FangjanCommentbackDao extends BaseMapper<FangjanCommentbackEntity> {

   List<FangjanCommentbackView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

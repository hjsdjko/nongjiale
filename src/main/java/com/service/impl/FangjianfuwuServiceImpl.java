package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import com.dao.FangjianfuwuDao;
import com.entity.FangjianfuwuEntity;
import com.service.FangjianfuwuService;
import com.entity.view.FangjianfuwuView;

/**
 * 房间服务 服务实现类
 */
@Service("fangjianfuwuService")
@Transactional
public class FangjianfuwuServiceImpl extends ServiceImpl<FangjianfuwuDao, FangjianfuwuEntity> implements FangjianfuwuService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<FangjianfuwuView> page =new Query<FangjianfuwuView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}

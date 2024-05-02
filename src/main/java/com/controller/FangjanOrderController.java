










package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 房间订单
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/fangjanOrder")
public class FangjanOrderController {
    private static final Logger logger = LoggerFactory.getLogger(FangjanOrderController.class);

    @Autowired
    private FangjanOrderService fangjanOrderService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private FangjanService fangjanService;
    @Autowired
    private YonghuService yonghuService;
@Autowired
private FangjanCommentbackService fangjanCommentbackService;
@Autowired
private ShangjiaService shangjiaService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("商家".equals(role))
            params.put("shangjiaId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = fangjanOrderService.queryPage(params);

        //字典表数据转换
        List<FangjanOrderView> list =(List<FangjanOrderView>)page.getList();
        for(FangjanOrderView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FangjanOrderEntity fangjanOrder = fangjanOrderService.selectById(id);
        if(fangjanOrder !=null){
            //entity转view
            FangjanOrderView view = new FangjanOrderView();
            BeanUtils.copyProperties( fangjanOrder , view );//把实体数据重构到view中

                //级联表
                FangjanEntity fangjan = fangjanService.selectById(fangjanOrder.getFangjanId());
                if(fangjan != null){
                    BeanUtils.copyProperties( fangjan , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setFangjanId(fangjan.getId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(fangjanOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody FangjanOrderEntity fangjanOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,fangjanOrder:{}",this.getClass().getName(),fangjanOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("用户".equals(role))
            fangjanOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        fangjanOrder.setInsertTime(new Date());
        fangjanOrder.setCreateTime(new Date());
        fangjanOrderService.insert(fangjanOrder);
        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody FangjanOrderEntity fangjanOrder, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,fangjanOrder:{}",this.getClass().getName(),fangjanOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(StringUtil.isEmpty(role))
//            return R.error(511,"权限为空");
//        else if("用户".equals(role))
//            fangjanOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<FangjanOrderEntity> queryWrapper = new EntityWrapper<FangjanOrderEntity>()
            .eq("id",0)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FangjanOrderEntity fangjanOrderEntity = fangjanOrderService.selectOne(queryWrapper);
        if(fangjanOrderEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      fangjanOrder.set
            //  }
            fangjanOrderService.updateById(fangjanOrder);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        fangjanOrderService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<FangjanOrderEntity> fangjanOrderList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            FangjanOrderEntity fangjanOrderEntity = new FangjanOrderEntity();
//                            fangjanOrderEntity.setFangjanOrderUuidNumber(data.get(0));                    //订单号 要改的
//                            fangjanOrderEntity.setFangjanId(Integer.valueOf(data.get(0)));   //房间 要改的
//                            fangjanOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            fangjanOrderEntity.setFangjanTime(new Date(data.get(0)));          //预定时间 要改的
//                            fangjanOrderEntity.setFangjanOrderTypes(Integer.valueOf(data.get(0)));   //订单类型 要改的
//                            fangjanOrderEntity.setInsertTime(date);//时间
//                            fangjanOrderEntity.setCreateTime(date);//时间
                            fangjanOrderList.add(fangjanOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //订单号
                                if(seachFields.containsKey("fangjanOrderUuidNumber")){
                                    List<String> fangjanOrderUuidNumber = seachFields.get("fangjanOrderUuidNumber");
                                    fangjanOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> fangjanOrderUuidNumber = new ArrayList<>();
                                    fangjanOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("fangjanOrderUuidNumber",fangjanOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //订单号
                        List<FangjanOrderEntity> fangjanOrderEntities_fangjanOrderUuidNumber = fangjanOrderService.selectList(new EntityWrapper<FangjanOrderEntity>().in("fangjan_order_uuid_number", seachFields.get("fangjanOrderUuidNumber")));
                        if(fangjanOrderEntities_fangjanOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(FangjanOrderEntity s:fangjanOrderEntities_fangjanOrderUuidNumber){
                                repeatFields.add(s.getFangjanOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [订单号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        fangjanOrderService.insertBatch(fangjanOrderList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = fangjanOrderService.queryPage(params);

        //字典表数据转换
        List<FangjanOrderView> list =(List<FangjanOrderView>)page.getList();
        for(FangjanOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FangjanOrderEntity fangjanOrder = fangjanOrderService.selectById(id);
            if(fangjanOrder !=null){


                //entity转view
                FangjanOrderView view = new FangjanOrderView();
                BeanUtils.copyProperties( fangjanOrder , view );//把实体数据重构到view中

                //级联表
                    FangjanEntity fangjan = fangjanService.selectById(fangjanOrder.getFangjanId());
                if(fangjan != null){
                    BeanUtils.copyProperties( fangjan , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setFangjanId(fangjan.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(fangjanOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody FangjanOrderEntity fangjanOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,fangjanOrder:{}",this.getClass().getName(),fangjanOrder.toString());
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if("用户".equals(role)){
            FangjanEntity fangjanEntity = fangjanService.selectById(fangjanOrder.getFangjanId());
            if(fangjanEntity == null){
                return R.error(511,"查不到该物品");
            }
            // Double fangjanNewMoney = fangjanEntity.getFangjanNewMoney();

            if(false){
            }
            else if(fangjanEntity.getFangjanNewMoney() == null){
                return R.error(511,"物品价格不能为空");
            }

            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");
            double balance = yonghuEntity.getNewMoney() - fangjanEntity.getFangjanNewMoney()*1;//余额
            if(balance<0)
                return R.error(511,"余额不够支付");
            fangjanOrder.setFangjanOrderTypes(2); //设置订单状态为已支付
            fangjanOrder.setYonghuId(userId); //设置订单支付人id
            fangjanOrder.setInsertTime(new Date());
            fangjanOrder.setCreateTime(new Date());
                fangjanOrderService.insert(fangjanOrder);//新增订单
            yonghuEntity.setNewMoney(balance);//设置金额
            yonghuService.updateById(yonghuEntity);
            return R.ok();
        }else{
            return R.error(511,"您没有权限支付订单");
        }
    }
    /**
     * 添加订单
     */
    @RequestMapping("/order")
    public R add(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("order方法:,,Controller:{},,params:{}",this.getClass().getName(),params.toString());
        String fangjanOrderUuidNumber = String.valueOf(new Date().getTime());

        //获取当前登录用户的id
        Integer userId = (Integer) request.getSession().getAttribute("userId");

        Integer fangjanTime = Integer.valueOf(String.valueOf(params.get("fangjanTime")));//预定时间

        String data = String.valueOf(params.get("fangjans"));
        JSONArray jsonArray = JSON.parseArray(data);
        List<Map> fangjans = JSON.parseObject(jsonArray.toString(), List.class);

        //获取当前登录用户的个人信息
        YonghuEntity yonghuEntity = yonghuService.selectById(userId);

        //当前订单表
        List<FangjanOrderEntity> fangjanOrderList = new ArrayList<>();
        //商品表
        List<FangjanEntity> fangjanList = new ArrayList<>();

        BigDecimal zhekou = new BigDecimal(1.0);

        //循环取出需要的数据
        for (Map<String, Object> map : fangjans) {
           //取值
            Integer fangjanId = Integer.valueOf(String.valueOf(map.get("fangjanId")));//商品id
            Integer buyNumber = Integer.valueOf(String.valueOf(map.get("buyNumber")));//购买数量
            FangjanEntity fangjanEntity = fangjanService.selectById(fangjanId);//购买的商品
            String id = String.valueOf(map.get("id"));

            //订单信息表增加数据
            FangjanOrderEntity fangjanOrderEntity = new FangjanOrderEntity<>();

            //赋值订单信息
            fangjanOrderEntity.setFangjanOrderUuidNumber(fangjanOrderUuidNumber);//订单号
            fangjanOrderEntity.setFangjanId(fangjanId);//房间
            fangjanOrderEntity.setYonghuId(userId);//用户
            fangjanOrderEntity.setFangjanOrderTypes(2);//订单类型
            fangjanOrderEntity.setInsertTime(new Date());//订单创建时间
            fangjanOrderEntity.setCreateTime(new Date());//创建时间

            //计算金额
            Double money = new BigDecimal(fangjanEntity.getFangjanNewMoney()).multiply(new BigDecimal(buyNumber)).multiply(zhekou).doubleValue();

            if(yonghuEntity.getNewMoney() - money <0 ){
                return R.error("余额不足,请充值！！！");
            }else{
                //计算所获得积分
                Double buyJifen =0.0;
                yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() - money); //设置金额
            }
            fangjanOrderList.add(fangjanOrderEntity);
            fangjanList.add(fangjanEntity);

        }
        fangjanOrderService.insertBatch(fangjanOrderList);
        fangjanService.updateBatchById(fangjanList);
        yonghuService.updateById(yonghuEntity);
        return R.ok();
    }






    /**
    * 退款
    */
    @RequestMapping("/refund")
    public R refund(Integer id, HttpServletRequest request){
        logger.debug("refund方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));

        if("用户".equals(role)){
            FangjanOrderEntity fangjanOrder = fangjanOrderService.selectById(id);
            Integer buyNumber = 1;
            Integer fangjanId = fangjanOrder.getFangjanId();
            if(fangjanId == null)
                return R.error(511,"查不到该物品");
            FangjanEntity fangjanEntity = fangjanService.selectById(fangjanId);
            if(fangjanEntity == null)
                return R.error(511,"查不到该物品");
            Double fangjanNewMoney = fangjanEntity.getFangjanNewMoney();
            if(fangjanNewMoney == null)
                return R.error(511,"物品价格不能为空");

            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");

            Double zhekou = 1.0;


            //计算金额
            Double money = fangjanEntity.getFangjanNewMoney() * buyNumber  * zhekou;
            //计算所获得积分
            Double buyJifen = 0.0;
            yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() + money); //设置金额


            fangjanOrder.setFangjanOrderTypes(1);//设置订单状态为退款
            fangjanOrderService.updateById(fangjanOrder);//根据id更新
            yonghuService.updateById(yonghuEntity);//更新用户信息
            fangjanService.updateById(fangjanEntity);//更新订单中物品的信息
            return R.ok();
        }else{
            return R.error(511,"您没有权限退款");
        }
    }





    /**
     * 评论
     */
    @RequestMapping("/commentback")
    public R commentback(Integer id, String commentbackText,HttpServletRequest request){
        logger.debug("commentback方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if("用户".equals(role)){
            FangjanOrderEntity fangjanOrder = fangjanOrderService.selectById(id);
            if(fangjanOrder == null)
                return R.error(511,"查不到该订单");
            if(fangjanOrder.getFangjanOrderTypes() != 3)
                return R.error(511,"您不能评论");
            Integer fangjanId = fangjanOrder.getFangjanId();
            if(fangjanId == null)
                return R.error(511,"查不到该房间");

            FangjanCommentbackEntity fangjanCommentbackEntity = new FangjanCommentbackEntity();
            fangjanCommentbackEntity.setId(id);
            fangjanCommentbackEntity.setFangjanId(fangjanId);
            fangjanCommentbackEntity.setYonghuId((Integer) request.getSession().getAttribute("userId"));
            fangjanCommentbackEntity.setFangjanCommentbackText(commentbackText);
            fangjanCommentbackEntity.setReplyText(null);
            fangjanCommentbackEntity.setInsertTime(new Date());
            fangjanCommentbackEntity.setUpdateTime(null);
            fangjanCommentbackEntity.setCreateTime(new Date());
            fangjanCommentbackService.insert(fangjanCommentbackEntity);

            fangjanOrder.setFangjanOrderTypes(4);//设置订单状态为已评论
            fangjanOrderService.updateById(fangjanOrder);//根据id更新
            return R.ok();
        }else{
            return R.error(511,"您没有权限评论");
        }
    }











}

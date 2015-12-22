package cn.edu.zjut.service;

import cn.edu.zjut.po.Order;

/**
 * Created by stiles on 15/12/22.
 */
public interface IOrderReleaseController {
    boolean release(Order order);//发布订单接口
}

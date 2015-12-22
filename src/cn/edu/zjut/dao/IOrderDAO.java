package cn.edu.zjut.dao;

import cn.edu.zjut.po.Order;

/**
 * Created by stiles on 15/12/22.
 */
public interface IOrderDAO {
    boolean save(Order order);//保存订单的接口
    boolean update(Order order);//更新订单信息的接口
}

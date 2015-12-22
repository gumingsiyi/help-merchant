package cn.edu.zjut.dao;

import cn.edu.zjut.po.Order;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by stiles on 15/12/22.
 */
public class OrderDAO extends BaseHibernateDAO implements IOrderDAO {
    @Override
    public boolean save(Order order) {//实现保存订单接口的方法
        try {
            Session session = getSession();
            Transaction ts = session.beginTransaction();
            session.save(order);
            ts.commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Order order) {//实现更新订单接口的方法
        try {
            Session session = getSession();
            Transaction ts = session.beginTransaction();
            session.update(order);
            ts.commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

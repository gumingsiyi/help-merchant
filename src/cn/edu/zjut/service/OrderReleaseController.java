package cn.edu.zjut.service;

import cn.edu.zjut.dao.IOrderDAO;
import cn.edu.zjut.po.Merchant;
import cn.edu.zjut.po.Order;
import com.opensymphony.xwork2.ActionContext;

import java.util.Date;
import java.util.Map;

/**
 * Created by stiles on 15/12/22.
 */
public class OrderReleaseController implements IOrderReleaseController {
    private IOrderDAO orderDAO;
    ActionContext ctx= ActionContext.getContext();
    Map<String, Object> session = (Map) ctx.getSession();
    Map<String, Object> request = (Map) ctx.get("request");

    public void setOrderDAO(IOrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    public boolean release(Order order) {//实现order发布类
        Merchant merchant;
        merchant = (Merchant)session.get("merchant");
        order.setMerchant(merchant);
        order.setReleaseTime(new Date());
        order.setIfFinish(false);
        if (orderDAO.save(order)) {
            return true;
        }
        return false;
    }
}

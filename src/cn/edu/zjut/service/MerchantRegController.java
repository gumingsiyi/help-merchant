package cn.edu.zjut.service;

import cn.edu.zjut.dao.IMerchantDAO;
import cn.edu.zjut.po.Merchant;
import com.opensymphony.xwork2.ActionContext;

import java.io.*;
import java.util.Map;

/**
 * Created by Stiles on 2015/12/12.
 */
public class MerchantRegController implements IMerchantRegController {
    private IMerchantDAO merchantDAO;

    public IMerchantDAO getMerchantDAO() {
        return merchantDAO;
    }
    public void setMerchantDAO(IMerchantDAO merchantDAO) {
        this.merchantDAO = merchantDAO;
    }
    public MerchantRegController(){//构造方法
        System.out.println("create MerchantRegController.");
    }
    public boolean register(Merchant merchant) {
        ActionContext ctx= ActionContext.getContext();
        Map<String, Object> session = (Map) ctx.getSession();
        Map<String, Object> request = (Map) ctx.get("request");
        if (merchantDAO.find(merchant.getMerchantID()) != null) {
            request.put("tip", "用户已存在");
            System.out.println("用户已存在");
            return false;
        } else {
            session.put("merchant", merchant);
            request.put("tip", "注册成功");
            System.out.println("注册成功");
            return merchantDAO.save(merchant);
        }
    }

}

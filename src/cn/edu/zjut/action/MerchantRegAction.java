package cn.edu.zjut.action;

import cn.edu.zjut.po.Merchant;
import cn.edu.zjut.service.IMerchantRegController;
import cn.edu.zjut.service.MerchantRegController;
import org.apache.struts2.ServletActionContext;

import java.io.*;

/**
 * Created by Stiles on 2015/12/12.
 */
public class MerchantRegAction {
    private Merchant merchant;
    private IMerchantRegController merchantRegController;

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public void setMerchantRegController(IMerchantRegController merchantRegController){
        this.merchantRegController = merchantRegController;
    }

    public String regView() {
        return "success";
    }

    public String reg() {
        //System.out.println(merchantRegController);
        if (merchantRegController.register(merchant)) {
            return "regSUCCESS";
        } else {
            return "regFAILED";
        }
    }
}

package cn.edu.zjut.action;
import cn.edu.zjut.po.Merchant;
import cn.edu.zjut.service.IMerchantLoginController;


public class MerchantLoginAction {
    private Merchant merchant;
    private IMerchantLoginController MerchantLoginController;

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public void setMerchantLoginController(
            IMerchantLoginController MerchantRegisterController) {
        this.MerchantLoginController = MerchantRegisterController;
    }

    public String login(){
        if(MerchantLoginController.login(merchant.getMerchantUsername(), merchant.getMerchantPassword())){
            return "loginSUCCESS";
        }
        else{
            return "loginFAILED";
        }
    }
}
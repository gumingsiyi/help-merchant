/*MerchantLoginController.java
 *实现登录的登录功能*/
package cn.edu.zjut.service;
import cn.edu.zjut.dao.IMerchantDAO;
import cn.edu.zjut.po.Merchant;
import com.opensymphony.xwork2.ActionContext;

import java.util.Map;

public class MerchantLoginController implements IMerchantLoginController{
	private IMerchantDAO merchantDAO;

	public IMerchantDAO getMerchantDAO() {
		return merchantDAO;
	}
	public void setMerchantDAO(IMerchantDAO merchantDAO) {
		this.merchantDAO = merchantDAO;
	}
	public MerchantLoginController(){//构造方法
		System.out.println("create MerchantLoginController.");
	}

	public boolean login(String ID, String password) {//商家登录，成功返回true，失败返回false
		ActionContext ctx= ActionContext.getContext();
		Map<String, Object> session = (Map) ctx.getSession();
		Map<String, Object> request = (Map) ctx.get("request");
		Merchant merchant;
		System.out.println("execute --login()-- method.");
		if((merchant = merchantDAO.find(ID)) != null){//根据id查出商家
			if (merchant.getMerchantPassword().equals(password)) {
				session.put("merchant", merchant);
				request.put("tip", "登陆成功");
				return true;
			} else {
				request.put("tip", "用户名或密码错误");
				return false;
			}
		}
		else{
			request.put("tip", "用户名或密码错误");
			return false;
		}
	}
}

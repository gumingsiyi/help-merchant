/*MerchantLoginController.java
 *ʵ�ֵ�¼�ĵ�¼����*/
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
	public MerchantLoginController(){//���췽��
		System.out.println("create MerchantLoginController.");
	}

	public boolean login(String ID, String password) {//�̼ҵ�¼���ɹ�����true��ʧ�ܷ���false
		ActionContext ctx= ActionContext.getContext();
		Map<String, Object> session = (Map) ctx.getSession();
		Map<String, Object> request = (Map) ctx.get("request");
		Merchant merchant;
		System.out.println("execute --login()-- method.");
		if((merchant = merchantDAO.find(ID)) != null){//����id����̼�
			if (merchant.getMerchantPassword().equals(password)) {
				session.put("merchant", merchant);
				request.put("tip", "��½�ɹ�");
				return true;
			} else {
				request.put("tip", "�û������������");
				return false;
			}
		}
		else{
			request.put("tip", "�û������������");
			return false;
		}
	}
}

/*IEmployeeDAO:商家DAO接口类*/
package cn.edu.zjut.dao;
import cn.edu.zjut.po.Merchant;

public interface IMerchantDAO {
	Merchant find(String merchantID);//根据商家ID查找商家
	boolean save(Merchant merchant);//储存一个商家信息
	boolean update(Merchant merchant);//更新商家信息
}

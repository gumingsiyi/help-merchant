/*IEmployeeDAO:�̼�DAO�ӿ���*/
package cn.edu.zjut.dao;
import cn.edu.zjut.po.Merchant;

public interface IMerchantDAO {
	//boolean login(Merchant merchant);//�̼ҵ�¼
	Merchant find(String merchantID);//�����̼�ID�����̼�
	boolean save(Merchant merchant);//����һ���̼���Ϣ
	boolean update(Merchant merchant);//�����̼���Ϣ
}
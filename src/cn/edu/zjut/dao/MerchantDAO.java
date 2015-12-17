package cn.edu.zjut.dao;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.zjut.po.Merchant;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MerchantDAO extends BaseHibernateDAO implements IMerchantDAO{
	private Map<String, Object> request, session;

    public boolean save(Merchant merchant) {
        try {
            Session session = getSession();
            Transaction ts = session.beginTransaction();
            session.save(merchant);
            ts.commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
	//����id�����û�
	public Merchant find(String merchantID) {
        try {
            Session session=getSession();
            Transaction ts = session.beginTransaction();
            Query query = session.createQuery("from Merchant where ID = '"+ merchantID +"'");
            //query.setParameter(0, merchantID);
            query.setMaxResults(1);
            Merchant merchant = (Merchant)query.uniqueResult();
            ts.commit();
            session.clear();
            return merchant;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    //ʵ�֣��޸�ĳ�̼���Ϣ
    public boolean update(Merchant merchant) {
        try {
            Session session = getSession();
            Transaction ts = session.beginTransaction();
            session.update(merchant);
            ts.commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
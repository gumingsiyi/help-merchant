package cn.edu.zjut.dao;

import org.hibernate.Query;

import cn.edu.zjut.po.Merchant;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MerchantDAO extends BaseHibernateDAO implements IMerchantDAO{
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
	//根据id查找用户
	public Merchant find(String merchantID) {
        try {
            Session session=getSession();
            Transaction ts = session.beginTransaction();
            Query query = session.createQuery("from Merchant where merchantID = '"+ merchantID +"'");
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
    //实现：修改某商家信息
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

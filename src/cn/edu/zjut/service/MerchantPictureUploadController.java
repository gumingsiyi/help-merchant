package cn.edu.zjut.service;

import cn.edu.zjut.dao.IMerchantDAO;
import cn.edu.zjut.po.Merchant;
import com.opensymphony.xwork2.ActionContext;

import java.io.*;
import java.util.Map;

/**
 * Created by Stiles on 2015/12/16.
 */
public class MerchantPictureUploadController implements IMerchantPictureUploadController {
    private IMerchantDAO merchantDAO;
    ActionContext ctx= ActionContext.getContext();
    Map<String, Object> session = (Map) ctx.getSession();
    Map<String, Object> request = (Map) ctx.get("request");

    public MerchantPictureUploadController(){//构造方法
        System.out.println("create MerchantPictureUploadController.");
    }

    public IMerchantDAO getMerchantDAO() {
        return merchantDAO;
    }
    public void setMerchantDAO(IMerchantDAO merchantDAO) {
        this.merchantDAO = merchantDAO;
    }

    private boolean uploadPicture(String id, File pic, String name) {
        try {
            System.out.println(pic);
            InputStream in = new FileInputStream(pic);
            String dir = "G:/Merchant/" + id +"/";
            File fileLocation = new File(dir);
            if (!fileLocation.exists()) {
                boolean isCreated = fileLocation.mkdir();
                if (!isCreated) {
                    return false;
                }
                String fileName = name+".jpg";
                File uploadFile = new File(dir, fileName);
                OutputStream out = new FileOutputStream(uploadFile);
                byte[] buffer = new byte[1024 * 1024];
                int length;
                while ((length = in.read(buffer)) > 0) {
                    out.write(buffer, 0, length);
                }
                in.close();
                out.close();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("upload failed");
            return false;
        }
        return false;
    }
    public boolean uploadBusinessLicence(File pic) {
        Merchant merchant = (Merchant) session.get("merchant");
        if (uploadPicture(merchant.getMerchantID(), pic, "BusinessLicence")) {
            merchant.setMerchantBusinessLicence("G:/Merchant/" + merchant.getMerchantID() + "/BusinessLicence.jpg");
            if (merchantDAO.update(merchant)) {
                request.put("tip", "上传成功！");
                return true;
            }
        }
        request.put("tip", "上传失败！");
        return false;
    }
    public boolean uploadSecurityLicence(File pic) {
        Merchant merchant = (Merchant) session.get("merchant");
        if(uploadPicture(merchant.getMerchantID(), pic, "SecurityLicence")) {
            merchant.setMerchantBusinessLicence("G:/Merchant/" + merchant.getMerchantID() + "/SecurityLicence.jpg");
            if (merchantDAO.update(merchant)) {
                request.put("tip", "上传成功！");
                return true;
            }
        }
        request.put("tip", "上传失败！");
        return false;
    }
    public boolean uploadIcon(File pic) {
        Merchant merchant = (Merchant) session.get("merchant");
        if (uploadPicture(merchant.getMerchantID(), pic, "Icon")) {
            merchant.setMerchantBusinessLicence("G:/Merchant/" + merchant.getMerchantID() + "/Icon.jpg");
            if (merchantDAO.update(merchant)) {
                request.put("tip", "上传成功！");
                return true;
            }
        }
        request.put("tip", "上传失败！");
        return false;
    }
}

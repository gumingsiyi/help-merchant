package cn.edu.zjut.action;

import cn.edu.zjut.service.MerchantPictureUploadController;

import java.io.File;

/**
 * Created by Stiles on 2015/12/15.
 */
public class MerchantPictureUploadAction {
    private MerchantPictureUploadController merchantPictureUploadController;
    private File picture;

    public void setMerchantPictureUploadController(MerchantPictureUploadController merchantPictureUploadController) {
        this.merchantPictureUploadController = merchantPictureUploadController;
    }

    public File getPicture() {
        return picture;
    }

    public void setPicture(File picture) {
        this.picture = picture;
    }

    public String businessLicence() {
        if (merchantPictureUploadController.uploadBusinessLicence(picture))
            return "success";
        return "error";
    }

    public String securityLicence() {
        if (merchantPictureUploadController.uploadSecurityLicence(picture))
            return "success";
        return "error";
    }

    public String Icon() {
        if (merchantPictureUploadController.uploadIcon(picture))
            return "success";
        return "error";
    }

}

package cn.edu.zjut.service;

import java.io.File;

/**
 * Created by Stiles on 2015/12/16.
 */
public interface IMerchantPictureUploadController {
    boolean uploadBusinessLicence(File pic);//营业执照上传接口
    boolean uploadSecurityLicence(File pic);//卫生许可上传接口
    boolean uploadIcon(File pic);//头像上传接口
}

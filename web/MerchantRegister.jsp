<%--
  Created by IntelliJ IDEA.
  User: Stiles
  Date: 2015/12/12
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>Register Page</title>
</head>
<body>
    <form action="reg" method="post" enctype="multipart/form-data">
        <s:textfield name="merchant.ID" label="手机号" value=""/><br/>
        <s:textfield name="merchant.username" label="昵称" value=""/><br/>
        <s:textfield name="merchant.password" label="密码" value=""/><br/>
        <s:textfield name="merchant.IDNum" label="身份证号" value=""/><br/>
        <s:textfield name="merchant.name" label="姓名" value=""/><br/>
        <s:textfield name="merchant.age" label="年龄" value=""/><br/>
        <s:textfield name="merchant.phone" label="电话" value=""/><br/>
        <s:textfield name="merchant.creditCrad" label="信用卡号" value=""/><br/>
        <s:textfield name="merchant.email" label="邮编" value=""/><br/>
        <s:file name="businessLicenceFile" label="营业执照"/><br/>
        <s:file name="securityLicenceFile" label="卫生许可" value=""/><br/>
        <s:textfield name="merchant.shopName" label="商店名" value=""/><br/>
        <s:textfield name="merchant.shopAdress" label="商店地址" value=""/><br/>
        <s:textfield name="merchant.sex" label="性别" value=""/><br/>
        <s:submit/>
    </form>
</body>
</html>

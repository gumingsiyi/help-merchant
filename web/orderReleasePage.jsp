<%--
  Created by IntelliJ IDEA.
  User: stiles
  Date: 15/12/22
  Time: 下午7:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>orderRelease</title>
</head>
<body>
<form action="merchantReleaseOrder.action" method="post">
    <input type="datetime-local" name="date"/><br>
    <input type="text" name="salaryString"/> <br>
    <input type="submit" />
</form>

</body>
</html>

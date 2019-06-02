<html>
<head>
    <%@ page contentType="text/html;charset=utf-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</head>
<body>
<h2>请输入下面表单的数据，并提交给后台</h2>

<form action="/mvc/demo/form" method="post">

    <input name="name">

    <input name="age">

    <input type="submit" value="提交">

</form>


</body>
</html>

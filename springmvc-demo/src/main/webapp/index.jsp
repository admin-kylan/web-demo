<html>
<head>
    <%@ page contentType="text/html;charset=utf-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</head>
<body>
<h2>Hello World! 欢迎来到英雄联盟！！！${list}</h2>


<select>
    <c:forEach items="${list}" var="item" >
        <option><c:out value="${item.name}"/></option>
    </c:forEach>
</select>


</body>
</html>

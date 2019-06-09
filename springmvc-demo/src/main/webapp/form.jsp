<html>
<head>
    <%@ page contentType="text/html;charset=utf-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script type="text/javascript" src="../static/js/jquery-1.11.3.min.js"></script>
</head>
<body>
<h2>请输入下面表单的数据，并提交给后台</h2>

<form action="/mvc/demo/form" method="post" id="ac">

    <input name="name" id="name">

    <input name="age" id="age">

    <input type="submit" value="提交" id="sb">

</form>

<script type="text/javascript">
    $(document).ready(function () {
        $("sb").click(function () {
            var json = {
                name : $("#name").val(),
                age : $("#age").val()
            };
            $.ajax({
                url:"/mvc/demo/form",
                type:post,
                deta:json,
                dataType:"json",
                async:true,
                success:function (data) {
                    if (data.code == 0){
                        window.location.reload()  //页面实现跳转和刷新
                    }
                    else {

                    }
                }
            });
        });
    });
</script>


</body>

</html>

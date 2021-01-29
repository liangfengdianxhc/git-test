<%--
  Created by IntelliJ IDEA.
  User: 14767
  Date: 2021/1/25
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
                alert("hello")
                //发送ajax请求
                $.ajax({
                    //编写json格式，设置json属性和值
                    url:"user/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"username":"hehe","password":"213","age":"30"}',
                    dataType:"json",
                    type:"post",
                    success:function (data) {
                        //data表示服务器端响应的json的数据格式，进行解析
                        alert(data);
                        alert(data.username);
                        alert(data.password);
                        alert(data.age);
                    }
                })
            })
        })
    </script>
</head>
<body>
    <p>测试controller返回值为String类型</p>
    <a href="user/testString">testString</a>


    <p>测试controller没有返回值的情况</p>
    <a href="user/testVoid">testVoid</a>

    <p>测试转发和重定向</p>
    <a href="user/testForwardOrRedirect">testForwardOrRedirect</a>


    <p>测试返回值类型为ModelAndView</p>
    <a href="user/testModelAndView">testModelAndView</a>

    <p></p>

    <button id="btn">发送Ajax</button>
</body>
</html>

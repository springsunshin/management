<%@ page import="com.domain.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <style>
            #userEditBox{
                width: 400px;
                background-color: #ccffcc;
                border: 2px solid #ccc;
                margin: 20px auto;
            }

            #userEditBox input{
                width: 200px;
                height: 25px;
                padding-left: 4px;
            }

            #userEditBox button{
                width: 60px;
                height: 30px;
            }

            #userEditBox li{
                margin-top: 4px;
            }
        </style>


        <script type="text/javascript">
            window.onload=function () {
                var form=document.getElementById("userEditForm");
                form.onsubmit=function () {
                    return true;
                }
            }
        </script>
    </head>
    <body>
            <div id="userEditBox">
                <h2 align="center">信息修改</h2>
                <form id="userEditForm" action="userUpdate.do" method="post">
                    <input type="hidden" name="uno" value="${requestScope.oneUser.uno}">
                    <ul>
                        <li>用户名称:<input name="uname" required="required" value="${requestScope.oneUser.uname}"></li>
                        <li>真实姓名:<input name="truename" required="required" value="${requestScope.oneUser.truename}"></li>
                        <li>用户年龄:<input type="number" name="age" required="required" value="${requestScope.oneUser.age}"></li>
                        <li>用户性别:<input name="sex" required="required" list="sexList" value="${requestScope.oneUser.sex}">
                            <datalist id="sexList">
                                <option>男</option>
                                <option>女</option>
                            </datalist>
                        </li>
                        <li>电话号码:<input name="phone" required="required" value="${requestScope.oneUser.phone}"></li>
                        <li><button>保存</button></li>
                    </ul>
                </form>
            </div>
    </body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <script type="text/javascript">
            window.onload=function () {

                //斑马条纹
                var tbody = document.getElementById("userBody");
                var trs = tbody.getElementsByTagName('tr');
                for (var i = 0; i < trs.length; i++) {
                    var tr = trs[i];
                    if (i % 2 == 0) {
                        tr.style.background = "#ccffcc";
                    } else {
                        tr.style.background = "#ffffff";
                    }
                }

                //鼠标移动的背景处理
                for (let i = 0; i < trs.length; i++) {
                    var tr = trs[i];
                    tr.onmousemove = function () {
                        var oldColor = this.style.background;
                        this.style.background = "#008c8c";
                        this.onmouseout = function () {
                            this.style.background = "#ffffff";
                        }
                    }
                    //给数据行增加点击勾选功能
                    tr.onclick=function () {
                        var input=this.getElementsByTagName("input")[0];
                        input.checked=!input.checked;
                    }

                    //行中的复选框增加点击判断功能
                    var input=tr.getElementsByTagName("input")[0];
                    input.onclick=function (ev) {
                        var e=window.event || ev;
                        e.stopPropagation();
                    }
                }

                //设置复选框
                var inputs = document.getElementsByTagName("input");
                //找到第一个复选框
                for (var i = 0; i < inputs.length; i++) {
                    var input = inputs[i];
                    if (input.type == 'checkbox') {
                        input.onclick = function () {
                            //将其他复选框状态 和当前复选框状态设置一致
                            var f = this.checked;

                            for (var j = 0; j < inputs.length; j++) {
                                if (inputs[j].type == 'checkbox') {
                                    inputs[j].checked = f;
                                }
                            }
                        }
                        break;
                    }
                }
            }

            function deleteUser(uno) {
                var f = confirm("是否确认删除");
                if (!f) return;
                location.href = "deleteUser.do?uno=" + uno;
            }

            function deleteUsers() {
                //找寻选中的要删除的数据
                var tbody=document.getElementById("userBody");
                var inputs=tbody.getElementsByTagName("input");
                var unos="";
                for (var i=0;i<inputs.length;i++){
                    if (inputs[i].checked){
                        var uno=inputs[i].parentNode.nextElementSibling.innerHTML;
                        unos+=uno+",";
                    }
                }
                if (unos == ""){
                    alert("请选择要删除的记录")
                }else {
                    var f = confirm("是否确认删除");
                    if (!f) return;
                    location.href = "deleteUsers.do?unos="+unos;
                }
            }
        </script>
    </head>
    <body>
        <h2 align="center">用户列表</h2>
        <p align="center">
            <a href="userAdd.jsp">新建用户</a>
            <a href="javascript:deleteUsers()">批量删除</a>
            <a href="userAdds.jsp">批量导入</a>
        </p>
        <table border="1" width="50%" align="center" cellspacing="0">
            <thead>
                <tr>
                    <th><input type="checkbox"></input></th>
                    <th>用户编号</th>
                    <th>用户名称</th>
                    <th>用户密码</th>
                    <th>真实姓名</th>
                    <th>年龄</th>
                    <th>性别</th>
                    <th>电话号码</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody id="userBody">
            <c:forEach var="user" items="${requestScope.allUser}">
                <tr align="center">
                    <td><input type="checkbox"></input</td>
                    <td>${user.uno}</td>
                    <td>${user.uname}</td>
                    <td>${user.upass}</td>
                    <td>${user.truename}</td>
                    <td>${user.age}</td>
                    <td>${user.sex}</td>
                    <td>${user.phone}</td>
                    <td>
                        <a href="javascript:deleteUser(${user.uno})">删除</a>
                        <a href="userEdit.do?uno=${user.uno}">编辑</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </body>
</html>

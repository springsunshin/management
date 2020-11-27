<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
       <style>
           #searchButtons input{
               width: 100px;
           }
       </style>

        <script type="text/javascript">
            window.onload=function () {
                var rows=document.getElementById("rows");
                rows.onchange=function () {
                    roleList();
                }

                var table=document.getElementById("searchButtons");
                var inputs=table.getElementsByTagName("input");
                for (var i=0;i<inputs.length;i++){
                    var input=inputs[i];
                    input.onkeydown=function (ev) {
                        var e=window.event || ev;
                        if (e.keyCode==13){
                            roleList();
                        }
                    }
                }

                var button=document.getElementById("button");
                button.onclick=function () {
                    document.getElementById("rno").value=null;
                    document.getElementById("rname").value=null;
                    document.getElementById("description").value=null;
                    document.getElementById("page").value=1;
                    roleList();
                }
            }

           function roleList() {
               var rows=document.getElementById("rows").value;
               var page=document.getElementById("page").value;
               var rno=document.getElementById("rno").value;
               var rname=document.getElementById("rname").value;
               var description=document.getElementById("description").value;

               location.href="roleList.do?page="+page+"&rows="+rows+"&rno="+rno+"&rname="+rname+"&description="+description;
           }

           function queryByPage(page) {
               document.getElementById("page").value=page;
               roleList();
           }
        </script>
    </head>
    <body>
      <h2 align="center">角色列表</h2>

      <table id="searchButtons" align="center" width="80%">
          <tr>
              <td>
                  <input id="rno" placeholder="角色编号" type="number" value="${requestScope.rno}">
                  <input id="rname" placeholder="角色名称" value="${requestScope.rname}">
                  <input id="description" placeholder="角色描述" value="${requestScope.description}">
                  <button id="button">清空查询</button>
              </td>
          </tr>
      </table>

      <table align="center" width="80%" border="1" cellpadding="0">
          <thead>
            <tr>
                <th>角色编号</th>
                <th>角色名称</th>
                <th>角色描述</th>
                <th>角色操作</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="role" items="${requestScope.list}">
                <tr align="center">
                    <td>${role.rno}</td>
                    <td>${role.rname}</td>
                    <td>${role.description}</td>
                    <td><a href="">删除</a> | <a href="">编辑</a></td>
                </tr>
            </c:forEach>
          </tbody>
      </table>

      <table align="center" width="80%">
          <tr>
              <td align="left">
                  <select id="rows">
                      <option>3</option>
                      <option>5</option>
                      <option>10</option>
                      <option selected="selected">${requestScope.rows}</option>
                  </select>
                  <input id="page" type="hidden" value="${requestScope.page}">
                  第${requestScope.page}页/共${requestScope.pageNumber}页
              </td>
              <td align="right">
                  <a href="javascript: queryByPage(1)">首页</a>
                  <c:if test="${requestScope.page>1}">
                      <a href="javascript: queryByPage(${requestScope.page-1})">上一页</a>
                  </c:if>
                  <c:if test="${requestScope.page<requestScope.pageNumber}">
                      <a href="javascript: queryByPage(${requestScope.page+1})">下一页</a>
                  </c:if>
                  <a href="javascript: queryByPage(${requestScope.pageNumber})">尾页</a>
              </td>
          </tr>
      </table>

    </body>
</html>

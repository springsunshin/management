<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript">
        window.onload=function () {
            var xmlHttp=new XMLHttpRequest();
            xmlHttp.open("post","addMenu.do?mname=学生管理&mhref=www.do",true);
            xmlHttp.send();

            xmlHttp.onreadystatechange=function () {
                if (xmlHttp.readyState==4&&xmlHttp.status200){
                    var result=xmlHttp.responseText;
                }
            }
        }
    </script>
</head>
    <body>
        哈哈哈哈呵呵呵
    </body>
</html>

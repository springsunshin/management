<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <style>
            #userImportBox{
                width: 300px;
                background: #ccffcc;
                border: 2px solid #cccccc;
                border-radius: 10px;
                padding-bottom: 10px;

                margin: 50px auto;
            }

            #userImportBox input{
                width: 250px;
                height: 25px;
            }

            #userImportBox button{
                width: 60px;
                height: 30px;
            }

            #userImportBox li{
                margin-top: 8px;
            }
        </style>
    </head>
    <body>
    <div id="userImportBox">
        <h2 align="center">用户导入</h2>
       <form action="userImport.do" method="post" enctype="multipart/form-data">
           <ul>
               <li>请选择上传的文件:<input type="file" name="excel" required="required"></li>
               <li><a href="userTemplateDown.do">模版下载</a></li>
               <li><button>保存</button></li>
           </ul>
       </form>
    </div>
    </body>
</html>

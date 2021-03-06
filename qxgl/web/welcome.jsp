<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
    <style>
        #top{
            height: 15%;
            border-bottom: 2px solid #ccc;
        }
        #left{
            width: 20%;
            height: 85%;
            border-right: 2px solid #ccc;
            float: left;
        }
        #right{
            width: 79%;
            height: 85%;
            float: right;
        }
        #loginMsg{
            position: relative;
            top: 20px;
            left: 100px;
        }
        #menuBox li{
            list-style: none;
            cursor: pointer;
        }
    </style>
</head>
    <body>
        <div id="top">
            <span id="loginMsg">欢迎${sessionScope.tuser.truename}登录</span>
        </div>
        <div id="left">
            <ul id="menuBox">
                <li>
                    <span>权限管理</span>
                    <ul>
                        <li><span><a href="userList.do" target="right">用户管理</a></span></li>
                        <li><span><a href="roleList.do" target="right">角色管理</a></span></li>
                        <li><span><a href="menuList.jsp" target="right">菜单管理</a></span></li>
                    </ul>
                </li>
                <li>
                    <span>基本信息管理</span>
                    <ul>
                        <li><span>商品管理</span></li>
                        <li><span>供应商管理</span></li>
                        <li><span>库房管理</span></li>
                    </ul>
                </li>
                <li>
                    <span>系统管理</span>
                    <ul>
                        <li><span>修改密码</span></li>
                        <li><span>注销</span></li>
                    </ul>
                </li>
            </ul>
        </div>
        <div id="right">
            <iframe name="right" width="100%" height="100%" frameborder="0"></iframe>
        </div>
    </body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>

        <style>
            ul,li{
                list-style: none;
            }

            li{
                margin-top: 4px;
                margin-bottom: 4px;
            }

            ul span{
                cursor: pointer;
            }

            #mname,#mhref,#mtarget{
                width: 100px;
                margin-right: 8px;
            }

            #active{
                background: #5a9239;
            }
        </style>

        <script>
            $(function () {
                $.post(
                    'menuList.do',
                    {uname:"dmc",upass:"123"},
                    function (date) {

                    function showLevelMenu(pno,$position) {
                            var ul=$('<ul>');
                            $position.append(ul);
                            for (var i=0;i<date.length;i++){
                                var menu=date[i];
                                if (menu.pno == pno) {
                                    var li = $('<li>');
                                    ul.append(li);
                                    var span = $('<span>'+menu.mname+'</span>');
                                    li.append(span);
                                    showLevelMenu(menu.mno,li);
                                }
                        }
                    }

                    showLevelMenu(-1,$('body'));

                    // $('ul span').click(function () {
                    //     $(this).next().toggle(1000);
                    // })
                        $('ul span').click(function () {
                            $('#active').attr('id','');
                            $(this).attr('id','active');
                        });

                    },
                    'json'
                );
            });

            function addRootMenu() {
                if($('#mname').length!=0){
                    return;
                }
                var li=$('<li><input id="mname" placeholder="菜单名称"/><input id="mhref" placeholder="菜单请求"/><input id="mtarget" placeholder="显示位置"/><button id="saveButton">保存</button></li>');
                $('ul:first').append(li);

                $('#saveButton').click(function () {
                    saveMenu(-1);
                });
            }

            function saveMenu(pno) {
                var mname=$('#mname').val();
                var mhref=$('#mhref').val();
                var mtarget=$('#mtarget').val();

                $.ajax({
                    url:'addMenu.do',
                    date:{'pno':pno,'mname':mname,'mhref':mhref,'mtarget':mtarget},
                    type:'post',
                    dateType:'json',
                    success:function (data) {
                        alert("保存成功");
                        alert(data);
                    },
                    error:function () {

                    }
                });
            }
        </script>
    </head>
    <body>
        <div>
            <a href="javascript:addRootMenu()">新建根菜单</a>
            <a href="">新建子菜单</a>
        </div>
    </body>
</html>
package com.controller;

import com.domain.Menu;
import com.service.Imp3.MenuServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class MenuController {

    @Autowired
    private MenuServiceImp menuServiceImp;

    @RequestMapping(path = "menuList.do")
    @ResponseBody
    public List<Menu> menuList(String uname,String upass){
        System.out.println(uname+upass);
        return menuServiceImp.selectAll();
    }

    @RequestMapping(path = "addMenu.do")
    @ResponseBody
    public Menu addMenu(Menu menu){
        System.out.println("接收到了请求");
        System.out.println(menu);
        Menu menu1=new Menu();
        menu1.setMname("哈哈哈");
        return menu1;
    }
}

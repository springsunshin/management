package com.controller;

import com.domain.Role;
import com.service.Imp2.RoleServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class RoleController {
    @Autowired
    private RoleServiceImp roleService;

    @RequestMapping(path = "roleList.do")
    public ModelAndView roleLIst(Integer page,Integer rows,Integer rno,String rname,String description){
        if (page==null){
            page=1;
        }
        if (rows==null){
            rows=3;
        }
        List<Role> list=roleService.selectAll(page,rows,rno,rname,description);
        Integer total=roleService.selectNumberPage(rno,rname,description);
        Integer value=total%rows;
        Integer pageNUmber=null;
        if (value==0){
            pageNUmber=total/rows;
        }else {
            pageNUmber=(total/rows)+1;
        }
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("list",list);
        modelAndView.addObject("pageNumber",pageNUmber);
        modelAndView.addObject("page",page);
        modelAndView.addObject("rows",rows);
        modelAndView.addObject("rname",rname);
        modelAndView.addObject("description",description);
        modelAndView.addObject("rno",rno);
        modelAndView.setViewName("roleList.jsp");
        return modelAndView;
    }
}

package com.controller;

import com.domain.User;
import com.service.Imp1.UserServiceImp1;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@Controller
@SessionAttributes("tuser")
public class UserController {

    @Autowired
    private UserServiceImp1 userService;

    @RequestMapping(path = "login.do")
    public ModelAndView login(String uname, String upass){
        User user=userService.selectOne(uname,upass);
        if (user!=null){
            ModelAndView modelAndView=new ModelAndView();
            modelAndView.addObject("tuser",user);
            modelAndView.setViewName("welcome.jsp");
            return modelAndView;
        }else {
            ModelAndView modelAndView=new ModelAndView();
            modelAndView.addObject("flag","9");
            modelAndView.setViewName("index.jsp");
            return modelAndView;
        }
    }

    @RequestMapping(path = "userList.do")
    public ModelAndView userList(){
        List<User> allUser=userService.findUserAll();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("allUser",allUser);
        modelAndView.setViewName("userList.jsp");
        return modelAndView;
    }

    @RequestMapping(path = "userAdd.do",produces = "text/html; charset=utf-8")
    @ResponseBody
    public String userAdd(User user){
        userService.insert(user);
        return "添加成功";
    }

    @RequestMapping(path = "deleteUser.do",produces = "text/html; charset=utf-8")
    @ResponseBody
    public String deleteUser(Integer uno){
        userService.delete(uno);
        return "删除成功";
    }

    @RequestMapping(path = "userEdit.do")
    public ModelAndView userEdit(Integer uno){
        User user=userService.selectOneUser(uno);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("oneUser",user);
        modelAndView.setViewName("userEdit.jsp");
        return modelAndView;
    }

    @RequestMapping(path = "userUpdate.do",produces = "text/html; charset=utf-8")
    public String userUpdate(User user){
        userService.update(user);
        return "userList.do";
    }

    @RequestMapping(path = "deleteUsers.do")
    public String deleteUsers(String unos){
        String[] allUno=unos.split(",");
        Integer[] integers=new Integer[allUno.length];
        for (int i=0;i<allUno.length;i++){
            integers[i]=Integer.parseInt(allUno[i]);
        }
        userService.deleteUsers(integers);
        return "userList.do";
    }

    @RequestMapping(path = "userImport.do")
    public String upload(HttpServletRequest request) throws IOException, FileUploadException {
        DiskFileItemFactory factory=new DiskFileItemFactory();
        ServletFileUpload upload=new ServletFileUpload(factory);
        List<FileItem> items=upload.parseRequest(request);
        for (FileItem item:items){
            if (item.isFormField()){
                return null;
            }else {
                InputStream inputStream=item.getInputStream();
                //通过POI读取Excel内容
                Workbook workbook= WorkbookFactory.create(inputStream);//jvm版excel文件
                Sheet sheet=workbook.getSheetAt(0);//数据表
                for (int i=1;i<=sheet.getLastRowNum();i++){
                    Row row=sheet.getRow(i);
                    if (row==null)continue;
                    Cell c1=row.getCell(0);
                    Cell c2=row.getCell(1);
                    Cell c3=row.getCell(2);
                    Cell c4=row.getCell(3);
                    Cell c5=row.getCell(4);
                    Cell c6=row.getCell(5);
                    Cell c7=row.getCell(6);
                    Cell c8=row.getCell(7);

                    String uname=c1.getStringCellValue();
                    String upass=(int)c2.getNumericCellValue()+"";
                    String truename=c3.getStringCellValue();
                    int age=(int)c4.getNumericCellValue();
                    String sex=c5.getStringCellValue();
                    String phone=(int)c6.getNumericCellValue()+"";
                    String yl1=null;
                    String yl2=null;
                    if (c7!=null){
                        yl1=c7.getStringCellValue();
                    }
                    if (c8!=null){
                        yl2=c8.getStringCellValue();
                    }
                    User user=new User(null,uname,upass,truename,age,sex,phone,yl1,yl2);
                    userService.insert(user);
                }
            }
        }
        return "userList.do";
    }

    @RequestMapping(path = "userTemplateDown.do")
    public void userTemplateDown(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String realPath=request.getServletContext().getRealPath("files/userTemplate.xlsx");
        InputStream inputStream=new FileInputStream(realPath);
        String fileName="userTemplate.xlsx";
        response.setContentType("application/x-msdownload");
        response.setHeader("Content-disposition","attachment;filename="+fileName);
        byte[] bytes=new byte[1024];
        int count=inputStream.read(bytes);
        OutputStream outputStream=response.getOutputStream();
        while (count!=-1){
            outputStream.write(bytes,0,count);
            outputStream.flush();
            count=inputStream.read(bytes);
        }
    }
}

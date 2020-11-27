package com.dao;

import java.util.Map;

public class RoleProvide {
    public String selectForDynamic(Map<String,Object> map){
       StringBuilder builder=new StringBuilder();
       builder.append("select * from t_role where 1=1 ");
       Object rno=map.get("rno");
       if (rno!=null){
           builder.append("and rno=#{rno} ");
       }
       String rname= (String) map.get("rname");
       if (rname!=null&&!"".equals(rname)){
//           builder.append("and rname like "+"'%"+rname+"%' ");
           builder.append("and rname like concat(concat('%',#{rname}),'%')");
       }
       String description= (String) map.get("description");
       if (description!=null&&!"".equals(description)){
           builder.append("and description like "+"'%"+description+"%' ");
       }
       builder.append("limit #{start} , #{end}");
       return builder.toString();
    }

    public String selectPageNumber(Map<String,Object> map){
        StringBuilder builder=new StringBuilder();
        builder.append("select count(*) from t_role where 1=1 ");
        Integer rno= (Integer) map.get("rno");
        if (rno!=null){
            builder.append("and rno=#{rno} ");
        }
        String rname= (String) map.get("rname");
        if (rname!=null&&!"".equals(rname)){
            builder.append("and rname like "+"'%"+rname+"%' ");
        }
        String description= (String) map.get("description");
        if (description!=null&&!"".equals(description)){
            builder.append("and description like "+"'%"+description+"%' ");
        }
        return builder.toString();
    }
}

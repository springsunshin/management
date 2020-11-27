package com.dao;

import com.domain.Menu;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MenuDao {

    @Select("select * from t_menu")
    public List<Menu> selectAll();

    @Insert("insert into t_menu values(#{mno},#{mname},#{mhref},#{mtarget},#{pno},#{yl1},#{yl2})")
    public void insertMenu(Menu menu);
}

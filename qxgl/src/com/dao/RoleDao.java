package com.dao;

import com.domain.Role;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

public interface RoleDao {

    @SelectProvider(value =RoleProvide.class ,method = "selectForDynamic")
    public List<Role> selectAll(Map<String,Object> map);

    @SelectProvider(value = RoleProvide.class,method = "selectPageNumber")
    public Integer selectPageNumber(Map<String,Object> map);
}

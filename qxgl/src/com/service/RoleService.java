package com.service;

import com.domain.Role;

import java.util.List;
import java.util.Map;

public interface RoleService {


    public List<Role> selectAll(Integer page,Integer rows,Integer rno,String rname,String description);

    public Integer selectNumberPage(Integer rno,String rname,String description);
}

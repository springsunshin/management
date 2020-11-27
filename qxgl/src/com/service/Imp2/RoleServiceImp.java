package com.service.Imp2;

import com.dao.RoleDao;
import com.domain.Role;
import com.service.RoleService;
import com.util.MyUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImp implements RoleService {

    RoleDao roleDao= MyUtil.getSqlSession().getMapper(RoleDao.class);


    @Override
    public List<Role> selectAll(Integer page,Integer rows,Integer rno,String rname,String description) {
        Integer start=(page-1)*rows;
        Integer end=rows;
        Map<String,Object> map=new HashMap<>();
        map.put("rno",rno);
        map.put("rname",rname);
        map.put("description",description);
        map.put("start",start);
        map.put("end",end);
        return roleDao.selectAll(map);
    }

    @Override
    public Integer selectNumberPage(Integer rno, String rname, String description) {
        Map<String,Object> map=new HashMap<>();
        map.put("rno",rno);
        map.put("rname",rname);
        map.put("description",description);
        return roleDao.selectPageNumber(map);
    }
}

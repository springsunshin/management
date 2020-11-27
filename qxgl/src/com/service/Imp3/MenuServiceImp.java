package com.service.Imp3;

import com.dao.MenuDao;
import com.domain.Menu;
import com.service.MenuService;
import com.util.MyUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImp implements MenuService {
    private MenuDao menuDao= MyUtil.getSqlSession().getMapper(MenuDao.class);

    public List<Menu> selectAll() {
        List<Menu> list=menuDao.selectAll();
        return list;
    }

    @Override
    public void insertMenu(Menu menu) {
        menuDao.insertMenu(menu);
    }
}

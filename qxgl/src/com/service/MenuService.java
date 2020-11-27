package com.service;

import com.dao.MenuDao;
import com.domain.Menu;

import java.util.List;

public interface MenuService {

    public List<Menu> selectAll();

    public void insertMenu(Menu menu);
}

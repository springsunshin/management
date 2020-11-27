package com.service.Imp1;

import com.dao.UserDao;
import com.domain.User;
import com.service.UserService;
import com.util.MyUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp1 implements UserService {
        private UserDao userDao= MyUtil.getSqlSession().getMapper(UserDao.class);

        @Override
        public User selectOne(String uname, String upass){
            User user=userDao.selectOne(uname);
            if (upass.equals(user.getUpass())){
                return user;
            }else {
                return null;
            }
        }

    @Override
    public List<User> findUserAll() {
            return userDao.selectAll();
    }

    @Override
    public void insert(User user) {
        userDao.insert(user);
    }

    @Override
    public void delete(Integer uno) {
        userDao.delete(uno);
    }

    @Override
    public User selectOneUser(Integer uno) {
            return userDao.selectOneUser(uno);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void deleteUsers(Integer[] unos) {
        userDao.deleteUsers(unos);
    }
}

package cn.joey.service;

import cn.joey.entity.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private static Map<Integer,User> map;
    static{
        map = new HashMap<Integer,User>();
        for(int i=0;i<6;i++) {
            map.put(i,new User(i,"test"+i,"pwd"+i,8082));
        }
    }

    @Override
    public User getById(Integer id) {
        return map.get(id);
    }

}

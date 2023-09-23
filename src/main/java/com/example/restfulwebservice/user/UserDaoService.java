package com.example.restfulwebservice.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    private static int usersCount = 3;

    //데이터베이스에 3개의 데이터가 들어있다고 가정
    static {
        users.add(new User(1, "Kenneth", new Date()));
        users.add(new User(2, "Alice", new Date()));
        users.add(new User(3, "Elena", new Date()));
    }

    // 모든 사용자를 조회하는 메소드
    public List<User> findAll() {
        return users;
    }

    // 새로운 사용자를 추가하는 메소드
    // 매개변수로 전달된 user 안에 id가 존재하지 않을 경우 ++userCount 하여 id 생성. 그리고 그 값을 DB역할을 하는 List<user> users에 추가하고 id가 셋팅된 상태의 정보를 return
    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    //id로 사용자를 찾는 메소드
    public User findOne(int id) {
        for (User user: users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User deleteById(int id) {
        // 열거형 데이터(배열, 리스트 등)를 순차적으로 접근해서 사용하기 위한 데이터 형
        Iterator<User> iterator = users.iterator();

        while (iterator.hasNext()) {
            User user = iterator.next();

            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }

    public User modifyUser(int id, String name){
        Iterator<User> iterator =  users.iterator();

        while(iterator.hasNext()){
            User user = iterator.next();

            if(user.getId() == id){
                user.setId(user.getId());
                user.setName(name);
                return user;
            }
        }
        return null;
    }
}

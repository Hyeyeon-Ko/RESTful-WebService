package com.example.restfulwebservice.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private UserDaoService service;

    //생성자를 통한 의존성 주입
    //생성자의 매개변수를 통해서 전달하고자 하는 객체의 인스턴스를 넣어주고, 전달되어진 인스턴스를 멤버 필드로 할당하면 됨.
    //매개변수로 넣어준 UserDaoService 클래스에 @Service 어노테이션 붙여줘야 함
    public UserController(UserDaoService service) {
        this.service = service;
    }

    //전체 사용자 목록을 조회하는 메소드 등록
    //endpoint로 /users를 호출했을 경우 이 메소드가 실행됨
    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    //사용자 상세보기
    //사용자의 고유한 key값(id) 필요
    //endpoint로 /users/{id}를 호출했을 경우 이 메소드가 실행됨
    //GET /users/1 or /users/10
    //path variable은 항상 문자 형태로 전달. 여기서 선언한 path variable의 타입으로 자동 변환됨
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id) {
        return service.findOne(id);
    }
}

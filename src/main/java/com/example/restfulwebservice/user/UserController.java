package com.example.restfulwebservice.user;

import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.swing.text.html.parser.Entity;
import java.net.URI;
import java.util.List;
import java.util.Map;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
    public EntityModel<User> retrieveUser(@PathVariable int id) {
        User user = service.findOne(id);

        if (user == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }

        // HATEOAS
        EntityModel<User> model = EntityModel.of(user);
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        model.add(linkTo.withRel("all-users"));

        return model;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){ //반환하는 값이 User 클래스 값임
        User savedUser = service.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest() //현재 가지고 있는 Request 값을 사용한다는 의미
                .path("/{id}") //반환할 때 URI 뒤에 /{id}를 추가
                .buildAndExpand(savedUser.getId()) //{id}에 savedUser.getId()값을 넣어줌
                .toUri(); //위 모든 것을 URI형태로 변환

        return ResponseEntity.created(location).build(); //위 location을 빌드해서 반환함
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        User user = service.deleteById(id);

        if (user == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }
    }

    @PutMapping("/users/modify")
    public User modifyUser(@RequestBody Map<String, String> param){
        int id = Integer.parseInt(param.get("id"));
        String name = param.get("name");
        User modifiedUser = service.modifyUser(id, name);
        return modifiedUser;
    }
}

package com.example.restfulwebservice.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue
    private Integer id;

    // 게시물 내용
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    // User : Posts -> 1 : (0~N), Main : Sub -> Parent : Child
    // LAZY : 지연 로딩 방식
    // 매번 데이터를 로딩하는 것이 아니라 Post 데이터가 필요한 시점에 user(사용자)데이터를 가져오겠다는 뜻
    @JsonIgnore
    // 외부에 데이터 노출하지 않기위해
    private User user;
}

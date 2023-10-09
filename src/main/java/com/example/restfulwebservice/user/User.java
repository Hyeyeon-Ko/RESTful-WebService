package com.example.restfulwebservice.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonFilter("UserInfo")
@Schema(description = "사용자 상세 정보를 위한 도메인 객체")
@Table(name = "Users")
@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @Size(min=2, message = "Name은 2글자 이상 입력해 주세요.")
    @Schema(description = "사용자 이름을 입력해 주세요.")
    private String name;

    @Past
    @Schema(description = "사용자 등록일을 입력해 주세요.")
    private Date joinDate;

    @Schema(description = "사용자 패스워드를 입력해 주세요.")
    private String password;

    @Schema(description = "사용자 주민번호를 입력해 주세요.")
    private String ssn;
}
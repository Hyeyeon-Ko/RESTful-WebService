package com.example.restfulwebservice.exception;

import com.example.restfulwebservice.user.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    // ResponseEntity는 사용자 객체 한명 추가했을 때 반환하는 형태의 값
    // Exception ex는 메소드에서 발생했던 에러 객체
    // WebRequest request는 어디서 발생했는지 알아보기 위한 request 정보
    // @ExceptionHandler 어노테이션은 이 메소드가 ExceptionHandler로 사용될 수 있음을 지칭.
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handlerAllException(Exception ex, WebRequest request){

        // 발생 날짜, 에러 메시지, request의 부가적인 내용
        ExceptionResponse exceptionResponse =
                new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));

        // 위 값을 ResponseEntity의 인자로 넣어 반환
        // 서버에서 발생하는 일반화 된 에러이기 때문에 HttpStatusCode는 500번이고 INTERNAL_SERVER_ERROR로 지정
        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // @ExceptionHandler(UserNotFoundException.class)를 사용하여 사용자가 없을 때의 예외로 지정
    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFound(Exception ex, WebRequest request){

        // 발생 날짜, 에러 메시지, request의 부가적인 내용
        ExceptionResponse exceptionResponse =
                new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));

        // 위 값을 ResponseEntity의 인자로 넣어 반환
        // status code를 NotFound로 지정
        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}

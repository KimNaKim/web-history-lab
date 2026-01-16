package com.example.v4;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class UserController {

    @GetMapping("/join")
    public String join() {
        return "join 완료";
    }
    

    @GetMapping("/login")    
    public String login(){
        System.out.println("login 호출됨");
        return "Login 호출";
    }
    
}

package com.example.v4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController     //컴포넌트 스캔 대상
public class BoardController {
    
    @GetMapping("/insert")      //메서드 스캔 대상
    public String insert(){
        System.out.println("insert 호출됨");
        return "insert 호출 완료";
    }
    @GetMapping("/delete")
    public void delete(){
        System.out.println("delete 호출됨");
    }
    @GetMapping("/update")
    public void update(){
        System.out.println("update 호출됨");
    }
    
}

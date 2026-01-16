package ex04;

import ex04.anno.RequestMapping;
import ex04.anno.RestController;

@RestController
public class UserController {
    
    @RequestMapping("/login")
    public void login(){
        System.out.println("Login 호출됨");
    }
}

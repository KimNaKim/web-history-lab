package ex04;

import ex04.anno.RequestMapping;
import ex04.anno.RestController;

@RestController
public class BoardController {

    @RequestMapping("/insert")
    public void insert(){
        System.out.println("insert 호출됨");
    }
    @RequestMapping("/delete")
    public void delete(){
        System.out.println("delete 호출됨");
    }
    @RequestMapping("/update")
    public void update(){
        System.out.println("update 호출됨");
    }
    @RequestMapping("/select")
    public void select(){
        System.out.println("select 호출됨");
    }
}

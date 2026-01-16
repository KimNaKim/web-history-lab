package ex04;

import ex04.anno.RequestMapping;
import ex04.anno.RestController;

@RestController
public class ReplyController {

    @RequestMapping("/write")
    public void write(){
        System.out.println("댓글작성");
    }
}

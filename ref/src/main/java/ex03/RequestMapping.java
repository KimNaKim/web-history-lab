package ex03;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


//어노테이션 정보가 살아있는 시점을 결정
//실행 도중에도 읽을 수 있음을 표시
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RequestMapping {
    String value();
    //어노테이션의 속성값
    //'value'값만 key값을 생략가능 (디폴트 값)
}

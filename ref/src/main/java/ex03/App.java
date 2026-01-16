package ex03;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App {
    public static void main(String[] args) {
        // 키보드로 입력 받기(더미)
        String uri = "/select";

        //2. boardController 생성
        BoardController bc = new BoardController();

        //3. 동적 클래스 분석
        Method[] methods = BoardController.class.getDeclaredMethods();
        for(Method m : methods){
            //동적으로 RequestMapping 어노테이션이 붙어있는 것인지를 체크
            RequestMapping rm = m.getDeclaredAnnotation(RequestMapping.class);
            if(rm.value().equals(uri)){
                try {
                    Object res = m.invoke(bc);
                    System.out.println("응답 버퍼 : " + res);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
//            System.out.println(rm);
//            System.out.println(m.getName());
//            System.out.println("------------------------");
        }

    }
}

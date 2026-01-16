package ex02;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App {
    public static void main(String[] args) {
        // 키보드로 입력 받기(더미)
        String uri = "/join";

        // 2. 다른 사람이 만든 코드
        uri = uri.replace("/","");

        BoardController bc = new BoardController();

        //1. 동적 클래스 분석
        Method[] methods = BoardController.class.getDeclaredMethods();
        for(Method m : methods){
            try {
                if(m.getName().equals(uri)){
                    m.invoke(bc);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

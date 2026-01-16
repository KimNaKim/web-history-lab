package ex04;

import ex04.anno.RequestMapping;
import ex04.anno.RestController;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class App {

    static void findUri(String uri, Object obj){
        //3. 동적 클래스 분석
        Method[] methods = obj.getClass().getDeclaredMethods();
        for(Method m : methods){
            //동적으로 RequestMapping 어노테이션이 붙어있는 것인지를 체크
            RequestMapping rm = m.getDeclaredAnnotation(RequestMapping.class);
            if(rm.value().equals(uri)){
                try {
                    m.invoke(obj);
                } catch (Exception e) {
                    e.printStackTrace();    //피범벅
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        //1. 키보드로 입력 받기(더미)
        String uri = "/select";

        //ex04 패키지를 뒤져서 @RestController 어노테이션이 붙어있는지 체크
        //2. 패키지 스캔
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        //class를 스캔할 위치 지정해주기
        URL packageUrl = classLoader.getResource("ex04");
        File ex04Folder = new File(packageUrl.toURI());
        //스캔된 클래스와 폴더 리스트에 저장하기
        File[] files = ex04Folder.listFiles();
        
        //3. 찾은 것들을 new로 생성해 컬렉션에 담아 두기
        // IOC = Inversion Of Controller (제어의 역전)
        List<Object> iocContainer = new ArrayList<>();
        for(File f : files){
            //폴더를 제외하기
            if(f.getName().endsWith(".class")){
                String className = "ex04." + f.getName().replace(".class","");
                Class cls = Class.forName(className);

                //클래스 리플렉션(동적 분석)
                //RestController 어노테이션이 붙은 클래스만 찾아내기
                if(cls.isAnnotationPresent(RestController.class)){
                    //System.out.println(cls);
                    Object instance = cls.newInstance();
                    iocContainer.add(instance);
                }
            }
        }

        //메서드 호출
        for (Object o : iocContainer){
            findUri(uri, o);
        }
    }
}

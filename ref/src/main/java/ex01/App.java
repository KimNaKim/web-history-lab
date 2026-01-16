package ex01;

public class App {
    public static void main(String[] args) {
        String uri = "/insert";

        BoardController bc = new BoardController();

        //controller에 기능이 추가될 떄마다 main의 코드를 수정해야 함
        if(uri.equals("/select")){
            bc.select();
        }
        if(uri.equals("/insert")){
            bc.insert();
        }
        if(uri.equals("/delete")){
            bc.delete();
        }
        if(uri.equals("update")){
            bc.update();
        }


    }
}

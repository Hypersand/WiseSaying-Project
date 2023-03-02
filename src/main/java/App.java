
import system.controller.SystemController;
import wiseSaying.controller.WiseSayingController;
import wiseSaying.entity.WiseSaying;

import java.io.IOException;
import java.util.*;

public class App {

    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException {

        SystemController systemController = new SystemController();
        WiseSayingController wiseSayingController = new WiseSayingController(sc);


        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String input = sc.nextLine();

            if (input.equals("종료")) {
                systemController.exit();
            }
            if (input.equals("등록")) {
                wiseSayingController.write();
            }
            if (input.equals("목록")) {
                wiseSayingController.list();
            }

            if (input.contains("삭제")) {
                String s = input.substring(6);
                int id = Integer.parseInt(s);
                wiseSayingController.remove(id);
            }

            if (input.contains("수정")) {
                String s = input.substring(6);
                int id = Integer.parseInt(s);
                wiseSayingController.update(id);
            }

        }
    }
}

package com.ll;

import com.ll.system.controller.SystemController;
import com.ll.wiseSaying.controller.WiseSayingController;

public class App {

    public static void main(String[] args) {

        SystemController systemController = new SystemController();
        WiseSayingController wiseSayingController = new WiseSayingController();


        System.out.println("== 명언 앱 ==");
        Container.init();

        while (true) {
            System.out.print("명령) ");
            String input = Container.getScanner().nextLine();

            if (input.equals("종료")) {
                Container.close();
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
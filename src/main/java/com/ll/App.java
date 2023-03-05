package com.ll;

import com.ll.system.controller.SystemController;
import com.ll.wiseSaying.controller.WiseSayingController;


public class App {

    public void Run() {

        SystemController systemController = new SystemController();
        WiseSayingController wiseSayingController = new WiseSayingController();



        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String input = Container.getScanner().nextLine();
            Request request = new Request(input);


            if (input.equals("종료")) {
                systemController.exit();
                return;
            }
            if (input.equals("등록")) {
                wiseSayingController.write();
                continue;
            }
            if (input.equals("목록")) {
                wiseSayingController.list();
                continue;
            }

            if (request.getActionCode().equals("삭제")) {
                wiseSayingController.remove(request);
                continue;
            }

            if (request.getActionCode().equals("수정")) {
                wiseSayingController.update(request);
            }

        }
    }
}

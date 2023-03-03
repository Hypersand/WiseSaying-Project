package com.ll;

import com.ll.system.controller.SystemController;
import com.ll.wiseSaying.controller.WiseSayingController;

import java.util.HashMap;
import java.util.Map;

public class App {

    public void Run() {

        SystemController systemController = new SystemController();
        WiseSayingController wiseSayingController = new WiseSayingController();


        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String input = Container.getScanner().nextLine();


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


            String[] inputs = input.split("\\?");
            String actionCode = inputs[0];
            Map<String, String> paramMap = new HashMap<>();
            String[] params = inputs[1].split("&");

            if (actionCode.equals("삭제")) {
                for (String param : params) {
                    String[] str = param.split("=");
                    paramMap.put(str[0], str[1]);
                    wiseSayingController.remove(Integer.parseInt(str[1]));
                }

                continue;
            }

            if (actionCode.equals("수정")) {
                for (String param : params) {
                    String[] str = param.split("=");
                    paramMap.put(str[0], str[1]);
                    wiseSayingController.update((Integer.parseInt(str[1])));
                }

            }

        }
    }
}

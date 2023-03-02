
import system.controller.SystemController;
import wiseSaying.entity.WiseSaying;

import java.io.IOException;
import java.util.*;

public class App {
    public static void main(String[] args) throws IOException {
        SystemController systemController = new SystemController();
        Scanner sc = new Scanner(System.in);
        List<WiseSaying> wiseSayingList = new LinkedList<>();
        System.out.println("== 명언 앱 ==");
        int lastIndex = 0;

        while (true) {
            System.out.print("명령) ");
            String input = sc.nextLine();
            if (input.equals("종료")) {
                systemController.exit();
            }
            if (input.equals("등록")) {
                System.out.print("명언 : ");
                String content = sc.nextLine();
                System.out.print("작가 : ");
                String author = sc.nextLine();
                lastIndex += 1;
                wiseSayingList.add(new WiseSaying(lastIndex, content, author));
                System.out.println(lastIndex + "번 명언이 등록되었습니다.");
            }
            if (input.equals("목록")) {
                for (WiseSaying wiseSaying : wiseSayingList) {
                    System.out.println(wiseSaying.getId() + " / " + wiseSaying.getAuthor() + " / " + wiseSaying.getContent());
                }
            }

            if (input.contains("삭제")) {
                String s = input.substring(6);
                int id = Integer.parseInt(s);
                int removeCount = 0;
                for (WiseSaying wiseSaying : wiseSayingList) {
                    if (wiseSaying.getId() == id) {
                        wiseSayingList.remove(wiseSaying);
                        removeCount++;
                        System.out.println(id + "번 명언이 삭제되었습니다.");
                        break;
                    }
                }

                if (removeCount == 0) {
                    System.out.println(id + "번 명언은 존재하지 않습니다.");
                }
            }

            if (input.contains("수정")) {
                String s = input.substring(6);
                int id = Integer.parseInt(s);
                for (int i = 0; i<wiseSayingList.size(); i++) {
                    if (wiseSayingList.get(i).getId() == id) {
                        System.out.println("명언(기존) : " + wiseSayingList.get(i).getContent());
                        System.out.print("명언 : ");
                        String content = sc.nextLine();
                        System.out.println("작가(기존) : " + wiseSayingList.get(i).getAuthor());
                        System.out.print("작가 : ");
                        String author = sc.nextLine();
                        wiseSayingList.set(i, new WiseSaying(id, content, author));
                        break;
                    }
                }
            }


        }
    }
}

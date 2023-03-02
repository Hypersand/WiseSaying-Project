
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Map<Integer, WiseSaying> map = new HashMap<>();
        System.out.println("== 명언 앱 ==");
        int count = 0;

        while(true) {
            System.out.print("명령) ");
            String input = sc.nextLine();
            if (input.equals("종료")) {
                return;
            }
            if (input.equals("등록")) {
                System.out.print("명언 : ");
                String content = sc.nextLine();
                System.out.print("작가 : ");
                String author = sc.nextLine();
                count++;
                map.put(count, new WiseSaying(count,content, author));
                System.out.println(count+"번 명언이 등록되었습니다.");
            }
            if (input.equals("목록")) {
                for (int i = count; i > 0; i--) {
                    if (!map.containsKey(i)) {
                        continue;
                    }
                    System.out.println(i + " / " + map.get(i).getAuthor() + " / " + map.get(i).getContent());

                }
            }

            if (input.contains("삭제")) {
                String s = input.substring(6);
                int id = Integer.parseInt(s);
                if (!map.containsKey(id)) {
                    System.out.println(id + "번 명언은 존재하지 않습니다.");
                }
                else {
                    map.remove(id);
                    System.out.println(id + "번 명언이 삭제되었습니다.");
                }
            }

            if (input.contains("수정")) {
                String s = input.substring(6);
                int id = Integer.parseInt(s);
                System.out.println("명언(기존) : " + map.get(id).getContent());
                System.out.print("명언 : ");
                String content = sc.nextLine();
                System.out.println("작가(기존) : " + map.get(id).getAuthor());
                System.out.print("작가 : ");
                String author = sc.nextLine();
                map.put(id, new WiseSaying(id,content, author));
            }


        }

    }

    public static class WiseSaying {
        private long id;
        private String content;
        private String author;

        public WiseSaying(long id, String content, String author) {
            this.id = id;
            this.content = content;
            this.author = author;
        }

        public long getId() {
            return id;
        }

        public String getContent() {
            return content;
        }

        public String getAuthor() {
            return author;
        }
    }
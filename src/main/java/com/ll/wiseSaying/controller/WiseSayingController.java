package com.ll.wiseSaying.controller;

import com.ll.Container;
import com.ll.Request;
import com.ll.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingController {

    private int lastIndex = 0;
    private List<WiseSaying> wiseSayingList;

    public WiseSayingController() {
        lastIndex = 0;
        wiseSayingList = new ArrayList<>();
    }

    public void write() {
        System.out.print("명언 : ");
        String content = Container.getScanner().nextLine();
        System.out.print("작가 : ");
        String author = Container.getScanner().nextLine();
        lastIndex += 1;
        wiseSayingList.add(new WiseSaying(lastIndex, content, author));
        System.out.println(lastIndex + "번 명언이 등록되었습니다.");
    }

    public void list() {
        for (WiseSaying wiseSaying : wiseSayingList) {
            System.out.println(wiseSaying.getId() + " / " + wiseSaying.getAuthor() + " / " + wiseSaying.getContent());
        }
    }

    public void remove(Request request) {
        int removeCount = 0;
        int id = request.getIntParam("id", -1);

        if (id == -1) {
            System.out.println("id(정수)를 입력해주세요.");
            return;
        }

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

    public void update(Request request) {
        int id = request.getIntParam("id", -1);

        if (id == -1) {
            System.out.println("id(정수)를 입력해주세요.");
            return;
        }

        for (int i = 0; i < wiseSayingList.size(); i++) {
            if (wiseSayingList.get(i).getId() == id) {
                System.out.println("명언(기존) : " + wiseSayingList.get(i).getContent());
                System.out.print("명언 : ");
                String content = Container.getScanner().nextLine();
                System.out.println("작가(기존) : " + wiseSayingList.get(i).getAuthor());
                System.out.print("작가 : ");
                String author = Container.getScanner().nextLine();
                wiseSayingList.set(i, new WiseSaying(id, content, author));
                break;
            }
        }
    }

}

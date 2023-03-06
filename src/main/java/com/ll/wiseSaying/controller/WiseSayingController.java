package com.ll.wiseSaying.controller;

import com.ll.Container;
import com.ll.Request;
import com.ll.wiseSaying.entity.WiseSaying;
import com.ll.wiseSaying.service.WiseSayingService;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingController {

    private final WiseSayingService wiseSayingService;

    public WiseSayingController() {
        wiseSayingService = new WiseSayingService();
    }

    public void write() {
        System.out.print("명언 : ");
        String content = Container.getScanner().nextLine();
        System.out.print("작가 : ");
        String author = Container.getScanner().nextLine();

        int id = wiseSayingService.write(content, author);
        System.out.println(id + "번 명언이 등록되었습니다.");
    }

    public void list() {
        List<WiseSaying> wiseSayingList = wiseSayingService.findAll();

        for (int i = wiseSayingList.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying = wiseSayingList.get(i);
            System.out.println(wiseSaying.getId() + " / " + wiseSaying.getAuthor() + " / " + wiseSaying.getContent());
        }
    }

    public void remove(Request request) {
        int id = request.getIntParam("id", -1);

        if (id == -1) {
            System.out.println("id(정수)를 입력해주세요.");
            return;
        }

        WiseSaying wiseSaying = wiseSayingService.findById(id);

        if (wiseSaying == null) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
        } else {
            wiseSayingService.remove(wiseSaying);
            System.out.println(id + "번 명언이 삭제되었습니다.");
        }
    }

    public void update(Request request) {
        int id = request.getIntParam("id", -1);

        if (id == -1) {
            System.out.println("id(정수)를 입력해주세요.");
            return;
        }

        WiseSaying wiseSaying = wiseSayingService.findById(id);
        if (wiseSaying == null) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }
        System.out.println("명언(기존) : " + wiseSaying.getContent());
        System.out.print("명언 : ");
        String content = Container.getScanner().nextLine();
        System.out.println("작가(기존) : " + wiseSaying.getAuthor());
        System.out.print("작가 : ");
        String author = Container.getScanner().nextLine();
        wiseSayingService.update(wiseSaying,content,author);
    }


}

package com.ll.wiseSaying.repository;

import com.ll.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {

    private int lastIndex = 0;
    private List<WiseSaying> wiseSayingList;

    public WiseSayingRepository() {
        lastIndex = 0;
        wiseSayingList = new ArrayList<>();
    }

    public WiseSaying findById(int id) {
        for (WiseSaying wiseSaying : wiseSayingList) {
            if (wiseSaying.getId() == id) {
                return wiseSaying;
            }
        }
        return null;
    }

    public List<WiseSaying> findAll() {
        return wiseSayingList;
    }


    public int write(String content, String author) {
        lastIndex++;
        WiseSaying wiseSaying = new WiseSaying(lastIndex, content, author);
        wiseSayingList.add(wiseSaying);

        return lastIndex;
    }

    public void remove(WiseSaying wiseSaying) {
        wiseSayingList.remove(wiseSaying);
    }

    public void update(WiseSaying wiseSaying, String content, String author) {
        wiseSaying.setContent(content);
        wiseSaying.setAuthor(author);
    }
}

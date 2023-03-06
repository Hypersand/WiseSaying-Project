package com.ll.wiseSaying.service;

import com.ll.wiseSaying.entity.WiseSaying;
import com.ll.wiseSaying.repository.WiseSayingRepository;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingService {

    private final WiseSayingRepository wiseSayingRepository;

    public WiseSayingService() {
        wiseSayingRepository = new WiseSayingRepository();
    }


    public WiseSaying findById(int id) {
        WiseSaying wiseSaying = wiseSayingRepository.findById(id);
        return wiseSaying;
    }

    public List<WiseSaying> findAll() {
        return wiseSayingRepository.findAll();
    }


    public int write(String content, String author) {
        return wiseSayingRepository.write(content, author);
    }

    public void remove(WiseSaying wiseSaying) {
        wiseSayingRepository.remove(wiseSaying);
    }

    public void update(WiseSaying wiseSaying, String content, String author) {
        wiseSayingRepository.update(wiseSaying,content,author);
    }


}

package com.example.board.aop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class TimeCheckTest {

    @Test
    @TimeCheck
    void timeCheck() {
        List<String> arr =new ArrayList<>();
        arr.add("안");
        arr.add("녕");
        arr.stream().forEach(s->System.out.println(s));


    }
}
package com.ll;

public class Main {
    public static void main(String[] args) {

        Container.init();
        new App().Run();
        Container.close();
    }
}
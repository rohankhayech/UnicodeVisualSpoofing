package controller;

import model.Forum;

public class Main {
    public static void main(String[] args) {
        Forum forum = new Forum();
        App app = new App(forum);
    }
}

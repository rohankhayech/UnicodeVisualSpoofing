package src.controller;

import src.model.Forum;


/**
 * Main line for the application.
 */
public class Main {
    public static void main(String[] args) {
        Forum forum = new Forum();
        App app = new App(forum);
    }
}

package com.example.rksp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/meetings")
    public String allMeetings(Model model) {
        return "all_meetings";
    }

    @GetMapping("/meetings/my")
    public String myMeetings(Model model) {
        return "my_meetings";
    }

    @GetMapping("/meetings/create")
    public String createMeeting() {
        return "create_meeting";
    }
}

package com.example.rksp.controller;

import com.example.rksp.model.Meeting;
import com.example.rksp.service.MeetingService;
import com.example.rksp.model.AuthUser;

import org.springframework.http.ResponseEntity;

import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.bind.annotation.*;

import com.example.rksp.repository.UserRepository;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;

import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
@RequestMapping("/api/meetings")
@RequiredArgsConstructor
public class MeetingController {

    private final MeetingService meetingService;
    private final UserRepository userRepository;

    private AuthUser getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not found"));
    }

    @GetMapping
    public List<Meeting> getAll() {
        return meetingService.getAllMeetings();
    }

    @GetMapping("/my")
    public List<Meeting> getMyMeetings() {
        return meetingService.getMeetingsForUser(getCurrentUser());
    }

    @PostMapping
    public ResponseEntity<Meeting> create(@RequestBody Meeting meeting) {
        Meeting saved = meetingService.createMeeting(meeting, getCurrentUser());
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/join")
    public ResponseEntity<?> join(@PathVariable Long id) {
        Meeting meeting = meetingService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Meeting not found"));
        boolean joined = meetingService.joinMeeting(meeting, getCurrentUser());
        if (!joined) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "Вы уже записаны на эту встречу"));
        }
        return ResponseEntity.ok(Map.of("success", "Вы успешно записались на встречу"));
    }
}

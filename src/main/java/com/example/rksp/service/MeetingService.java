package com.example.rksp.service;

import com.example.rksp.model.Meeting;
import com.example.rksp.model.Participation;
import com.example.rksp.model.AuthUser;
import com.example.rksp.repository.MeetingRepository;
import com.example.rksp.repository.ParticipationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MeetingService {

    private final MeetingRepository meetingRepository;
    private final ParticipationRepository participationRepository;

    public List<Meeting> getAllMeetings() {
        return meetingRepository.findAll();
    }

    public List<Meeting> getMeetingsForUser(AuthUser user) {
        return meetingRepository.findAll().stream()
                .filter(meeting -> participationRepository.findByUserAndMeeting(user, meeting).isPresent())
                .toList();
    }

    public Meeting createMeeting(Meeting meeting, AuthUser user) {
        meeting.setCreator(user);
        Meeting saved = meetingRepository.save(meeting);
        participationRepository.save(
                Participation.builder().user(user).meeting(saved).build()
        );
        return saved;
    }

    public Optional<Meeting> getById(Long id) {
        return meetingRepository.findById(id);
    }

    public boolean joinMeeting(Meeting meeting, AuthUser user) {
        if (participationRepository.findByUserAndMeeting(user, meeting).isPresent()) {
            return false;
        }
        participationRepository.save(
                Participation.builder().user(user).meeting(meeting).build()
        );
        return true;
    }
}

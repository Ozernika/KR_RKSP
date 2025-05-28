package com.example.rksp.repository;

import com.example.rksp.model.Participation;
import com.example.rksp.model.Meeting;
import com.example.rksp.model.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParticipationRepository extends JpaRepository<Participation, Long> {
    Optional<Participation> findByUserAndMeeting(AuthUser user, Meeting meeting);
}

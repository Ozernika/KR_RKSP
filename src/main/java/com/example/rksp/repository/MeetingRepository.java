package com.example.rksp.repository;

import com.example.rksp.model.Meeting;
import com.example.rksp.model.Participation;
import com.example.rksp.model.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {
    List<Meeting> findByCreator(AuthUser creator);
}

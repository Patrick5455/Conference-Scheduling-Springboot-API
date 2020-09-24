package com.conferenceschedulingapp.repositories;

import com.conferenceschedulingapp.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepo extends JpaRepository <Speaker, Long> {
}

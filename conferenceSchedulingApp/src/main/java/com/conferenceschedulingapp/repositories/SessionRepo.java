package com.conferenceschedulingapp.repositories;

import com.conferenceschedulingapp.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepo extends JpaRepository <Session, Integer> {

}

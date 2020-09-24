package com.conferenceschedulingapp.controllers;

import com.conferenceschedulingapp.models.Session;
import com.conferenceschedulingapp.repositories.SessionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionController {

    @Autowired
    private SessionRepo sessionRepo;

    @GetMapping
    public List<Session> listSession(){
        return sessionRepo.findAll();
    }

    @GetMapping
    @RequestMapping("{id")
    public Session getSession(@PathVariable Long id){
        return sessionRepo.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // to specify the type of response we are doing and override the default 100 response
    public Session createSession(@RequestBody final Session session){
        // save an object and flush it to the database
        return sessionRepo.saveAndFlush(session);
    }

    @RequestMapping(value = ("{id}"), method = RequestMethod.DELETE)
    public void deleteSession(@PathVariable Long id){
        // Also need to check for children records before deleting
        sessionRepo.deleteById(id);
    }










}

package com.conferenceschedulingapp.controllers;

import com.conferenceschedulingapp.models.Session;
import com.conferenceschedulingapp.repositories.SessionRepo;
import org.springframework.beans.BeanUtils;
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

    @RequestMapping("{id}")
    public Session getSession(@PathVariable Integer id){
        return sessionRepo.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // to specify the type of response we are doing and override the default 100 response
    public Session createSession(@RequestBody final Session session){
        // save an object and flush it to the database
        return sessionRepo.saveAndFlush(session);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteSession(@PathVariable Integer id){
        // Also need to check for children records before deleting
        sessionRepo.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Session update(@PathVariable Integer id, @RequestBody Session session){

        // because this is a PUT, we expect all attributes to be passed in.
        // A PATCH would only need what
        // TODO: Add validation that all attributes are passed in,
        //  otherwise return a 400 bad payload
        Session existingSession = sessionRepo.getOne(id);
        // beanutils method takes the existing session and copies the incoming session into the existing session
        BeanUtils.copyProperties(session, existingSession, "session_id");
        return sessionRepo.saveAndFlush(existingSession);
    }

















}

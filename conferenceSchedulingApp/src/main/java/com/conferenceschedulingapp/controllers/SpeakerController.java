package com.conferenceschedulingapp.controllers;

import com.conferenceschedulingapp.models.Speaker;
import com.conferenceschedulingapp.repositories.SpeakerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakerController {

    @Autowired
    private SpeakerRepo speakerRepo;

    @GetMapping
    public List<Speaker> listSpeakers(){
        return speakerRepo.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Speaker getSpeaker(@PathVariable Long id){
        return speakerRepo.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // to specify the type of response we are doing and override the default 100 response
    public Speaker createSpeaker(@RequestBody final  Speaker speaker){
        return speakerRepo.saveAndFlush(speaker);
    }
}

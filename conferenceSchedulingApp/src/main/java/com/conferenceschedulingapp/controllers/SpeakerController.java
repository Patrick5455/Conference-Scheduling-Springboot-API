package com.conferenceschedulingapp.controllers;

import com.conferenceschedulingapp.models.Speaker;
import com.conferenceschedulingapp.repositories.SpeakerRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakerController {

    @Autowired
    private SpeakerRepo speakerRepo;

    //findAll speakers
    @GetMapping
    public List<Speaker> getSpeakers(){ return speakerRepo.findAll();}

    //get a speaker

    @GetMapping("{id}")
    public Speaker getOneSpeaker(@PathVariable Integer id){
        return speakerRepo.getOne(id);
    }

    //create a speaker
    @PostMapping
    public Speaker addSpeaker(@RequestBody final Speaker speaker){
       return speakerRepo.saveAndFlush(speaker);
    }

    //delete a speaker
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteSpeaker(@PathVariable Integer id){
        speakerRepo.deleteById(id);
    }

    //update Speaker
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Speaker updateSpeaker(@PathVariable Integer id, Speaker speaker){
        //TODO: Add validation later to check if incoming speaker object has all speaker attributes

        Speaker existingSpeaker = speakerRepo.getOne(id);
        //replace existing speaker properties with incoming speaker
        BeanUtils.copyProperties(speaker, existingSpeaker, "session_id");
        return speakerRepo.saveAndFlush(existingSpeaker);
    }





}

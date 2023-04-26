package com.jforce.task.controller;

import com.jforce.task.domain.VoterDomain;
import com.jforce.task.exception.UserAlreadyExistException;
import com.jforce.task.exception.UserNotFoundExcetion;
import com.jforce.task.service.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("voter")
public class VoterController {
private VoterService voterService;

@Autowired
    public VoterController(VoterService voterService) {
        this.voterService = voterService;
    }


    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody VoterDomain voterDomain) throws UserAlreadyExistException {
        return  new ResponseEntity<>(voterService.register(voterDomain), HttpStatus.CREATED);
    }



    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody VoterDomain voterDomain) throws  UserNotFoundExcetion {




        return  new ResponseEntity<>(voterService.loginCheck(voterDomain.getUsername(),voterDomain.getPassword()), HttpStatus.CREATED);
    }

    @GetMapping("/status/{username}")
    public ResponseEntity<?> status(@PathVariable String username){
        return  new ResponseEntity<>(voterService.votingDone(username), HttpStatus.CREATED);
    }
    @GetMapping("/get/{username}")
    public ResponseEntity<?> get(@PathVariable String username){
        return  new ResponseEntity<>(voterService.getVoter(username), HttpStatus.CREATED);
    }
}

package com.jforce.task.controller;


import com.jforce.task.domain.CandidateDomain;
import com.jforce.task.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("candidate")
public class CandidateController {
private CandidateService candidateService;

@Autowired
    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

@GetMapping("/getall")
public ResponseEntity<?> getCandidates()  {
    return  new ResponseEntity<>(candidateService.getCandidateNames(), HttpStatus.OK);
}
    @PostMapping("/add")
    public ResponseEntity<?> saveCandidate(@RequestBody CandidateDomain candidateDomain )  {
        return  new ResponseEntity<>(candidateService.addCandidate(candidateDomain  ), HttpStatus.CREATED);
    }


    @GetMapping("/addvote/{candidateName}")
    public ResponseEntity<?> addVote(@PathVariable String candidateName )  {
        return  new ResponseEntity<>(candidateService.addVoteCandidate(candidateName), HttpStatus.OK);
    }
}

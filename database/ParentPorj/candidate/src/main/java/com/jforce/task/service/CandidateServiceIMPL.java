package com.jforce.task.service;


import com.jforce.task.domain.CandidateDomain;
import com.jforce.task.repository.CandidateReository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateServiceIMPL implements CandidateService {

    CandidateReository candidateReository;


    @Autowired
    public CandidateServiceIMPL(CandidateReository candidateReository) {
        this.candidateReository = candidateReository;
    }


    @Override
    public List<CandidateDomain> getCandidateNames() {
        return candidateReository.findAll();
    }

    @Override
    public CandidateDomain addCandidate(CandidateDomain candidateDomain) {
        return candidateReository.save(candidateDomain);
    }

    @Override
    public CandidateDomain addVoteCandidate(String candidateName) {

       CandidateDomain  candidateDomain= candidateReository.findById(candidateName).get();

        if(candidateDomain==null){
            throw new RuntimeException();
        }

        int votes=candidateDomain.getVotes()+1;

        candidateDomain.setVotes(votes);
        candidateReository.deleteById(candidateName);

        return  candidateReository.save(candidateDomain);
    }


}

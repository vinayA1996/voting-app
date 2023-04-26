package com.jforce.task.service;

import com.jforce.task.domain.VoterDomain;
import com.jforce.task.exception.UserAlreadyExistException;
import com.jforce.task.exception.UserNotFoundExcetion;
import com.jforce.task.repository.VoterReository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoterServiceIMPL implements VoterService{

    VoterReository voterReository;


    @Autowired
    public VoterServiceIMPL(VoterReository voterReository) {
        this.voterReository = voterReository;
    }

    @Override
    public VoterDomain register(VoterDomain voterDomain) throws UserAlreadyExistException {

        if (voterReository.existsById(voterDomain.getUsername())){
            throw new UserAlreadyExistException();
        }

        return voterReository.save(voterDomain);
    }

    @Override
    public VoterDomain loginCheck(String username, String password) throws UserNotFoundExcetion {
        VoterDomain voterDomain= voterReository.findByUsernameAndPassword(username, password);
        if(voterDomain==null){
            throw new UserNotFoundExcetion();
        }


        return voterDomain;
    }

    @Override
    public VoterDomain votingDone(String username) {

        VoterDomain voterDomain= voterReository.findById(username).get();

        voterDomain.setVotingStatus(false);
        voterReository.deleteById(username);

        return voterReository.save(voterDomain);
    }

    @Override
    public VoterDomain getVoter(String username) {
        return voterReository.findById(username).get();
    }
}

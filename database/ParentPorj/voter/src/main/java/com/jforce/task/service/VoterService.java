package com.jforce.task.service;

import com.jforce.task.domain.VoterDomain;
import com.jforce.task.exception.UserAlreadyExistException;
import com.jforce.task.exception.UserNotFoundExcetion;

public interface VoterService {

    VoterDomain register( VoterDomain voterDomain) throws UserAlreadyExistException;

    VoterDomain loginCheck(String username, String password) throws UserNotFoundExcetion;

    VoterDomain votingDone (String username);
    VoterDomain getVoter (String username);


}

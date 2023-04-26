package com.jforce.task.service;


import com.jforce.task.domain.CandidateDomain;

import java.util.List;

public interface CandidateService {
    List<CandidateDomain> getCandidateNames();

    CandidateDomain addCandidate(CandidateDomain candidateDomain);

    CandidateDomain addVoteCandidate(String candidateName);


}

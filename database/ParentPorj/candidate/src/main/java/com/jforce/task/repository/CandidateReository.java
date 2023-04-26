package com.jforce.task.repository;

import com.jforce.task.domain.CandidateDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateReository extends JpaRepository<CandidateDomain,String> {




}

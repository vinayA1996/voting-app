package com.jforce.task.repository;

import com.jforce.task.domain.VoterDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoterReository extends JpaRepository<VoterDomain,String> {

    VoterDomain  findByUsernameAndPassword(String username, String password);


}

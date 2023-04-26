package com.jforce.task.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
@AllArgsConstructor
@Data
@ToString
@NoArgsConstructor
@Entity
public class VoterDomain {
    @Id
    private String username;
    private String password;
    private String email;
    private  String phone;
    private String role ;
        private  boolean votingStatus;
}

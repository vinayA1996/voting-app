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
public class CandidateDomain {
    @Id
    private String candidateName;
   private int votes;
}

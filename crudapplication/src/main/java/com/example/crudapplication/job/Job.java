package com.example.crudapplication.job;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
//@Table(name="JobInfo")

public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String desc;
    private String location;
    private long minSal;
    private long maxSal;

    public Job() {

    }
}

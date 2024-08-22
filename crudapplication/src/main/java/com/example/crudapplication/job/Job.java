package com.example.crudapplication.job;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Job {
    private Long id;
    private String title;
    private String desc;
    private String location;
    private long minSal;
    private long maxSal;

}

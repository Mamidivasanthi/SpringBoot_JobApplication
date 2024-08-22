package com.example.crudapplication.job;

import java.util.List;

public interface JobService {
    List<Job> findall();
    void CreateJob(Job job);


    Job getJobById(Long id);

    boolean deleteJobById(Long id);

    boolean updateJob(Long id, Job updatedJob);
}

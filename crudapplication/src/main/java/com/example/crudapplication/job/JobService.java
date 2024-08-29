package com.example.crudapplication.job;

import java.util.List;

public interface JobService {

    List<Job> findall(Long CompanyId);
    boolean CreateJob(Long CompanyId,Job job);


    Job getJobById(Long CompanyId,Long jobId);





    boolean deleteJob(Long CompanyId, Long jobId);

    boolean updateJob(Long CompanyId, Long jobId, Job job);
}

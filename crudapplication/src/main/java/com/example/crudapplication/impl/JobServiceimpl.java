package com.example.crudapplication.impl;

import com.example.crudapplication.job.Job;
import com.example.crudapplication.job.JobRepository;
import com.example.crudapplication.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceimpl implements JobService {
    private JobRepository jobRepository;

    public JobServiceimpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }


    @Override
    public List<Job> findall() {

        return jobRepository.findAll();
    }

    @Override
    public void CreateJob(Job job) {

        jobRepository.save(job);

    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
        Optional<Job> jobOptional=jobRepository.findById(id);

            if(jobOptional.isPresent()){
                Job job=jobOptional.get();
                job.setTitle(updatedJob.getTitle());
                job.setDesc(updatedJob.getDesc());
                job.setLocation(updatedJob.getLocation());
                job.setMinSal(updatedJob.getMinSal());
                job.setMaxSal(updatedJob.getMaxSal());
                jobRepository.save(job);
                return true;
            }

        return false;
    }


}

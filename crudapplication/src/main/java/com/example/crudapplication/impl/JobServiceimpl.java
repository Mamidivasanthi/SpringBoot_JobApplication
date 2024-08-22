package com.example.crudapplication.impl;

import com.example.crudapplication.job.Job;
import com.example.crudapplication.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Service
public class JobServiceimpl implements JobService {
    private List<Job> jobs=new ArrayList<>();
    private Long nid=1L;


    @Override
    public List<Job> findall() {
        return jobs;
    }

    @Override
    public void CreateJob(Job job) {
       job.setId(nid++);
        jobs.add(job);

    }

    @Override
    public Job getJobById(Long id) {
        for(Job job:jobs){
            if(job.getId().equals(id)){
                return job;
            }
        }return null;
    }

    @Override
    public boolean deleteJobById(Long id) {
        Iterator<Job> iterator= jobs.iterator();
        while(iterator.hasNext()){
            Job job=iterator.next();
            if(job.getId().equals(id)){
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
        for(Job job:jobs){
            if(job.getId().equals(id)){
                job.setTitle(updatedJob.getTitle());
                job.setDesc(updatedJob.getDesc());
                job.setLocation(updatedJob.getLocation());
                job.setMinSal(updatedJob.getMinSal());
                job.setMaxSal(updatedJob.getMaxSal());
                return true;
            }
        }
        return false;
    }


}

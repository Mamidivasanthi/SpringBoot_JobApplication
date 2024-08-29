package com.example.crudapplication.job.impl;

import com.example.crudapplication.company.Company;
import com.example.crudapplication.company.CompanyService;
import com.example.crudapplication.company.impl.CompanyServiceImpl;
import com.example.crudapplication.job.Job;
import com.example.crudapplication.job.JobRepository;
import com.example.crudapplication.job.JobService;
import com.example.crudapplication.review.Review;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceimpl implements JobService {
    private JobRepository jobRepository;
    private CompanyService companyService;

    public JobServiceimpl(JobRepository jobRepository, CompanyService companyService) {
        this.jobRepository = jobRepository;
        this.companyService=companyService;
    }


    @Override
    public List<Job> findall(Long CompanyId) {

       List<Job> jobs=jobRepository.findByCompanyId(CompanyId);
       return jobs;
    }
    @Override
    public boolean CreateJob(Long CompanyId, Job job) {
        Company company=companyService.getCompanyById(CompanyId);
        if(company!=null){
            job.setCompany(company);
            jobRepository.save(job);
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    public Job getJobById(Long CompanyId, Long jobId) {
        List<Job> jobs=jobRepository.findByCompanyId(CompanyId);
        return jobs.stream().filter(review->review.getId().equals(jobId)).findFirst().orElse(null);
    }






    @Override
    public boolean deleteJob(Long CompanyId, Long jobId) {
        if(companyService.getCompanyById(CompanyId)!=null&&
               jobRepository.existsById(jobId))
        {
            Job job=jobRepository.findById(jobId).orElse(null);
            Company company=job.getCompany();
            company.getJobs().remove(job);
            job.setCompany(null);
            companyService.updateCompany(company,CompanyId);
            jobRepository.deleteById(jobId);
            return true;


        }
        else{
            return false;
        }

    }

    @Override
    public boolean updateJob(Long CompanyId, Long jobId, Job job) {
        if(companyService.getCompanyById(CompanyId)!=null){
           job.setCompany(companyService.getCompanyById(CompanyId));
            job.setId(jobId);
            jobRepository.save(job);
            return true;
        }else{
            return false;
        }
    }

}




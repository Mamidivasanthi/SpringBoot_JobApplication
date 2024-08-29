package com.example.crudapplication.job;

import com.example.crudapplication.company.CompanyService;
import com.example.crudapplication.review.Review;
import com.example.crudapplication.review.ReviewController;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/companies/{CompanyId}")
public class JobController {
    //    private Job jobs;
    private JobService jobService;
    private CompanyService companyService;

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findall(@PathVariable Long CompanyId) {
        return new ResponseEntity<>(jobService.findall(CompanyId),HttpStatus.OK);
    }
    @PostMapping("/jobs")
    public ResponseEntity<String> CreateJob(@PathVariable Long CompanyId,@RequestBody Job job){
        boolean isJobSaved=jobService.CreateJob(CompanyId, job);
        if(isJobSaved)
            return new ResponseEntity<>("Job Added Successfully",HttpStatus.OK);
        else
            return new ResponseEntity<>("Job Not Saved",HttpStatus.NOT_FOUND);
    }
    @GetMapping("/jobs/{jobId}")
    public ResponseEntity<Job> getJobById(@PathVariable Long CompanyId,@PathVariable Long jobId){
        Job job=jobService.getJobById(CompanyId,jobId);
        return new ResponseEntity<>(job,HttpStatus.OK);
    }
    @DeleteMapping("/jobs/{jobId}")
    public ResponseEntity<String> deleteJob(@PathVariable Long CompanyId,@PathVariable Long jobId){
        boolean isJobDeleted=jobService.deleteJob(CompanyId,jobId);
        if (isJobDeleted) {

            return new ResponseEntity<>("Job deleted successfully", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Job Not deleted",HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/jobs/{jobId}")
    public ResponseEntity<String> updateJob(@PathVariable Long CompanyId,@PathVariable Long jobId,@RequestBody Job job) {
        boolean isJobUpdated = jobService.updateJob(CompanyId, jobId, job);
        if (isJobUpdated) {

            return new ResponseEntity<>("Job updated successfully", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Job Not Updated",HttpStatus.NOT_FOUND);
        }
    }



}

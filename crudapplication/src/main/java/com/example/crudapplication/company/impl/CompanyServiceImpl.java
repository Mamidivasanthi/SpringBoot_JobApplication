package com.example.crudapplication.company.impl;

import com.example.crudapplication.company.Company;
import com.example.crudapplication.company.CompanyRepository;
import com.example.crudapplication.company.CompanyService;
import com.example.crudapplication.job.Job;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> companies() {
        return companyRepository.findAll();
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public boolean updateCompany(Company company1,Long id) {
        Optional<Company> companyOptional=companyRepository.findById(id);

        if(companyOptional.isPresent()){
            Company company=companyOptional.get();
            company.setName(company1.getName());
            company.setDescription(company.getDescription());
            company.setJobs(company1.getJobs());
            companyRepository.save(company);
            return true;
        }

        return false;

    }

    @Override
    public boolean deleteCompanyById(Long id) {
        if(companyRepository.existsById(id)){
            companyRepository.deleteById(id);
            return true;
        }
        else{
            return false;
        }


    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }


}


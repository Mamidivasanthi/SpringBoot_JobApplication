package com.example.crudapplication.company;

import java.util.List;

public interface CompanyService {
    List<Company> companies();
    void createCompany(Company company);
    boolean updateCompany(Company company1,Long id);
    boolean deleteCompanyById(Long id);
    Company getCompanyById(Long id);

}

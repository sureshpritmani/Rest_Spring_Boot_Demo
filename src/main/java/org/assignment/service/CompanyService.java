package org.assignment.service;

import java.util.List;

import org.assignment.entity.Company;
import org.assignment.entity.People;

public interface CompanyService {
     List<Company> getAllCompanies();
     Company getCompanyById(int companyId);
     boolean addCompany(Company company);
     void updateCompany(Company company);
     void deleteCompany(int companyId);
     
}
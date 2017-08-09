package org.assignment.dao;

import java.util.List;
import org.assignment.entity.Company;
import org.assignment.entity.People;
import org.springframework.stereotype.Component;

@Component
public interface CompanyDAO {
    List<Company> getAllCompanies();
    Company getCompanyById(int comanyId);
    void addCompany(Company company);
    void updateCompany(Company company);
    void deleteCompany(int companyId);
    boolean companyExists(String name);
    
} 
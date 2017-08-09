package org.assignment.service;

import java.util.List;
import org.assignment.dao.CompanyDAO;
import org.assignment.entity.Company;
import org.assignment.entity.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	private CompanyDAO companyDAO;
	
	@Override
	public Company getCompanyById(int companyId) {
		Company obj = companyDAO.getCompanyById(companyId);
		return obj;
	}	
	@Override
	public List<Company> getAllCompanies(){
		return companyDAO.getAllCompanies();
	}
	@Override
	public synchronized boolean addCompany(Company company){
        if (companyDAO.companyExists(company.getCompany())) {
            return true;
        } else {
            companyDAO.addCompany(company);
            return true;
        }
	}
	
	@Override
	public void updateCompany(Company company) {
		companyDAO.updateCompany(company);
	}
	
	@Override
	public void deleteCompany(int companyId) {
		companyDAO.deleteCompany(companyId);
	}
	
}

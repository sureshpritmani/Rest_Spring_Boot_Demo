package org.assignment.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.assignment.entity.Company;
import org.assignment.entity.People;

@Transactional
@Repository
public class CompanyDAOImpl implements CompanyDAO {
	
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public Company getCompanyById(int companyId) {
		return entityManager.find(Company.class, companyId);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Company> getAllCompanies() {
		String hql = "FROM Company as cmp ORDER BY cmp.id";
		return (List<Company>) entityManager.createQuery(hql).getResultList();
	}
	
	@Override
	public void addCompany(Company company) {
		entityManager.persist(company);
	}
	
	@Override
	public void updateCompany(Company company) {
		Company companyObj = getCompanyById(company.getIndex());
		company.setIndex(companyObj.getIndex());
		company.setCompany(companyObj.getCompany());
		entityManager.flush();
	}
	
	@Override
	public void deleteCompany(int CompanyId) {
		entityManager.remove(getCompanyById(CompanyId));
	}
	
	@Override
	public boolean companyExists(String name) {
		System.out.println("Company Name :" + name);
		String hql = "FROM Company as cmp WHERE cmp.company = :name";
		int count = entityManager.createQuery(hql).setParameter("name", name)
		              .getResultList().size();
		System.out.println("Count :" + count);
		return count > 0 ? true : false;
	}
} 

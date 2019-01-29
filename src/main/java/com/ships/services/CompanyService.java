/**
 * 
 */
package com.ships.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ships.model.ShippingCompany;
import com.ships.repositories.ShipCompanyInterface;

/**
 * @author G00339811
 *
 */
@Service
public class CompanyService {

	@Autowired
	private ShipCompanyInterface companyInt;

	/**
	 * Uses the shipCompany Interface to retrieve all companies from database
	 * 
	 * @return an ArrayList of company objects
	 */
	public ArrayList<ShippingCompany> getAllCompanies() {
		return (ArrayList<ShippingCompany>) companyInt.findAll();
	}

	/**
	 * Uses the shipCompany Interface to save a company to database
	 * 
	 * @param company
	 *            A ShippingCompany type object
	 * @return the saved entity
	 */
	public ShippingCompany addCompany(ShippingCompany company) {
		return companyInt.save(company);
	}

}

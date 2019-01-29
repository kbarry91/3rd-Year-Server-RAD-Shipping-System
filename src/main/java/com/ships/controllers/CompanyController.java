/**

 * 
 */
package com.ships.controllers;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ships.model.ShippingCompany;
import com.ships.services.CompanyService;

/**
 * @author G00339811
 *
 */

@Controller
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@RequestMapping(value = "/showShippingCompanies", method = RequestMethod.GET)
	public String getCompanies(Model m) {

		ArrayList<ShippingCompany> companies = companyService.getAllCompanies();
		m.addAttribute("companies", companies);

		return "showShippingCompanies";
	}

	/**
	 * method to handle a HTTP GET request for addShippingCompany,
	 * 
	 * @returns addShippingCompany a jsp page
	 */
	@RequestMapping(value = "/addShippingCompany", method = RequestMethod.GET)
	public String getCompany(@ModelAttribute("companyAdd") ShippingCompany c, HttpServletRequest h) {
		return "addShippingCompany";
	}

	/**
	 * method to handle a HTTP POST request for addShippingCompany,
	 * 
	 * @returns showShippingCompanies jsp if successful
	 * 
	 */
	@RequestMapping(value = "/addShippingCompany", method = RequestMethod.POST)
	public String addCompany(@Valid @ModelAttribute("companyAdd") ShippingCompany newCompany, BindingResult result,
			HttpServletRequest h, Model m) {

		// if an error in the validation result return the same page with error info
		if (result.hasErrors()) {
			return "addShippingCompany";
		} else {
			companyService.addCompany(newCompany);

			// re-populate the list
			ArrayList<ShippingCompany> companies = companyService.getAllCompanies();

			// add company to the model
			m.addAttribute("companies", companies);

			// return to show companies page
			return "showShippingCompanies";
		}
	}

}

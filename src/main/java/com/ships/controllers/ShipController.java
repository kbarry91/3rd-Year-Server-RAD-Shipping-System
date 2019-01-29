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

import com.ships.model.Ship;
import com.ships.services.ShipService;

/**
 * @author G00339811
 *
 */
@Controller
public class ShipController {

	@Autowired
	private ShipService shipService;

	/**
	 * method to handle a HTTP GET request for showShips
	 * 
	 * @param m
	 *            A model attribute object
	 * @return showShips A jsp file listing all ships
	 */
	@RequestMapping(value = "/showShips", method = RequestMethod.GET)
	public String getShips(Model m) {

		ArrayList<Ship> ships = shipService.getAllShips();
		m.addAttribute("ships", ships);

		return "showShips";
	}

	/**
	 * method to handle a HTTP GET request for addShip. .
	 * 
	 * @return addShip a jsp file that has an input form
	 */
	@RequestMapping(value = "/addShip", method = RequestMethod.GET)
	public String getShip(@ModelAttribute("shipAdd") Ship newShip, HttpServletRequest h) {
		return "addShip";
	}

	/**
	 * method to handle a HTTP POST request for addShip. Adds a ship to database.
	 * 
	 * @return showShips The jsp file that shows all orders
	 */
	@RequestMapping(value = "/addShip", method = RequestMethod.POST)
	public String addShip(@Valid @ModelAttribute("shipAdd") Ship newShip, BindingResult result, HttpServletRequest h,
			Model m) {
		// must ensure no errors in adding ship
		// if generic error return page with error tags
		if (result.hasErrors()) {
			return "addShip";
		} else {
			// add the ship to the database
			shipService.addShip(newShip);

			ArrayList<Ship> ships = shipService.getAllShips();

			// add the ship to the modelHolder
			m.addAttribute("ships", ships);

			// ship successfully added return to showShips page
			return "showShips";
		}
	}

}

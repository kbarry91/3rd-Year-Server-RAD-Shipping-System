/**
 * 
 */
package com.ships.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ships.model.Ship;
import com.ships.repositories.ShipInterface;

/**
 * @author g00339811
 *
 */

@Service
public class ShipService {

	@Autowired
	private ShipInterface shipInt;

	/**
	 * getAllShips uses the ShipInterface to get all ships from the Database
	 * 
	 * @Returns An Arraylist of Ship objects
	 */
	public ArrayList<Ship> getAllShips() {

		return (ArrayList<Ship>) shipInt.findAll();
	}

	/**
	 * Adds a new ship to the database.
	 * 
	 * @param ship
	 *            A ship model to add to database.
	 * @return the saved entity
	 */
	public Ship addShip(Ship ship) {
		return shipInt.save(ship);
	}
}

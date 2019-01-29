/**
 * 
 */
package com.ships.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ships.model.OrderInfo;
import com.ships.model.Ship;
import com.ships.model.ShippingCompany;
import com.ships.repositories.OrderInterface;
import com.ships.repositories.ShipCompanyInterface;
import com.ships.repositories.ShipInterface;

/**
 * @author G00339811
 *
 */
@Service
public class OrderService {

	@Autowired
	private OrderInterface orderInt;

	@Autowired
	private ShipInterface shipInterface;

	@Autowired
	private ShipCompanyInterface companyInterface;

	@Autowired
	private ShipService shipService;

	private Ship ship;
	private ShippingCompany ShippingCompany;

	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private Date date = new Date();

	/**
	 * getAllOrders uses the OrderInterface to get all orders from the Database
	 * 
	 * @Returns An Arraylist of OrderInfo objects
	 */
	public ArrayList<OrderInfo> getAllOrders() {
		return (ArrayList<OrderInfo>) orderInt.findAll();
	}

	/**
	 * Adds a new order to the database. Must also update the ship and company in
	 * database.
	 * 
	 * @param order
	 *            and OrderInfo entity
	 * @return the saved entity
	 */
	public OrderInfo addOrder(OrderInfo order) {

		// check if ship is available
		if (shipInterface.findOne(order.getShip().getSid()) != null) {
			ship = shipInterface.findOne(order.getShip().getSid());
		}
		// ship = shipInterface.findOne(order.getShip().getSid());

		ShippingCompany = companyInterface.findOne(order.getShippingCompany().getScid());

		ship.setShippingCompany(order.getShippingCompany());

		shipService.addShip(ship);

		order.setShippingCompany(ShippingCompany);

		order.setDate(dateFormat.format(date));

		return orderInt.save(order);
	}
}

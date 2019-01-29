/**
 * 
 */
package com.ships.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ships.model.OrderInfo;
import com.ships.model.Ship;
import com.ships.model.ShippingCompany;
import com.ships.services.CompanyService;
import com.ships.services.OrderService;
import com.ships.services.ShipService;

/**
 * @author G00339811
 *
 */

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private ShipService shipService;

	@Autowired
	private CompanyService companyService;

	/**
	 * method to handle a HTTP GET request for showOrders
	 * 
	 * @return showOrders A jsp file listing all orders
	 */
	@RequestMapping(value = "/showOrders", method = RequestMethod.GET)
	public String getOrders(Model m) {

		ArrayList<OrderInfo> orders = orderService.getAllOrders();
		m.addAttribute("orders", orders);

		return "showOrders";
	}

	/**
	 * method to handle a HTTP GET request for createOrder. Populates lists for drop
	 * down boxes and adds them to the model.
	 * 
	 * @return createOrder a jsp file that has an input form
	 */
	@RequestMapping(value = "/createOrder", method = RequestMethod.GET)
	public String getShip(@ModelAttribute("orderAdd") OrderInfo c, HttpServletRequest h, Model m) {

		ArrayList<Ship> ships = shipService.getAllShips();

		// must map ids to ship for list
		Map<Long, String> shipList = new HashMap<Long, String>();

		for (Ship s : ships) {
			if (s.getShippingCompany() == null) {
				shipList.put(s.getSid(), s.getName() + ", Cost = " + s.getCost());
			}
		}
		// add mapped list to model
		m.addAttribute("shipList", shipList);

		ArrayList<ShippingCompany> companies = companyService.getAllCompanies();

		Map<Long, String> companyList = new HashMap<Long, String>();

		for (ShippingCompany sc : companies) {
			companyList.put(sc.getScid(), sc.getName() + ", Balance = " + sc.getBalance());
		}

		m.addAttribute("companyList", companyList);

		return "createOrder";
	}
 
	/**
	 * method to handle a HTTP POST request for createOrder. adds a order to the
	 * database
	 * 
	 * @return showOrders The jsp file that shows all orders
	 */
	@RequestMapping(value = "/createOrder", method = RequestMethod.POST)
	public String addShip(@Valid @ModelAttribute("orderAdd") OrderInfo order, BindingResult result,
			HttpServletRequest h, Model m) {

		// must ensure no errors in order
		// if generic error return page with error tags
		// if no ship or company must show page stating no ship or company
		// if balance is too low must show page stating balance too low
		if (result.hasErrors()) {
			return "addOrder";
		} else if (order.getShip() == null || order.getShippingCompany() == null) {
			return "addOrderSelectError";
		} else if (order.getShip().getCost().compareTo(order.getShippingCompany().getBalance()) == (0 | 1)) {
			return "addOrderBalanceError";
		}

		else {
			// if order is success must subtract ship price from company balance
			order.getShippingCompany()
					.setBalance(order.getShippingCompany().getBalance().subtract(order.getShip().getCost()));
			// update order info
			orderService.addOrder(order);
			/// update ship info
			shipService.addShip(order.getShip());
			// update company info
			companyService.addCompany(order.getShippingCompany());

			ArrayList<OrderInfo> orders = orderService.getAllOrders();
			m.addAttribute("orders", orders);

			return "showOrders";
		}
	}

}

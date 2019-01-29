/**
 * 
 */
package com.ships.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ships.model.ShippingCompany;

/**
 * @author g00339811
 *
 */
public interface ShipCompanyInterface  extends CrudRepository<ShippingCompany, Long>{

}

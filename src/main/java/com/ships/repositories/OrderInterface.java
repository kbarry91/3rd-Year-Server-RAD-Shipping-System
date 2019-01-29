package com.ships.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ships.model.OrderInfo;
/**
 * @author G00339811
 *
 */
@Repository
public interface OrderInterface extends CrudRepository<OrderInfo, Long> {

}

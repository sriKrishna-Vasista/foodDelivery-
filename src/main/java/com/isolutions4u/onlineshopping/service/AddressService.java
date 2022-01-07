package com.isolutions4u.onlineshopping.service;

import java.util.List;

import com.isolutions4u.onlineshopping.model.Address;

public interface AddressService {

	boolean saveAddress(Address address);
	Address findAddressByBilling(boolean billing);
	List<String> findAll();

}

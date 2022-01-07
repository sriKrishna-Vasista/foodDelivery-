package com.isolutions4u.onlineshopping.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.isolutions4u.onlineshopping.model.Address;
import com.isolutions4u.onlineshopping.repository.AddressRepository;

@Service("addressService")
public class AddressServiceImpl implements AddressService {

	@Qualifier("addressRepository")
	@Autowired
	private AddressRepository addressRepository;
	
	@Override
	public boolean saveAddress(Address address) {
		// TODO Auto-generated method stub
		addressRepository.saveAndFlush(address);
		return true;
	}

	@Override
	public Address findAddressByBilling(boolean billing) {
		// TODO Auto-generated method stub
		return addressRepository.findAddressByBilling(billing);
	}
	
	public List<String> findAll() {
		// TODO Auto-generated method stub
		
		List<Address> addresses =  addressRepository.findAll();
		List<String> cities = new ArrayList<String>();
		for(Address thisAdd : addresses) {
			if(thisAdd.getCity()==null) {
				continue;
			}
			cities.add(thisAdd.getCity());
		}
		return cities;
	}
	
}

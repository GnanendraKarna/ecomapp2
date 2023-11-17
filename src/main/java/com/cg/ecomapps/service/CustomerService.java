package com.cg.ecomapps.service;

import java.util.List;

import com.cg.ecomapps.entity.Customer;

public interface CustomerService {
	
    void saveCustomer(Customer  customer);
	
	Customer getCustomerById(int customerId);
	
	List<Customer> getAllCustomers();
	
	void deleteCustomerById(int customerId);
	
	Customer updateCustomer(Customer customer);
	

}

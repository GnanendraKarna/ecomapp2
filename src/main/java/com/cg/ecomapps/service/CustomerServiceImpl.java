package com.cg.ecomapps.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ecomapps.entity.Cart;
import com.cg.ecomapps.entity.Customer;
import com.cg.ecomapps.exception.CustomerNotFoundException;
import com.cg.ecomapps.repository.CartRepository;
import com.cg.ecomapps.repository.CustomerRepository;
@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Override
	public void saveCustomer(Customer customer) {
		
		customerRepository.save(customer);
		
		Cart cart = new Cart();
		cart.setCartId(0);
		cart.setCartItems(null);
		cart.setCartTotal(0);
		cart.setCustomer(customer);
		
		cartRepository.save(cart);
	}

	@Override
	public Customer getCustomerById(int customerId) throws CustomerNotFoundException{
		
		Optional<Customer> customer = customerRepository.findById(customerId);
		if(customer.isEmpty()) {
			throw new CustomerNotFoundException("Customer not found with ID - "+customerId);
		}
		return customer.get();
	}

	@Override
	public List<Customer> getAllCustomers() {
		
		List<Customer> customerList = customerRepository.findAll();
		return customerList;
	}

	@Override
	public void deleteCustomerById(int customerId) throws CustomerNotFoundException{
		
		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
		if(optionalCustomer.isEmpty()) {
			throw new CustomerNotFoundException("Customer not found with ID - "+customerId);
		}
		Customer customer = optionalCustomer.get();
		customerRepository.delete(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException{
		
		Optional<Customer> optionalCustomer = customerRepository.findById(customer.getCustomerId());
		if(optionalCustomer.isEmpty()) {
			throw new CustomerNotFoundException("Customer not found with ID - "+customer.getCustomerId());
		}
		Customer updateCustomer = customerRepository.save(customer);
		return updateCustomer;
	}
	
}

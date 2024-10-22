package com.iitposs.pos.service.impl;

import com.iitposs.pos.dto.request.CustomerSaveRequestDTO;
import com.iitposs.pos.entity.Customer;
import com.iitposs.pos.repo.CustomerReo;
import com.iitposs.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerReo customerReo;

    @Override
    public String saveCustomer(CustomerSaveRequestDTO saveRequestDTO) {

        Customer customer = new Customer(
                1,
                saveRequestDTO.getCustomerName(),
                saveRequestDTO.getCustomerAddress(),
                saveRequestDTO.getSalary(),
                saveRequestDTO.getContacts(),
                saveRequestDTO.getNic(),
                saveRequestDTO.isActiveState()
        );

        customerReo.save(customer);

        return "saved";

    }

    @Override
    public String updateCustomer(CustomerSaveRequestDTO requestDTO) {

        if (customerReo.existsById(requestDTO.getCustomerID())) {

            Customer customer = customerReo.getReferenceById(requestDTO.getCustomerID());

            customer.setCustomerName(requestDTO.getCustomerName());
            customer.setCustomerAddress(requestDTO.getCustomerAddress());
            customer.setSalary(requestDTO.getSalary());
            customer.setActiveState(requestDTO.isActiveState());

            customerReo.save(customer);

            return requestDTO.getCustomerName() + " has been updated...!";

        } else {
            return "something went wrong...!";
        }

    }
}

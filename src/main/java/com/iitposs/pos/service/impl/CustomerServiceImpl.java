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
                saveRequestDTO.getCustomerID(),
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
}

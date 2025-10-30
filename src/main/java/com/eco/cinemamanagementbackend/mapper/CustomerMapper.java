package com.eco.cinemamanagementbackend.mapper;

import com.eco.cinemamanagementbackend.dto.response.customer.CustomerResponse;
import com.eco.cinemamanagementbackend.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper extends BaseMapper<Customer, CustomerResponse> {
}

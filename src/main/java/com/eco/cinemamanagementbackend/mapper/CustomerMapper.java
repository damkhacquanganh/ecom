package com.eco.cinemamanagementbackend.mapper;

import com.eco.cinemamanagementbackend.dto.response.customer.CustomerResponse;
import com.eco.cinemamanagementbackend.entity.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")  // Chỉ cần annotation này
public interface CustomerMapper extends BaseMapper<Customer, CustomerResponse> {

    @Override
    CustomerResponse toDto(Customer entity);

    @Override
    default List<CustomerResponse> toDtoList(List<Customer> entities) {
        return entities.stream().map(this::toDto).toList();
    }
}
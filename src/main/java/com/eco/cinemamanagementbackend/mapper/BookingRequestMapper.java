package com.eco.cinemamanagementbackend.mapper;

import com.eco.cinemamanagementbackend.dto.response.booking.BookingResponse;
import com.eco.cinemamanagementbackend.entity.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface BookingRequestMapper extends BaseMapper<Booking, BookingResponse>  {

    @Mapping(target = "customeId",source = "customer.customerId")
    @Mapping(target = "showtimeId", source = "showtime.showtimeId")
    BookingResponse toDto(Booking entity);

}

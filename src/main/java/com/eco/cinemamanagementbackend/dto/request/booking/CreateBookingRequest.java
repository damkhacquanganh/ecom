package com.eco.cinemamanagementbackend.dto.request.booking;

import com.eco.cinemamanagementbackend.entity.Concession;
import com.eco.cinemamanagementbackend.entity.Seat;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateBookingRequest {
    Integer cinemaId;
    //mã rạp
    Integer showtimeId;
    //id xuất chiếu
    List<SeatBooking> seats;
    //danh sách vé
    List<ConcessionItem> concessions;
// danh sách đồ ăn
    String promotionCode;
// mã giảm giá
    String notes;
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SeatBooking {
        Integer seatId;
// mã ghếA
        String ticketType;
        // loại vé

    }

    public static class ConcessionItem {
        Integer concessionId;
        // mã đồ ăn
        Integer quantity;
        // số lượng đồ ăn
    }
}

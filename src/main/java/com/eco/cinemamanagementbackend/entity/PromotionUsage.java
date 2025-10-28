package com.eco.cinemamanagementbackend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "promotion_usage")//lịch sử dùng mã
public class PromotionUsage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer usageId;
// định nghĩa id được giảm giá được tạo tự động
    @ManyToOne
    @JoinColumn(name = "promotion_id", nullable = false)
    Promotion promotion;
//nỗi nhiều một với mã giảm vì có thể nhiều lần đùng, không được để trống.
    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = false)
    Booking booking;
// nối nhiều một với booking vì mỗi booking có khả năng giảm giá một lần và không được đẻ trống
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    Customer customer;
//nối nhiều một vơi khách hàng vì một mã giảm được nhiều khách hàng dùng và không được để trống
    @Column(nullable = false, precision = 10, scale = 2)
    BigDecimal discountAmount;
// số tiền giảm giá không được để trống
    @CreationTimestamp
    LocalDateTime usedAt;
}// thời gian được sử dụng
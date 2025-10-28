package com.eco.cinemamanagementbackend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "promotions")
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer promotionId;
// tự động sinh mã khuyến mãi và là khóa chính
    @Column(nullable = false, unique = true)
    String code;
// mã code giảm giá và đặc biệt không được để trống
    @Column(nullable = false)
    String title;
// tiêu đề không được đẻ trống
    String description;
// mô tả
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    DiscountType discountType;
// loại giảm giá được định nghĩa trong enum và không được để trống
    @Column(nullable = false, precision = 10, scale = 2)
    BigDecimal discountValue;
// giá trị giảm giá
    @Column(precision = 10, scale = 2)
    BigDecimal minPurchaseAmount = BigDecimal.ZERO;
//đơn tối thiểu được giảm và được mặc định là không
    @Column(precision = 10, scale = 2)
    BigDecimal maxDiscountAmount;
//mã giảm giá tối  đa
    Integer usageLimit;
    // giối hạn lần dùng
    Integer usedCount = 0;
// số ần dùng được traccking
    @Column(nullable = false)
    LocalDateTime startDate;
// thời gian bắt đầu không được để trống
    @Column(nullable = false)
    LocalDateTime endDate;
// thời gian kết thúc
    @Column(columnDefinition = "JSON")
    String applicableDays;
// ngày áp dụng vd thứ 2 thứ 4
    @Column(columnDefinition = "JSON")
    String applicableTimes;
// giờ áp dung chỉ sáng hoặc chiều hoặc cả hai
    Boolean isActive = true;
// hoạt động mặc định là true
    @CreationTimestamp
    LocalDateTime createdAt;
// thời gian tạo được tự đông lần đầu
    @UpdateTimestamp
    LocalDateTime updatedAt;
// thời gian update được tạo tự động
    public enum DiscountType {
        PERCENTAGE, FIXED_AMOUNT, FREE_ITEM
    }
}// định nghĩa loại mã giảm giá

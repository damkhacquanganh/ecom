package com.eco.cinemamanagementbackend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "work_schedules")
public class WorkSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer scheduleId;
// mã lịch trình làm việc
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    Employee employee;
//nhiều lịch trình cho 1 nhân viên
    @ManyToOne
    @JoinColumn(name = "cinema_id", nullable = false)
    Cinema cinema;
//nhiều lịch trình cho rạp chiếu và không để trống
    @Column(nullable = false)
    LocalDate workDate;
//thời gian làm việc
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    Shift shift;
//ca làm được định nghĩa
    @Column(nullable = false)
    LocalTime startTime;
//thời gian bắt dầu không được để trống
    @Column(nullable = false)
    LocalTime endTime;
// thời gian kết thúc
    @Enumerated(EnumType.STRING)
    Status status = Status.SCHEDULED;
//trạng thái được định nghĩa mặc định là đã lên lịch
    String notes;

    @CreationTimestamp
    LocalDateTime createdAt;

    public enum Shift {
        MORNING, AFTERNOON, EVENING, FULL_DAY
    }

    public enum Status {
        SCHEDULED, COMPLETED, ABSENT, CANCELLED
    }// đã lên, hoàn thành, vắng mặt v hủy
}

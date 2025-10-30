package com.eco.cinemamanagementbackend.repository;

import com.eco.cinemamanagementbackend.entity.RevenueReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevenueReportReponsitory extends JpaRepository<RevenueReport, Integer> {
}

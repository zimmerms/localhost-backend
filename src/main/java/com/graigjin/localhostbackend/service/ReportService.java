package com.graigjin.localhostbackend.service;

import com.graigjin.localhostbackend.dao.ReportRepository;
import com.graigjin.localhostbackend.model.Report;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    private final ReportRepository reportRepository;

    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public List<Report> findAll() {
        return reportRepository.findAll();
    }
}

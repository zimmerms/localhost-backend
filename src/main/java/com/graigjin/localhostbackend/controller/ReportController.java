package com.graigjin.localhostbackend.controller;

import com.graigjin.localhostbackend.model.Report;
import com.graigjin.localhostbackend.service.ReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    public List<Report> findAll() {
        return reportService.findAll();
    }
}

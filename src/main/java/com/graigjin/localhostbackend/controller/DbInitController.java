package com.graigjin.localhostbackend.controller;

import com.graigjin.localhostbackend.service.DbInitService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class DbInitController {

    private final DbInitService initService;

    public DbInitController(DbInitService initService) {
        this.initService = initService;
    }

    @PostConstruct
    public void init() {
        initService.initRoles();
        initService.initActionItems();
        initService.initPeople();
        initService.initUsers();
        initService.initAddresses();
        initService.initCars();
        initService.initMeasurements();
        initService.initServices();
        initService.initClients();
        initService.initWorkshops();
        initService.initCreators();
        initService.initReports();
    }
}

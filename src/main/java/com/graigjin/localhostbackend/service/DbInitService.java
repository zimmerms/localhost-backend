package com.graigjin.localhostbackend.service;

import com.graigjin.localhostbackend.dao.*;
import com.graigjin.localhostbackend.model.*;
import com.graigjin.localhostbackend.model.enums.EActionItem;
import com.graigjin.localhostbackend.model.enums.ERole;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DbInitService {

    private final RoleRepository roleRepository;
    private final ActionItemRepository actionItemRepository;
    private final PersonRepository personRepository;
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final CarRepository carRepository;
    private final MeasurementRepository measurementRepository;
    private final ServiceRepository serviceRepository;
    private final ClientRepository clientRepository;
    private final WorkshopRepository workshopRepository;
    private final CreatorRepository creatorRepository;
    private final ReportRepository reportRepository;

    private final PasswordEncoder encoder;

    public DbInitService(RoleRepository roleRepository,
                         ActionItemRepository actionItemRepository,
                         PersonRepository personRepository,
                         UserRepository userRepository,
                         AddressRepository addressRepository,
                         CarRepository carRepository,
                         MeasurementRepository measurementRepository,
                         ServiceRepository serviceRepository,
                         ClientRepository clientRepository,
                         WorkshopRepository workshopRepository,
                         CreatorRepository creatorRepository,
                         ReportRepository reportRepository,
                         PasswordEncoder encoder) {
        this.roleRepository = roleRepository;
        this.actionItemRepository = actionItemRepository;
        this.personRepository = personRepository;
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.carRepository = carRepository;
        this.measurementRepository = measurementRepository;
        this.serviceRepository = serviceRepository;
        this.clientRepository = clientRepository;
        this.workshopRepository = workshopRepository;
        this.creatorRepository = creatorRepository;
        this.reportRepository = reportRepository;
        this.encoder = encoder;
    }

    public void initRoles() {
        List<Role> roles = new ArrayList<>();
        roles.add(new Role(ERole.ROLE_ADMIN));
        roles.add(new Role(ERole.ROLE_MODERATOR));
        roles.add(new Role(ERole.ROLE_USER));
        roleRepository.saveAll(roles);
    }

    public void initActionItems() {
        List<ActionItem> actionItems = new ArrayList<>();
        actionItems.add(new ActionItem(EActionItem.ACTION_ITEM_DONE));
        actionItems.add(new ActionItem(EActionItem.ACTION_ITEM_RECOMMENDED));
        actionItemRepository.saveAll(actionItems);
    }

    public void initPeople() {
        List<Person> people = new ArrayList<>();
        people.add(new Person(
                "Vorname",
                "Nachname",
                "+49 89 123 456 7890",
                "vorname.nachname@werkstatt.de"
        ));
        people.add(new Person(
                "Sebastian",
                "Zimmermann",
                "+49 159 0172 6005",
                "zimmermann.email@web.de"
        ));
        personRepository.saveAll(people);
    }

    public void initUsers() {
        Role admin = roleRepository.findByName(ERole.ROLE_ADMIN).get();
        Role mod = roleRepository.findByName(ERole.ROLE_MODERATOR).get();
        Role user = roleRepository.findByName(ERole.ROLE_USER).get();

        List<User> users = new ArrayList<>();

        Set<Role> userRoles = new HashSet<>();
        Set<Role> modRoles = new HashSet<>();
        Set<Role> adminRoles = new HashSet<>();

        userRoles.add(user);

        modRoles.add(user);
        modRoles.add(mod);

        adminRoles.add(user);
        adminRoles.add(mod);
        adminRoles.add(admin);

        User userUser = new User("user", encoder.encode("123456"));
        userUser.setRoles(userRoles);
        users.add(userUser);

        User modUser = new User("mod", encoder.encode("123456"));
        modUser.setRoles(modRoles);
        users.add(modUser);

        User adminUser = new User("admin", encoder.encode("123456"));
        adminUser.setRoles(adminRoles);
        users.add(adminUser);

        userRepository.saveAll(users);
    }

    public void initAddresses() {
        List<Address> addresses = new ArrayList<>();
        addresses.add(new Address(
                "Werkstattstr. 34",
                "12345",
                "Werkstadt",
                "BY",
                "Deutschland"
        ));
        addresses.add(new Address(
                "Waterloostr. 32a",
                "81476",
                "München",
                "BY",
                "Deutschland"
        ));
        addressRepository.saveAll(addresses);
    }

    public void initCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("BMW", "330i", "M-AB 1234"));
        cars.add(new Car("Audi", "Q3", "M-UM 2303"));
        carRepository.saveAll(cars);
    }

    public void initMeasurements() {
        List<Measurement> measurements = new ArrayList<>();
        measurements.add(new Measurement(800, 200));
        measurements.add(new Measurement(1200, 150));
        measurementRepository.saveAll(measurements);
    }

    public void initServices() {
        List<com.graigjin.localhostbackend.model.Service> services = new ArrayList<>();
        ActionItem done = actionItemRepository.findByName(EActionItem.ACTION_ITEM_DONE).get();
        ActionItem recommended = actionItemRepository.findByName(EActionItem.ACTION_ITEM_RECOMMENDED).get();

        services.add(new com.graigjin.localhostbackend.model.Service(
                done,
                true,
                true,
                true,
                new GregorianCalendar(2024, Calendar.APRIL, 15).getTime()
        ));
        services.add(new com.graigjin.localhostbackend.model.Service(
                recommended,
                false,
                false,
                false,
                new GregorianCalendar(2022, Calendar.DECEMBER, 1).getTime()
        ));
        serviceRepository.saveAll(services);
    }

    public void initClients() {
        Set<Address> addresses = new HashSet<>();
        addresses.add(addressRepository.getById(2L));

        Client client = new Client();
        client.setPerson(personRepository.getById(2L));
        client.setAddresses(addresses);

        clientRepository.save(client);
    }

    public void initWorkshops() {
        Workshop workshop = new Workshop(
                "Test Werkstatt",
                addressRepository.getById(1L)
        );

        workshopRepository.save(workshop);
    }

    public void initCreators() {
        Creator creator = new Creator(
                personRepository.getById(1L),
                userRepository.getById(1L),
                workshopRepository.getById(1L)
        );

        creatorRepository.save(creator);
    }

    public void initReports() {
        List<Report> reports = new ArrayList<>();
        reports.add(new Report(
                creatorRepository.getById(1L),
                clientRepository.getById(1L),
                carRepository.getById(1L),
                measurementRepository.getById(1L),
                serviceRepository.getById(1L)
        ));
        reports.add(new Report(
                creatorRepository.getById(1L),
                clientRepository.getById(1L),
                carRepository.getById(2L),
                measurementRepository.getById(2L),
                serviceRepository.getById(2L)
        ));
        reportRepository.saveAll(reports);
    }
}

package com.campus.restaurant.booking.api;

import com.campus.restaurant.booking.model.Table;
import com.campus.restaurant.booking.repository.TableRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TableApiController {

    private final Logger log = LoggerFactory.getLogger(TableApiController.class);

    @Autowired
    private TableRepository tableRepository;


    // int counter;

    // /api/table/1
    @GetMapping("/tables/{id}")
    public Table getTable(@PathVariable("id") Integer id) {

        /*
        Table table = new Table();
        table.setFrom(11);
        table.setTo(14);
        table.setPersonName("Johannes");
        table.setNumberOfPersons(9);

        this.counter++;
        System.out.println("getTable was called: " + this.counter + " times");

        ;
        */
        log.info("request by id: " + id);
        return tableRepository.getOne(id);

    }

    @GetMapping("/tables/name/{name}")
    public List<Table> getTableByName(@PathVariable("name") String name) {


        List<Table> tables = tableRepository.findByPersonName(name);
        //tableRepository.gibMirAlleByName(name);
        log.info("request by name: {}", name);
        // tableRepository.
        return tables;
    }

    @GetMapping("tables/NumberOfPersonsGreaterThan/{numberOfPersons}")
        public List<Table> getTableByNumberOfPersonsGreaterThan(@PathVariable ("numberOfPersons")Integer number){

        Integer numberTemp = number;
        log.info("number of persons greater then: " , numberTemp, " -- hier muss noch die Anzahl über den Request ausgewertet werden." );
        List<Table> tables = tableRepository.findByNumberOfPersonsGreaterThan(numberTemp);
        return tables;


    }


    @GetMapping("/tables")
    public List<Table> getAllTables() {
        log.info("REST request to get all tables: count: {} {}", tableRepository.count(), "TABLES");
        return tableRepository.findAll();
    }
}

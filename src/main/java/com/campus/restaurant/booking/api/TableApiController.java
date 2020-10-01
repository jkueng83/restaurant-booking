package com.campus.restaurant.booking.api;

import com.campus.restaurant.booking.model.Table;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TableApiController {
int counter;
    @GetMapping("/api/table")
    public Table getTable() {

        Table table = new Table();
        table.setFrom(11);
        table.setTo(14);
        table.setPersonName("Johannes");
        table.setNumberOfPersons(9);

        this.counter++;
        System.out.println("getTable was called: " + this.counter + " times");

        return table;

    }

}

package com.campus.restaurant.booking.api;

import com.campus.restaurant.booking.model.Table;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TableApiController {

    @GetMapping("/table")
    public Table getTable() {

        Table table = new Table();
        table.setFrom(11);
        table.setTo(14);
        table.setName("Johannes");
        table.setNumberOfPersons(9);

        return table;

    }

}

package com.campus.restaurant.booking.web;

import com.campus.restaurant.booking.api.TableApiController;
import com.campus.restaurant.booking.model.Table;
import com.campus.restaurant.booking.repository.TableRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.slf4j.Logger;

import java.util.List;


@Controller
public class TableController {

    private final Logger log = LoggerFactory.getLogger(TableApiController.class);

    @Autowired
    private TableRepository tableRepository;

    @GetMapping("/table")
    public String tableForm(Model model) {
        Table table = new Table();
        model.addAttribute("table", table);
        return "table";
    }

    @PostMapping("/table")
    public String tableSubmit(@ModelAttribute Table table, Model model) {

        tableRepository.save(table);
        model.addAttribute("table", table);

        return "result";
    }

    // /table/view?id=1
    @GetMapping("/table/view")
    public String viewOneTable(@RequestParam("id") Integer id, Model model){
        log.debug("entered vie one method with id {}",id);

        Table table = tableRepository.getOne(id);
        model.addAttribute("table",table);

        return "result";
    }

}

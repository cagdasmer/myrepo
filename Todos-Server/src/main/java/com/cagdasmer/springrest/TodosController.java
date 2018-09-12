package com.cagdasmer.springrest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodosController {

    @RequestMapping("/")
    public String index() {
        return "Congratulations from TodosController.java";
    }

}



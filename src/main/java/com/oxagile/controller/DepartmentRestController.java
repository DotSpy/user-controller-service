package com.oxagile.controller;

import com.oxagile.model.dto.DepartmentDTO;
import com.oxagile.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentRestController {


    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/departments", method = RequestMethod.GET)
    public List<DepartmentDTO> getAllDepartments() {
        return departmentService.getAllDepartments();
    }


}

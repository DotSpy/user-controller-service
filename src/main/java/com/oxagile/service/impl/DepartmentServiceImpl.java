package com.oxagile.service.impl;

import com.oxagile.dao.DepartmentDao;
import com.oxagile.model.dto.DepartmentDTO;
import com.oxagile.service.DepartmentDbToDtoConverter;
import com.oxagile.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private DepartmentDbToDtoConverter departmentDbToDtoConverter;

    @Override
    @Transactional
    public List<DepartmentDTO> getAllDepartments() {
        return departmentDbToDtoConverter.convertListDepartmentDbToDto(departmentDao.getAllDepartments());
    }
}

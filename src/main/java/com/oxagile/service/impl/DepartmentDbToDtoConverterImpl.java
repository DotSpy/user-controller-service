package com.oxagile.service.impl;

import com.oxagile.model.database.DepartmentDb;
import com.oxagile.model.dto.DepartmentDTO;
import com.oxagile.service.DepartmentDbToDtoConverter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentDbToDtoConverterImpl implements DepartmentDbToDtoConverter {

    @Override
    public List<DepartmentDTO> convertListDepartmentDbToDto(List<DepartmentDb> departmentDbs) {
        return departmentDbs.stream().map(this::convertDepartmentDbToDto).collect(Collectors.toList());
    }

    @Override
    public DepartmentDTO convertDepartmentDbToDto(DepartmentDb departmentDb) {
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setName(departmentDb.getName());
        return departmentDTO;
    }
}

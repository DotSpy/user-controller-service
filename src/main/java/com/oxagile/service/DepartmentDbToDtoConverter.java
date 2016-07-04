package com.oxagile.service;

import com.oxagile.model.database.DepartmentDb;
import com.oxagile.model.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentDbToDtoConverter {

    List<DepartmentDTO> convertListDepartmentDbToDto(List<DepartmentDb> departmentDbs);

    DepartmentDTO convertDepartmentDbToDto(DepartmentDb departmentDb);

}

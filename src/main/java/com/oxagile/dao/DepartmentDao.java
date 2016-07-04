package com.oxagile.dao;

import com.oxagile.model.database.DepartmentDb;

import java.util.List;

public interface DepartmentDao {

    List<DepartmentDb> getAllDepartments();

    DepartmentDb findByName(String name);

    void saveDepartment(DepartmentDb departmentDb);

    void deleteDepartment(DepartmentDb departmentDb);

}

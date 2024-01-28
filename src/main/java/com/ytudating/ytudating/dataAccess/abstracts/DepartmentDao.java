package com.ytudating.ytudating.dataAccess.abstracts;

import com.ytudating.ytudating.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentDao extends JpaRepository<Department, Integer> {

    Department findById(int id);

}

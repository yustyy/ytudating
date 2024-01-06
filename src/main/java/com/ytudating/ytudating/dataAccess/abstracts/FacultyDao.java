package com.ytudating.ytudating.dataAccess.abstracts;

import com.ytudating.ytudating.entities.Department;
import com.ytudating.ytudating.entities.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyDao extends JpaRepository<Faculty, Integer> {

    Faculty findById(int id);

}

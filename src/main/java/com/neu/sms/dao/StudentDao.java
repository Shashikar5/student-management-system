package com.neu.sms.dao;

import com.neu.sms.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student, Long> {
}

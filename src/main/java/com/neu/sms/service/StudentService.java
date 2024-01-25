package com.neu.sms.service;

import com.neu.sms.dto.StudentDto;
import com.neu.sms.models.Student;

import java.util.List;

public interface StudentService {
    List<StudentDto> findAllStudents();

    StudentDto createNewStudent(Student student);

    StudentDto getStudentById(Long id);

    StudentDto updateStudent(Student student);

    void deleteStudent(Long id);
}

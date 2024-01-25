package com.neu.sms.service.Impl;

import com.neu.sms.dao.StudentDao;
import com.neu.sms.dto.StudentDto;
import com.neu.sms.models.Student;
import com.neu.sms.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<StudentDto> findAllStudents() {
            List<Student> studentsList = studentDao.findAll();
            return studentsList.stream().map((student) -> mapToDto(student)).collect(Collectors.toList());
    }

    @Override
    public StudentDto createNewStudent(Student student) {
        Student student1 = studentDao.save(student);
        return mapToDto(student1);
    }

    @Override
    public StudentDto getStudentById(Long id) {
        return mapToDto(studentDao.findById(id).get());
    }

    @Override
    public StudentDto updateStudent(Student student) {
        return mapToDto(studentDao.save(student));
    }

    @Override
    public void deleteStudent(Long id) {
        studentDao.deleteById(id);
    }

    private StudentDto mapToDto(Student student) {
        return StudentDto.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .email(student.getEmail())
                .build();
    }
}

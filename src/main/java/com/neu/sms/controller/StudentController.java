package com.neu.sms.controller;

import com.neu.sms.dto.StudentDto;
import com.neu.sms.models.Student;
import com.neu.sms.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

    /*
        Thymeleaf notes
        Basic principle - we can return API endpoints as string and add model attribute(model.addAttribute("students", studentDtoList);)
        and display the saved attribute in the html page

        1. Loop - if we are returning list of something
        use th:each = "student:${students}" in HTML element(Similar to for(student:Students) in java)
        and use th:text inside HTML element to refer to the student attributes(For eg: student.firstName)

        2. Link - if we want to go to another page, we can use th:href="@{/APIEndpoint}"
        we can also include variables like id th:href="@{/student/{id}(id="${student.id}")",
        provided that student is already defined in th:each loop or as th:object="${student}"
        we can access {id} as @PathVariable Long id in API call

        3. th:object="${student}", for inserting or updating an entity, we need two API endpoints
        one for taking as to the insert/update page and another for insert/update API
        For the first API, when adding to model, we can access it via th:object="${model attribute}"
        and for the input fields, use th:field = "${entity.attribute}" to get the value. @ModelAttribute("student")
        to access the th:object="${student}" in the second API.

        4. when using th:object="${student}", all the inside attributes(For eg:- input tag) displays the student attributes value

        5. when submitting a form or making an API call using th:href, add method="POST/GET"
     */
    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String listAllStudents(Model model)
    {
        List<StudentDto> studentDtoList = studentService.findAllStudents();
        model.addAttribute("students", studentDtoList);
        return "students";
    }

    @GetMapping("/students/new")
    public String getNewStudent(Model model)
    {
        Student student = new Student();
        model.addAttribute("student", student);
        return "create-student";
    }

    @PostMapping("/students/create")
    public String createNewStudent(@ModelAttribute("student") Student student)
    {
        studentService.createNewStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String getStudentToBeUpdated(@PathVariable Long id, Model model)
    {
        System.out.println("Received id: " + id);
        StudentDto studentDto = studentService.getStudentById(id);
        model.addAttribute("student",studentDto);
        return "update-student";
    }

    @PutMapping("/students/update/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student)
    {
        StudentDto studentDto = studentService.getStudentById(id);
        /*
        * JPA (Java Persistence API) provides a mechanism to update entities
        * without explicitly writing an update method. When you retrieve an entity
        * from the database, modify its attributes, and then commit the transaction,
        * JPA automatically updates the corresponding database record.
        *
        * When you retrieve an entity using Spring Data JPA and modify its
        * attributes within a transaction, the changes to the entity are
        * automatically tracked by the JPA provider (like Hibernate)
        * and persisted to the database when the transaction is committed.
        *
        *  Spring Data JPA simplifies the process of working with JPA by providing
        *  high-level abstractions and default implementations. The automatic update
        *  of entities is one of the features provided by JPA and is commonly used in
        *  Spring applications.
        * */

        //Update the existing student
        studentDto.setId(student.getId());
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setEmail(student.getEmail());

        studentService.updateStudent(convertStudentDtoToStudent(studentDto));
        return "redirect:/students";
    }

    @GetMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable Long id)
    {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }


    private Student convertStudentDtoToStudent(StudentDto studentDto)
    {
        return Student.builder()
                .id(studentDto.getId())
                .firstName(studentDto.getFirstName())
                .lastName(studentDto.getLastName())
                .email(studentDto.getEmail())
                .build();
    }
}

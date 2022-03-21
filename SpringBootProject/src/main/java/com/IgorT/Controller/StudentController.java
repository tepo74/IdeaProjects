package com.IgorT.Controller;

import com.IgorT.Entity.Student;
import com.IgorT.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class StudentController {
    @Autowired
    private  StudentService studentService;


    @RequestMapping(value= "/students", method = RequestMethod.GET )
    public Collection<Student> getAllStudents()
    {
        return studentService.getAllStudents();
    }
    @RequestMapping(value= "/students/{id}", method = RequestMethod.GET )
    public Student getStudentById(@PathVariable("id") int id)
    {
        return studentService.getStudentById(id);

    }

    @RequestMapping(value= "/students/{id}", method = RequestMethod.DELETE )
    public void removeStudentById(@PathVariable("id") int id)
    {
         studentService.removeStudentByID(id);

    }
    @RequestMapping(value= "/students", method = RequestMethod.PUT, consumes= MediaType.APPLICATION_JSON_VALUE )
    public void updateStudentById(@RequestBody Student student)
    {
        studentService.updateStudentById(student);
    }


    public StudentService getStudentService() {
        return studentService;
    }
}

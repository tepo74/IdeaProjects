package com.IgorT.Service;

import com.IgorT.Dao.StudentDao;
import com.IgorT.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentService {
    @Autowired
    private  StudentDao studentDao;

    public Collection<Student> getAllStudents()
    {
        return studentDao.getAllStudents();
    }

    public Student getStudentById(int id)
    {
        return studentDao.getStudentById(id);

    }

    public void removeStudentByID(int id)
    {
         studentDao.removeStudentById(id);
    }
    public void updateStudentById(Student student) {
        studentDao.updateStudentById(student);
    }
}

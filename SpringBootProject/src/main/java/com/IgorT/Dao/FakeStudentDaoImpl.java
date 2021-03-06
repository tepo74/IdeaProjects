package com.IgorT.Dao;

import com.IgorT.Entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;

@Repository
@Qualifier("fakeData")
public class FakeStudentDaoImpl implements StudentDao {
   private static HashMap<Integer, Student> students;


   static
   {
       students = new HashMap<Integer, Student>()
       {
           {
               put(1, new Student(1,"IgorT","Computer Design"));
               put(2, new Student(2,"AndrejT","Economy"));
               put(3, new Student(3,"VukasinT","Management"));
           }

       };


      /*
       students.put(1, new Student(1,"IgorT","Computer Design"));
       students.put(2, new Student(2,"AndrejT","Economy"));
       students.put(3, new Student(3,"VukasinT","Management"));
       */

   }

    @Override
    public Collection<Student> getAllStudents()
    {
        return students.values();
    }

    @Override
    public Student getStudentById(int id)
    {
        return students.get(id);

    }

    @Override
    public void removeStudentById(int id) {
        students.remove(id);
    }

    @Override
    public void updateStudentById(Student student)
    {
        Student s = students.get(student.getId());
        s.setCourse(student.getCourse());
        s.setName(student.getName());
        students.put(student.getId(),s);
    }
}

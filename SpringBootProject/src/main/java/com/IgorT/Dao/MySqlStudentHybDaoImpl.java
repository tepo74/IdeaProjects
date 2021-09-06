package com.IgorT.Dao;

import com.IgorT.Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.imageio.spi.ServiceRegistry;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

@Repository
@Qualifier("mysqlDataHyb")
public class MySqlStudentHybDaoImpl  implements StudentDao
{
    private static  SessionFactory sf;
    private static Configuration con;
    private static ServiceRegistry reg;
    static
    {
         con = new Configuration().configure("hibernate.cfg.xml");
         con.addAnnotatedClass(Student.class);
         sf = con.buildSessionFactory();


    }
    private static <T> Collection<T> loadAllData(Class<T> type, Session session) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(type);
        criteria.from(type);
        Collection<T> data = session.createQuery(criteria).getResultList();
        return data;
    }

    @Override
    public Collection<Student> getAllStudents()
    {
        Session session = MySqlStudentHybDaoImpl.sf.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        return loadAllData(Student.class, session);

    }

    @Override
    public Student getStudentById(int id)
    {
        Session session = sf.openSession();
        return  (Student) session.get(Student.class,id);
    }

    @Override
    public void removeStudentById(int id)
    {
        Transaction tx;
        Session session = sf.openSession();
        tx = session.beginTransaction();
        Student st = new Student();
        //st = new Student();
        st.setId(id);
        session.delete(st);
        tx.commit();
    }

    @Override
    public void updateStudentById(Student student)
    {
        Transaction tx;
        Session session = sf.openSession();

        tx = session.beginTransaction();
        try
        {
            session.saveOrUpdate(student);
        }
        catch(Exception e)
        {
            tx.rollback();
        }

        tx.commit();

    }

}

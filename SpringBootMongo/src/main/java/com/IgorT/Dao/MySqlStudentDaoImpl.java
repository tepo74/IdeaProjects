package com.IgorT.Dao;

import com.IgorT.Entity.Student;
import com.mysql.cj.jdbc.MysqlDataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
//@Repository
@Qualifier("mysqlData")
public class MySqlStudentDaoImpl implements StudentDao {

    private Connection conn ;
    private static final MysqlDataSource dataSource;

    static
    {
        dataSource = new MysqlDataSource();
        dataSource.setUser("ris");
        dataSource.setDatabaseName("ris");
        dataSource.setPassword("krastavac23");
        dataSource.setServerName("localhost");
        try {
            dataSource.setUseSSL(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            dataSource.setServerTimezone("UTC");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



    @Override
    public Collection<Student> getAllStudents() {
        try {
            Collection<Student> sk = new ArrayList<Student>();
            ResultSet rs=null;
            conn = dataSource.getConnection();
            Statement stmt;
            stmt = conn.createStatement();
            try
                {
                    rs = stmt.executeQuery("SELECT * FROM students");
                    while( rs.next())
                    {
                        sk.add(new Student(rs.getInt(1),rs.getString(2),rs.getString(3) ));

                    }
                    rs.close();
                }
            catch(Exception e)
                {

                    e.printStackTrace();
                    //rs.close();
                }


            stmt.close();
            conn.close();

            return sk;
        }
        catch( Exception e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Student getStudentById(int id) {
        return null;
    }

    @Override
    public void removeStudentById(int id) {

    }

    @Override
    public void updateStudentById(Student student) {

    }
}

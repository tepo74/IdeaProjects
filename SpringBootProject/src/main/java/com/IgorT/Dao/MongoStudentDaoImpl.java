package com.IgorT.Dao;

import com.IgorT.Entity.Student;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.Collection;
@Repository
@Qualifier("mongoData")
public class MongoStudentDaoImpl implements StudentDao {

    private MongoCollection<Document> table ;
    private static MongoClient mongoClient = null;
    private static  MongoDatabase db=null;
    static
    {

            //---------- Connecting DataBase -------------------------//
            mongoClient = new MongoClient( "localhost" , 27017 );
            //---------- Creating DataBase ---------------------------//
            db = mongoClient.getDatabase("ris");


    }
    @Override
    public Collection<Student> getAllStudents() {
        /* ---------- Creating Collection -------------------------// */
        table = db.getCollection("Students");
        return (Collection<Student>) table;
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
        /* ---------- Creating Document ---------------------------// */
        Document doc = new Document("name", "Peter John");
        doc.append("id",12);
        //----------- Inserting Data ------------------------------//
        table.insertOne(doc);

    }
}

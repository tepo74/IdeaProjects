package com.IgorT.Dao;

import com.IgorT.Entity.HomeScheduleItem;
import com.IgorT.Entity.ItemType;
import com.IgorT.Entity.SafariCntry;
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
import java.util.Collection;
@Repository
@Qualifier("mysqlSafariData")
public class MySqlSafariHybDaoImpl implements SafariDao {
    private static SessionFactory sf;
    private static Configuration con;
    private static ServiceRegistry reg;
    static
    {
        con = new Configuration().configure("hibernate.cfg.xml");
        con.addAnnotatedClass(SafariCntry.class);
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
    public void updateSafari(Integer ordNo, String name) {
        Transaction tx;
        Session session = sf.openSession();
        tx = session.beginTransaction();
        SafariCntry st = new SafariCntry(name);
        //st = new Student();
        st.setOrdNo(ordNo);
        session.saveOrUpdate(st);
        tx.commit();


    };

    @Override
    public Collection<SafariCntry> getAllSafariCnt(){
        Session session = sf.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        return loadAllData(SafariCntry.class, session);
    };
}

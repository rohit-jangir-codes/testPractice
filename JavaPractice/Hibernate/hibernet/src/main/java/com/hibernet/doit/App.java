package com.hibernet.doit;

import com.hibernet.doit.entities.Student;
import com.hibernet.doit.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Student student = new Student();
        student.setActive(true);
        student.setCollege("MVJ");
        student.setInfo("Ass");
        student.setName("Rohit");
        student.setMotherName("Nirmala");
        student.setFatherName("Sundar");
        student.setPhoneNumber("25756465787");
        try {
            tx = session.beginTransaction();
            session.persist(student);
            session.getTransaction().commit();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

//        System.out.println( sessionFactory );
    }
}

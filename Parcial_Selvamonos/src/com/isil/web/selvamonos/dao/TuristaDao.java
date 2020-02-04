package com.isil.web.selvamonos.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.isil.web.selvamonos.model.Turista;
import com.isil.web.selvamonos.util.SelvamonosUtil;

public class TuristaDao {

    /**
     * Save Tourist
     * @param turista
     */
    public void saveTurista(Turista turista) {
        Transaction transaction = null;
        try (Session session = SelvamonosUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(turista);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Update Tourist
     * @param turista
     */
    public void updateTurista(Turista turista) {
        Transaction transaction = null;
        try (Session session = SelvamonosUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the tourist object
            session.update(turista);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Delete Tourist
     * @param id
     */
    public void deleteTurista(int id) {

        Transaction transaction = null;
        try (Session session = SelvamonosUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a tourist object
            Turista turista = session.get(Turista.class, id);
            if (turista != null) {
                session.delete(turista);
                System.out.println("tourist is deleted");
            }

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Get Tourist By ID
     * @param id
     * @return
     */
    public Turista getTurista(int id) {

        Transaction transaction = null;
        Turista turista = null;
        try (Session session = SelvamonosUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an tourist object
            turista = session.get(Turista.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return turista;
    }

    /**
     * Get all Tourist
     * @return
     */
    @SuppressWarnings("unchecked")
    public List < Turista > getAllTurista() {

        List < Turista > listOfTourist = null;
        try (Session session = SelvamonosUtil.getSessionFactory().openSession()) {
            // start a transaction
            // get an tourist object

            listOfTourist = session.createQuery("from Tourist").getResultList();

            // commit transaction
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        return listOfTourist;
    }
}

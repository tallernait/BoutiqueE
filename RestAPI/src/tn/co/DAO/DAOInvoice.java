package tn.co.DAO;

import tn.co.InvoiceEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class DAOInvoice implements IDAO {

    private final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("NewPersistenceUnit");

    @Override
    public void create(Object o) {

        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();

            InvoiceEntity Invoice = (InvoiceEntity)o;
            manager.persist(Invoice);

            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            manager.close();
        }
    }

    @Override
    public List readAll() {
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        List<InvoiceEntity> Invoices = null;

        try{
            transaction = manager.getTransaction();
            transaction.begin();

            Invoices = manager.createQuery("select s from InvoiceEntity s", InvoiceEntity.class ).getResultList();
            transaction.commit();
        } catch (Exception ex){
            if(transaction != null){
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            manager.close();
        }

        return Invoices;
    }

    @Override
    public void delete(int id) {

    }

    public List<InvoiceEntity> findByIdClient(int id) {
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        List<InvoiceEntity> Invoices = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();

            Invoices = manager.createQuery("select s from InvoiceEntity s where idCustomerInv = :d", InvoiceEntity.class)
                    .setParameter("d",id)
                    .getResultList();

            manager.remove(Invoices);

            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            manager.close();
        }

        return  Invoices;
    }

}
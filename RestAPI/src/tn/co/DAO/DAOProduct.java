package tn.co.DAO;

import tn.co.ProductEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class DAOProduct implements IDAO {

    private final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("NewPersistenceUnit");

    @Override
    public void create(Object o) {

        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();

            ProductEntity product = (ProductEntity)o;
            manager.persist(product);

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
        List<ProductEntity> products = null;

        try{
            transaction = manager.getTransaction();
            transaction.begin();

            products = manager.createQuery("select s from ProductEntity s", ProductEntity.class ).getResultList();
            transaction.commit();
        } catch (Exception ex){
            if(transaction != null){
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            manager.close();
        }

        return products;
    }

    @Override
    public void delete(int id) {
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();

            ProductEntity product = manager.find(ProductEntity.class, id);

            manager.remove(product);

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


    public void deleteAll() {
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();

            manager.createQuery("delete from Product").executeUpdate();

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

}
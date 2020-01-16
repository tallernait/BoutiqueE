package tn.co.DAO;

import tn.co.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class DAOClient implements IDAO {

    private final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("NewPersistenceUnit");

    @Override
    public void create(Object o) {
        // Create an EntityManager

        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();

            UserEntity userE = (UserEntity)o;
            manager.persist(userE);

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
        List<UserEntity> users = null;

        try{
            transaction = manager.getTransaction();
            transaction.begin();

            users = manager.createQuery("select s from UserEntity s", UserEntity.class ).getResultList();
            transaction.commit();
        } catch (Exception ex){
            if(transaction != null){
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            manager.close();
        }

        return users;
    }

    @Override
    public void delete(int id) {
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();

            UserEntity user = manager.find(UserEntity.class, id);

            manager.remove(user);

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

    public UserEntity findByUser(String nickName) {
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        UserEntity userRepos=null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();

            userRepos =  manager.createQuery("select s from UserEntity s where user = :d", UserEntity.class)
                    .setParameter("d",nickName)
                    .getSingleResult();

            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                System.out.println("------ ERROR //// ");
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            manager.close();
        }

        return userRepos;
    }
}

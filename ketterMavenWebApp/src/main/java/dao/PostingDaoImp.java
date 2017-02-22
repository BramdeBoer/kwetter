package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Posting;

@Stateless
public class PostingDaoImp implements PostingDao {

    @PersistenceContext
    EntityManager em;

    public PostingDaoImp() {

    }

    @Override
    public boolean create(Posting p) {
        em.persist(p);
        return true;
    }

    ;

    @Override
    public List<Posting> findAll() {
        Query query = em.createQuery("SELECT p FROM Posting p");
        return (List<Posting>) query.getResultList();
    }

    ;

     @Override
    public Posting find(Long id) {
        return em.find(Posting.class, id);
    }
}

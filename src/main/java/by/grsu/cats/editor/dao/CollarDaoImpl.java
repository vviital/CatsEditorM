package by.grsu.cats.editor.dao;

import by.grsu.cats.editor.beans.Collar;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vviital on 27.3.16.
 */
@Transactional
public class CollarDaoImpl implements GenericDao<Collar, Long> {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Collar obj) {
        this.sessionFactory.getCurrentSession().save(obj);
    }

    @Override
    public Collar read(Long id) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Collar.class);
        criteria.add(Restrictions.eq("id", id));
        List result = criteria.list();
        return (Collar) result.get(0);
    }

    @Override
    public void update(Collar obj) {
        this.sessionFactory.getCurrentSession().update(obj);
    }

    @Override
    public void delete(Long id) {
        Query query = this.sessionFactory.getCurrentSession().createQuery("delete from Collar where id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public List<Collar> getAll() {
        return (List<Collar>)this.sessionFactory.getCurrentSession().createCriteria(Collar.class).list();
    }
}

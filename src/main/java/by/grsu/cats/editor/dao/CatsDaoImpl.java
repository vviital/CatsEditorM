package by.grsu.cats.editor.dao;

import by.grsu.cats.editor.beans.Cat;
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
public class CatsDaoImpl implements GenericDao<Cat, Long> {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Cat obj) {
        this.sessionFactory.getCurrentSession().save(obj);
    }

    @Override
    public Cat read(Long id) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Cat.class);
        criteria.add(Restrictions.eq("id", id));
        List result = criteria.list();
        return (Cat) result.get(0);
    }

    @Override
    public void update(Cat obj) {
        this.sessionFactory.getCurrentSession().update(obj);
    }

    @Override
    public void delete(Long id) {
        Query query = this.sessionFactory.getCurrentSession().createQuery("delete from Cat where id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public List<Cat> getAll() {
        return (List<Cat>) this.sessionFactory.getCurrentSession().createCriteria(Cat.class).list();
    }
}

/**
 * UserBean.java
 */
package br.com.cmd.ejb.crud;

import com.mycompany.customerdomain.Persistent;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author rodrigo
 */
@Stateless
@Dependent
public class UserBean implements User, Serializable {
    
    @PersistenceContext
    EntityManager emanager;
    
    @Override
    public <P extends Persistent, K extends Serializable> P find(
            Class<P> clazz, K key) {
        return emanager.find(clazz, key);
    }

    @Override
    public <P extends Persistent> P find(String queryName, Object... params) {
        Query q = emanager.createNamedQuery(queryName);
        for (int i = 0; i < params.length; i++) {
            q.setParameter(i + 1, params[i]);
        }
        return (P) q.getSingleResult();
    }

    @Override
    public <P extends Persistent> List<P> query(String name, Object... params) {
        return limitedQuery(name, null, params);
    }

    @Override
    public <P extends Persistent> List<P> limitedQuery(String name,
            Integer maxResults, Object... params) {
        Query q = emanager.createNamedQuery(name);
        if (maxResults != null) {
            q.setMaxResults(maxResults);
        }
        for (int i = 0; i < params.length; i++) {
            q.setParameter(i + 1, params[i]);
        }
        return q.getResultList();
    }

    @Override
    public <S extends Serializable> List<S> nativeQuery(String queryName,
            Object... params) {
        Query q = emanager.createNamedQuery(queryName);
        for (int i = 0; i < params.length; i++) {
            q.setParameter(i + 1, params[i]);
        }
        return q.getResultList();
    }

    @Override
    public <P extends Persistent> void save(P instance) {
        emanager.persist(instance);
    }

    @Override
    public <P extends Persistent> P update(P instance) {
        return emanager.merge(instance);
    }

    @Override
    public <P extends Persistent> void delete(P instance) {
        emanager.remove(emanager.merge(instance));
    }

    public EntityManager getEntityManager() {
        return emanager;
    }

}

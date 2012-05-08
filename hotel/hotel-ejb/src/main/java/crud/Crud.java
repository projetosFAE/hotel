/**
 * Crud.java
 */
package crud;

import domain.Persistent;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author AlexPorto
 */
public interface Crud extends Serializable {

    <P extends Persistent> P find(String queryName, Object... params);

    <P extends Persistent, K extends Serializable> P find(Class<P> clazz, K key);

    <P extends Persistent> List<P> query(String name, Object... params);

    <P extends Persistent> List<P> limitedQuery(String name, Integer maxResults, Object... params);

    <S extends Serializable> List<S> nativeQuery(String queryName, Object... params);

    <P extends Persistent> void save(P instance);

    <P extends Persistent> P update(P instance);

    <P extends Persistent> void delete(P instance);

    EntityManager getEntityManager();
}

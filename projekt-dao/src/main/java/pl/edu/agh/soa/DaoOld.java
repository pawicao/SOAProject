package pl.edu.agh.soa;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

public abstract class DaoOld {
    @PersistenceContext(unitName = "students")
    protected EntityManager manager;

    protected abstract Logger getLogger();

    public <T> void create(T object) {
        getLogger().info("create - invoked " + object);
        manager.persist(object);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public <T> void createNewTransaction(T object) {
        getLogger().info("createNewTransaction - invoked " + object);
        manager.persist(object);
    }

    public <T> boolean update(T object) {
        getLogger().info("update - invoked " + object);
        manager.merge(object);
        getLogger().info("update - record udapted");
        return true;
    }

    public <T> boolean delete(Object pk) {
        getLogger().info("delete - invoked " + pk);
        T object = manager.find(getType(), pk);
        manager.remove(object);
        return true;
    }

    public <T> List<T> list(int offset, int limit) {
        getLogger().info("list - invoked");
        CriteriaQuery<T> criteriaQuery = manager.getCriteriaBuilder().createQuery(getType());
        criteriaQuery.from(getType());
        TypedQuery<T> query = manager.createQuery(criteriaQuery);
        query.setFirstResult(offset).setMaxResults(limit);
        return query.getResultList();
    }

    public <T> T get(Object pk) {
        getLogger().info("get - invoked for: " + pk);
        return manager.find(getType(), pk);
    }

    protected <T> Optional<T> getSingleResult(List<T> resultList) {
        getLogger().info("getSingleResult invoked...");
        return resultList.isEmpty() ? Optional.empty() : Optional.of(resultList.get(0));
    }

    protected void fillQueryParameters(Query query, Map<String, Object> filters) {
        for (Map.Entry<String, Object> filter : filters.entrySet()) {
            query.setParameter(filter.getKey(), filter.getValue());
        }
    }

    protected <T> T getSingleResult(TypedQuery<T> query) {
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    protected abstract <T> Class<T> getType();
}

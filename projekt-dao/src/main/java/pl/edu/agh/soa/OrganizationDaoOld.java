package pl.edu.agh.soa;

import pl.edu.agh.soa.entities.OrganizationEntity;

import javax.ejb.Stateless;
import java.util.logging.Logger;

@Stateless
public class OrganizationDaoOld extends DaoOld {
    private static final Logger LOGGER = Logger.getLogger(OrganizationDaoOld.class.getName());

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected Class<OrganizationEntity> getType() {
        return OrganizationEntity.class;
    }
}

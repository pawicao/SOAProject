package pl.edu.agh.soa.daos;

import pl.edu.agh.soa.entities.OrganizationEntity;
import pl.edu.agh.soa.models.Organization;

public class OrganizationDao {
    public static OrganizationEntity modelToEntity(Organization organization) {
        return new OrganizationEntity(organization.getName(), organization.getCreationYear());
    }

    public static Organization entityToModel(OrganizationEntity organizationEntity) {
        return new Organization(organizationEntity.getName(), organizationEntity.getCreationYear());
    }
}

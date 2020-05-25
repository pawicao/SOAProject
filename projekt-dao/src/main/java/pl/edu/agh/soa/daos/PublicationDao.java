package pl.edu.agh.soa.daos;

import pl.edu.agh.soa.entities.PublicationEntity;
import pl.edu.agh.soa.models.Publication;

public class PublicationDao {
    public static PublicationEntity modelToEntity(Publication publication) {
        return new PublicationEntity(publication.getName());
    }

    public static Publication entityToModel(PublicationEntity publicationEntity) {
        return new Publication(publicationEntity.getName());
    }
}

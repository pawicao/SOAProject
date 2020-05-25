package pl.edu.agh.soa.daos;

import pl.edu.agh.soa.entities.DormitoryEntity;
import pl.edu.agh.soa.models.Dormitory;

public class DormitoryDao {

        public static DormitoryEntity modelToEntity(Dormitory dormitory) {
            if(dormitory == null)
                return null;
            return new DormitoryEntity(dormitory.getName(), dormitory.getCode());
        }

        public static Dormitory entityToModel(DormitoryEntity dormitoryEntity) {
            if(dormitoryEntity == null)
                return null;
            return new Dormitory(dormitoryEntity.getName(), dormitoryEntity.getCode());
        }
}

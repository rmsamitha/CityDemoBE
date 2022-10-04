package sam.kuehne.nagel.com.city.repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sam.kuehne.nagel.com.city.entities.City;

import java.util.List;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {
    @Query(value = "SELECT CITY.NAME AS cityName, CITY_PHOTO.IMAGE_SRC_URL AS imageSrcUrl FROM CITY INNER JOIN CITY_PHOTO ON CITY.PHOTO_ID=CITY_PHOTO.CITY_PHOTO_ID", nativeQuery=true )    //This is using a named query method
    List<?> getLightWeightCities();
}

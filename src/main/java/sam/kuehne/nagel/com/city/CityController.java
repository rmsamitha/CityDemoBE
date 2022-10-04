package sam.kuehne.nagel.com.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sam.kuehne.nagel.com.city.entities.City;
import sam.kuehne.nagel.com.city.repos.CityRepository;

import java.util.*;

@RestController
@RequestMapping("/api/citydemo/cities")
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @GetMapping()
    /**
     * Return all cities only with the minimal information (i.e. name, imageURL)
     */
    public ResponseEntity<Map> getAllLightWeightCities() {
        List<Object[]> result = (List<Object[]>) cityRepository.getLightWeightCities();
        Map<String, String> map = new HashMap<>();

        if (result != null && !result.isEmpty()) {
            for (Object[] object : result) {
                map.put((String) object[0], (String) object[1]);
            }
        }

        return ResponseEntity.ok().body(map);
    }

    /**
     * Get CITY details by city ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<City> findCityById(@PathVariable(value = "id") long id) {
        Optional<City> city = cityRepository.findById(id);
        if (city.isPresent()) {
            return ResponseEntity.ok().body(city.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

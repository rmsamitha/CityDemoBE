package sam.kuehne.nagel.com.city.services;

import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sam.kuehne.nagel.com.city.repos.CityPhotoRepository;
import sam.kuehne.nagel.com.city.repos.CityRepository;
import sam.kuehne.nagel.com.city.utils.CSVHelper;

@Service
public class CSVService {
    @Autowired
    CityPhotoRepository cityPhotoRepository;

    @Autowired
    CityRepository cityRepository;

    public void save(InputStreamReader reader) {
        CSVHelper csvHelper = new CSVHelper();
        csvHelper.csvToDB(reader, cityPhotoRepository, cityRepository);
    }
}
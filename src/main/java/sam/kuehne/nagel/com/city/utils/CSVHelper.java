package sam.kuehne.nagel.com.city.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sam.kuehne.nagel.com.city.AppStartupRunner;
import sam.kuehne.nagel.com.city.entities.City;
import sam.kuehne.nagel.com.city.entities.CityPhoto;
import sam.kuehne.nagel.com.city.repos.CityPhotoRepository;
import sam.kuehne.nagel.com.city.repos.CityRepository;

public class CSVHelper {
    private static final Logger LOG = LoggerFactory.getLogger(CSVHelper.class);

    public void csvToDB(InputStreamReader is, CityPhotoRepository cityPhotoRepository, CityRepository cityRepository) {
        try (BufferedReader fileReader = new BufferedReader(is);
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<City> cities = new ArrayList<>();
            List<CityPhoto> cityPhotos = new ArrayList<>();
            List<CSVRecord> csvRecords = csvParser.getRecords();

            for (int i = 0; i < csvRecords.size(); i++) {
                CSVRecord record = csvRecords.get(i);
                CityPhoto cityPhoto = new CityPhoto(i + 1, record.get("photo"));
                cityPhotos.add(cityPhoto);
                City city = new City(Long.parseLong(record.get("id")), record.get("name"), cityPhoto);
                cities.add(city);
            }
            cityPhotoRepository.saveAll(cityPhotos);
            cityRepository.saveAll(cities);
        } catch (IOException e) {
            LOG.error("Failed to parse CSV file:");
            throw new RuntimeException("Error occurred in parsing CSV file: ", e);
        }
    }

}

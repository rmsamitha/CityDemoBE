package sam.kuehne.nagel.com.city;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import sam.kuehne.nagel.com.city.repos.CityRepository;
import sam.kuehne.nagel.com.city.services.CSVService;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Load city information from cities.csv file in to the database
 */
@Component
public class AppStartupRunner implements ApplicationRunner {
    private static final Logger LOG = LoggerFactory.getLogger(AppStartupRunner.class);
    private static final String CITIES_CSV_FILE_NAME = "cities.csv";

    @Autowired
    private CityRepository cityRepository;
    @Autowired
    CSVService fileService;
    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        LOG.info("Application started with option names : {}", args.getOptionNames());
        loadCityInfo();
    }

    /**
     * Load city information from cities.csv file in to the database
     */
    private void loadCityInfo() {
        final Resource resource = resourceLoader.getResource("classpath:" + CITIES_CSV_FILE_NAME);
        InputStreamReader reader;
        try {
            reader = new InputStreamReader(resource.getInputStream());
        } catch (IOException e) {
            LOG.error("Error occurred in reading file " + CITIES_CSV_FILE_NAME, e);
            throw new RuntimeException(e);
        }
        fileService.save(reader);
    }
}
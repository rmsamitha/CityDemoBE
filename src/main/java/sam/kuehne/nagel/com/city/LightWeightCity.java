package sam.kuehne.nagel.com.city;

/**
 * This class is used as minimal City info class to be returned when information of all cities are requested
 */
public class LightWeightCity {
    int cityId;
    String cityName;
    String imageSrcUrl;

    public LightWeightCity(int cityId, String cityName, String imageSrcUrl) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.imageSrcUrl = imageSrcUrl;
    }

    public String getCityName() {
        return cityName;
    }

    public String getImageSrcUrl() {
        return imageSrcUrl;
    }
}

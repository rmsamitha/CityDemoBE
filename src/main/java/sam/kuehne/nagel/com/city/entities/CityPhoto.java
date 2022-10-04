package sam.kuehne.nagel.com.city.entities;

import javax.persistence.*;

@Entity
@Table(name = "CITY_PHOTO")
public class CityPhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cityPhotoId;
    @Column(length = 2000)
    private String imageSrcUrl;
    @Lob
    @Column(name = "imageFile", columnDefinition = "BLOB")
    private byte[] imageFile;

    @OneToOne(mappedBy = "photoId")
    private City city;

    public CityPhoto() {
    }

    public void setCityPhotoId(int cityPhotoId) {
        this.cityPhotoId = cityPhotoId;
    }

    public CityPhoto(int cityPhotoId, String imageSrcUrl) {
        this.cityPhotoId = cityPhotoId;
        this.imageSrcUrl = imageSrcUrl;
    }

    int getCityPhotoId() {
        return cityPhotoId;
    }

    String getImageSrcUrl() {
        return imageSrcUrl;
    }
}

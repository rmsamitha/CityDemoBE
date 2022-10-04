package sam.kuehne.nagel.com.city.entities;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cityId;
    private String name;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "photoId")
    private CityPhoto photoId;

    public City() {
    }

    public City(long id, String name, CityPhoto photo) {
        this.cityId = id;
        this.name = name;
        this.photoId = new CityPhoto(photo.getCityPhotoId(), photo.getImageSrcUrl() );
    }
}



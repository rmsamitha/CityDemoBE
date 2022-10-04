-- Can use below script instead of creating schema automatically by Spring JPA entities
CREATE TABLE CITY (
   CITY_ID INTEGER NOT NULL,
   NAME VARCHAR(255),
   PHOTO_ID INTEGER NOT NULL,
   PRIMARY KEY (CITY_ID)
   FOREIGN KEY (CITY_ID) REFERENCES CITY_PHOTO (CITY_PHOTO_ID) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE CITY_PHOTO (
   CITY_PHOTO_ID INTEGER NOT NULL,
   IMAGE_FILE BLOB,
   IMAGE_SRC_URL VARCHAR(1000),
   PRIMARY KEY (PHOTO_ID)
);


package me.codaline.model;

import javax.persistence.*;

/**
 * Created by yurik on 29.05.16.
 */
@Entity
public class Images {

    @Id
    @GeneratedValue
    int id;

    @Lob
    @Column(nullable=false, columnDefinition="mediumblob")
    byte[] image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}

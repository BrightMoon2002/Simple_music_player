package duy.codegym.model;

import javax.persistence.*;

@Entity
@Table
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String artist;
    private String type;
    private String trackLink;

    public Track() {
    }

    public Track(int id, String name, String artist, String type, String trackLink) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.type = type;
        this.trackLink = trackLink;
    }

    public Track(String name, String artist, String type, String trackLink) {
        this.name = name;
        this.artist = artist;
        this.type = type;
        this.trackLink = trackLink;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTrackLink() {
        return trackLink;
    }

    public void setTrackLink(String trackLink) {
        this.trackLink = trackLink;
    }
}

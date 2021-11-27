package duy.codegym.model;

import org.springframework.web.multipart.MultipartFile;

public class TrackForm {
    private int id;
    private String name;
    private String artist;
    private String type;
    private MultipartFile trackLink;

    public TrackForm() {
    }

    public TrackForm(String name, String artist, String type, MultipartFile trackLink) {
        this.name = name;
        this.artist = artist;
        this.type = type;
        this.trackLink = trackLink;
    }

    public TrackForm(int id, String name, String artist, String type, MultipartFile trackLink) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.type = type;
        this.trackLink = trackLink;
    }

    public TrackForm(int id, String name, String artist, String type) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.type = type;
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

    public MultipartFile getTrackLink() {
        return trackLink;
    }

    public void setTrackLink(MultipartFile trackLink) {
        this.trackLink = trackLink;
    }
}

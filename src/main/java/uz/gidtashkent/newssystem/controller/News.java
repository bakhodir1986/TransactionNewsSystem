package uz.gidtashkent.newssystem.controller;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class News {

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public NewsState getState() {
        return state;
    }

    public void setState(NewsState state) {
        this.state = state;
    }

    public String getPlatform() {
        return Platform;
    }

    public void setPlatform(String platform) {
        Platform = platform;
    }

    public String getVersion() {
        return Version;
    }

    public void setVersion(String version) {
        Version = version;
    }

    @Id
    private long id;
    private String title;
    private String description;
    private String iconPath;
    private NewsState state;
    private String Platform;
    private String Version;

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", iconPath='" + iconPath + '\'' +
                ", state=" + state +
                ", Platform='" + Platform + '\'' +
                ", Version='" + Version + '\'' +
                '}';
    }


}

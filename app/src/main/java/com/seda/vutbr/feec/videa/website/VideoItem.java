package com.seda.vutbr.feec.videa.website;

/**
 * Created by Seda on 10/20/2016.
 *
 * A POJO representing a YouTube video item equals method is Override depending on id String.
 */
public class VideoItem {
    private String title;
    private String description;
    private String thumbnailURL;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnail) {
        this.thumbnailURL = thumbnail;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if(!(obj instanceof VideoItem))
            return false;
        VideoItem videoItem = (VideoItem) obj;
        if(id == null){
            if(videoItem.getId() !=null)
                return false;
        } else if(!id.equals(videoItem.getId()))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "VideoItem{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", thumbnailURL='" + thumbnailURL + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
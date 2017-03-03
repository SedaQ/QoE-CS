package com.seda.vutbr.feec.videa;

/**
 * Created by Seda on 11/26/2016.
 */
public enum VideoQuality {

    HD_1440("?vq=hd1440"),
    HD_1080("?vq=hd1080"),
    HD_720("?vq=hd720"),
    HD_480p("?vq=large"),
    HD_360p("?vq=medium"),
    HD_240p("?vq=small");

    private String videoQuality;

    private VideoQuality(String videoQuality){
        this.videoQuality = videoQuality;
    }

    public String getQuality(){
        return this.videoQuality;
    }

    @Override
    public String toString() {
        return this.videoQuality;
    }
}

package com.example.varun.cfg;

public class LectureItem {

    String videoUrl;
    String audioUrl;
    String pdfUrl;
    String arUrl;
    String tagText;
    String desc;
    String  id;
    String imgUrl;

    public LectureItem(String videoUrl, String audioUrl, String pdfUrl, String arUrl, String tagText, String id, String desc, String imgUrl) {
        this.videoUrl = videoUrl;
        this.audioUrl = audioUrl;
        this.pdfUrl = pdfUrl;
        this.arUrl = arUrl;
        this.tagText = tagText;
        this.id = id;
        this.desc = desc;
        this.imgUrl = imgUrl;
    }


    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getAudioUrl() {
        return audioUrl;
    }

    public void setAudioUrl(String audioUrl) {
        this.audioUrl = audioUrl;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }

    public String getArUrl() {
        return arUrl;
    }

    public void setArUrl(String arUrl) {
        this.arUrl = arUrl;
    }

    public String getTagText() {
        return tagText;
    }

    public void setTagText(String tagText) {
        this.tagText = tagText;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public void setDesc(String desc){
        this.desc = desc;
    }

    public String  getDesc(){
        return desc;
    }

    public void setImgUrl(String imgUrl){
        this.imgUrl = imgUrl;
    }

    public String  getImgUrl(){
        return imgUrl;
    }


}

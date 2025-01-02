package com.example.oyunlar;

public class Oyunlar  {
    private String oyunAd;
    private String oyunYil;
    private String oyunBoyut;
    private String oyunTur;
    private String oyunResim;
    private String oyunUrl;
    private String oyunAciklama;

    public  Oyunlar(){

    }

    public Oyunlar(String oyunAd, String oyunYil, String oyunBoyut, String oyunTur,String oyunResim,String oyunUrl,String oyunAciklama) {
        this.oyunAd = oyunAd;
        this.oyunYil = oyunYil;
        this.oyunBoyut = oyunBoyut;
        this.oyunTur = oyunTur;
        this.oyunResim = oyunResim;
        this.oyunUrl = oyunUrl;
        this.oyunAciklama = oyunAciklama;
    }

    public String getOyunAd() {
        return oyunAd;
    }

    public void setOyunAd(String oyunAd) {
        this.oyunAd = oyunAd;
    }

    public String getOyunYil() {
        return oyunYil;
    }

    public void setOyunYil(String oyunYil) {
        this.oyunYil = oyunYil;
    }

    public String getOyunBoyut() {
        return oyunBoyut;
    }

    public void setOyunBoyut(String oyunBoyut) {
        this.oyunBoyut = oyunBoyut;
    }

    public String getOyunTur() {
        return oyunTur;
    }

    public void setOyunTur(String oyunTur) {
        this.oyunTur = oyunTur;
    }

    public String getOyunResim() {
        return oyunResim;
    }

    public void setOyunResim(String oyunResim) {
        this.oyunResim = oyunResim;
    }
    public String getOyunUrl() {
        return oyunUrl;
    }

    public void setOyunUrl(String oyunUrl) {
        this.oyunUrl = oyunUrl;
    }

    public String getOyunAciklama() {
        return oyunAciklama;
    }

    public void setOyunAciklama(String oyunAciklama) {
        this.oyunAciklama = oyunAciklama;
    }
}

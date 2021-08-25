package ru.telegram.learn.english.bot.entity;

public class Audio {
    private String audioFileNameUK;
    private String audioFileNameUS;
    private String audioLinkUK;
    private String audioLinkUS;

    public Audio() {
    }

    public Audio(String audioFileNameUK, String audioFileNameUS, String audioLinkUK, String audioLinkUS) {
        this.audioFileNameUK = audioFileNameUK;
        this.audioFileNameUS = audioFileNameUS;
        this.audioLinkUK = audioLinkUK;
        this.audioLinkUS = audioLinkUS;
    }

    public String getAudioFileNameUK() {
        return audioFileNameUK;
    }

    public void setAudioFileNameUK(String audioFileNameUK) {
        this.audioFileNameUK = audioFileNameUK;
    }

    public String getAudioFileNameUS() {
        return audioFileNameUS;
    }

    public void setAudioFileNameUS(String audioFileNameUS) {
        this.audioFileNameUS = audioFileNameUS;
    }

    public String getAudioLinkUK() {
        return audioLinkUK;
    }

    public void setAudioLinkUK(String audioLinkUK) {
        this.audioLinkUK = audioLinkUK;
    }

    public String getAudioLinkUS() {
        return audioLinkUS;
    }

    public void setAudioLinkUS(String audioLinkUS) {
        this.audioLinkUS = audioLinkUS;
    }
}

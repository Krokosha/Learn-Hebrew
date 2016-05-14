package com.krokosha.aleksey.learnhebrew.generals;

public class LettersItem {
    private String name;
    private String transcription;
    private String keyboardInput;
    private int idIRForPechat;
    private String idOriImage;
    private int music;

    public LettersItem(String name, int idIRForPechat, String transcription, String idOriImage,
                       int music, String val) {
        this.name = name;
        this.idIRForPechat = idIRForPechat;
        this.transcription = transcription;
        this.idOriImage = idOriImage;
        this.music = music;
        this.keyboardInput = val;
    }

    public String getName() {
        return name;
    }

    public int getMusic() {
        return music;
    }

    public String getIdOriImage() {
        return idOriImage;
    }

    public String getTranscription() {
        return transcription;
    }

    public int getIdIRForPechat() {
        return idIRForPechat;
    }

    public String getKeyboardInput() {
        return keyboardInput;
    }
}

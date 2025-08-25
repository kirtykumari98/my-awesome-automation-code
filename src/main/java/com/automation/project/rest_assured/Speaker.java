package com.automation.project.rest_assured;

import java.util.Objects;


public class Speaker {

    private String speakerName;
    private String speakerProfile;
    private String speakerPicPath;
    private String speakerEmail;
    private boolean disabledStatus;

    private int speakerId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Speaker speaker = (Speaker) o;
        return disabledStatus == speaker.disabledStatus && speakerId == speaker.speakerId && speakerName.equals(speaker.speakerName) && speakerProfile.equals(speaker.speakerProfile) && Objects.equals(speakerPicPath, speaker.speakerPicPath) && speakerEmail.equals(speaker.speakerEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(speakerName, speakerProfile, speakerPicPath, speakerEmail, disabledStatus, speakerId);
    }

    public String getSpeakerName() {
        return speakerName;
    }

    public void setSpeakerName(String speakerName) {
        this.speakerName = speakerName;
    }

    public String getSpeakerProfile() {
        return speakerProfile;
    }

    public void setSpeakerProfile(String speakerProfile) {
        this.speakerProfile = speakerProfile;
    }

    public String getSpeakerPicPath() {
        return speakerPicPath;
    }

    public void setSpeakerPicPath(String speakerPicPath) {
        this.speakerPicPath = speakerPicPath;
    }

    public String getSpeakerEmail() {
        return speakerEmail;
    }

    public void setSpeakerEmail(String speakerEmail) {
        this.speakerEmail = speakerEmail;
    }

    public boolean isDisabledStatus() {
        return disabledStatus;
    }

    public void setDisabledStatus(boolean disabledStatus) {
        this.disabledStatus = disabledStatus;
    }

    @Override
    public String toString() {
        return "Speaker{" +
                "speakerName='" + speakerName + '\'' +
                ", speakerProfile='" + speakerProfile + '\'' +
                ", speakerPicPath='" + speakerPicPath + '\'' +
                ", speakerEmail='" + speakerEmail + '\'' +
                ", disabledStatus=" + disabledStatus +
                ", speakerId=" + speakerId +
                '}';
    }

    public int getSpeakerId() {
        return speakerId;
    }

    public void setSpeakerId(int speakerId) {
        this.speakerId = speakerId;
    }

}

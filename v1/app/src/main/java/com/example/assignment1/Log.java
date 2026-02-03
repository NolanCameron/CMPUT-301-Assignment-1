package com.example.assignment1;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Log {
    private Emotion emotion;
    private Date timestamp;

    public Log(Emotion emotion, Date timestamp){
        this.emotion = emotion;
        this.timestamp = timestamp;
    }

    public String getEmotion() {
        switch (emotion){
            case SAD:
                return "Sad";
            case EXCITED:
                return "Excited";
            case GRATEFUL:
                return "Grateful";
            case TIRED:
                return "Tired";
            case ANGRY:
                return "Angry";
            case HAPPY:
                return "Happy";
            default:
                return "No Emotion";
        }
    }

    public Date getTimestamp() {
        return timestamp;
    }
}

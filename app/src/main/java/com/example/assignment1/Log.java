package com.example.assignment1;

import java.sql.Timestamp;
import java.util.Date;

public class Log {
    private Emotion emotion;
    private Date timestamp;

    public Log(Emotion emotion, Date timestamp){
        this.emotion = emotion;
        this.timestamp = timestamp;
    }
}

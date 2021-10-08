package com.example.mynotes.data;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Note {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String note ;
    private int priority;
    private String time ;
    private String date ;



    public Note(String note, int priority, String time, String date) {
        this.note = note;
        this.priority = priority;
        this.time = time;
        this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNote() {
        return note;
    }

    public int getPriority() {
        return priority;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }


}

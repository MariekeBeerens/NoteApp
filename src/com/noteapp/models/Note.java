package com.noteapp.models;

import java.util.ArrayList;
import java.util.List;

public class Note {
    private String text;
    private static int count = 0;  // Om een uniek id voor elke notitie te genereren
    private int id;
    private List<Image> images;
    private List<Sketch> sketches;

    public Note(String text) {
        this.text = text;
        this.id = ++count;
        this.images = new ArrayList<>();
        this.sketches = new ArrayList<>();
    }

    public String getText() {
        return text;
    }

    public int getId() {
        return id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Image> getImages() {
        return images;
    }

    public List<Sketch> getSketches() {
        return sketches;
    }

    // Voeg afbeelding toe
    public void addImage(Image image) {
        this.images.add(image);
    }

    // Voeg schets toe
    public void addSketch(Sketch sketch) {
        this.sketches.add(sketch);
    }
}

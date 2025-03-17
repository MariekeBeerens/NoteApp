package com.noteapp.models;

import java.util.ArrayList;
import java.util.List;

public class NoteController {
    private List<Note> notes;  // De lijst van notities

    public NoteController() {
        notes = new ArrayList<>();
    }

    // Voeg een nieuwe notitie toe
    public void createNote(String text) {
        Note newNote = new Note(text);
        notes.add(newNote);
    }

    // Voeg een nieuwe private (beveiligde) notitie toe
    public void createSecureNote(String text, String password) {
        SecureNote newSecureNote = new SecureNote(text, password);
        notes.add(newSecureNote);
    }

    // Toon alle notities
    public void showNotes() {
        if (notes.isEmpty()) {
            System.out.println("Er zijn geen notities.");
        } else {
            System.out.println("\n--- Alle Notities ---");
            for (Note note : notes) {
                System.out.println("ID: " + note.getId() + " - " + note.getText());
                System.out.println("Afbeeldingen: " + note.getImages().size() + " | Schetsen: " + note.getSketches().size());
                if (note instanceof SecureNote) {
                    System.out.println("Privé: Ja");
                } else {
                    System.out.println("Privé: Nee");
                }
            }
        }
    }

    // Werk een notitie bij op basis van het ID
    public void updateNote(int index, String newText) {
        if (index > 0 && index <= notes.size()) {
            Note note = notes.get(index - 1);  // Gebruiker geeft een 1-gebaseerde index
            note.setText(newText);
            System.out.println("Notitie " + index + " bijgewerkt!");
        } else {
            System.out.println("Notitie met dat nummer bestaat niet.");
        }
    }

    // Voeg afbeelding toe aan een notitie
    public void addImageToNote(int noteId, String filePath) {
        for (Note note : notes) {
            if (note.getId() == noteId) {
                Image image = new Image(filePath);
                note.addImage(image);
                System.out.println("Afbeelding toegevoegd aan notitie " + noteId);
                return;
            }
        }
        System.out.println("Notitie niet gevonden.");
    }

    // Voeg schets toe aan een notitie
    public void addSketchToNote(int noteId, String filePath) {
        for (Note note : notes) {
            if (note.getId() == noteId) {
                Sketch sketch = new Sketch(filePath);
                note.addSketch(sketch);
                System.out.println("Schets toegevoegd aan notitie " + noteId);
                return;
            }
        }
        System.out.println("Notitie niet gevonden.");
    }

    // Probeer toegang te krijgen tot een beveiligde notitie met wachtwoord
    public boolean openSecureNote(int noteId, String password) {
        for (Note note : notes) {
            if (note.getId() == noteId && note instanceof SecureNote) {
                SecureNote secureNote = (SecureNote) note;
                if (secureNote.checkPassword(password)) {
                    System.out.println("Toegang verleend tot beveiligde notitie: " + secureNote.getText());
                    return true;
                } else {
                    System.out.println("Wachtwoord incorrect.");
                    return false;
                }
            }
        }
        System.out.println("Beveiligde notitie niet gevonden.");
        return false;
    }
}

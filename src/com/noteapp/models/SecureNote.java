package com.noteapp.models;

public class SecureNote extends Note {
    private String passwordHash;  // Het wachtwoord van de notitie in gehashte vorm

    public SecureNote(String text, String password) {
        super(text);
        this.passwordHash = Crypto.hash(password); // Wachtwoord is gehasht
    }

    public boolean checkPassword(String password) {
        return this.passwordHash.equals(Crypto.hash(password));  // Vergelijk wachtwoord hash
    }

    public String getPasswordHash() {
        return passwordHash;
    }
}

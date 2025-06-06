package com.noteapp.models;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NoteController noteController = new NoteController();

        while (true) {
            System.out.println("\n--- Notitie App ---");
            System.out.println("1. Voeg een notitie toe");
            System.out.println("2. Voeg een beveiligde notitie toe");
            System.out.println("3. Bekijk notities");
            System.out.println("4. Bewerken notitie");
            System.out.println("5. Voeg afbeelding toe");
            System.out.println("6. Voeg schets toe");
            System.out.println("7. Open beveiligde notitie");
            System.out.println("8. Verwijder notitie");
            System.out.println("9. Stoppen");
            System.out.print("Kies een optie: ");

            int keuze = -1;  // Start met een ongeldige keuze
            try {
                keuze = scanner.nextInt();
                scanner.nextLine(); // Verwijder newline teken na nextInt()
            } catch (InputMismatchException e) {
                // Als er een fout is in de invoer (bijvoorbeeld een letter), geef een foutmelding
                System.out.println("Ongeldige keuze, probeer opnieuw.");
                scanner.nextLine(); // Verwijder het foute invoer van de scanner
                continue;  // Ga terug naar de keuze prompt
            }

            switch (keuze) {
                case 1:
                    System.out.print("Voer tekst in voor de nieuwe notitie: ");
                    String tekst = scanner.nextLine();
                    noteController.createNote(tekst);
                    System.out.println("Notitie toegevoegd!");
                    break;

                case 2:
                    System.out.print("Voer tekst in voor de beveiligde notitie: ");
                    String secureText = scanner.nextLine();
                    System.out.print("Voer een wachtwoord in voor de beveiligde notitie: ");
                    String password = scanner.nextLine();
                    noteController.createSecureNote(secureText, password);
                    System.out.println("Beveiligde notitie toegevoegd!");
                    break;

                case 3:
                    noteController.showNotes();
                    break;

                case 4:
                    System.out.print("Voer het nummer van de notitie in die je wilt bewerken: ");
                    int index = scanner.nextInt();
                    scanner.nextLine(); // Verwijder newline teken
                    System.out.print("Voer de nieuwe tekst in voor de notitie: ");
                    String nieuweTekst = scanner.nextLine();
                    noteController.updateNote(index, nieuweTekst);
                    break;

                case 5:
                    System.out.print("Voer het ID van de notitie waaraan je een afbeelding wilt toevoegen: ");
                    int noteIdForImage = scanner.nextInt();
                    scanner.nextLine(); // Verwijder newline teken
                    System.out.print("Voer het pad naar de afbeelding in: ");
                    String imagePath = scanner.nextLine();
                    noteController.addImageToNote(noteIdForImage, imagePath);
                    break;

                case 6:
                    System.out.print("Voer het ID van de notitie waaraan je een schets wilt toevoegen: ");
                    int noteIdForSketch = scanner.nextInt();
                    scanner.nextLine(); // Verwijder newline teken
                    System.out.print("Voer het pad naar de schets in: ");
                    String sketchPath = scanner.nextLine();
                    noteController.addSketchToNote(noteIdForSketch, sketchPath);
                    break;

                case 7:
                    System.out.print("Voer het ID van de beveiligde notitie in die je wilt openen: ");
                    int noteIdForSecure = scanner.nextInt();
                    scanner.nextLine(); // Verwijder newline teken
                    System.out.print("Voer het wachtwoord in: ");
                    String enteredPassword = scanner.nextLine();
                    noteController.openSecureNote(noteIdForSecure, enteredPassword);
                    break;

                case 8:
                    System.out.print("Voer het ID van de notitie in die je wilt verwijderen: ");
                    int noteIdForDelete = scanner.nextInt();
                    scanner.nextLine(); // Verwijder newline teken
                    noteController.deleteNote(noteIdForDelete);
                    break;

                case 9:
                    System.out.println("App wordt afgesloten...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Ongeldige keuze, probeer opnieuw.");
            }
        }
    }
}

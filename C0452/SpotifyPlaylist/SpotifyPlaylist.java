import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Created a class for the songs with the titles, artists and number of plays
class Song {
    private String title;
    private String artist;
    private double plays; // Number of times played in millions

    // Constructor to initialize the song
    public Song(String title, String artist, double plays) {
        this.title = title;
        this.artist = artist;
        this.plays = plays;
    }

    // Getter methods
    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public double getPlays() {
        return plays;
    }

    // Method to increment the play count
    public void incrementPlays() {
        plays++;
    }

    // String representation of the song
    @Override
    public String toString() {
        return title + " by " + artist + " (" + plays + " million plays)";
    }
}

// Created a class for the playlist
public class SpotifyPlaylist {
    private List<Song> playlist;

    // Constructor to initialize the playlist with initial songs
    public SpotifyPlaylist() {
        playlist = new ArrayList<>();
        // Adding initial songs
        playlist.add(new Song("Blinding Lights", "The Weeknd", 149.0));
        playlist.add(new Song("Starboy", "The Weeknd", 103.0));
        playlist.add(new Song("Shape Of You", "Ed Sheeran", 119.0));
        playlist.add(new Song("After Dark", "Mr. Kitty", 24.2));
        playlist.add(new Song("Number 1", "Nico Santos", 1.39));
        playlist.add(new Song("Brooklyn", "Glockenbach", 1.23));
        playlist.add(new Song("HYPNOTIC DATA", "Odetari", 8.02));
        playlist.add(new Song("Daylight", "David Kushner", 163.0));
        playlist.add(new Song("Strangers", "Kenya Grace", 207.0));
        playlist.add(new Song("Shameless", "Camila Cabello", 17.4));
        // Add other initial songs...(optional)
    }

    // Method to add a new song to the playlist
    public void addSong(String title, String artist, double plays) {
        playlist.add(new Song(title, artist, plays));
    }

    // Method to remove a song from the playlist
    public void removeSong(String title) {
        Song songToRemove = null;
        for (Song song : playlist) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                songToRemove = song;
                break;
            }
        }
        if (songToRemove != null) {
            playlist.remove(songToRemove);
            System.out.println("Song removed from the playlist.");
        } else {
            System.out.println("Song not found in the playlist.");
        }
    }

    // Method to list all songs in the playlist
    public void listAllSongs() {
        System.out.println("Spotify Playlist:");
        for (Song song : playlist) {
            System.out.println(song);
        }
    }

    // Method to list play counts for all the songs
    public void listPlayCounts() {
        System.out.println("Play Counts:");
        for (Song song : playlist) {
            System.out.println(song.getTitle() + " - " + song.getPlays() + " million plays");
        }
    }

    // Method to list the songs with play counts over a specified threshold
    public void listSongsOverThreshold(double threshold) {
        System.out.println("Songs with play counts over " + threshold + " million plays:");
        for (Song song : playlist) {
            if (song.getPlays() > threshold) {
                System.out.println(song);
            }
        }
    }

    // Main method to run the "SpotifyPlaylist" application
    public static void main(String[] args) {
        SpotifyPlaylist playlistManager = new SpotifyPlaylist();

        Scanner scanner = new Scanner(System.in);
        int choice;

        // Menu-driven loop
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add a Song");
            System.out.println("2. Remove a Song");
            System.out.println("3. List All Songs");
            System.out.println("4. List Play Counts");
            System.out.println("5. List Songs Over a Threshold");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            // Switch statement to handle the user choices
            switch (choice) {
                case 1:
                    // Adds a new song with user input
                    System.out.print("Enter song title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter artist: ");
                    String artist = scanner.nextLine();
                    double plays;
                    while (true) {
                        System.out.print("Enter play count (millions): ");
                        if (scanner.hasNextDouble()) {
                            plays = scanner.nextDouble();
                            scanner.nextLine(); // Consume the newline
                            break;
                        } else {
                            System.out.println("Invalid input. Please enter a valid number.");
                            scanner.nextLine(); // Clear the invalid input
                        }
                    }
                    playlistManager.addSong(title, artist, plays);
                    System.out.println("Song added to the playlist.");
                    break;
                case 2:
                    // Remove a song with the user input
                    System.out.print("Enter song title to remove: ");
                    String titleToRemove = scanner.nextLine();
                    playlistManager.removeSong(titleToRemove);
                    break;
                case 3:
                    // List all songs
                    playlistManager.listAllSongs();
                    break;
                case 4:
                    // List all play counts
                    playlistManager.listPlayCounts();
                    break;
                case 5:
                    // List all songs over a threshold
                    double threshold;
                    while (true) {
                        System.out.print("Enter the play count threshold (millions): ");
                        if (scanner.hasNextDouble()) {
                            threshold = scanner.nextDouble();
                            scanner.nextLine(); // Consume the newline
                            break;
                        } else {
                            System.out.println("Invalid input. Please enter a valid number.");
                            scanner.nextLine(); // Clear the invalid input
                        }
                    }
                    playlistManager.listSongsOverThreshold(threshold);
                    break;
                case 6:
                    // Exits the program
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 6);

        // Close the scanner
        scanner.close();
    }
}

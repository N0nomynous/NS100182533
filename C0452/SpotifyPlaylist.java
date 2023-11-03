import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Song {
    private String title;
    private String artist;
    private double plays; // Number of times played in millions

    public Song(String title, String artist, double plays) {
        this.title = title;
        this.artist = artist;
        this.plays = plays;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public double getPlays() {
        return plays;
    }

    public void incrementPlays() {
        plays++;
    }

    @Override
    public String toString() {
        return title + " by " + artist + " (" + plays + " million plays)";
    }
}

public class SpotifyPlaylist {
    private List<Song> playlist;

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
    }

    public void addSong(Song song) {
        playlist.add(song);
    }

    public void removeSong(Song song) {
        playlist.remove(song);
    }

    public void listAllSongs() {
        System.out.println("Spotify Playlist:");
        for (Song song : playlist) {
            System.out.println(song);
        }
    }

    public void listPlayCounts() {
        System.out.println("Play Counts:");
        for (Song song : playlist) {
            System.out.println(song.getTitle() + " - " + song.getPlays() + " million plays");
        }
    }

    public static void main(String[] args) {
        SpotifyPlaylist playlistManager = new SpotifyPlaylist();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add a Song");
            System.out.println("2. Remove a Song");
            System.out.println("3. List All Songs");
            System.out.println("4. List Play Counts");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Add a new song with user input
                    scanner.nextLine();  // Consume the newline character
                    System.out.print("Enter song title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter artist: ");
                    String artist = scanner.nextLine();
                    System.out.print("Enter play count (millions): ");
                    double plays = scanner.nextDouble();
                    playlistManager.addSong(new Song(title, artist, plays));
                    System.out.println("Song added to the playlist.");
                    break;
                case 2:
                    // Remove a song
                    scanner.nextLine();  // Consume the newline character
                    System.out.print("Enter song title to remove: ");
                    String titleToRemove = scanner.nextLine();
                    for (Song song : playlistManager.playlist) {
                        if (song.getTitle().equalsIgnoreCase(titleToRemove)) {
                            playlistManager.removeSong(song);
                            System.out.println("Song removed from the playlist.");
                            break;
                        }
                    }
                    break;
                case 3:
                    // List all songs
                    playlistManager.listAllSongs();
                    break;
                case 4:
                    // List play counts
                    playlistManager.listPlayCounts();
                    break;
                case 5:
                    // Exit the program
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 5);

        scanner.close();
    }
}

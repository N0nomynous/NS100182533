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
        // Add other initial songs...
    }

    public void addSong(String title, String artist, double plays) {
        playlist.add(new Song(title, artist, plays));
    }

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

    public void listSongsOverThreshold(double threshold) {
        System.out.println("Songs with play counts over " + threshold + " million plays:");
        for (Song song : playlist) {
            if (song.getPlays() > threshold) {
                System.out.println(song);
            }
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
            System.out.println("5. List Songs Over a Threshold");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Add a new song with user input
                    System.out.print("Enter song title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter artist: ");
                    String artist = scanner.nextLine();
                    double plays;
                    while (true) {
                        System.out.print("Enter play count (millions): ");
                        if (scanner.hasNextDouble()) {
                            plays = scanner.nextDouble();
                            scanner.nextLine();
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
                    // Remove a song with user input
                    System.out.print("Enter song title to remove: ");
                    String titleToRemove = scanner.nextLine();
                    playlistManager.removeSong(titleToRemove);
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
                    // List songs over a threshold
                    double threshold;
                    while (true) {
                        System.out.print("Enter the play count threshold (millions): ");
                        if (scanner.hasNextDouble()) {
                            threshold = scanner.nextDouble();
                            scanner.nextLine();
                            break;
                        } else {
                            System.out.println("Invalid input. Please enter a valid number.");
                            scanner.nextLine(); // Clear the invalid input
                        }
                    }
                    playlistManager.listSongsOverThreshold(threshold);
                    break;
                case 6:
                    // Exit the program
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 6);

        scanner.close();
    }
}

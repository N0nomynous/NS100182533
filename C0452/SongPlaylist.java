import java.util.ArrayList;
import java.util.List;

class Song {
    private String title;
    private String artist;
    private double plays; // How many times the Song is played in millions

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

public class YouTubeMusicPlaylist { //creating a new class called YoutubeMusicPlaylist as YT Music is better
    private List<Song> playlist;

    public YouTubeMusicPlaylist() {
        playlist = new ArrayList<>();
    }

    public void addSong(Song song) { //adding songs to class
        playlist.add(song);
    }

    public void removeSong(Song song) { //removing songs of class
        playlist.remove(song);
    }

    public void printAllSongs() { //print songs of class
        System.out.println("YouTube Music Playlist:");
        for (Song song : playlist) {
            System.out.println(song);
        }
    }

    public void printSongsOverPlays(double playsThreshold) {
        System.out.println("Songs with more than " + playsThreshold + " million plays:");
        for (Song song : playlist) {
            if (song.getPlays() > playsThreshold) {
                System.out.println(song);
            }
        }
    }

    public static void main(String[] args) {
        YouTubeMusicPlaylist playlistManager = new YouTubeMusicPlaylist();

        // Song methods or names, artists & number of times played (in millions)
        Song song1 = new Song("Blinding Lights", "The Weeknd", 149.0);
        Song song2 = new Song("Starboy", "The Weeknd", 103.0);
        Song song3 = new Song("Shape Of You", "Ed Sheeran", 119.0);
        Song song4 = new Song("After Dark", "Mr. Kitty", 24.2);
        Song song5 = new Song("Number 1", "Nico Santos", 1.39);
        Song song6 = new Song("Brooklyn", "Glockenbach", 1.23);
        Song song7 = new Song("HYPNOTIC DATA", "Odetari", 8.02);
        Song song8 = new Song("Daylight", "David Kushner", 163.0);
        Song song9 = new Song("Strangers", "Kenya Grace", 207.0);
        Song song10 = new Song("Shameless", "Camila Cabello", 17.4);

        playlistManager.addSong(song1);
        playlistManager.addSong(song2);
        playlistManager.addSong(song3);
        playlistManager.addSong(song4);
        playlistManager.addSong(song5);
        playlistManager.addSong(song6);
        playlistManager.addSong(song7);
        playlistManager.addSong(song8);
        playlistManager.addSong(song9);
        playlistManager.addSong(song10);

        // Print the playlist
        playlistManager.printAllSongs();

        // Increment feature plays for a song (simulate playing a song)
        song1.incrementPlays();

        // Add a new song
        Song newSong = new Song("New Song", "New Artist", 0.5);
        playlistManager.addSong(newSong);

        // Remove a song
        playlistManager.removeSong(song6);

        // Print the updated playlist
        playlistManager.printAllSongs();

        // Print songs with more than 100 million plays (special feature)
        playlistManager.printSongsOverPlays(100.0);
    }
}

package testVagrant;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;



public class RecentlyPlayedStore {
    private int capacity;
    private Map<User, LinkedList<Song>> store;

    public RecentlyPlayedStore(int capacity) {
        this.capacity = capacity;
        this.store = new java.util.HashMap<>();
    }

    public void playSong(User user, Song song) {
        LinkedList<Song> playlist = store.get(user);

        if (playlist == null) {
            playlist = new LinkedList<>();
            store.put(user, playlist);
        }

        if (playlist.size() == capacity) {
            playlist.removeLast(); // Remove the least recently played song
        }

        playlist.addFirst(song); // Add the new song to the front
    }

    public LinkedList<Song> getRecentlyPlayedSongs(User user) {
        return store.get(user);
    }
}



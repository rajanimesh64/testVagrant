package testVagrant;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

public class RecentlyPlayedStoreTest {
	 @Test
	    public void testRecentlyPlayedStore() {
	        RecentlyPlayedStore store = new RecentlyPlayedStore(3);

	        User user1 = new User("John");
	        Song song1 = new Song("S1");
	        Song song2 = new Song("S2");
	        Song song3 = new Song("S3");
	        Song song4 = new Song("S4");
	        Song song5 = new Song("S5");

	        // Play 4 songs for user1
	        store.playSong(user1, song1);
	        store.playSong(user1, song2);
	        store.playSong(user1, song3);
	        store.playSong(user1, song4);

	        LinkedList<Song> recentlyPlayed1 = store.getRecentlyPlayedSongs(user1);
	        Assert.assertEquals(3, recentlyPlayed1.size());
	        Assert.assertEquals(song4, recentlyPlayed1.get(0));
	        Assert.assertEquals(song3, recentlyPlayed1.get(1));
	        Assert.assertEquals(song2, recentlyPlayed1.get(2));

	        // Play 2 more songs for user1
	        store.playSong(user1, song2);
	        store.playSong(user1, song5);

	        LinkedList<Song> recentlyPlayed2 = store.getRecentlyPlayedSongs(user1);
	        Assert.assertEquals(3, recentlyPlayed2.size());
	        Assert.assertEquals(song5, recentlyPlayed2.get(0));
	        Assert.assertEquals(song2, recentlyPlayed2.get(1));
	        Assert.assertEquals(song4, recentlyPlayed2.get(2));

	    }
}

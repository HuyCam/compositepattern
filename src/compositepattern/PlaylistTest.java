package compositepattern;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

class PlaylistTest {

	@Test
	void songAndPlaylistNameTest() {
		Playlist experimentalPlaylist = new Playlist("Experimental");		
		Song experimentalSong1 = new Song("About you", "XXYYXX");
		Song experimentalSong2 = new Song("Motivation", "Clams Casino");	
		Playlist playlist2 = new Playlist("Playlist2");
		
		experimentalPlaylist.add(experimentalSong1);
		experimentalPlaylist.add(experimentalSong2);
		experimentalPlaylist.add(playlist2);

		String[] names = {"About you", "Motivation", "Playlist2"};
		
		Iterator<IComponent> i = experimentalPlaylist.getPlaylist().iterator();
		int index = 0;
		
		while (i.hasNext()) {
			IComponent c = i.next();
			assertEquals(names[index], c.getName());
			index++;
		}
	}

}

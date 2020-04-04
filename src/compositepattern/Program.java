package compositepattern;

import java.util.ArrayList;
import java.util.Iterator;

//--------------------
//[Program.java]
//--------------------
public class Program {

	public static void main(String args[]) {
	
	// Make new empty "Study" playlist 
	Playlist studyPlaylist = new Playlist("Study");		

	// Make "Synth Pop" playlist and add 2 songs to it.
	Playlist synthPopPlaylist = new Playlist("Synth Pop");
	Song synthPopSong1 = new Song("Girl Like You", "Toro Y Moi" );
	Song synthPopSong2 = new Song("Outside", "TOPS");
	synthPopPlaylist.add(synthPopSong1);
	synthPopPlaylist.add(synthPopSong2);

	// Make "Experimental" playlist and add 3 songs to it, 
	// then set playback speed of the playlist to 0.5x
	Playlist experimentalPlaylist = new Playlist("Experimental");		
	Song experimentalSong1 = new Song("About you", "XXYYXX");
	Song experimentalSong2 = new Song("Motivation", "Clams Casino");	
	Song experimentalSong3 = new Song("Computer Vision", "Oneohtrix Point Never");
	experimentalPlaylist.add(experimentalSong1);
	experimentalPlaylist.add(experimentalSong2);
	experimentalPlaylist.add(experimentalSong3);
	float slowSpeed = 0.5f;
	experimentalPlaylist.setPlaybackSpeed(slowSpeed);
	
	// Add the "Synth Pop" playlist to the "Experimental" playlist
	experimentalPlaylist.add(synthPopPlaylist);

	// Add the "Experimental" playlist to the "Study" playlist
	studyPlaylist.add(experimentalPlaylist);

	// Create a new song and set its playback speed to 1.25x, play this song, 
	// get the name of glitchSong → "Textuell", then get the artist of this song → "Oval"
	Song glitchSong = new Song("Textuell", "Oval");
	float fasterSpeed = 1.25f;
	glitchSong.setPlaybackSpeed(fasterSpeed);
	glitchSong.play(); 
	String name = glitchSong.getName(); 
	String artist = glitchSong.getArtist(); 
	System.out.println ("The song name is " + name );
	System.out.println ("The song artist is " + artist );

	// Add glitchSong to the "Study" playlist
	studyPlaylist.add(glitchSong);

	// Play "Study" playlist.
	studyPlaylist.play(); 

	// Get the playlist name of studyPlaylist → "Study"
	System.out.println ("The Playlist's name is " + studyPlaylist.getName() );
	}
}

//--------------------
//[IComponent.java]
//--------------------
interface IComponent {

// Your code goes here!
void play();

void setPlaybackSpeed(float speed);
String getName();


}

//--------------------
//[Playlist.java]
//--------------------
class Playlist implements IComponent {

	public String playlistName;
	public ArrayList<IComponent> playlist = new ArrayList<>();

	public Playlist(String playlistName) {
		this.playlistName = playlistName;
	}

	public void add(Playlist playList) {
		// TODO Auto-generated method stub
		playlist.add(playList);
		
	}

	public void add(Song songName) {
		playlist.add(songName);
	}

	@Override
	public void play() {
		System.out.println("Playin " + playlistName +" playlist");
	}

	@Override
	public void setPlaybackSpeed(float speed) {
		System.out.println("Speed set: " + speed);
		
		Iterator<IComponent> i = playlist.iterator();
		
		while (i.hasNext()) {
			i.next().setPlaybackSpeed(speed);
		}
	}

	@Override
	public String getName() {
		return playlistName;
	}

	public ArrayList<IComponent> getPlaylist() {
		return playlist;
	}

	public void setPlaylist(ArrayList<IComponent> playlist) {
		this.playlist = playlist;
	}
	
	
}

//--------------------
//[Song.java]
//--------------------
class Song implements IComponent {
	public String songName;
	public String artist;
	public float speed = 1; // Default playback speed

	public Song(String songName, String artist ) {
		this.songName = songName;
		this.artist = artist; 
	}

	@Override
	public void play() {
		System.out.println("PLaying " + songName + " song");
		
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	@Override
	public void setPlaybackSpeed(float speed) {
		this.speed = speed;
	}

	@Override
	public String getName() {
		return this.songName;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
}
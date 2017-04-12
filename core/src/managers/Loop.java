package managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class Loop {

	public Sound sound;
	
	public Loop(String name) {
		sound = Gdx.audio.newSound(Gdx.files.internal("loops/"+ name +".ogg"));
	
	}
	
	public void play(){
		System.out.println("play");
		sound.stop();
		sound.play();
	}
}

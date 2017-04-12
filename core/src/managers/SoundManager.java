package managers;

import java.util.Timer;
import java.util.TimerTask;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;

public class SoundManager {

	Controler controler;
	public Array<Loop> drums;
	public Array<Loop> synths;
	public Array<Loop> basses;
	
	public static Loop currDrums;
	public static Loop currBass;
	public static Loop currSynth;
	
	public static Loop nextDrums;
	public static Loop nextBass;
	public static Loop nextSynth;
	
	float tempo_sixteenth = 0.117f;
	
	public Timer timer;
	
	public SoundManager() {
		
		timer = new Timer();
		controler = new Controler();
		drums = new Array<Loop>();
		synths = new Array<Loop>();
		basses = new Array<Loop>();
		
		initLoops();
		
		currBass = basses.first();
		currDrums = drums.first();
		currSynth = synths.first();
		
		nextBass = basses.first();
		nextDrums = drums.first();
		nextSynth = synths.first();
		
		timer.scheduleAtFixedRate(new TimerTask() {
			  @Override
			  public void run() {
			    playLoops();
			  }
			}, 0, (long) (tempo_sixteenth * 16 * 2 * 1000));
	}
	
	public void initLoops(){
		//drums
		Loop temp = new Loop("clap");
		drums.add(temp);
		
		temp = new Loop("kick");
		drums.add(temp);
		
		//synth
		temp = new Loop("loop");
		synths.add(temp);
		
		temp = new Loop("hat");
		synths.add(temp);
		
		//bass
		temp = new Loop("fill");
		basses.add(temp);
		
		temp = new Loop("melody");
		basses.add(temp);
		
	}
	
	public void update(){
		
		// Set Changes
		controler.update();
		if(controler.step == 2){
			
			// Check if drums changes
			if(controler.isDrum && drums.get(controler.choice) != null){
				nextDrums = drums.get(controler.choice);
				controler.isDrum = false;
				System.out.println("Drums Changed");
			}
			
			// Check if basses changes
			else if(controler.isBass && basses.get(controler.choice) != null){
				nextBass = basses.get(controler.choice);
				controler.isBass = false;
				System.out.println("Bass Changed");
			}
			
			// Check if basses changes
			else if(controler.isSynth && synths.get(controler.choice) != null){
				nextSynth = synths.get(controler.choice);
				controler.isSynth = false;
				System.out.println("Synth Changed");
			}
			
			controler.step = 0;
		}
		

			
	}
	
	public static void playLoops() {
		if(currDrums != nextDrums){
			currDrums.sound.stop();
			currDrums = nextDrums;
		}

		else if(currSynth != nextSynth){
			currSynth.sound.stop();
			currSynth = nextSynth;				
		}

		else if(currBass != nextBass){
			currBass.sound.stop();
			currBass = nextBass;
		}
		currDrums.play();
		currSynth.play();
		currBass.play();
	}
	
}

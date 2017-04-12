package managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Controler {

	public int step;
	
	public boolean isDrum;
	public boolean isBass;
	public boolean isSynth;
	
	public int choice;
	
	public Controler() {
		step = 0;
		isDrum = false;
		isBass = false;
		isSynth = false;
		
		choice = 0;
	}
	
	public void update(){
		// Step 0
		if(step == 0){
			if(Gdx.input.isKeyJustPressed(Input.Keys.D)){
				isDrum = true;
				step = 1;
			}
			
			else if(Gdx.input.isKeyJustPressed(Input.Keys.B)){
				isBass = true;
				step = 1;
			}
			
			else if(Gdx.input.isKeyJustPressed(Input.Keys.S)){
				isSynth = true;
				step = 1;
			}
		}
		// Step 1
		if(step == 1){
			
			if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_1)){
				choice = 0;
				step = 2;
			}
			
			else if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_2)){
				choice = 1;
				step = 2;
			}
			
			else if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_3)){
				choice = 2;
				step = 2;
			}
		}
	}
}

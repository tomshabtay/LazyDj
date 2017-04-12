package com.tslazydj;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import managers.Controler;
import managers.Loop;
import managers.SoundManager;

public class LazyDj extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	
	Loop drums;
	Loop synth;
	
	SoundManager sound_manager;
	
	double tempo_sixteenth = 0.117f;
	float timer = 0;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		
		sound_manager = new SoundManager();
	
	}
	
	public void update(){

		sound_manager.update();

	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}

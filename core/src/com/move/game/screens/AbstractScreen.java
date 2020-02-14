package com.move.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.move.game.manager.ScreenManager;

public abstract class AbstractScreen implements Screen{
	
	ScreenManager sm;
	public AbstractScreen(ScreenManager sm) {
		this.sm = sm;
	}
	
	public abstract void update(float delta);
	
	@Override
	public void render(float delta) {
		update(delta);
		Gdx.gl.glClearColor(0.25f,0.25f,0.25f,0.25f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
	
	
	
}

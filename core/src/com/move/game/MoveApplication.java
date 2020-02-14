package com.move.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.move.game.manager.ScreenManager;

public class MoveApplication extends Game {
	public SpriteBatch batch;
	ScreenManager sm;
//	Texture meri;
//	OrthographicCamera camera;
//	
	
	public static final int WIDTH = 720;
	public static final int HEIGTH = 420;
	
//	private int zoom = 2;
//	private float speed = 30;
//	
	@Override
	public void create () {
		this.sm = new ScreenManager(this);
		batch = new SpriteBatch();
//		meri = new Texture("meri2.jpg");
//		
////		camera = new OrthographicCamera(WIDTH * 1, HEIGTH * 1 );
//		camera = new OrthographicCamera();
//		camera.setToOrtho(false, WIDTH * zoom , HEIGTH * zoom  );
////		camera.position.set(camera.viewportWidth/2, camera.viewportHeight/2, 0);
	}

	@Override
	public void render () {
		super.render();
//		Gdx.gl.glClearColor(1, 0, 0, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		
//		camera.translate(Gdx.graphics.getDeltaTime() * speed
//		, 0);
//		
//		camera.update();
//		
//		batch.begin();
//		batch.setProjectionMatrix(camera.combined);
//		
//		batch.draw(meri,0
//				, camera.viewportHeight/2- meri.getHeight()/2);
//		batch.end();
		
		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
			Gdx.app.exit();
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
//		meri.dispose();
	}
}

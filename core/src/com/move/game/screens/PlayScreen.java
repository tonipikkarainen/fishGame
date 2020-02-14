package com.move.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.move.game.MoveApplication;
import com.move.game.manager.ScreenManager;
import com.move.game.objects.BackGround;
import com.move.game.objects.Fish;
import com.move.game.objects.Medusa;

public class PlayScreen extends AbstractScreen {
	
	// objects
	Texture meri;
	Fish fish;
//	Medusa medusa;
	Array<Medusa> medusas;
	Array<BackGround> bgs;
	
	OrthographicCamera camera;
	
	private int zoom = 10;
	private float speed = 2000;
	float medusa_distance = 2000;
	
	float meriX = 0;
	float meriWidth; 
	
	public PlayScreen(ScreenManager sm) {
		super(sm);
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, MoveApplication.WIDTH * zoom ,
				MoveApplication.HEIGTH * zoom  );
		meri = new Texture("meri2.jpg");
		fish = new Fish(new Vector2(0,camera.viewportHeight/2));
		
		meriWidth = 2 * camera.viewportWidth;
		camera.position.x = fish.getPosition().x + 100;
		meriX = camera.position.x - camera.viewportWidth/2;
		
		
		medusas = new Array<Medusa>();
		bgs = new Array<BackGround>();
		
		for (int i = 0; i < 2; i++) {
			bgs.add(new BackGround(2 * camera.viewportWidth,
					2 * camera.viewportHeight,
					camera.position.x - camera.viewportWidth/2 
					+ i * 2 * camera.viewportWidth, i % 2 == 0));
		}
		//medusa = new Medusa(camera.viewportWidth/2, camera.viewportHeight);
		for (int i = 0; i < 5; i++) {
			medusas.add(new Medusa(camera.viewportWidth/2 + i*medusa_distance
					, camera.viewportHeight));
		}
	}

	@Override
	public void show() {
		
		
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
		
		handleInput(delta);
		fish.moveForward(delta);
		fish.feelGravity(delta);
		
		moveMedusas();
		moveMeri();
		
		sm.app.batch.begin();
		sm.app.batch.setProjectionMatrix(camera.combined);
		
//		sm.app.batch.draw(meri,meriX//camera.position.x - camera.viewportWidth/2
//					, camera.position.y - camera.viewportHeight / 2
//					, 3 *camera.viewportWidth
//					, 3 * camera.viewportHeight);
		for (BackGround backGround : bgs) {
			sm.app.batch.draw(backGround.getImg(),backGround.getX(),
					camera.position.y - camera.viewportHeight / 2,
					backGround.getX() / 2 , (camera.position.y - camera.viewportHeight / 2)/2
					, backGround.getWidth(), backGround.getHeight(),
					1f,1f,0,
					0,0,backGround.getImg().getWidth(),backGround.getImg().getHeight(),
					backGround.isFlip,false);
		}
		for (Medusa medusa : medusas) {
			sm.app.batch.draw(medusa.getImg(), medusa.getPosition().x, medusa.getPosition().y,
					medusa.getSize(),medusa.getSize());
		}
		
		
		sm.app.batch.draw(fish.getFish(), fish.getPosition().x, fish.getPosition().y);
		sm.app.batch.end();
	}
	
	
	private void moveMeri() {
		for (BackGround backGround : bgs) {
			if(backGround.getX()+ backGround.getWidth() 
				< camera.position.x - camera.viewportWidth/2) {
				backGround.setX(backGround.getX() + 2 * backGround.getWidth());
//				meriX = camera.position.x - camera.viewportWidth/2
			}
		}
//		if(meriX + meriWidth < camera.position.x + camera.viewportWidth/2) {
//			meriX = camera.position.x - camera.viewportWidth/2;
//		}
//		
	}

	private void moveMedusas() {
		for (Medusa medusa : medusas) {
			if (medusa.getPosition().x < camera.position.x - camera.viewportWidth/2) {
				medusa.setPosition(new Vector2(medusa.getPosition().x + 5 * medusa_distance,
						(float)Math.random()*camera.viewportHeight));
			}
		}
		
	}

	private void handleInput(float delta) {
		if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			fish.moveUp(delta);
		}
	}

	@Override
	public void update(float delta) {
		camera.position.x = fish.getPosition().x + 100;
		camera.update();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		meri.dispose();
		fish.dispose();
		for (Medusa medusa : medusas) {
			if (medusa != null) {
				medusa.dispose();
			}
		}
		
	}

}

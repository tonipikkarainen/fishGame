package com.move.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.math.Vector2;

public class Medusa {
	Texture img;
	Vector2 position;
	float size = 500;
	
	public Medusa(float x, float bound) {
		this.img = new Texture(Gdx.files.internal("medusa.png"));
		
		this.position = new Vector2(x, (float)Math.random()*bound);
	}
	
	public void dispose() {
		img.dispose();
	}

	public Texture getImg() {
		return img;
	}

	public Vector2 getPosition() {
		return position;
	}
	
	

	public void setPosition(Vector2 position) {
		this.position = position;
	}

	public float getSize() {
		return size;
	}
	
	
	
}

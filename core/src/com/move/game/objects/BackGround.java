package com.move.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class BackGround {
	Texture img;
	float height;
	float width;
	float x;
	public boolean isFlip;
	
	public BackGround(float w, float h, float x, boolean flip) {
		this.width = w;
		this.height = h;
		this.img = new Texture(Gdx.files.internal("meri2.jpg"));
		this.x = x;
		this.isFlip = flip;
	}

	public float getHeight() {
		return height;
	}

	public float getWidth() {
		return width;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public Texture getImg() {
		return img;
	}
	
	
	
	
}

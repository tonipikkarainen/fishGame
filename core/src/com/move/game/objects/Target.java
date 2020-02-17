package com.move.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Target {
	Texture img;
	Vector2 position;
	float size = 500;
	Rectangle area;
	boolean CATCHED = false;
	
	public Target(float x, float bound) {
		this.img = new Texture(Gdx.files.internal("saalis.png"));
		
		this.position = new Vector2(x, (float)Math.random()*bound);
		this.area = new Rectangle(position.x, position.y, size, size);
	}
	
	public void dispose() {
		img.dispose();
	}

	public Texture getImg() {
		return img;
	}

	public Vector2 getPosition() {
		return area.getPosition(this.position);
	}
	
	

	public void setPosition(Vector2 position) {
		this.area.setPosition(position);
	}

	public float getSize() {
		return size;
	}

	public boolean isCATCHED() {
		return CATCHED;
	}

	public void setCATCHED(boolean cATCHED) {
		CATCHED = cATCHED;
	}

	public Rectangle getArea() {
		return area;
	}
	
	
	
	
}

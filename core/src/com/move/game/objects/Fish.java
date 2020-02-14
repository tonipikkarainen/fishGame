/**
 * 
 */
package com.move.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

/**
 * @author tonipikkarainen
 * @date 14.2.2020
 */
public class Fish {
	Texture fish;

	Vector2 position;
	
	float y_speed = 0;
	float x_speed = 1700;
	float gravity = -2000f;
	
	
	
	public Fish(Vector2 pos) {
		this.position = pos;
		this.fish = new Texture(Gdx.files.internal("hauki.png"));
		
	}
	
	public void dispose() {
		fish.dispose();
	}
	public Texture getFish() {
		return fish;
	}
	
	public Vector2 getPosition() {
		return position;
	}
	
	
	public void feelGravity(float delta) {
		y_speed += gravity * delta; 
		this.position.y += y_speed * delta;
		
		if (this.position.y < 0) {
			this.position.y = 0;
			this.y_speed = 0;
		}
	
		
	}
	
	public void moveUp(float delta) {
		this.y_speed += 90;
	}
	
	public void moveForward(float delta) {
		this.position.x += x_speed * delta;
	}
	
//	public void moveFishX(float delta) {
//		this.position.x +=  
//	}
}

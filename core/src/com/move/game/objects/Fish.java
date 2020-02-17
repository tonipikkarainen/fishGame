/**
 * 
 */
package com.move.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.move.game.MoveApplication;

/**
 * @author tonipikkarainen
 * @date 14.2.2020
 */
public class Fish {
	Texture fish;
	Rectangle area;
	Vector2 position;
	
	float y_speed = 0;
	float x_speed = 1700;
	float gravity = -2000f;
	
	
	
	
	public Fish(Vector2 pos) {
		this.position = pos;
		this.fish = new Texture(Gdx.files.internal("hauki.png"));
		this.area = new Rectangle(position.x, position.y,
				fish.getWidth(), fish.getHeight());
		
	}
	
	public void dispose() {
		fish.dispose();
	}
	public Texture getFish() {
		return fish;
	}
	
	public Vector2 getPosition() {
//		return position;
		return area.getPosition(position);
	}
	
	
	public void feelGravity(float delta) {
		y_speed += gravity * delta; 
//		this.position.y += y_speed * delta;
//		
//		if (this.position.y < 0) {
//			this.position.y = 0;
//			this.y_speed = 0;
//		}
//		if (this.position.y + this.fish.getHeight() 
//			> MoveApplication.HEIGTH * MoveApplication.ZOOM) {
//			this.position.y = MoveApplication.HEIGTH * MoveApplication.ZOOM - 
//			this.fish.getHeight();
//			this.y_speed = 0;
//		}
		this.area.y += y_speed * delta;
		
		if (this.area.y < 0) {
			this.area.y = 0;
			this.y_speed = 0;
		}
		if (this.area.y + this.fish.getHeight() 
			> MoveApplication.HEIGTH * MoveApplication.ZOOM) {
			this.area.y = MoveApplication.HEIGTH * MoveApplication.ZOOM - 
			this.fish.getHeight();
			this.y_speed = 0;
		}
		
		
	}
	
	public void moveUp(float delta) {
			this.y_speed += 200;
	}
	
	public void moveForward(float delta) {
		this.area.x += x_speed * delta;
	}

	public Rectangle getArea() {
		return area;
	}
	
	
	
//	public void moveFishX(float delta) {
//		this.position.x +=  
//	}
}

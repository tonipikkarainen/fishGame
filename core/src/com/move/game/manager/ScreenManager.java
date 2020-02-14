/**
 * 
 */
package com.move.game.manager;

import java.util.HashMap;

import com.move.game.MoveApplication;
import com.move.game.screens.AbstractScreen;
import com.move.game.screens.PlayScreen;

/**
 * @author tonipikkarainen
 * @date 14.2.2020
 */
public class ScreenManager {
	public MoveApplication app;
	
	HashMap<GAMESCREEN, AbstractScreen> screens;
	
	public enum GAMESCREEN {
		MENU,
		PLAY
	}
	
	public ScreenManager(MoveApplication app) {
		this.app = app;
		initGameScreens();
		setGameScreen(GAMESCREEN.PLAY);
	}
	
	private void initGameScreens() {
		this.screens = new HashMap<GAMESCREEN, AbstractScreen> ();
		this.screens.put(GAMESCREEN.PLAY, new PlayScreen(this) );
		//this.screens.put(GAMESCREEN.MENU, new MenuScreen(this.app));
		// here we can add new types of screens
	}
	
	public void setGameScreen(GAMESCREEN nextScreen) {
		app.setScreen(screens.get(nextScreen));
	}
	
	public void dispose() {
		for (AbstractScreen screen : screens.values()) {
			if (screen != null) {
				screen.dispose();
			}
		}
	}
	
	
	
}

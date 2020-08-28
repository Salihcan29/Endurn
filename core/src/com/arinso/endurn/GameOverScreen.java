package com.arinso.endurn;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class GameOverScreen {
	Boolean TouchActive = false;
	int Timer = 0;
	
	public GameOverScreen(){
		
	}
	
	public void update(){
		if(Timer == 0){
			if(GameScreen.score > GameClass.prefs.getInteger("Highscore")){
				GameClass.prefs.putInteger("Highscore", GameScreen.score);	
			}
			GameClass.prefs.putInteger("TP", GameClass.prefs.getInteger("TP")+GameScreen.score);
			GameClass.prefs.putInteger("GIFTP", GameClass.prefs.getInteger("GIFTP")+GameScreen.score);
			GameClass.prefs.flush();
			if(GameClass.prefs.getInteger("GIFTP") > 500)
				GameClass.prefs.putInteger("GIFTP",500);
			GameClass.prefs.putInteger("Coin",GameClass.prefs.getInteger("Coin")+GameClass.GS.Coin);
			GameClass.prefs.flush();
		}
		
		if(Timer<30)
			Timer++;
		else
			TouchActive = true;
		
		render(GameClass.SR, GameClass.SB);
		
		if((Gdx.input.justTouched()||Gdx.input.isKeyPressed(Keys.BACK))&&TouchActive){
			GameClass.SCREEN = SCREENS.HOME;
			GameClass.HS.timer = 0;
			GameClass.HS = new HomeScreen();
			GameClass.GS = new GameScreen();
			GameClass.bg.play();
			Timer = 0;
			TouchActive = false;
		}
		
		
	}
	
	public void render(ShapeRenderer SR,SpriteBatch SB){
		
		SB.begin();
		GameClass.TextFontLarge.setColor(1,1,1,1);
		GameClass.TextFontLarge.draw(SB,"GAME", Gdx.graphics.getWidth()/6, Gdx.graphics.getHeight()/20*18);
		GameClass.TextFontLarge.draw(SB,"OVER", Gdx.graphics.getWidth()/5, Gdx.graphics.getHeight()/4*3);
		GameClass.TextFontMedium.draw(SB,""+GameScreen.score, Gdx.graphics.getWidth()/2-(""+GameScreen.score).length()*16f/405*Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/2);
		GameClass.TextFontMedium.draw(SB,""+GameClass.prefs.getInteger("Highscore"), Gdx.graphics.getWidth()/2-(""+GameClass.prefs.getInteger("Highscore")).length()*16f/405*Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/2-Gdx.graphics.getHeight()/7);
		SB.end();
	}
}

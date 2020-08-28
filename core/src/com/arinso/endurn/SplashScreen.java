package com.arinso.endurn;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class SplashScreen {
	int timer = 0;
	Texture CompanyLogo;
	
	public SplashScreen(){
		CompanyLogo = new Texture(Gdx.files.internal("ARINSO_WHITE.png"));
		GameClass.BCR = 256;
		GameClass.BCG = 0;
		GameClass.BCB = 0;
	}
	
	public void update(){
		if(GameClass.SCREEN==SCREENS.SPLASH){
		Gdx.gl.glClearColor(1,GameClass.BCG/256,GameClass.BCB/256, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT | (Gdx.graphics.getBufferFormat().coverageSampling?GL20.GL_COVERAGE_BUFFER_BIT_NV:0));
		}
		
		if(GameClass.SCREEN == SCREENS.SPLASH)
		if(timer<120)
			timer++;
		else{
			if(GameClass.BCG<255)
			GameClass.BCG +=2;
			if(GameClass.BCB<255)
			GameClass.BCB +=2;
		}
			
		
		if(GameClass.SCREEN == SCREENS.SPLASH)
		if(GameClass.BCG>=256){
			GameClass.SCREEN = SCREENS.HOME;
			GameClass.bg.play();
		}
		
		
		render(GameClass.SR,GameClass.SB);		
	}
	
	public void render(ShapeRenderer SR,SpriteBatch SB){
		SB.begin();
		SB.setColor(1-GameClass.BCG/256,1- GameClass.BCG/256,1-GameClass.BCG/256, 1-GameClass.BCG/256);
		SB.draw(CompanyLogo, Gdx.graphics.getWidth()/2-Gdx.graphics.getWidth()/8*3, Gdx.graphics.getHeight()/2-((float) (Gdx.graphics.getWidth()/4*3)/CompanyLogo.getWidth()*CompanyLogo.getHeight())/2,Gdx.graphics.getWidth()/4*3,(float) (Gdx.graphics.getWidth()/4*3)/CompanyLogo.getWidth()*CompanyLogo.getHeight());	
		SB.end();
	}
}

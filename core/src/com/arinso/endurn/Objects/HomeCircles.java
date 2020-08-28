package com.arinso.endurn.Objects;

import com.arinso.endurn.GameClass;
import com.arinso.endurn.HomeScreen;
import com.arinso.endurn.SCREENS;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;

public class HomeCircles {
	float x,y;
	float speed;
	int radius;
	int SRColor;
	float AlphaTimer;
	Boolean hl = false;
	public HomeCircles(){
		radius = (int) (MathUtils.random(10,50)/405f*Gdx.graphics.getWidth());
		
		x = MathUtils.random(0, Gdx.graphics.getWidth());
		y = MathUtils.random(0, Gdx.graphics.getHeight());
		
		speed = MathUtils.random(25, 300);
		speed = (speed/100)/720*Gdx.graphics.getHeight();
		SRColor = MathUtils.random(1, 6);
		AlphaTimer = 0;
	}
	
	void randomColor(ShapeRenderer SR,int i){
		switch(i){
		
		case 1: SR.setColor(1, 0, 1, 0.5f*AlphaTimer/240); break;
		case 2: SR.setColor(1, 1, 0, 0.5f*AlphaTimer/240); break;
		case 3: SR.setColor(0, 1, 1, 0.5f*AlphaTimer/240); break;
		case 4: SR.setColor(0, 0, 1, 0.5f*AlphaTimer/240); break;
		case 5: SR.setColor(0, 1, 0, 0.5f*AlphaTimer/240); break;
		case 6: SR.setColor(1, 0, 0, 0.5f*AlphaTimer/240); break;
		
		}
		
	}
	public void update(){
		
		if(!hl)
		if(AlphaTimer<240)
		AlphaTimer++;
		else 
		hl=!hl;
		
		if(hl)
		AlphaTimer--;
		if(AlphaTimer<0)
		HomeScreen.HCS.remove(this);
		
		
		if(x<-radius&&HomeScreen.direction>90&&HomeScreen.direction<270)
			HomeScreen.HCS.remove(this);
		if(x>Gdx.graphics.getWidth()+radius&&(HomeScreen.direction<90||HomeScreen.direction>270))
			HomeScreen.HCS.remove(this);
		if(y<-radius&&HomeScreen.direction>180&&HomeScreen.direction<360)
			HomeScreen.HCS.remove(this);
		if(y>Gdx.graphics.getHeight()+radius&&HomeScreen.direction<180&&HomeScreen.direction>0)
			HomeScreen.HCS.remove(this);
		
		if(GameClass.SCREEN == SCREENS.HOME){
			x += speed*HomeScreen.speedparameter*MathUtils.cosDeg(HomeScreen.direction);
			y += speed*HomeScreen.speedparameter*MathUtils.sinDeg(HomeScreen.direction);
		}else{
			x += (x-Gdx.input.getX())/20;
			y += (y-(Gdx.graphics.getHeight()-Gdx.input.getY()))/20;
		}
		
		render(GameClass.SR, GameClass.SB);
	}
	
	public void render(ShapeRenderer SR,SpriteBatch SB){
			randomColor(GameClass.SR,SRColor);
			SR.circle(x, y, radius);
	}
}

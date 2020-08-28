package com.arinso.endurn.Objects;

import com.arinso.endurn.GameClass;
import com.arinso.endurn.GameScreen;
import com.arinso.endurn.SCREENS;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;

public class Barrier {
	float x,y;
	float speed;
	int Color;
	int radius;
	float Alpha256 = 255;
	
	public Barrier(){
		radius = (int) (MathUtils.random(5, 50)/405f*Gdx.graphics.getWidth());

		int directionSpawn = MathUtils.random(1,3);
		if(directionSpawn!=3 || GameClass.GS.direction >= 268 && GameClass.GS.direction <= 272){
			y = Gdx.graphics.getHeight()+radius;
			x = MathUtils.random(0,Gdx.graphics.getWidth());
		}else{
			if(GameClass.GS.direction>272){
				x = -radius;
				y = MathUtils.random(Gdx.graphics.getHeight()-Gdx.graphics.getHeight()/45f*Math.abs(270-GameClass.GS.direction),Gdx.graphics.getHeight()+radius);
			}

			if(GameClass.GS.direction<268){
				x = Gdx.graphics.getWidth()+radius;
				y = MathUtils.random(Gdx.graphics.getHeight()-Gdx.graphics.getHeight()/45f*(270-GameClass.GS.direction),Gdx.graphics.getHeight()+radius);
			}

		}




		
		
		Color = MathUtils.random(1, 5);
		speed = MathUtils.random(10,30);
		speed = (speed/10)/720*Gdx.graphics.getHeight();
	}
	
	void setColor(ShapeRenderer SR,int Color){
		switch(Color){	
		case 1: SR.setColor(1, 0, 1, Alpha256/256); break;
		case 2: SR.setColor(1, 1, 0, Alpha256/256); break;
		case 3: SR.setColor(0, 1, 1, Alpha256/256); break;
		case 4: SR.setColor(0, 1, 0, Alpha256/256); break;
		case 5: SR.setColor(1, 0, 0, Alpha256/256); break;		
		}
	}
	
	public void update(){

		x += speed*MathUtils.cosDeg(GameClass.GS.direction);
		y += speed*MathUtils.sinDeg(GameClass.GS.direction);
		
		if(GameClass.SCREEN == SCREENS.GAMEOVER){
			if(Alpha256>2)
				Alpha256 -= Alpha256/20;
			else
				GameScreen.Barriers.remove(this);
		}

		if(y<-radius||(GameClass.GS.direction > 270 && x > Gdx.graphics.getWidth() + radius)|| (GameClass.GS.direction < 270 && x < -radius)){
			GameScreen.Barriers.remove(this);
		}

		
		render(GameClass.SR);
	}
	
	public void render(ShapeRenderer SR){
		setColor(GameClass.SR,Color);
		SR.circle(x, y, radius);
	}
}

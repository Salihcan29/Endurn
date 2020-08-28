package com.arinso.endurn.Objects;

import com.arinso.endurn.GameClass;
import com.arinso.endurn.SCREENS;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;

public class coin {
	int x,y;
	int mod;
	public int startopacity = 0;
	int EndTimer = 0;
	Boolean xx = false;
	Boolean collect = false;
	
	public coin(int mod){
		if(mod == 0){
			x = MathUtils.random(Gdx.graphics.getWidth()/15*2, Gdx.graphics.getWidth()/15*13);
			y = MathUtils.random(Gdx.graphics.getWidth()/15*2, Gdx.graphics.getHeight()-Gdx.graphics.getWidth()/15*2);
			
		}
		if(mod == 1){
			x = (int) (Gdx.graphics.getWidth()/20f*19-(GameClass.prefs.getInteger("Coin")+"").length()*(int) ((18f/405)*Gdx.graphics.getWidth())-Gdx.graphics.getWidth()/15);
			y = (int) (Gdx.graphics.getHeight()/10f*9);
		}
		if(mod == 2){
			x = (int) (Gdx.graphics.getWidth()/2f-Gdx.graphics.getWidth()/15);
			y = (int) (Gdx.graphics.getHeight()/4f*3);
		}
		
		this.mod = mod;
	}
	
	
	
	public void update(){
		
		if(GameClass.SCREEN == SCREENS.GAMEOVER)
			xx = true;
		
		EndTimer++;
		if(EndTimer>360)
			xx = true;
		
		if(!xx&&startopacity<255)
		startopacity += 15;
		
		
		if(xx&&mod == 0&&!collect){
			startopacity -=35;
		}else if(xx&&mod == 0&&collect){
			startopacity -=15;
			y+=2;
		}

		
		if(startopacity < 0) startopacity  = 0;
		
			double distance = Math.sqrt(
					(x+Gdx.graphics.getWidth()/30-(GameClass.GS.GC.x))*(x+Gdx.graphics.getWidth()/30-(GameClass.GS.GC.x))+
					(y+Gdx.graphics.getWidth()/30-(GameClass.GS.GC.y))*(y+Gdx.graphics.getWidth()/30-(GameClass.GS.GC.y)));
			if(distance<Gdx.graphics.getWidth()/30+10f/405*Gdx.graphics.getWidth()){
				
				if(!xx){
					GameClass.GS.Coin++;
					xx = true;
					collect = true;
					GameClass.coinsfx.play(GameClass.prefs.getFloat("SFXVol"));
				}
			}
		
		
		if(EndTimer!=0&&startopacity <=0)
			GameClass.GS.Coins.remove(this);
		
		render(GameClass.SR,GameClass.SB);
	}
	
	public void render(ShapeRenderer SR,SpriteBatch SB){
		if(mod==0){
			SB.setColor(1,1,1,startopacity/256f);
			SB.begin();
			SB.draw(GameClass.coin, x, y,Gdx.graphics.getWidth()/15,Gdx.graphics.getWidth()/15);
			SB.end();
		}else{
			if(mod == 1)
			SB.setColor(1,1,1,GameClass.HS.GameLogoAlphaTimer/256);
			if(mod == 2)
			SB.setColor(1,1,1,1-GameClass.HS.GameLogoAlphaTimer/256);


			SB.begin();
			SB.draw(GameClass.coin, x, y,Gdx.graphics.getWidth()/15,Gdx.graphics.getWidth()/15);
			SB.end();
		}
	}
}

package com.arinso.endurn.Objects;

import com.arinso.endurn.GameClass;
import com.arinso.endurn.GameScreen;
import com.arinso.endurn.SCREENS;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;

public class GameCircle {
	float x,y;
	int direction;
	float speed;
	public Sprite circle;
	float TRadius = 10f/405*Gdx.graphics.getWidth();
	float radius = 125f/405*Gdx.graphics.getWidth();
	float VerticalTimer = 0;
	int Color,CloneTimer = 0;
	int[] CloneX = new int[20];
	int[] CloneY = new int[20];
	int[] CloneR = new int[20];
	Boolean CTS = false;
	Boolean REVERS = false;

	public GameCircle(){
		x = Gdx.graphics.getWidth()/2;
		y = Gdx.graphics.getHeight()/2;
		Color = GameClass.prefs.getInteger("Ball-Number");

		switch (Color){
			case 0: CTS = false; REVERS = false; break;
			case 1: CTS = false; REVERS = false; break;
			case 2: CTS = false; REVERS = false; break;
			case 3: CTS = false; REVERS = false; break;
			case 4: CTS = false; REVERS = false; break;
			case 5: CTS = false; REVERS = false; break;
			case 6: CTS = true; REVERS = false; break;
			case 7: CTS = true; REVERS = false; break;
			case 8: CTS = true; REVERS = false; break;
			case 9: CTS = true; REVERS = false; break;
			case 10: CTS = true; REVERS = false; break;
			case 11: CTS = true; REVERS = false; break;
			case 12: CTS = true; REVERS = true; break;
			case 13: CTS = true; REVERS = true; break;
			case 14: CTS = true; REVERS = true; break;
			case 15: CTS = false; REVERS = false ;break;
			case 16: CTS = true; REVERS = false; break;
			case 17: CTS = true; REVERS = true; break;
			case 18: CTS = true; REVERS = false; break;
			case 19: CTS = true; REVERS = false; break;
			case 20: CTS = true; REVERS = false; break;
			case 21: CTS = true; REVERS = false; break;
			case 22: CTS = true; REVERS = true; break;
			case 23: CTS = true; REVERS = true; break;
			case 24: CTS = true; REVERS = false; break;
			case 25: CTS = true; REVERS = false; break;
			case 26: CTS = true; REVERS = false; break;
			case 27: CTS = false; REVERS = false; break;
			case 28: CTS = false; REVERS = false; break;
			case 29: CTS = true; REVERS = false; break;
			case 30: CTS = true; REVERS = false; break;
			case 31: CTS = true; REVERS = false; break;
			case 32: CTS = true; REVERS = false; break;
			case 33: CTS = true; REVERS = false; break;
			case 34: CTS = true; REVERS = false; break;
			case 35: CTS = true; REVERS = false; break;
		}

		if(Color >= 6){
			switch(Color){
				case 6:  circle = new Sprite(GameClass.RedHexa);  break;
				case 7:  circle = new Sprite(GameClass.YelHexa);  break;
				case 8:  circle = new Sprite(GameClass.CyanHexa); break;
				case 9:  circle = new Sprite(GameClass.GrePent);  break;
				case 10: circle = new Sprite(GameClass.MagPent);  break;
				case 11: circle = new Sprite(GameClass.WhiPent);  break;

				case 12: circle = new Sprite(GameClass.rball);    break;
				case 13: circle = new Sprite(GameClass.rball2);   break;
				case 14: circle = new Sprite(GameClass.Hexa);     break;
				case 15: circle = new Sprite(GameClass.yinyang);  break;
				case 16: circle = new Sprite(GameClass.ColHexa);  break;
				case 17: circle = new Sprite(GameClass.square);  break;
				case 18: circle = new Sprite(GameClass.fireball);  break;
				case 19: circle = new Sprite(GameClass.rtri);  break;
				case 20: circle = new Sprite(GameClass.iceball);  break;
				case 21: circle = new Sprite(GameClass.pokeball);  break;
				case 22: circle = new Sprite(GameClass.flower);  break;
				case 23: circle = new Sprite(GameClass.star);  break;


				case 24: circle = new Sprite(GameClass.spider);   break;
				case 25: circle = new Sprite(GameClass.bat);    break;
				case 26: circle = new Sprite(GameClass.dp);       break;
				case 27: circle = new Sprite(GameClass.smile);    break;
				case 28: circle = new Sprite(GameClass.pac);      break;
				case 29: circle = new Sprite(GameClass.illu);     break;
				case 30: circle = new Sprite(GameClass.wolf); 	  break;
				case 31: circle = new Sprite(GameClass.skull); 	  break;
				case 32: circle = new Sprite(GameClass.like);	  break;
				case 33: circle = new Sprite(GameClass.pac); 	  break;
				case 34: circle = new Sprite(GameClass.pac); 	  break;
				case 35: circle = new Sprite(GameClass.pac);	  break;
			}

		}


		direction = 225;
		speed = 2f/405*Gdx.graphics.getWidth();
		for(int i = 0;i<20;i++){
			CloneX[i] = (int)-(200f/405*Gdx.graphics.getWidth());
			CloneY[i] = (int)-(200f/405*Gdx.graphics.getWidth());
			CloneR[i] = 180;
		}
			
	}
	//SHAPERENDERER BALLS COLOR CODES BEGIN
	void BallColor(ShapeRenderer SR,int Color){
		switch(Color){
			case 0: SR.setColor(1, 0, 0, 1); break;
			case 1: SR.setColor(1, 1, 0, 1); break;
			case 2: SR.setColor(0, 1, 1, 1); break;
			case 3: SR.setColor(0, 1, 0, 1); break;
			case 4: SR.setColor(1, 0, 1, 1); break;
			case 5: SR.setColor(1, 1, 1, 1); break;
		}
		
	}
	void CloneColor(ShapeRenderer SR,int Color,float i){
		switch(Color){
			case 0: SR.setColor(1, 0, 0, (0.50f-i/40f)); break;
			case 1: SR.setColor(1, 1, 0, (0.50f-i/40f)); break;
			case 27:SR.setColor(1, 220/256f, 90/256f, (0.50f-i/40f)); break;
			case 28:SR.setColor(1, 210/256f, 40/256f, (0.50f-i/40f)); break;
			case 2: SR.setColor(0, 1, 1, (0.50f-i/40f)); break;
			case 3: SR.setColor(0, 1, 0, (0.50f-i/40f)); break;
			case 4: SR.setColor(1, 0, 1, (0.50f-i/40f)); break;
			case 5:
			case 15:SR.setColor(1, 1, 1, (0.50f-i/40f)); break;
		}
	}
	//SHAPERENDERER BALLS COLOR CODES END

	public void update(){
		if(VerticalTimer<60)
		VerticalTimer++;	
		
		if(radius-TRadius>1){
			if(Color>5)
			circle.setScale((radius * 2f + 1) / circle.getHeight());
			radius += (TRadius - radius)/10;
		}

		
		
		
		if(GameClass.SCREEN == SCREENS.GAME){
			if(VerticalTimer<30){
				y -= (y-Gdx.graphics.getHeight()/4)/10;
			}
			
			if(Gdx.input.isTouched()){
			direction+=4;
			}else{
			direction-=4;
			}
			
			x += speed*MathUtils.cosDeg(direction);
			y += speed*MathUtils.sinDeg(direction);

		}
		for(int i = 0;i < GameScreen.Barriers.size();i++){		
			double distance = Math.sqrt(
					(x-(GameScreen.Barriers.get(i).x))*(x-(GameScreen.Barriers.get(i).x))+
					(y-(GameScreen.Barriers.get(i).y))*(y-(GameScreen.Barriers.get(i).y)));
			if(distance<radius+GameScreen.Barriers.get(i).radius){
				if(GameClass.SCREEN != SCREENS.GAMEOVER){
					GameClass.GameOverSound.play(GameClass.prefs.getFloat("SFXVol"));
					GameClass.bg.stop();
				}
				GameClass.SCREEN = SCREENS.GAMEOVER;
				
				
			}
		}
		
		if(GameClass.SCREEN == SCREENS.GAME)
		if(x<radius||y<radius||x>Gdx.graphics.getWidth()-radius||y>Gdx.graphics.getHeight()-radius){
			GameClass.SCREEN = SCREENS.GAMEOVER;
			GameClass.bg.stop();
			GameClass.GameOverSound.play(GameClass.prefs.getFloat("SFXVol"));
		}

		
		if(GameClass.SCREEN == SCREENS.GAME){
			if(CloneTimer == 3){
				for(int i = 19;i>0;i--){
					CloneX[i] = CloneX[i-1];
					CloneY[i] = CloneY[i-1];
					CloneR[i] = CloneR[i-1];
				}
				CloneTimer = 0;
			}

			CloneTimer++;
			CloneX[0] = (int) x;
			CloneY[0] = (int) y;
			if(!REVERS)
				CloneR[0] = +direction;
			else
				CloneR[0] = -direction;

			if(Color == 18)
				CloneR[0] = direction-45;
			if(Color == 29)
				CloneR[0] = MathUtils.random(0,360);

		}

		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);

			/////////////////////

			GameClass.SR.begin(ShapeRenderer.ShapeType.Filled);
				if(!CTS)
					renderClone(GameClass.SR);
				if(Color < 6)
					render(GameClass.SR);
			GameClass.SR.end();

			////////////////////////////

			GameClass.SB.begin();
				if(CTS)
					renderClone(GameClass.SB);
				if(Color >= 6)
					render(GameClass.SB);
			GameClass.SB.end();

			/////////////////

		Gdx.gl.glDisable(GL20.GL_BLEND);

	}

	public void render(ShapeRenderer SR){
		BallColor(SR,Color);
		if(Color < 6)
			SR.circle(x, y, radius);

	}

	public void renderClone(ShapeRenderer SR) {
			for(int i = 0;i<20;i++){
				CloneColor(SR,Color,i);
				SR.circle(CloneX[i], CloneY[i], radius);
			}
	}

	public void render(SpriteBatch SB){
		if(!REVERS)
			circle.setRotation(+direction);
		else
			circle.setRotation(-direction);

		if(Color == 18)
			circle.setRotation(direction-45);

		if(Color == 29)
			circle.setRotation(0);

		circle.setCenterX(x);
		circle.setCenterY(y);
		circle.setColor(1,1,1,1);
		circle.draw(SB);
	}

	public void renderClone(SpriteBatch SB) {
		for(int i = 0;i<20;i++){
			circle.setRotation(CloneR[i]);
			circle.setCenterX(CloneX[i]);
			circle.setCenterY(CloneY[i]);
			circle.setColor(1, 1, 1, (0.50f - i / 40f));
			circle.draw(SB);
		}
	}
}

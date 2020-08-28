package com.arinso.endurn;

import java.util.ArrayList;

import com.arinso.endurn.Objects.BGameCircles;
import com.arinso.endurn.Objects.Barrier;
import com.arinso.endurn.Objects.GameCircle;
import com.arinso.endurn.Objects.coin;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;

public class GameScreen {
	static int timer;
	static int score;
	public float direction = 270;
	int StartColorTimer = 0;
	public static ArrayList<Barrier> Barriers;
	public static ArrayList<BGameCircles> BGameCircles;
	public ArrayList<coin> Coins; 
	public GameCircle GC;
	int targetDirection = 270;
	public int Coin = 0;
	
	public GameScreen(){	
		Barriers = new ArrayList<Barrier>();
		BGameCircles = new ArrayList<BGameCircles>();
		Coins = new ArrayList<coin>();
		GC = new GameCircle();
		timer = 0;
		score = 0;
	}
	
	public void update(){
		if(GameClass.SCREEN == SCREENS.GAME || GameClass.SCREEN == SCREENS.GAMEOVER){
			Gdx.gl.glClearColor(GameClass.BCR/256, GameClass.BCG/256, GameClass.BCB/256, 0.5f);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		}



		render(GameClass.SR, GameClass.SB);

		//START COLOR START
		if(StartColorTimer<120)
		StartColorTimer++;
		if(StartColorTimer<120){
			if(GameClass.BCR>0)
				GameClass.BCR-=3;
			
			if(GameClass.BCG>0)
				GameClass.BCG-=3;
			
			if(GameClass.BCG<GameClass.BCB-100)
				if(GameClass.BCB!=100){
					GameClass.BCB -= (GameClass.BCB - 100)/20;
					if(GameClass.BCB-100<4)
						GameClass.BCB = 100;
				}
		}
		//START COLOR END
		if(GameClass.BCR<0)
			GameClass.BCR = 0;
		if(GameClass.BCG<0)
			GameClass.BCG = 0;
		
		if(StartColorTimer==120){
			if(GameClass.BCR==0&&GameClass.BCG!=100&&GameClass.BCB==100)
				GameClass.BCG+=0.5;
				
			if(GameClass.BCR==0&&GameClass.BCG==100&&GameClass.BCB!=0)
				GameClass.BCB-=0.5;
				
			if(GameClass.BCR!=100&&GameClass.BCG==100&&GameClass.BCB==0)
				GameClass.BCR+=0.5;
				
			if(GameClass.BCR==100&&GameClass.BCG!=0&&GameClass.BCB==0)
				GameClass.BCG-=0.5;
				
			if(GameClass.BCR==100&&GameClass.BCG==0&&GameClass.BCB!=100)
				GameClass.BCB+=0.5;
				
			if(GameClass.BCR!=0&&GameClass.BCG==0&&GameClass.BCB==100)
				GameClass.BCR-=0.5;
				
		}

		if(GameClass.SCREEN == SCREENS.GAME && timer/30 == (float) timer/30)
		score+=1;
		
		if(timer<900)
			timer++;
		else
			timer = 1;
		

		
		if(GameClass.SCREEN == SCREENS.GAME){
			if(timer/30 == (float) timer/30){
				Barriers.add(new Barrier());
				if(BGameCircles.size()<10)
				BGameCircles.add(new BGameCircles());
			}

			if(timer/180 == (float) timer/180)
				Coins.add(new coin(0));

			if(timer/900 == (float) timer/900)
				targetDirection = MathUtils.random(225,315);

			direction += (targetDirection-direction) / 100f;
		}

		GC.update();

		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);

			GameClass.SR.begin(ShapeRenderer.ShapeType.Filled);

			for(int i = 0;i < BGameCircles.size();i++){
				BGameCircles.get(i).update();
			}

			for(int i = 0;i<Barriers.size();i++){
				Barriers.get(i).update();
			}

			GameClass.SR.end();

			for(int i = 0;i<Coins.size();i++){
				Coins.get(i).update();
			}

		Gdx.gl.glDisable(GL20.GL_BLEND);


	}
	
	public void render(ShapeRenderer SR,SpriteBatch SB){
		SB.begin();
		if(GameClass.SCREEN == SCREENS.GAME){
			GameClass.TextFontLarge.setColor(1, 1, 1, 0.8f);
			GameClass.TextFontLarge.draw(SB, "" + score, Gdx.graphics.getWidth() / 2 - ("" + GameScreen.score).length() * 24f / 405 * Gdx.graphics.getWidth(), Gdx.graphics.getHeight() / 4 * 3 - GameClass.TextFontLarge.getXHeight() / 2);
		}
		SB.end();
	}
}

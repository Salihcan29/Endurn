package com.arinso.endurn;

import java.util.ArrayList;

import com.arinso.endurn.Objects.HomeCircles;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.arinso.endurn.Objects.coin;

public class HomeScreen {
	float LogoX = Gdx.graphics.getWidth()/2-(Gdx.graphics.getWidth()/4*3)/2;
	float LogoY = Gdx.graphics.getHeight();
	float TLOGOY = Gdx.graphics.getHeight()/4*3;
	float ButtonDistance = 720f/720*Gdx.graphics.getHeight();

	float TPBR,TPBG,TPBB = 0;
	float PBR,PBG,PBB = 0;
	
	public float GameLogoAlphaTimer = 0;
	float PlayButtonAlphaTimer = 0;
	int timer,rda = 0; //Random direction addition
	public static ArrayList<HomeCircles> HCS;
	public static float speedparameter;
	public static float direction;
	
	Boolean TouchActive = false;
	coin coin;
	float ShopAnimY = Gdx.graphics.getHeight()/2;
	float ShopAnimRadius = (int) (125f/405*Gdx.graphics.getWidth());
	public HomeScreen(){
		HCS = new ArrayList<HomeCircles>();
		direction = MathUtils.random(1, 259);
		speedparameter = ((float) MathUtils.random(0,200));
		coin = new coin(1);
		updatePlayButtonSRColor(GameClass.prefs.getInteger("Ball-Number"));
	}
	void updatePlayButtonSRColor(int BallNumber){//
		switch (BallNumber){
			case 0:  TPBR = 1; TPBG = 0; TPBB = 0; break;
			case 1:  TPBR = 1; TPBG = 1; TPBB = 0; break;
			case 2:  TPBR = 0; TPBG = 1; TPBB = 1; break;
			case 3:  TPBR = 0; TPBG = 1; TPBB = 0; break;
			case 4:  TPBR = 1; TPBG = 0; TPBB = 1; break;
			case 5:  TPBR = 0.8f; TPBG = 0.8f; TPBB = 0.8f; break;
			case 6:  TPBR = 1; TPBG = 0; TPBB = 0; break;
			case 7:  TPBR = 1; TPBG = 1; TPBB = 0; break;
			case 8:  TPBR = 0; TPBG = 1; TPBB = 1; break;
			case 9:  TPBR = 0; TPBG = 1; TPBB = 0; break;
			case 10: TPBR = 1; TPBG = 0; TPBB = 1; break;
			case 11: TPBR = 0.8f; TPBG = 0.8f; TPBB = 0.8f; break;
			case 12: TPBR = 0.8f; TPBG = 0.8f; TPBB = 0.8f; break;
			case 13: TPBR = 0.8f; TPBG = 0.8f; TPBB = 0.8f; break;
			case 14: TPBR = 0.1f; TPBG = 0.1f; TPBB = 0.1f; break;
			case 15: TPBR = 0.1f; TPBG = 0.1f; TPBB = 0.1f; break;
			case 16: TPBR = 0.8f; TPBG = 0.8f; TPBB = 0.8f; break;
			case 17: TPBR = 0.8f; TPBG = 0.8f; TPBB = 0.8f; break;
			case 18: TPBR = 0.8f; TPBG = 0.5f; TPBB = 0; break;
			case 19: TPBR = 0.5f; TPBG = 0; TPBB = 1; break;
			case 20: TPBR = 44/256f; TPBG = 177/256f; TPBB = 222/256f; break;
			case 21: TPBR = 237/256f; TPBG = 28/256f; TPBB = 36/256f; break;
			case 22: TPBR = 231/256f; TPBG = 76/256f; TPBB = 60/256f; break;
			case 23: TPBR = 222/256f; TPBG = 222/256f; TPBB = 32/256f; break;
			case 24: TPBR = 186/256f; TPBG = 21/256f; TPBB = 28/256f; break;
			case 25: TPBR = 0.8f; TPBG = 0.8f; TPBB = 0.8f; break;
			case 26: TPBR = 153/256f; TPBG = 0; TPBB = 0; break;
			case 27: TPBR = 1; TPBG = 222/256f; TPBB = 88/256f; break;
			case 28: TPBR = 1; TPBG = 212/256f; TPBB = 39/256f; break;
			case 29: TPBR = 115/256f; TPBG = 159/256f; TPBB = 96/256f; break;
			case 30: TPBR = 0; TPBG = 0; TPBB = 0; break;
			case 31: TPBR = 0; TPBG = 0; TPBB = 0; break;
			case 32: TPBR = 0; TPBG = 0; TPBB = 0; break;
			case 33: TPBR = 0; TPBG = 0; TPBB = 0; break;
			case 34: TPBR = 0; TPBG = 0; TPBB = 0; break;
			case 35: TPBR = 0; TPBG = 0; TPBB = 0; break;
		}

	}
	
	public void update(){
		PBR += (TPBR-PBR)/10;
		PBG += (TPBG-PBG)/10;
		PBB += (TPBB-PBB)/10;

		if(PlayButtonAlphaTimer<255)
			PlayButtonAlphaTimer+=5;
		else
			PlayButtonAlphaTimer=255;


		if((!Gdx.input.justTouched())&&Gdx.input.isKeyPressed(Keys.BACK)&&TouchActive&&GameClass.SCREEN == SCREENS.HOME)
			Gdx.app.exit();

		if(GameClass.SCREEN != SCREENS.GAME){
			Gdx.gl.glClearColor(GameClass.BCR/256, GameClass.BCG/256, GameClass.BCB/256, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT | (Gdx.graphics.getBufferFormat().coverageSampling?GL20.GL_COVERAGE_BUFFER_BIT_NV:0));
		}
		
		if(GameClass.SCREEN == SCREENS.HOME){
			if(GameClass.prefs.getInteger("MusicVol") == 1 && !GameClass.bg.isPlaying())
				GameClass.bg.play();

			if(GameLogoAlphaTimer<255)
				GameLogoAlphaTimer+=5;
			else
				GameLogoAlphaTimer=255;
		
			TLOGOY = Gdx.graphics.getHeight()/4*3;
			ButtonDistance -= (ButtonDistance - 180f/405*Gdx.graphics.getWidth())/10;
		}else{
			ButtonDistance += (Gdx.graphics.getHeight()/2-ButtonDistance)/10;
			TLOGOY = Gdx.graphics.getHeight();
			if(GameLogoAlphaTimer>0)
				GameLogoAlphaTimer-=15;
			if(GameLogoAlphaTimer<0)
				GameLogoAlphaTimer = 0;
		}
		LogoY -= (LogoY-TLOGOY)/15;
	
		if(GameClass.SCREEN == SCREENS.HOME || GameClass.SCREEN == SCREENS.SHOP){
			if(GameClass.BCR>0)GameClass.BCR-=3;
			if(GameClass.BCG>0)GameClass.BCG-=3;

			if(GameClass.BCG<GameClass.BCB-100&&GameClass.BCR<GameClass.BCB-100)
				if(GameClass.BCB>100){
					GameClass.BCB-=3;
				}

			if(GameClass.BCB<100)
				GameClass.BCB+=3;
		}

		if(GameClass.SCREEN == SCREENS.SETTINGS){
			if(GameClass.BCR>0)GameClass.BCR-=3;

			if(GameClass.BCR<GameClass.BCG-100&&GameClass.BCR<GameClass.BCB-100){
				if(GameClass.BCG>100)
					GameClass.BCG-=3;

				if(GameClass.BCB>100)
					GameClass.BCB-=3;
			}

			if(GameClass.BCG<100)
				GameClass.BCG+=3;
			if(GameClass.BCB<100)
				GameClass.BCB+=3;
		}

		if(GameClass.SCREEN == SCREENS.PURCHASE){
			if(GameClass.BCR>0)GameClass.BCR-=5;
			if(GameClass.BCB>0)GameClass.BCB-=5;

			if(GameClass.BCB<GameClass.BCG-100&&GameClass.BCR<GameClass.BCG-100)
				if(GameClass.BCG>100){
					GameClass.BCG-=5;
				}

			if(GameClass.BCG<100)
				GameClass.BCG+=5;
		}

		if(GameClass.SCREEN == SCREENS.GIFT){
			if(GameClass.BCG>0)GameClass.BCG-=5;

			if(GameClass.BCG<GameClass.BCR-100&&GameClass.BCG<GameClass.BCB-100){
				if(GameClass.BCR>100)
					GameClass.BCR-=5;

				if(GameClass.BCB>100)
					GameClass.BCB-=5;
			}

			if(GameClass.BCR<100)
				GameClass.BCR+=5;
			if(GameClass.BCB<100)
				GameClass.BCB+=5;
		}

		if(Gdx.input.isTouched() && GameClass.SCREEN == SCREENS.HOME){
			if(125f/405*Gdx.graphics.getWidth()>Math.sqrt(
					(Gdx.input.getX()-(Gdx.graphics.getWidth()/2))*(Gdx.input.getX()-(Gdx.graphics.getWidth()/2))+
							(Gdx.input.getY()-(Gdx.graphics.getHeight()/2))*(Gdx.input.getY()-(Gdx.graphics.getHeight()/2)))
					&&TouchActive&&Gdx.input.justTouched())GameClass.SCREEN = SCREENS.GAME;

			if(40f/405*Gdx.graphics.getWidth()>Math.sqrt(
					(Gdx.input.getX()-(Gdx.graphics.getWidth()/2))*(Gdx.input.getX()-(Gdx.graphics.getWidth()/2))+
							((Gdx.graphics.getHeight()-Gdx.input.getY())-(Gdx.graphics.getHeight()/2-ButtonDistance*MathUtils.cosDeg(0)))*((Gdx.graphics.getHeight()-Gdx.input.getY())-(Gdx.graphics.getHeight()/2-ButtonDistance*MathUtils.cosDeg(0))))
					&&TouchActive&&Gdx.input.justTouched()){GameClass.SCREEN = SCREENS.SHOP; GameClass.SHOP.HOR = 0;}

			if(40f/405*Gdx.graphics.getWidth()>Math.sqrt(
					(Gdx.input.getX()-(Gdx.graphics.getWidth()/2-ButtonDistance*MathUtils.sinDeg(30)))*(Gdx.input.getX()-(Gdx.graphics.getWidth()/2-ButtonDistance*MathUtils.sinDeg(30)))+
							((Gdx.graphics.getHeight()-Gdx.input.getY())-(Gdx.graphics.getHeight()/2-ButtonDistance*MathUtils.cosDeg(30)))*((Gdx.graphics.getHeight()-Gdx.input.getY())-(Gdx.graphics.getHeight()/2-ButtonDistance*MathUtils.cosDeg(30))))
					&&TouchActive&&Gdx.input.justTouched())GameClass.SCREEN = SCREENS.SETTINGS;

			if(40f/405*Gdx.graphics.getWidth()>Math.sqrt(
					(Gdx.input.getX()-(Gdx.graphics.getWidth()/2+ButtonDistance*MathUtils.sinDeg(30)))*(Gdx.input.getX()-(Gdx.graphics.getWidth()/2+ButtonDistance*MathUtils.sinDeg(30)))+
							((Gdx.graphics.getHeight()-Gdx.input.getY())-(Gdx.graphics.getHeight()/2-ButtonDistance*MathUtils.cosDeg(30)))*((Gdx.graphics.getHeight()-Gdx.input.getY())-(Gdx.graphics.getHeight()/2-ButtonDistance*MathUtils.cosDeg(30))))
					&&TouchActive&&Gdx.input.justTouched()){GameClass.SCREEN = SCREENS.GIFT;GameClass.GIS.Flash256 = 0;}

			if(40f/405*Gdx.graphics.getWidth()>Math.sqrt(
					(Gdx.input.getX()-(Gdx.graphics.getWidth()/2+ButtonDistance*MathUtils.sinDeg(60)))*(Gdx.input.getX()-(Gdx.graphics.getWidth()/2+ButtonDistance*MathUtils.sinDeg(60)))+
							((Gdx.graphics.getHeight()-Gdx.input.getY())-(Gdx.graphics.getHeight()/2-ButtonDistance*MathUtils.cosDeg(60)))*((Gdx.graphics.getHeight()-Gdx.input.getY())-(Gdx.graphics.getHeight()/2-ButtonDistance*MathUtils.cosDeg(60))))
					&&TouchActive&&Gdx.input.justTouched())Gdx.net.openURI("https://play.google.com/store/apps/details?id=com.arinso.endurn");

			if(40f/405*Gdx.graphics.getWidth()>Math.sqrt(
					(Gdx.input.getX()-(Gdx.graphics.getWidth()/2-ButtonDistance*MathUtils.sinDeg(60)))*(Gdx.input.getX()-(Gdx.graphics.getWidth()/2-ButtonDistance*MathUtils.sinDeg(60)))+
							((Gdx.graphics.getHeight()-Gdx.input.getY())-(Gdx.graphics.getHeight()/2-ButtonDistance*MathUtils.cosDeg(60)))*((Gdx.graphics.getHeight()-Gdx.input.getY())-(Gdx.graphics.getHeight()/2-ButtonDistance*MathUtils.cosDeg(60))))
					&&TouchActive&&Gdx.input.justTouched())GameClass.SCREEN = SCREENS.PURCHASE;


		}

		if(timer==30){
			TouchActive = true;
		}

		if(timer<120){
			timer++;
		}else{
			rda = MathUtils.random(0, 3);
			timer = 0;
		}

		switch(rda){
		case 0: direction++;  break;	
		case 1: direction--;  break;
		case 2: direction-=2; break;
		case 3: direction+=2; break;	
		}
		
		if(direction>360)
			direction = 0;
			
		speedparameter = ((float) MathUtils.random(100,200))/100;
		
		if(GameClass.SCREEN == SCREENS.HOME)
		while(HCS.size()<20){
			HCS.add(new HomeCircles());
		}

		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		GameClass.SR.begin(ShapeRenderer.ShapeType.Filled);
		for(int i = 0;i<HCS.size();i++)
			HCS.get(i).update();
		GameClass.SR.end();
		Gdx.gl.glDisable(GL20.GL_BLEND);

		coin.update();
		render(GameClass.SR, GameClass.SB);

	}
	
	public void render(ShapeRenderer SR,SpriteBatch SB){
		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		SR.begin(ShapeRenderer.ShapeType.Filled);

		SR.setColor(0, 162f / 256, 232f / 256, GameLogoAlphaTimer / 256);
		SR.circle(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2 - ButtonDistance * MathUtils.cosDeg(0), 40f / 405 * Gdx.graphics.getWidth());
		SR.setColor(0, 0.5f, 1, GameLogoAlphaTimer / 256);
		SR.circle(Gdx.graphics.getWidth() / 2 - ButtonDistance * MathUtils.sinDeg(30), Gdx.graphics.getHeight() / 2 - ButtonDistance * MathUtils.cosDeg(30), 40f / 405 * Gdx.graphics.getWidth());
		SR.setColor(163 / 256f, 73 / 256f, 164 / 256f, GameLogoAlphaTimer / 256);
		SR.circle(Gdx.graphics.getWidth() / 2 + ButtonDistance * MathUtils.sinDeg(30), Gdx.graphics.getHeight() / 2 - ButtonDistance * MathUtils.cosDeg(30), 40f / 405 * Gdx.graphics.getWidth());
		SR.setColor(0, 65 / 256f, 185 / 256f, GameLogoAlphaTimer / 256);
		SR.circle(Gdx.graphics.getWidth() / 2 - ButtonDistance * MathUtils.sinDeg(60), Gdx.graphics.getHeight() / 2 - ButtonDistance * MathUtils.cosDeg(60), 40f / 405 * Gdx.graphics.getWidth());
		SR.setColor(1, 51 / 256f, 153f / 256, GameLogoAlphaTimer / 256);
		SR.circle(Gdx.graphics.getWidth() / 2 + ButtonDistance * MathUtils.sinDeg(60), Gdx.graphics.getHeight() / 2 - ButtonDistance * MathUtils.cosDeg(60), 40f / 405 * Gdx.graphics.getWidth());

		if(GameClass.SCREEN == SCREENS.HOME)
		SR.setColor(PBR, PBG, PBB, -0.2f+PlayButtonAlphaTimer/256);
			else
		SR.setColor(PBR, PBG, PBB, PlayButtonAlphaTimer / 256);

			if(GameClass.SCREEN == SCREENS.HOME){
				ShopAnimY += (Gdx.graphics.getHeight()/2f-ShopAnimY)/7;
				ShopAnimRadius -= (ShopAnimRadius-(125f/405*Gdx.graphics.getWidth()))/7;
				SR.circle(Gdx.graphics.getWidth()/2, ShopAnimY, ShopAnimRadius);
			}else  if(GameClass.SCREEN == SCREENS.SHOP){
				ShopAnimY -= ShopAnimY/15;
				ShopAnimRadius += (Gdx.graphics.getHeight()/20f*17-ShopAnimRadius)/15;
				SR.circle(Gdx.graphics.getWidth()/2, ShopAnimY, ShopAnimRadius);
			}
			
			
		if(GameClass.SCREEN == SCREENS.HOME){	

			SR.setColor(1,1,1,-0.2f+GameLogoAlphaTimer/256);
			SR.triangle(Gdx.graphics.getWidth()/2-30f/405*Gdx.graphics.getWidth(),
						Gdx.graphics.getHeight()/2+60f/405*Gdx.graphics.getWidth(),
						Gdx.graphics.getWidth()/2+60f/405*Gdx.graphics.getWidth(),
						Gdx.graphics.getHeight()/2,
						Gdx.graphics.getWidth()/2-30f/405*Gdx.graphics.getWidth(),
						Gdx.graphics.getHeight()/2-60f/405*Gdx.graphics.getWidth());				
		}




		SR.end();
		
		SB.setColor(1, 1, 1, GameLogoAlphaTimer / 256);
		GameClass.TextFontSmall.setColor(1, 1, 1, GameLogoAlphaTimer / 256);
		SB.begin();			
		GameClass.TextFontSmall.draw(SB, GameClass.prefs.getInteger("Coin") + "", Gdx.graphics.getWidth() / 40f * 39 - (GameClass.prefs.getInteger("Coin") + "").length() * (((18f / 405) * Gdx.graphics.getWidth())), Gdx.graphics.getHeight() / 10f * 9 + GameClass.TextFontSmall.getLineHeight());
		SB.draw(GameClass.GameLogo,LogoX,LogoY,Gdx.graphics.getWidth()/4*3f, (Gdx.graphics.getWidth()/4*3f)/GameClass.GameLogo.getWidth()*GameClass.GameLogo.getHeight());
		
		SB.draw(GameClass.ShopLogo,Gdx.graphics.getWidth()/2-30f/405*Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/2-ButtonDistance*MathUtils.cosDeg(0)-30f/405*Gdx.graphics.getWidth(),60f/405*Gdx.graphics.getWidth(),60f/405*Gdx.graphics.getWidth());
		SB.draw(GameClass.SettingsLogo,Gdx.graphics.getWidth()/2-ButtonDistance*MathUtils.sinDeg(30)-30f/405*Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/2-ButtonDistance*MathUtils.cosDeg(30)-30f/405*Gdx.graphics.getWidth(),60f/405*Gdx.graphics.getWidth(),60f/405*Gdx.graphics.getWidth());
		SB.draw(GameClass.GiftLogo,Gdx.graphics.getWidth()/2+ButtonDistance*MathUtils.sinDeg(30)-28f/405*Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/2-ButtonDistance*MathUtils.cosDeg(30)-26f/405*Gdx.graphics.getWidth(),56f/405*Gdx.graphics.getWidth(),56f/405*Gdx.graphics.getWidth());
		SB.draw(GameClass.Diamond,Gdx.graphics.getWidth()/2-ButtonDistance*MathUtils.sinDeg(60)-30f/405*Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/2-ButtonDistance*MathUtils.cosDeg(60)-33f/405*Gdx.graphics.getWidth(),60f/405*Gdx.graphics.getWidth(),60f/405*Gdx.graphics.getWidth());
		SB.draw(GameClass.RateStar,Gdx.graphics.getWidth()/2+ButtonDistance*MathUtils.sinDeg(60)-30f/405*Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/2-ButtonDistance*MathUtils.cosDeg(60)-28f/405*Gdx.graphics.getWidth(),60f/405*Gdx.graphics.getWidth(),60f/405*Gdx.graphics.getWidth());
		SB.end();

		Gdx.gl.glDisable(GL20.GL_BLEND);
		}
}

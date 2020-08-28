package com.arinso.endurn;

import com.arinso.endurn.Objects.GameCircle;
import com.arinso.endurn.Objects.coin;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Shop {
	coin coinicon;
	float HOR = 0;
	float touchPX;
	int RT = 2;
	int X;

	float SelectedX,SelectedY = 0;
	float SelectedAlpha256 = 0;
	Boolean BallSelected = true;

	Boolean TouchActive;

	public Shop(){
		coinicon = new coin(2);
		TouchActive = false;
		updateSelectedBallArea(GameClass.prefs.getInteger("Ball-Number"));
	}

	void updateSelectedBallArea(int BallNumber){
		switch (BallNumber){
			case 0:  SelectedX = Gdx.graphics.getWidth() / 22f * 4 ; SelectedY = Gdx.graphics.getWidth() / 22f * 25*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f));break;
			case 1:  SelectedX = Gdx.graphics.getWidth() / 22f * 11; SelectedY = Gdx.graphics.getWidth() / 22f * 25*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f));break;
			case 2:  SelectedX = Gdx.graphics.getWidth() / 22f * 18; SelectedY = Gdx.graphics.getWidth() / 22f * 25*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f));break;
			case 3:  SelectedX = Gdx.graphics.getWidth() / 22f * 4 ; SelectedY = Gdx.graphics.getWidth() / 22f * 18 *((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f));break;
			case 4:  SelectedX = Gdx.graphics.getWidth() / 22f * 11; SelectedY = Gdx.graphics.getWidth() / 22f * 18*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f));break;
			case 5:  SelectedX = Gdx.graphics.getWidth() / 22f * 18; SelectedY = Gdx.graphics.getWidth() / 22f * 18*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f));break;
			case 6:  SelectedX = Gdx.graphics.getWidth() / 22f * 4 ; SelectedY = Gdx.graphics.getWidth() / 22f * 11*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f));break;
			case 7:  SelectedX = Gdx.graphics.getWidth() / 22f * 11; SelectedY = Gdx.graphics.getWidth() / 22f * 11*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f));break;
			case 8:  SelectedX = Gdx.graphics.getWidth() / 22f * 18; SelectedY = Gdx.graphics.getWidth() / 22f * 11*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f));break;
			case 9:  SelectedX = Gdx.graphics.getWidth() / 22f * 4 ; SelectedY = Gdx.graphics.getWidth() / 22f * 4 *((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f));break;
			case 10: SelectedX = Gdx.graphics.getWidth() / 22f * 11; SelectedY = Gdx.graphics.getWidth() / 22f * 4 *((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f));break;
			case 11: SelectedX = Gdx.graphics.getWidth() / 22f * 18; SelectedY = Gdx.graphics.getWidth() / 22f * 4 *((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f));break;
			case 12: SelectedX = Gdx.graphics.getWidth() / 22f * 26; SelectedY = Gdx.graphics.getWidth() / 22f * 25*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f));break;
			case 13: SelectedX = Gdx.graphics.getWidth() / 22f * 33; SelectedY = Gdx.graphics.getWidth() / 22f * 25*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f));break;
			case 14: SelectedX = Gdx.graphics.getWidth() / 22f * 40; SelectedY = Gdx.graphics.getWidth() / 22f * 25*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f));break;
			case 15: SelectedX = Gdx.graphics.getWidth() / 22f * 26; SelectedY = Gdx.graphics.getWidth() / 22f * 18*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f));break;
			case 16: SelectedX = Gdx.graphics.getWidth() / 22f * 33; SelectedY = Gdx.graphics.getWidth() / 22f * 18*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f));break;
			case 17: SelectedX = Gdx.graphics.getWidth() / 22f * 40; SelectedY = Gdx.graphics.getWidth() / 22f * 18*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f));break;
			case 18: SelectedX = Gdx.graphics.getWidth() / 22f * 26; SelectedY = Gdx.graphics.getWidth() / 22f * 11*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f));break;
			case 19: SelectedX = Gdx.graphics.getWidth() / 22f * 33; SelectedY = Gdx.graphics.getWidth() / 22f * 11*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f));break;
			case 20: SelectedX = Gdx.graphics.getWidth() / 22f * 40; SelectedY = Gdx.graphics.getWidth() / 22f * 11*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f));break;
			case 21: SelectedX = Gdx.graphics.getWidth() / 22f * 26; SelectedY = Gdx.graphics.getWidth() / 22f * 4 *((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f));break;
			case 22: SelectedX = Gdx.graphics.getWidth() / 22f * 33; SelectedY = Gdx.graphics.getWidth() / 22f * 4 *((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f));break;
			case 23: SelectedX = Gdx.graphics.getWidth() / 22f * 40; SelectedY = Gdx.graphics.getWidth() / 22f * 4 *((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f));break;
			case 24: SelectedX = Gdx.graphics.getWidth() / 22f * 48; SelectedY = Gdx.graphics.getWidth() / 22f * 25*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f));break;
			case 25: SelectedX = Gdx.graphics.getWidth() / 22f * 55; SelectedY = Gdx.graphics.getWidth() / 22f * 25*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f));break;
			case 26: SelectedX = Gdx.graphics.getWidth() / 22f * 62; SelectedY = Gdx.graphics.getWidth() / 22f * 25*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f));break;
			case 27: SelectedX = Gdx.graphics.getWidth() / 22f * 48; SelectedY = Gdx.graphics.getWidth() / 22f * 18*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f));break;
			case 28: SelectedX = Gdx.graphics.getWidth() / 22f * 55; SelectedY = Gdx.graphics.getWidth() / 22f * 18*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f));break;
			case 29: SelectedX = Gdx.graphics.getWidth() / 22f * 62; SelectedY = Gdx.graphics.getWidth() / 22f * 18*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f));break;
			case 30: SelectedX = Gdx.graphics.getWidth() / 22f * 48; SelectedY = Gdx.graphics.getWidth() / 22f * 11*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f));break;
			case 31: SelectedX = Gdx.graphics.getWidth() / 22f * 55; SelectedY = Gdx.graphics.getWidth() / 22f * 11*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f));break;
			case 32: SelectedX = Gdx.graphics.getWidth() / 22f * 62; SelectedY = Gdx.graphics.getWidth() / 22f * 11*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f));break;
			case 33: SelectedX = Gdx.graphics.getWidth() / 22f * 48; SelectedY = Gdx.graphics.getWidth() / 22f * 4 *((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f));break;
			case 34: SelectedX = Gdx.graphics.getWidth() / 22f * 55; SelectedY = Gdx.graphics.getWidth() / 22f * 4 *((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f));break;
			case 35: SelectedX = Gdx.graphics.getWidth() / 22f * 62; SelectedY = Gdx.graphics.getWidth() / 22f * 4 *((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f));break;
		}
	}
	public void update(){

		////////////////////////
		if(Gdx.input.isKeyPressed(Input.Keys.BACK)||Gdx.input.isKeyJustPressed(Input.Keys.BACKSPACE)){
			coinicon.startopacity = 0;
			GameClass.HS.GameLogoAlphaTimer = 0;
			GameClass.SCREEN = SCREENS.HOME;
			GameClass.HS.timer = 0;
			GameClass.HS.TouchActive = false;
			TouchActive = false;
		}

		if(Gdx.input.justTouched())
			if (Gdx.input.getX() > 0 && Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getHeight() / 20f * 17 && Gdx.input.getX() < Gdx.graphics.getWidth() && Gdx.graphics.getHeight() - Gdx.input.getY() < Gdx.graphics.getHeight()) {
				coinicon.startopacity = 0;
				GameClass.HS.GameLogoAlphaTimer = 0;
				GameClass.SCREEN = SCREENS.HOME;
				GameClass.HS.timer = 0;
				GameClass.HS.TouchActive = false;
				TouchActive = false;
			}
		////////////////////////

		if(BallSelected){
			if(SelectedAlpha256<153)
				SelectedAlpha256+=25.5f;
		} else {
			if(SelectedAlpha256>0)
				SelectedAlpha256-=25.5f;
		}

		if(!BallSelected && SelectedAlpha256 == 0){
			updateSelectedBallArea(GameClass.prefs.getInteger("Ball-Number"));
			BallSelected = true;
		}


		if(Gdx.input.isTouched()){
			X = Gdx.input.getX();
			if(Gdx.input.justTouched()){
				touchPX = X;
			}
			HOR -= Gdx.input.getDeltaX()*1.5f;
			RT = 0;
		}else{
			RT++;
			//SCREEN STABILIZER
			if(HOR < Gdx.graphics.getWidth()/2)HOR-=HOR/10;
			if(HOR > Gdx.graphics.getWidth()/2f && HOR < Gdx.graphics.getWidth()/2f*3)HOR+=(Gdx.graphics.getWidth()-HOR)/10f;
			if(HOR > Gdx.graphics.getWidth()/2f*3)HOR+=(Gdx.graphics.getWidth()*2f-HOR)/10f;
		}

		if(RT == 1) {
			if (touchPX - X < 15 && touchPX - X > -15 && TouchActive){
				//1. COLUMN
				if (X > -HOR + Gdx.graphics.getWidth() / 22 && X < -HOR + Gdx.graphics.getWidth() / 22 * 7) {
					if (Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getWidth()*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) && Gdx.graphics.getHeight() - Gdx.input.getY() < Gdx.graphics.getWidth() / 22 * 28*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))) {
						GameClass.prefs.putInteger("Ball-Number", 0);
					}

					if (Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getWidth() / 22 * 15*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) && Gdx.graphics.getHeight() - Gdx.input.getY() < Gdx.graphics.getWidth() / 22 * 21*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))) {
						if ((!GameClass.prefs.getBoolean("BUnlock3")) && GameClass.prefs.getInteger("Coin") >= 25) {
							GameClass.prefs.putInteger("Coin", GameClass.prefs.getInteger("Coin") - 25);
							GameClass.prefs.putBoolean("BUnlock3", true);
						}

						if (GameClass.prefs.getBoolean("BUnlock3"))
							GameClass.prefs.putInteger("Ball-Number", 3);
					}

					if (Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getWidth() / 22 * 8*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) && Gdx.graphics.getHeight() - Gdx.input.getY() < Gdx.graphics.getWidth() / 22 * 14*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))) {
						if ((!GameClass.prefs.getBoolean("BUnlock6")) && GameClass.prefs.getInteger("Coin") >= 25) {
							GameClass.prefs.putInteger("Coin", GameClass.prefs.getInteger("Coin") - 25);
							GameClass.prefs.putBoolean("BUnlock6", true);
						}

						if (GameClass.prefs.getBoolean("BUnlock6"))
							GameClass.prefs.putInteger("Ball-Number", 6);
					}

					if (Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getWidth() / 22*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) && Gdx.graphics.getHeight() - Gdx.input.getY() < Gdx.graphics.getWidth() / 22 * 7*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))) {
						if ((!GameClass.prefs.getBoolean("BUnlock9")) && GameClass.prefs.getInteger("Coin") >= 25) {
							GameClass.prefs.putInteger("Coin", GameClass.prefs.getInteger("Coin") - 25);
							GameClass.prefs.putBoolean("BUnlock9", true);
						}

						if (GameClass.prefs.getBoolean("BUnlock9"))
							GameClass.prefs.putInteger("Ball-Number", 9);
					}

				}

				//2. COLUMN
				if (X > -HOR + Gdx.graphics.getWidth() / 22 * 8 && X < -HOR + Gdx.graphics.getWidth() / 22 * 14) {
					if (Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getWidth()*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) && Gdx.graphics.getHeight() - Gdx.input.getY() < Gdx.graphics.getWidth() / 22 * 28*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))) {
						if ((!GameClass.prefs.getBoolean("BUnlock1")) && GameClass.prefs.getInteger("Coin") >= 25) {
							GameClass.prefs.putInteger("Coin", GameClass.prefs.getInteger("Coin") - 25);
							GameClass.prefs.putBoolean("BUnlock1", true);
						}

						if (GameClass.prefs.getBoolean("BUnlock1"))
							GameClass.prefs.putInteger("Ball-Number", 1);
					}
					if (Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getWidth() / 22 * 15*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) && Gdx.graphics.getHeight() - Gdx.input.getY() < Gdx.graphics.getWidth() / 22 * 21*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))) {
						if ((!GameClass.prefs.getBoolean("BUnlock4")) && GameClass.prefs.getInteger("Coin") >= 25) {
							GameClass.prefs.putInteger("Coin", GameClass.prefs.getInteger("Coin") - 25);
							GameClass.prefs.putBoolean("BUnlock4", true);
						}

						if (GameClass.prefs.getBoolean("BUnlock4"))
							GameClass.prefs.putInteger("Ball-Number", 4);
					}

					if (Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getWidth() / 22 * 8*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) && Gdx.graphics.getHeight() - Gdx.input.getY() < Gdx.graphics.getWidth() / 22 * 14*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))) {
						if ((!GameClass.prefs.getBoolean("BUnlock7")) && GameClass.prefs.getInteger("Coin") >= 25) {
							GameClass.prefs.putInteger("Coin", GameClass.prefs.getInteger("Coin") - 25);
							GameClass.prefs.putBoolean("BUnlock7", true);
						}

						if (GameClass.prefs.getBoolean("BUnlock7"))
							GameClass.prefs.putInteger("Ball-Number", 7);
					}

					if (Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getWidth() / 22*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) && Gdx.graphics.getHeight() - Gdx.input.getY() < Gdx.graphics.getWidth() / 22 * 7*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))) {
						if ((!GameClass.prefs.getBoolean("BUnlock10")) && GameClass.prefs.getInteger("Coin") >= 25) {
							GameClass.prefs.putInteger("Coin", GameClass.prefs.getInteger("Coin") - 25);
							GameClass.prefs.putBoolean("BUnlock10", true);
						}

						if (GameClass.prefs.getBoolean("BUnlock10"))
							GameClass.prefs.putInteger("Ball-Number", 10);
					}

				}

				//3. COLUMN
				if (X > -HOR + Gdx.graphics.getWidth() / 22 * 15 && X < -HOR + Gdx.graphics.getWidth() / 22 * 21) {
					if (Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getWidth()*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) && Gdx.graphics.getHeight() - Gdx.input.getY() < Gdx.graphics.getWidth() / 22 * 28*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))) {
						if ((!GameClass.prefs.getBoolean("BUnlock2")) && GameClass.prefs.getInteger("Coin") >= 25) {
							GameClass.prefs.putInteger("Coin", GameClass.prefs.getInteger("Coin") - 25);
							GameClass.prefs.putBoolean("BUnlock2", true);
						}

						if (GameClass.prefs.getBoolean("BUnlock2"))
							GameClass.prefs.putInteger("Ball-Number", 2);
					}

					if (Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getWidth() / 22 * 15*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) && Gdx.graphics.getHeight() - Gdx.input.getY() < Gdx.graphics.getWidth() / 22 * 21*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))) {
						if ((!GameClass.prefs.getBoolean("BUnlock5")) && GameClass.prefs.getInteger("Coin") >= 25) {
							GameClass.prefs.putInteger("Coin", GameClass.prefs.getInteger("Coin") - 25);
							GameClass.prefs.putBoolean("BUnlock5", true);
						}

						if (GameClass.prefs.getBoolean("BUnlock5"))
							GameClass.prefs.putInteger("Ball-Number", 5);
					}

					if (Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getWidth() / 22 * 8*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) && Gdx.graphics.getHeight() - Gdx.input.getY() < Gdx.graphics.getWidth() / 22 * 14*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))) {
						if ((!GameClass.prefs.getBoolean("BUnlock8")) && GameClass.prefs.getInteger("Coin") >= 25) {
							GameClass.prefs.putInteger("Coin", GameClass.prefs.getInteger("Coin") - 25);
							GameClass.prefs.putBoolean("BUnlock8", true);
						}

						if (GameClass.prefs.getBoolean("BUnlock8"))
							GameClass.prefs.putInteger("Ball-Number", 8);
					}

					if (Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getWidth() / 22*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) && Gdx.graphics.getHeight() - Gdx.input.getY() < Gdx.graphics.getWidth() / 22 * 7*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))) {
						if ((!GameClass.prefs.getBoolean("BUnlock11")) && GameClass.prefs.getInteger("Coin") >= 25) {
							GameClass.prefs.putInteger("Coin", GameClass.prefs.getInteger("Coin") - 25);
							GameClass.prefs.putBoolean("BUnlock11", true);
						}

						if (GameClass.prefs.getBoolean("BUnlock11"))
							GameClass.prefs.putInteger("Ball-Number", 11);
					}
				}

				//4. COLUMN
				if (X > -HOR + Gdx.graphics.getWidth() / 22 * 23 && X < -HOR + Gdx.graphics.getWidth() / 22 * 29) {
					if (Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getWidth()*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) && Gdx.graphics.getHeight() - Gdx.input.getY() < Gdx.graphics.getWidth() / 22 * 28*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))) {
						if ((!GameClass.prefs.getBoolean("BUnlock12")) && GameClass.prefs.getInteger("Coin") >= 50) {
							GameClass.prefs.putInteger("Coin", GameClass.prefs.getInteger("Coin") - 50);
							GameClass.prefs.putBoolean("BUnlock12", true);
						}

						if (GameClass.prefs.getBoolean("BUnlock12"))
							GameClass.prefs.putInteger("Ball-Number", 12);
					}

					if (Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getWidth() / 22 * 15*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) && Gdx.graphics.getHeight() - Gdx.input.getY() < Gdx.graphics.getWidth() / 22 * 21*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))) {
						if ((!GameClass.prefs.getBoolean("BUnlock15")) && GameClass.prefs.getInteger("Coin") >= 50) {
							GameClass.prefs.putInteger("Coin", GameClass.prefs.getInteger("Coin") - 50);
							GameClass.prefs.putBoolean("BUnlock15", true);
						}

						if (GameClass.prefs.getBoolean("BUnlock15"))
							GameClass.prefs.putInteger("Ball-Number", 15);
					}

					if (Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getWidth() / 22 * 8*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) && Gdx.graphics.getHeight() - Gdx.input.getY() < Gdx.graphics.getWidth() / 22 * 14*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))) {
						if ((!GameClass.prefs.getBoolean("BUnlock18")) && GameClass.prefs.getInteger("Coin") >= 25) {
							GameClass.prefs.putInteger("Coin", GameClass.prefs.getInteger("Coin") - 25);
							GameClass.prefs.putBoolean("BUnlock18", true);
						}

						if (GameClass.prefs.getBoolean("BUnlock18"))
							GameClass.prefs.putInteger("Ball-Number", 18);
					}

					if (Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getWidth() / 22*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) && Gdx.graphics.getHeight() - Gdx.input.getY() < Gdx.graphics.getWidth() / 22 * 7*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))) {
						if ((!GameClass.prefs.getBoolean("BUnlock21")) && GameClass.prefs.getInteger("Coin") >= 25) {
							GameClass.prefs.putInteger("Coin", GameClass.prefs.getInteger("Coin") - 25);
							GameClass.prefs.putBoolean("BUnlock21", true);
						}

						if (GameClass.prefs.getBoolean("BUnlock21"))
							GameClass.prefs.putInteger("Ball-Number", 21);
					}
				}

				//5. COLUMN
				if (X > -HOR + Gdx.graphics.getWidth() / 22 * 30 && X < -HOR + Gdx.graphics.getWidth() / 22 * 36) {
					if (Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getWidth()*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) && Gdx.graphics.getHeight() - Gdx.input.getY() < Gdx.graphics.getWidth() / 22 * 28*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))) {
						if ((!GameClass.prefs.getBoolean("BUnlock13")) && GameClass.prefs.getInteger("Coin") >= 50) {
							GameClass.prefs.putInteger("Coin", GameClass.prefs.getInteger("Coin") - 50);
							GameClass.prefs.putBoolean("BUnlock13", true);
						}

						if (GameClass.prefs.getBoolean("BUnlock13"))
							GameClass.prefs.putInteger("Ball-Number", 13);
					}

					if (Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getWidth() / 22 * 15*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) && Gdx.graphics.getHeight() - Gdx.input.getY() < Gdx.graphics.getWidth() / 22 * 21*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))) {
						if ((!GameClass.prefs.getBoolean("BUnlock16")) && GameClass.prefs.getInteger("Coin") >= 50) {
							GameClass.prefs.putInteger("Coin", GameClass.prefs.getInteger("Coin") - 50);
							GameClass.prefs.putBoolean("BUnlock16", true);
						}

						if (GameClass.prefs.getBoolean("BUnlock16"))
							GameClass.prefs.putInteger("Ball-Number", 16);
					}

					if (Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getWidth() / 22 * 8*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) && Gdx.graphics.getHeight() - Gdx.input.getY() < Gdx.graphics.getWidth() / 22 * 14*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))) {
						if ((!GameClass.prefs.getBoolean("BUnlock19")) && GameClass.prefs.getInteger("Coin") >= 25) {
							GameClass.prefs.putInteger("Coin", GameClass.prefs.getInteger("Coin") - 25);
							GameClass.prefs.putBoolean("BUnlock19", true);
						}

						if (GameClass.prefs.getBoolean("BUnlock19"))
							GameClass.prefs.putInteger("Ball-Number", 19);
					}

					if (Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getWidth() / 22*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) && Gdx.graphics.getHeight() - Gdx.input.getY() < Gdx.graphics.getWidth() / 22 * 7*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))) {
						if ((!GameClass.prefs.getBoolean("BUnlock22")) && GameClass.prefs.getInteger("Coin") >= 25) {
							GameClass.prefs.putInteger("Coin", GameClass.prefs.getInteger("Coin") - 25);
							GameClass.prefs.putBoolean("BUnlock22", true);
						}

						if (GameClass.prefs.getBoolean("BUnlock22"))
							GameClass.prefs.putInteger("Ball-Number", 22);
					}
				}

				//6. COLUMN
				if (X > -HOR + Gdx.graphics.getWidth() / 22 * 37 && X < -HOR + Gdx.graphics.getWidth() / 22 * 43) {
					if (Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getWidth()*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) && Gdx.graphics.getHeight() - Gdx.input.getY() < Gdx.graphics.getWidth() / 22 * 28*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))) {
						if ((!GameClass.prefs.getBoolean("BUnlock14")) && GameClass.prefs.getInteger("Coin") >= 50) {
							GameClass.prefs.putInteger("Coin", GameClass.prefs.getInteger("Coin") - 50);
							GameClass.prefs.putBoolean("BUnlock14", true);
						}

						if (GameClass.prefs.getBoolean("BUnlock14"))
							GameClass.prefs.putInteger("Ball-Number", 14);
					}

					if (Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getWidth() / 22 * 15*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) && Gdx.graphics.getHeight() - Gdx.input.getY() < Gdx.graphics.getWidth() / 22 * 21*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))) {
						if ((!GameClass.prefs.getBoolean("BUnlock17")) && GameClass.prefs.getInteger("Coin") >= 50) {
							GameClass.prefs.putInteger("Coin", GameClass.prefs.getInteger("Coin") - 50);
							GameClass.prefs.putBoolean("BUnlock17", true);
						}

						if (GameClass.prefs.getBoolean("BUnlock17"))
							GameClass.prefs.putInteger("Ball-Number", 17);
					}
					if (Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getWidth() / 22 * 8*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) && Gdx.graphics.getHeight() - Gdx.input.getY() < Gdx.graphics.getWidth() / 22 * 14*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))) {
						if ((!GameClass.prefs.getBoolean("BUnlock20")) && GameClass.prefs.getInteger("Coin") >= 25) {
							GameClass.prefs.putInteger("Coin", GameClass.prefs.getInteger("Coin") - 25);
							GameClass.prefs.putBoolean("BUnlock20", true);
						}

						if (GameClass.prefs.getBoolean("BUnlock20"))
							GameClass.prefs.putInteger("Ball-Number", 20);
					}

					if (Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getWidth() / 22*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) && Gdx.graphics.getHeight() - Gdx.input.getY() < Gdx.graphics.getWidth() / 22 * 7*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))) {
						if ((!GameClass.prefs.getBoolean("BUnlock23")) && GameClass.prefs.getInteger("Coin") >= 25) {
							GameClass.prefs.putInteger("Coin", GameClass.prefs.getInteger("Coin") - 25);
							GameClass.prefs.putBoolean("BUnlock23", true);
						}

						if (GameClass.prefs.getBoolean("BUnlock23"))
							GameClass.prefs.putInteger("Ball-Number", 23);
					}
				}

				//7. COLUMN
				if (X > -HOR + Gdx.graphics.getWidth() / 22 * 45 && X < -HOR + Gdx.graphics.getWidth() / 22 * 51) {
					if (Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getWidth()*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) && Gdx.graphics.getHeight() - Gdx.input.getY() < Gdx.graphics.getWidth() / 22 * 28*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))) {
						if ((!GameClass.prefs.getBoolean("BUnlock24")) && GameClass.prefs.getInteger("Coin") >= 25) {
							GameClass.prefs.putInteger("Coin", GameClass.prefs.getInteger("Coin") - 25);
							GameClass.prefs.putBoolean("BUnlock24", true);
						}

						if (GameClass.prefs.getBoolean("BUnlock24"))
							GameClass.prefs.putInteger("Ball-Number", 24);
					}

					if (Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getWidth() / 22 * 15*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) && Gdx.graphics.getHeight() - Gdx.input.getY() < Gdx.graphics.getWidth() / 22 * 21*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))) {
						if ((!GameClass.prefs.getBoolean("BUnlock27")) && GameClass.prefs.getInteger("Coin") >= 25) {
							GameClass.prefs.putInteger("Coin", GameClass.prefs.getInteger("Coin") - 25);
							GameClass.prefs.putBoolean("BUnlock27", true);
						}

						if (GameClass.prefs.getBoolean("BUnlock27"))
							GameClass.prefs.putInteger("Ball-Number", 27);
					}

					if (Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getWidth() / 22 * 8*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) && Gdx.graphics.getHeight() - Gdx.input.getY() < Gdx.graphics.getWidth() / 22 * 14*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))) {
						if ((!GameClass.prefs.getBoolean("BUnlock30")) && GameClass.prefs.getInteger("Coin") >= 25) {
							GameClass.prefs.putInteger("Coin", GameClass.prefs.getInteger("Coin") - 25);
							GameClass.prefs.putBoolean("BUnlock30", true);
						}

						if (GameClass.prefs.getBoolean("BUnlock30"))
							GameClass.prefs.putInteger("Ball-Number", 30);
					}

					if (Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getWidth() / 22*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) && Gdx.graphics.getHeight() - Gdx.input.getY() < Gdx.graphics.getWidth() / 22 * 7*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))) {
						if ((!GameClass.prefs.getBoolean("BUnlock33")) && GameClass.prefs.getInteger("Coin") >= 25) {
							GameClass.prefs.putInteger("Coin", GameClass.prefs.getInteger("Coin") - 25);
							GameClass.prefs.putBoolean("BUnlock33", true);
						}

						if (GameClass.prefs.getBoolean("BUnlock33"))
							GameClass.prefs.putInteger("Ball-Number", 33);
					}
				}

				//8. COLUMN
				if (X > -HOR + Gdx.graphics.getWidth() / 22 * 52 && X < -HOR + Gdx.graphics.getWidth() / 22 * 58) {
					if (Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getWidth()*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) && Gdx.graphics.getHeight() - Gdx.input.getY() < Gdx.graphics.getWidth() / 22 * 28*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))) {
						if ((!GameClass.prefs.getBoolean("BUnlock25")) && GameClass.prefs.getInteger("Coin") >= 25) {
							GameClass.prefs.putInteger("Coin", GameClass.prefs.getInteger("Coin") - 25);
							GameClass.prefs.putBoolean("BUnlock25", true);
						}

						if (GameClass.prefs.getBoolean("BUnlock25"))
							GameClass.prefs.putInteger("Ball-Number", 25);
					}

					if (Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getWidth() / 22 * 15*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) && Gdx.graphics.getHeight() - Gdx.input.getY() < Gdx.graphics.getWidth() / 22 * 21*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))) {
						if ((!GameClass.prefs.getBoolean("BUnlock28")) && GameClass.prefs.getInteger("Coin") >= 25) {
							GameClass.prefs.putInteger("Coin", GameClass.prefs.getInteger("Coin") - 25);
							GameClass.prefs.putBoolean("BUnlock28", true);
						}

						if (GameClass.prefs.getBoolean("BUnlock28"))
							GameClass.prefs.putInteger("Ball-Number", 28);
					}

					if (Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getWidth() / 22 * 8*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) && Gdx.graphics.getHeight() - Gdx.input.getY() < Gdx.graphics.getWidth() / 22 * 14*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))) {
						if ((!GameClass.prefs.getBoolean("BUnlock31")) && GameClass.prefs.getInteger("Coin") >= 25) {
							GameClass.prefs.putInteger("Coin", GameClass.prefs.getInteger("Coin") - 25);
							GameClass.prefs.putBoolean("BUnlock31", true);
						}

						if (GameClass.prefs.getBoolean("BUnlock31"))
							GameClass.prefs.putInteger("Ball-Number", 31);
					}

					if (Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getWidth() / 22*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) && Gdx.graphics.getHeight() - Gdx.input.getY() < Gdx.graphics.getWidth() / 22 * 7*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))) {
						if ((!GameClass.prefs.getBoolean("BUnlock34")) && GameClass.prefs.getInteger("Coin") >= 25) {
							GameClass.prefs.putInteger("Coin", GameClass.prefs.getInteger("Coin") - 25);
							GameClass.prefs.putBoolean("BUnlock34", true);
						}

						if (GameClass.prefs.getBoolean("BUnlock34"))
							GameClass.prefs.putInteger("Ball-Number", 34);
					}
				}

				//9. COLUMN
				if (X > -HOR + Gdx.graphics.getWidth() / 22 * 59 && X < -HOR + Gdx.graphics.getWidth() / 22 * 65) {
					if (Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getWidth()*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) && Gdx.graphics.getHeight() - Gdx.input.getY() < Gdx.graphics.getWidth() / 22 * 28*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))) {
						if ((!GameClass.prefs.getBoolean("BUnlock26")) && GameClass.prefs.getInteger("Coin") >= 25) {
							GameClass.prefs.putInteger("Coin", GameClass.prefs.getInteger("Coin") - 25);
							GameClass.prefs.putBoolean("BUnlock26", true);
						}

						if (GameClass.prefs.getBoolean("BUnlock26"))
							GameClass.prefs.putInteger("Ball-Number", 26);
					}

					if (Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getWidth() / 22 * 15*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) && Gdx.graphics.getHeight() - Gdx.input.getY() < Gdx.graphics.getWidth() / 22 * 21*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))) {
						if ((!GameClass.prefs.getBoolean("BUnlock29")) && GameClass.prefs.getInteger("Coin") >= 25) {
							GameClass.prefs.putInteger("Coin", GameClass.prefs.getInteger("Coin") - 25);
							GameClass.prefs.putBoolean("BUnlock29", true);
						}

						if (GameClass.prefs.getBoolean("BUnlock29"))
							GameClass.prefs.putInteger("Ball-Number", 29);
					}
					if (Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getWidth() / 22 * 8*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) && Gdx.graphics.getHeight() - Gdx.input.getY() < Gdx.graphics.getWidth() / 22 * 14*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))) {
						if ((!GameClass.prefs.getBoolean("BUnlock32")) && GameClass.prefs.getInteger("Coin") >= 25) {
							GameClass.prefs.putInteger("Coin", GameClass.prefs.getInteger("Coin") - 25);
							GameClass.prefs.putBoolean("BUnlock32", true);
						}

						if (GameClass.prefs.getBoolean("BUnlock32"))
							GameClass.prefs.putInteger("Ball-Number", 32);
					}

					if (Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getWidth() / 22*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) && Gdx.graphics.getHeight() - Gdx.input.getY() < Gdx.graphics.getWidth() / 22 * 7*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))) {
						if ((!GameClass.prefs.getBoolean("BUnlock35")) && GameClass.prefs.getInteger("Coin") >= 25) {
							GameClass.prefs.putInteger("Coin", GameClass.prefs.getInteger("Coin") - 25);
							GameClass.prefs.putBoolean("BUnlock35", true);
						}

						if (GameClass.prefs.getBoolean("BUnlock35"))
							GameClass.prefs.putInteger("Ball-Number", 35);
					}
				}

				GameClass.prefs.flush();

				GameClass.HS.updatePlayButtonSRColor(GameClass.prefs.getInteger("Ball-Number"));

				GameClass.GS.GC = new GameCircle();
			}
			TouchActive = true;
			BallSelected = false;
		}

		render(GameClass.SR, GameClass.SB);
	}
	
	public void render(ShapeRenderer SR,SpriteBatch SB){
		if(HOR > -0.5f && HOR < 1.5f)
			HOR = 0;
		if(HOR > 404.5f && HOR < 405.5f)
			HOR = 405;
		if(HOR > 809.5f && HOR < 810.5f)
			HOR = 810;

		int HORINT = (int) HOR;
		SB.begin();

		SB.setColor(1, 1, 1, 1 - GameClass.HS.GameLogoAlphaTimer / 256);

		SB.draw(GameClass.home,Gdx.graphics.getWidth()/2-Gdx.graphics.getHeight()/20,Gdx.graphics.getHeight()/40f*37-Gdx.graphics.getHeight()/20,Gdx.graphics.getHeight()/10,Gdx.graphics.getHeight()/10);
		if(HORINT < Gdx.graphics.getWidth()/22f*21) {
			SB.draw(GameClass.layout,-HORINT,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		}

		if (HORINT > Gdx.graphics.getWidth() / 22f && HORINT < Gdx.graphics.getWidth() / 22f * 43) {
			SB.draw(GameClass.layout,Gdx.graphics.getWidth()-HORINT,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		}

		if(HORINT > Gdx.graphics.getWidth()/22f*23) {
			SB.draw(GameClass.layout,Gdx.graphics.getWidth()*2-HORINT,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		}

		SB.setColor(GameClass.HS.PBR, GameClass.HS.PBG, GameClass.HS.PBB, SelectedAlpha256/256f);
		SB.draw(GameClass.SelectedBall,-HORINT + SelectedX - 30f / 405 * Gdx.graphics.getWidth(),SelectedY - 30f / 405 * Gdx.graphics.getWidth(),60f / 405 * Gdx.graphics.getWidth(),60f / 405 * Gdx.graphics.getWidth());

		SB.setColor(1, 1, 1, 1 - GameClass.HS.GameLogoAlphaTimer / 256);
		GameClass.TextFontSmall.setColor(Color.WHITE);
		GameClass.TextFontSmall.draw(SB, GameClass.prefs.getInteger("Coin") + "", Gdx.graphics.getWidth() / 2 + Gdx.graphics.getWidth() / 50, Gdx.graphics.getHeight() / 4f * 3 + GameClass.TextFontSmall.getLineHeight());

		if(HORINT < Gdx.graphics.getWidth()/22f*21) {
			SB.draw(GameClass.RedHexa, -HORINT + Gdx.graphics.getWidth() / 22f * 4 - 20f / 405 * Gdx.graphics.getWidth(), Gdx.graphics.getWidth() / 22f * 11*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) - 20f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth());
			SB.draw(GameClass.YelHexa, -HORINT + Gdx.graphics.getWidth() / 22f * 11 - 20f / 405 * Gdx.graphics.getWidth(), Gdx.graphics.getWidth() / 22f * 11*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) - 20f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth());
			SB.draw(GameClass.CyanHexa, -HORINT + Gdx.graphics.getWidth() / 22f * 18 - 20f / 405 * Gdx.graphics.getWidth(), Gdx.graphics.getWidth() / 22f * 11*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) - 20f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth());
			SB.draw(GameClass.GrePent, -HORINT + Gdx.graphics.getWidth() / 22f * 4 - 20f / 405 * Gdx.graphics.getWidth(), Gdx.graphics.getWidth() / 22f * 4*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) - 20f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth());
			SB.draw(GameClass.MagPent, -HORINT + Gdx.graphics.getWidth() / 22f * 11 - 20f / 405 * Gdx.graphics.getWidth(), Gdx.graphics.getWidth() / 22f * 4*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) - 20f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth());
			SB.draw(GameClass.WhiPent, -HORINT + Gdx.graphics.getWidth() / 22f * 18 - 20f / 405 * Gdx.graphics.getWidth(), Gdx.graphics.getWidth() / 22f * 4*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) - 20f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth());
		}

		if (HORINT > Gdx.graphics.getWidth() / 22f && HOR < Gdx.graphics.getWidth() / 22f * 43) {
			SB.draw(GameClass.rball, -HORINT + Gdx.graphics.getWidth() / 22f * 26 - 20f / 405 * Gdx.graphics.getWidth(), Gdx.graphics.getWidth() / 22f * 25*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) - 20f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth());
			SB.draw(GameClass.rball2, -HORINT + Gdx.graphics.getWidth() / 22f * 33 - 20f / 405 * Gdx.graphics.getWidth(), Gdx.graphics.getWidth() / 22f * 25*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) - 20f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth());
			SB.draw(GameClass.Hexa, -HORINT + Gdx.graphics.getWidth() / 22f * 40 - 20f / 405 * Gdx.graphics.getWidth(), Gdx.graphics.getWidth() / 22f * 25*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) - 20f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth());
			SB.draw(GameClass.yinyang, -HORINT + Gdx.graphics.getWidth() / 22f * 26 - 20f / 405 * Gdx.graphics.getWidth(), Gdx.graphics.getWidth() / 22f * 18*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) - 20f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth());
			SB.draw(GameClass.ColHexa, -HORINT + Gdx.graphics.getWidth() / 22f * 33 - 20f / 405 * Gdx.graphics.getWidth(), Gdx.graphics.getWidth() / 22f * 18*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) - 20f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth());
			SB.draw(GameClass.square, -HORINT + Gdx.graphics.getWidth() / 22f * 40 - 20f / 405 * Gdx.graphics.getWidth(), Gdx.graphics.getWidth() / 22f * 18*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) - 20f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth());
			SB.draw(GameClass.fireball, -HORINT + Gdx.graphics.getWidth() / 22f * 26 - 20f / 405 * Gdx.graphics.getWidth(), Gdx.graphics.getWidth() / 22f * 11*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) - 20f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth());
			SB.draw(GameClass.rtri, -HORINT + Gdx.graphics.getWidth() / 22f * 33 - 20f / 405 * Gdx.graphics.getWidth(), Gdx.graphics.getWidth() / 22f * 11*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) - 20f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth());
			SB.draw(GameClass.iceball, -HORINT + Gdx.graphics.getWidth() / 22f * 40 - 20f / 405 * Gdx.graphics.getWidth(), Gdx.graphics.getWidth() / 22f * 11*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) - 20f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth());
			SB.draw(GameClass.pokeball, -HORINT + Gdx.graphics.getWidth() / 22f * 26 - 20f / 405 * Gdx.graphics.getWidth(), Gdx.graphics.getWidth() / 22f * 4*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) - 20f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth());
			SB.draw(GameClass.flower, -HORINT + Gdx.graphics.getWidth() / 22f * 33 - 20f / 405 * Gdx.graphics.getWidth(), Gdx.graphics.getWidth() / 22f * 4*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) - 20f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth());
			SB.draw(GameClass.star, -HORINT + Gdx.graphics.getWidth() / 22f * 40 - 20f / 405 * Gdx.graphics.getWidth(), Gdx.graphics.getWidth() / 22f * 4*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) - 20f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth());
		}
		if(HORINT > Gdx.graphics.getWidth()/22f*23) {
			SB.draw(GameClass.spider, -HORINT + Gdx.graphics.getWidth() / 22f * 48 - 20f / 405 * Gdx.graphics.getWidth(), Gdx.graphics.getWidth() / 22f * 25*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) - 20f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth());
			SB.draw(GameClass.bat, -HORINT + Gdx.graphics.getWidth() / 22f * 55 - 20f / 405 * Gdx.graphics.getWidth(), Gdx.graphics.getWidth() / 22f * 25*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) - 20f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth());
			SB.draw(GameClass.dp, -HORINT + Gdx.graphics.getWidth() / 22f * 62 - 20f / 405 * Gdx.graphics.getWidth(), Gdx.graphics.getWidth() / 22f * 25*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) - 20f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth());
			SB.draw(GameClass.smile, -HORINT + Gdx.graphics.getWidth() / 22f * 48 - 20f / 405 * Gdx.graphics.getWidth(), Gdx.graphics.getWidth() / 22f * 18*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) - 20f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth());
			SB.draw(GameClass.pac, -HORINT + Gdx.graphics.getWidth() / 22f * 55 - 20f / 405 * Gdx.graphics.getWidth(), Gdx.graphics.getWidth() / 22f * 18*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) - 20f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth());
			SB.draw(GameClass.illu, -HORINT + Gdx.graphics.getWidth() / 22f * 62 - 20f / 405 * Gdx.graphics.getWidth(), Gdx.graphics.getWidth() / 22f * 18*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) - 20f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth());
			SB.draw(GameClass.wolf, -HORINT + Gdx.graphics.getWidth() / 22f * 48 - 20f / 405 * Gdx.graphics.getWidth(), Gdx.graphics.getWidth() / 22f * 11*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) - 20f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth());
			SB.draw(GameClass.skull, -HORINT + Gdx.graphics.getWidth() / 22f * 55 - 20f / 405 * Gdx.graphics.getWidth(), Gdx.graphics.getWidth() / 22f * 11*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) - 20f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth());
			SB.draw(GameClass.like, -HORINT + Gdx.graphics.getWidth() / 22f * 62 - 20f / 405 * Gdx.graphics.getWidth(), Gdx.graphics.getWidth() / 22f * 11*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) - 20f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth());
			SB.draw(GameClass.skull, -HORINT + Gdx.graphics.getWidth() / 22f * 48 - 20f / 405 * Gdx.graphics.getWidth(), Gdx.graphics.getWidth() / 22f * 4*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) - 20f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth());
			SB.draw(GameClass.skull, -HORINT + Gdx.graphics.getWidth() / 22f * 55 - 20f / 405 * Gdx.graphics.getWidth(), Gdx.graphics.getWidth() / 22f * 4*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) - 20f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth());
			SB.draw(GameClass.skull, -HORINT + Gdx.graphics.getWidth() / 22f * 62 - 20f / 405 * Gdx.graphics.getWidth(), Gdx.graphics.getWidth() / 22f * 4*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f)) - 20f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth(), 40f / 405 * Gdx.graphics.getWidth());
		}
		SB.end();

		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);

		SR.setColor(0, 0, 0, 0.5f - GameClass.HS.GameLogoAlphaTimer / 256);

		SR.begin(ShapeRenderer.ShapeType.Filled);

		SR.setColor(1, 0, 0, 1 - GameClass.HS.GameLogoAlphaTimer / 256);
		SR.circle(-HORINT + Gdx.graphics.getWidth() / 22f * 4, Gdx.graphics.getWidth() / 22f * 25 * ((Gdx.graphics.getHeight() * 1f / Gdx.graphics.getWidth()) / (16 / 9f)), 20f / 405 * Gdx.graphics.getWidth());
		SR.setColor(1, 1, 0, 1 - GameClass.HS.GameLogoAlphaTimer / 256);
		SR.circle(-HORINT + Gdx.graphics.getWidth() / 22f * 11, Gdx.graphics.getWidth() / 22f * 25 * ((Gdx.graphics.getHeight() * 1f / Gdx.graphics.getWidth()) / (16 / 9f)), 20f / 405 * Gdx.graphics.getWidth());
		SR.setColor(0, 1, 1, 1 - GameClass.HS.GameLogoAlphaTimer / 256);
		SR.circle(-HORINT + Gdx.graphics.getWidth() / 22f * 18, Gdx.graphics.getWidth() / 22f * 25 * ((Gdx.graphics.getHeight() * 1f / Gdx.graphics.getWidth()) / (16 / 9f)), 20f / 405 * Gdx.graphics.getWidth());
		SR.setColor(0, 1, 0, 1 - GameClass.HS.GameLogoAlphaTimer / 256);
		SR.circle(-HORINT + Gdx.graphics.getWidth() / 22f * 4, Gdx.graphics.getWidth() / 22f * 18 * ((Gdx.graphics.getHeight() * 1f / Gdx.graphics.getWidth()) / (16 / 9f)), 20f / 405 * Gdx.graphics.getWidth());
		SR.setColor(1, 0, 1, 1 - GameClass.HS.GameLogoAlphaTimer / 256);
		SR.circle(-HORINT + Gdx.graphics.getWidth() / 22f * 11, Gdx.graphics.getWidth() / 22f * 18 * ((Gdx.graphics.getHeight() * 1f / Gdx.graphics.getWidth()) / (16 / 9f)), 20f / 405 * Gdx.graphics.getWidth());
		SR.setColor(0.8f, 0.8f, 0.8f, 1 - GameClass.HS.GameLogoAlphaTimer / 256);
		SR.circle(-HORINT + Gdx.graphics.getWidth() / 22f * 18, Gdx.graphics.getWidth() / 22f * 18 * ((Gdx.graphics.getHeight() * 1f / Gdx.graphics.getWidth()) / (16 / 9f)), 20f / 405 * Gdx.graphics.getWidth());

		SR.end();

		Gdx.gl.glDisable(GL20.GL_BLEND);

		SB.begin();
		if(HORINT < Gdx.graphics.getWidth()/22f*21){
			if(!GameClass.prefs.getBoolean("BUnlock1"))
				SB.draw(GameClass.lock25, -HORINT+Gdx.graphics.getWidth()/22f*8, Gdx.graphics.getWidth()/22f*25*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))- Gdx.graphics.getWidth()/22*3, Gdx.graphics.getWidth()/22*6, Gdx.graphics.getWidth()/22*6);

			if(!GameClass.prefs.getBoolean("BUnlock2"))
				SB.draw(GameClass.lock25, -HORINT+Gdx.graphics.getWidth()/22f*15, Gdx.graphics.getWidth()/22f*25*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))- Gdx.graphics.getWidth()/22*3, Gdx.graphics.getWidth()/22*6, Gdx.graphics.getWidth()/22*6);

			if(!GameClass.prefs.getBoolean("BUnlock3"))
				SB.draw(GameClass.lock25, -HORINT+Gdx.graphics.getWidth()/22f, Gdx.graphics.getWidth()/22f*18*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))- Gdx.graphics.getWidth()/22*3, Gdx.graphics.getWidth()/22*6, Gdx.graphics.getWidth()/22*6);

			if(!GameClass.prefs.getBoolean("BUnlock4"))
				SB.draw(GameClass.lock25, -HORINT+Gdx.graphics.getWidth()/22f*8, Gdx.graphics.getWidth()/22f*18*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))- Gdx.graphics.getWidth()/22*3, Gdx.graphics.getWidth()/22*6, Gdx.graphics.getWidth()/22*6);

			if(!GameClass.prefs.getBoolean("BUnlock5"))
				SB.draw(GameClass.lock25, -HORINT+Gdx.graphics.getWidth()/22f*15, Gdx.graphics.getWidth()/22f*18*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))- Gdx.graphics.getWidth()/22*3, Gdx.graphics.getWidth()/22*6, Gdx.graphics.getWidth()/22*6);

			if(!GameClass.prefs.getBoolean("BUnlock6"))
				SB.draw(GameClass.lock25, -HORINT+Gdx.graphics.getWidth()/22f, Gdx.graphics.getWidth()/22f*11*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))- Gdx.graphics.getWidth()/22*3, Gdx.graphics.getWidth()/22*6, Gdx.graphics.getWidth()/22*6);

			if(!GameClass.prefs.getBoolean("BUnlock7"))
				SB.draw(GameClass.lock25, -HORINT+Gdx.graphics.getWidth()/22f*8, Gdx.graphics.getWidth()/22f*11*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))- Gdx.graphics.getWidth()/22*3, Gdx.graphics.getWidth()/22*6, Gdx.graphics.getWidth()/22*6);

			if(!GameClass.prefs.getBoolean("BUnlock8"))
				SB.draw(GameClass.lock25, -HORINT+Gdx.graphics.getWidth()/22f*15, Gdx.graphics.getWidth()/22f*11*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))- Gdx.graphics.getWidth()/22*3, Gdx.graphics.getWidth()/22*6, Gdx.graphics.getWidth()/22*6);

			if(!GameClass.prefs.getBoolean("BUnlock9"))
				SB.draw(GameClass.lock25, -HORINT+Gdx.graphics.getWidth()/22f, Gdx.graphics.getWidth()/22f*4*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))- Gdx.graphics.getWidth()/22*3, Gdx.graphics.getWidth()/22*6, Gdx.graphics.getWidth()/22*6);

			if(!GameClass.prefs.getBoolean("BUnlock10"))
				SB.draw(GameClass.lock25, -HORINT+Gdx.graphics.getWidth()/22f*8, Gdx.graphics.getWidth()/22f*4*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))- Gdx.graphics.getWidth()/22*3, Gdx.graphics.getWidth()/22*6, Gdx.graphics.getWidth()/22*6);

			if(!GameClass.prefs.getBoolean("BUnlock11"))
				SB.draw(GameClass.lock25, -HORINT+Gdx.graphics.getWidth()/22f*15, Gdx.graphics.getWidth()/22f*4*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))- Gdx.graphics.getWidth()/22*3, Gdx.graphics.getWidth()/22*6, Gdx.graphics.getWidth()/22*6);
		}

		if(HORINT > Gdx.graphics.getWidth()/22f && HORINT < Gdx.graphics.getWidth()/22f*43){

			if(!GameClass.prefs.getBoolean("BUnlock12"))
				SB.draw(GameClass.lock50, -HORINT+Gdx.graphics.getWidth()/22f*23, Gdx.graphics.getWidth()/22f*25*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))- Gdx.graphics.getWidth()/22*3, Gdx.graphics.getWidth()/22*6, Gdx.graphics.getWidth()/22*6);

			if(!GameClass.prefs.getBoolean("BUnlock13"))
				SB.draw(GameClass.lock50, -HORINT+Gdx.graphics.getWidth()/22f*30, Gdx.graphics.getWidth()/22f*25*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))- Gdx.graphics.getWidth()/22*3, Gdx.graphics.getWidth()/22*6, Gdx.graphics.getWidth()/22*6);

			if(!GameClass.prefs.getBoolean("BUnlock14"))
				SB.draw(GameClass.lock50, -HORINT+Gdx.graphics.getWidth()/22f*37, Gdx.graphics.getWidth()/22f*25*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))- Gdx.graphics.getWidth()/22*3, Gdx.graphics.getWidth()/22*6, Gdx.graphics.getWidth()/22*6);

			if(!GameClass.prefs.getBoolean("BUnlock15"))
				SB.draw(GameClass.lock50, -HORINT+Gdx.graphics.getWidth()/22f*23, Gdx.graphics.getWidth()/22f*18*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))- Gdx.graphics.getWidth()/22*3, Gdx.graphics.getWidth()/22*6, Gdx.graphics.getWidth()/22*6);

			if(!GameClass.prefs.getBoolean("BUnlock16"))
				SB.draw(GameClass.lock100, -HORINT+Gdx.graphics.getWidth()/22f*30, Gdx.graphics.getWidth()/22f*18*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))- Gdx.graphics.getWidth()/22*3, Gdx.graphics.getWidth()/22*6, Gdx.graphics.getWidth()/22*6);

			if(!GameClass.prefs.getBoolean("BUnlock17"))
				SB.draw(GameClass.lock25, -HORINT+Gdx.graphics.getWidth()/22f*37, Gdx.graphics.getWidth()/22f*18*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))- Gdx.graphics.getWidth()/22*3, Gdx.graphics.getWidth()/22*6, Gdx.graphics.getWidth()/22*6);

			if(!GameClass.prefs.getBoolean("BUnlock18"))
				SB.draw(GameClass.lock25, -HORINT+Gdx.graphics.getWidth()/22f*23, Gdx.graphics.getWidth()/22f*11*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))- Gdx.graphics.getWidth()/22*3, Gdx.graphics.getWidth()/22*6, Gdx.graphics.getWidth()/22*6);

			if(!GameClass.prefs.getBoolean("BUnlock19"))
				SB.draw(GameClass.lock25, -HORINT+Gdx.graphics.getWidth()/22f*30, Gdx.graphics.getWidth()/22f*11*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))- Gdx.graphics.getWidth()/22*3, Gdx.graphics.getWidth()/22*6, Gdx.graphics.getWidth()/22*6);

			if(!GameClass.prefs.getBoolean("BUnlock20"))
				SB.draw(GameClass.lock25, -HORINT+Gdx.graphics.getWidth()/22f*37, Gdx.graphics.getWidth()/22f*11*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))- Gdx.graphics.getWidth()/22*3, Gdx.graphics.getWidth()/22*6, Gdx.graphics.getWidth()/22*6);

			if(!GameClass.prefs.getBoolean("BUnlock21"))
				SB.draw(GameClass.lock25, -HORINT+Gdx.graphics.getWidth()/22f*23, Gdx.graphics.getWidth()/22f*4*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))- Gdx.graphics.getWidth()/22*3, Gdx.graphics.getWidth()/22*6, Gdx.graphics.getWidth()/22*6);

			if(!GameClass.prefs.getBoolean("BUnlock22"))
				SB.draw(GameClass.lock25, -HORINT+Gdx.graphics.getWidth()/22f*30, Gdx.graphics.getWidth()/22f*4*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))- Gdx.graphics.getWidth()/22*3, Gdx.graphics.getWidth()/22*6, Gdx.graphics.getWidth()/22*6);

			if(!GameClass.prefs.getBoolean("BUnlock23"))
				SB.draw(GameClass.lock25, -HORINT+Gdx.graphics.getWidth()/22f*37, Gdx.graphics.getWidth()/22f*4*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))- Gdx.graphics.getWidth()/22*3, Gdx.graphics.getWidth()/22*6, Gdx.graphics.getWidth()/22*6);

		}

		if(HORINT > Gdx.graphics.getWidth()/22f*23){
			if(!GameClass.prefs.getBoolean("BUnlock24"))
				SB.draw(GameClass.lock25, -HORINT+Gdx.graphics.getWidth()/22f*45, Gdx.graphics.getWidth()/22f*25*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))- Gdx.graphics.getWidth()/22*3, Gdx.graphics.getWidth()/22*6, Gdx.graphics.getWidth()/22*6);

			if(!GameClass.prefs.getBoolean("BUnlock25"))
				SB.draw(GameClass.lock25, -HORINT+Gdx.graphics.getWidth()/22f*52, Gdx.graphics.getWidth()/22f*25*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))- Gdx.graphics.getWidth()/22*3, Gdx.graphics.getWidth()/22*6, Gdx.graphics.getWidth()/22*6);

			if(!GameClass.prefs.getBoolean("BUnlock26"))
				SB.draw(GameClass.lock25, -HORINT+Gdx.graphics.getWidth()/22f*59, Gdx.graphics.getWidth()/22f*25*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))- Gdx.graphics.getWidth()/22*3, Gdx.graphics.getWidth()/22*6, Gdx.graphics.getWidth()/22*6);

			if(!GameClass.prefs.getBoolean("BUnlock27"))
				SB.draw(GameClass.lock25, -HORINT+Gdx.graphics.getWidth()/22f*45, Gdx.graphics.getWidth()/22f*18*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))- Gdx.graphics.getWidth()/22*3, Gdx.graphics.getWidth()/22*6, Gdx.graphics.getWidth()/22*6);

			if(!GameClass.prefs.getBoolean("BUnlock28"))
				SB.draw(GameClass.lock25, -HORINT+Gdx.graphics.getWidth()/22f*52, Gdx.graphics.getWidth()/22f*18*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))- Gdx.graphics.getWidth()/22*3, Gdx.graphics.getWidth()/22*6, Gdx.graphics.getWidth()/22*6);

			if(!GameClass.prefs.getBoolean("BUnlock29"))
				SB.draw(GameClass.lock25, -HORINT+Gdx.graphics.getWidth()/22f*59, Gdx.graphics.getWidth()/22f*18*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))- Gdx.graphics.getWidth()/22*3, Gdx.graphics.getWidth()/22*6, Gdx.graphics.getWidth()/22*6);

			if(!GameClass.prefs.getBoolean("BUnlock30"))
				SB.draw(GameClass.lock25, -HORINT+Gdx.graphics.getWidth()/22f*45, Gdx.graphics.getWidth()/22f*11*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))- Gdx.graphics.getWidth()/22*3, Gdx.graphics.getWidth()/22*6, Gdx.graphics.getWidth()/22*6);

			if(!GameClass.prefs.getBoolean("BUnlock31"))
				SB.draw(GameClass.lock25, -HORINT+Gdx.graphics.getWidth()/22f*52, Gdx.graphics.getWidth()/22f*11*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))- Gdx.graphics.getWidth()/22*3, Gdx.graphics.getWidth()/22*6, Gdx.graphics.getWidth()/22*6);

			if(!GameClass.prefs.getBoolean("BUnlock32"))
				SB.draw(GameClass.lock25, -HORINT+Gdx.graphics.getWidth()/22f*59, Gdx.graphics.getWidth()/22f*11*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))- Gdx.graphics.getWidth()/22*3, Gdx.graphics.getWidth()/22*6, Gdx.graphics.getWidth()/22*6);

			if(!GameClass.prefs.getBoolean("BUnlock33"))
				SB.draw(GameClass.lock25, -HORINT+Gdx.graphics.getWidth()/22f*45, Gdx.graphics.getWidth()/22f*4*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))- Gdx.graphics.getWidth()/22*3, Gdx.graphics.getWidth()/22*6, Gdx.graphics.getWidth()/22*6);

			if(!GameClass.prefs.getBoolean("BUnlock34"))
				SB.draw(GameClass.lock25, -HORINT+Gdx.graphics.getWidth()/22f*52, Gdx.graphics.getWidth()/22f*4*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))- Gdx.graphics.getWidth()/22*3, Gdx.graphics.getWidth()/22*6, Gdx.graphics.getWidth()/22*6);

			if(!GameClass.prefs.getBoolean("BUnlock35"))
				SB.draw(GameClass.lock25, -HORINT+Gdx.graphics.getWidth()/22f*59, Gdx.graphics.getWidth()/22f*4*((Gdx.graphics.getHeight()*1f/Gdx.graphics.getWidth())/(16/9f))- Gdx.graphics.getWidth()/22*3 , Gdx.graphics.getWidth()/22*6, Gdx.graphics.getWidth()/22*6);
		}
		SB.end();

		coinicon.update();

	}
}

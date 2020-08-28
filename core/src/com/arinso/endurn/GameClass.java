package com.arinso.endurn;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class GameClass extends ApplicationAdapter {
	public static int FPS = 60;//FINAL FINAL FINAL

	public static float _WC;
	public static float _HC;
	
	public static ShapeRenderer SR;
	public static SpriteBatch SB;
	public static FreeTypeFontGenerator generator;
	public static FreeTypeFontParameter parameter;
	public static BitmapFont TextFontSmall;
	public static BitmapFont TextFontPre;
	public static BitmapFont TextFontMedium;
	public static BitmapFont TextFontLarge;
	SplashScreen SS;
	public static HomeScreen HS;
	public static GameScreen GS;
	public static Settings SET;
	public static GiftScreen GIS;
	public static PurchaseScreen PS;
	static Shop SHOP;
	public static GameOverScreen GOS;
	public static float BCR,BCG,BCB;
	public static int SCREEN = 0;
	public static Music bg;
	public static Sound GameOverSound; 
	public static Sound coinsfx;
	static Texture GameLogo;
	static Texture ShopLogo;
	static Texture SettingsLogo;
	static Texture RateStar;
	static Texture GiftLogo;
	static Texture Diamond;


	public static Texture MUSIC_OFF;
	public static Texture MUSIC_ON;
	public static Texture SOUNDS_OFF;
	public static Texture SOUNDS_ON;
	public static Texture RESET_DATA;

	public static Texture lock25,lock50,lock100;
	public static Texture coin;
	public static Texture home;
	public static Texture SelectedBall;

	public static Texture ftg;
	public static Texture scoreleft;
	public static Texture collect;
	public static Texture youearned;
	public static Texture cointext;
	public static Texture freecoin;
	public static Texture removeads;
	public static Texture unlockall;

	public static Texture layout;
	public static Texture giftlayout;
	public static Texture purchaselayout;
	public static Texture confirm;
	public static Texture alpha192;

	public static Texture RedHexa;
	public static Texture CyanHexa;
	public static Texture YelHexa;
	public static Texture GrePent;
	public static Texture MagPent;
	public static Texture WhiPent;

	public static Texture rball;
	public static Texture rball2;
	public static Texture Hexa;
	public static Texture yinyang;
	public static Texture ColHexa;
	public static Texture square;
	public static Texture fireball;
	public static Texture rtri;
	public static Texture iceball;

	public static Texture pokeball;
	public static Texture flower;
	public static Texture star;

	public static Texture spider;
	public static Texture bat;
	public static Texture dp;
	public static Texture smile;
	public static Texture pac;
	public static Texture illu;
	public static Texture wolf;
	public static Texture skull;
	public static Texture like;

	public static Preferences prefs;

	static AdHandler handler;
	public GameClass(AdHandler handler){
		this.handler = handler;
	}

	@Override
	public void create () {
		_WC = (Gdx.graphics.getWidth()/405f);
		_HC = (Gdx.graphics.getHeight()/720f);

		generator = new FreeTypeFontGenerator(Gdx.files.internal("FFFFORWA.TTF"));
		parameter = new FreeTypeFontParameter();
		parameter.size = (int) ((18f/405)*Gdx.graphics.getWidth());
		TextFontSmall = GameClass.generator.generateFont(GameClass.parameter); // font size 12 pixels
		parameter.size = (int) ((36f/405)*Gdx.graphics.getWidth());
		TextFontPre    = GameClass.generator.generateFont(GameClass.parameter); // font size 48 pixels
		parameter.size = (int) ((48f/405)*Gdx.graphics.getWidth());
		TextFontMedium = GameClass.generator.generateFont(GameClass.parameter); // font size 48 pixels
		parameter.size = (int) ((72f/405)*Gdx.graphics.getWidth());
		TextFontLarge = GameClass.generator.generateFont(GameClass.parameter); // font size 72 pixels
		generator.dispose();
		
		prefs = Gdx.app.getPreferences("Endurn");

		if(!prefs.contains("SFXVol"))
			prefs.putFloat("SFXVol", 1);
		if(!prefs.contains("MusicVol"))
			prefs.putInteger("MusicVol", 1);

		MUSIC_OFF = new Texture(Gdx.files.internal("MUSIC_OFF.png"));
		MUSIC_ON = new Texture(Gdx.files.internal("MUSIC_ON.png"));
		SOUNDS_OFF = new Texture(Gdx.files.internal("SOUNDS_OFF.png"));
		SOUNDS_ON = new Texture(Gdx.files.internal("SOUNDS_ON.png"));

		GameLogo = new Texture(Gdx.files.internal("LOGO_WHITE.png"));
		coin = new Texture(Gdx.files.internal("coin.png"));
		SettingsLogo = new Texture(Gdx.files.internal("Settings.png"));
		RateStar = new Texture(Gdx.files.internal("test.png"));
		ShopLogo = new Texture(Gdx.files.internal("basket.png"));
		GiftLogo = new Texture(Gdx.files.internal("gift.png"));
		Diamond = new Texture(Gdx.files.internal("diamond.png"));

		lock25 = new Texture(Gdx.files.internal("lock25.png"));
		lock50 = new Texture(Gdx.files.internal("lock50.png"));
		lock100 = new Texture(Gdx.files.internal("lock100.png"));
		home = new Texture(Gdx.files.internal("home.png"));
		SelectedBall = new Texture(Gdx.files.internal("SelectedBall.png"));

		ftg = new Texture(Gdx.files.internal("ftg.png"));
		scoreleft = new Texture(Gdx.files.internal("scoreleft.png"));
		collect = new Texture(Gdx.files.internal("collect.png"));
		youearned = new Texture(Gdx.files.internal("youearned.png"));
		cointext = new Texture(Gdx.files.internal("cointext.png"));
		freecoin = new Texture(Gdx.files.internal("freecoin.png"));
		removeads = new Texture(Gdx.files.internal("removeads.png"));
		unlockall = new Texture(Gdx.files.internal("unlockall.png"));

		layout = new Texture(Gdx.files.internal("layout.png"));
		giftlayout = new Texture(Gdx.files.internal("giftlayout.png"));
		purchaselayout = new Texture(Gdx.files.internal("purchaselayout.png"));
		confirm = new Texture(Gdx.files.internal("confirm.png"));
		alpha192 = new Texture(Gdx.files.internal("alpha192.png"));

		RedHexa = new Texture(Gdx.files.internal("RedHexa.png"));
		YelHexa = new Texture(Gdx.files.internal("YelHexa.png"));
		CyanHexa = new Texture(Gdx.files.internal("CyanHexa.png"));
		GrePent = new Texture(Gdx.files.internal("GrePent.png"));
		MagPent = new Texture(Gdx.files.internal("MagPent.png"));
		WhiPent = new Texture(Gdx.files.internal("WhiPent.png"));

		yinyang = new Texture(Gdx.files.internal("yinyang.png"));
		rball = new Texture(Gdx.files.internal("rball.png"));
		rball2 = new Texture(Gdx.files.internal("rball-2.png"));
		Hexa = new Texture(Gdx.files.internal("Hexa.png"));
		ColHexa = new Texture(Gdx.files.internal("ColHexa.png"));
        square = new Texture(Gdx.files.internal("1x1"));
		fireball = new Texture(Gdx.files.internal("fireball.png"));
		rtri = new Texture(Gdx.files.internal("triangle.png"));
		iceball = new Texture(Gdx.files.internal("iceball.png"));

		pokeball = new Texture(Gdx.files.internal("pokeball.png"));
		flower = new Texture(Gdx.files.internal("flower.png"));
		star = new Texture(Gdx.files.internal("star.png"));

		spider = new Texture(Gdx.files.internal("spider.png"));
		bat = new Texture(Gdx.files.internal("bat.png"));
		dp = new Texture(Gdx.files.internal("dp.png"));
		smile = new Texture(Gdx.files.internal("smile.png"));
		pac = new Texture(Gdx.files.internal("pac.png"));
		illu = new Texture(Gdx.files.internal("illu.png"));
		wolf = new Texture(Gdx.files.internal("wolf.png"));
		skull = new Texture(Gdx.files.internal("skull.png"));
		like = new Texture(Gdx.files.internal("like.png"));

		
		bg = Gdx.audio.newMusic(Gdx.files.internal("bg.mp3"));
		bg.setVolume(prefs.getInteger("MusicVol"));
		bg.setLooping(true);

		GameOverSound = Gdx.audio.newSound(Gdx.files.internal("GameOver.mp3"));
		coinsfx = Gdx.audio.newSound(Gdx.files.internal("coin.mp3"));
		
		SR = new ShapeRenderer();
		SB = new SpriteBatch();
		
		SS = new SplashScreen();
		HS = new HomeScreen();
		GS = new GameScreen();
		GOS = new GameOverScreen();
		SET = new Settings();
		SHOP = new Shop();
		GIS = new GiftScreen();
		PS = new PurchaseScreen();
		Gdx.input.setCatchBackKey(true);
	}
	
	@Override
	public void render () {

		if(500-prefs.getInteger("GIFTP")!=0)
		if(Gdx.input.isKeyPressed(Input.Keys.G))
			prefs.putInteger("GIFTP", prefs.getInteger("GIFTP")+5);
		if(Gdx.input.isKeyPressed(Input.Keys.C))
			prefs.putInteger("Coin", prefs.getInteger("Coin")+2);

		if(Gdx.input.isKeyPressed(Input.Keys.D)&&FPS!=5)
			FPS--;
		if(Gdx.input.isKeyPressed(Input.Keys.U)&&FPS!=65)
			FPS++;




		if(SCREEN == SCREENS.SPLASH){
			SS.update();
			if(handler!=null)
			handler.showAds(false);
		}
		if(SCREEN == SCREENS.HOME){
			HS.update();
			if(handler!=null)
				handler.showAds(true);
		}
		if(SCREEN == SCREENS.GAME){
			GS.update();		
			HS.update();
			if(handler!=null)
				handler.showAds(false);
		}
		
		if(SCREEN == SCREENS.GAMEOVER){
			GS.update();
			GOS.update();
			if(handler!=null)
				handler.showAds(true);
		}
		if(SCREEN == SCREENS.SHOP){
			HS.update();
			SHOP.update();
			if(handler!=null)
				handler.showAds(false);
		}

		if(SCREEN == SCREENS.SETTINGS){
			HS.update();
			SET.update();
			if(handler!=null)
				handler.showAds(true);
		}

		if(SCREEN == SCREENS.GIFT){
			HS.update();
			GIS.update();
			if(handler!=null)
				handler.showAds(true);
		}

		if(SCREEN == SCREENS.PURCHASE){
			HS.update();
			PS.update();
			if(handler!=null)
				handler.showAds(true);
		}

		/*
		SR.begin(ShapeRenderer.ShapeType.Line);
		SR.line(Gdx.graphics.getWidth()/8f, Gdx.graphics.getHeight(), Gdx.graphics.getWidth()/8f, 0);
		SR.line(Gdx.graphics.getWidth()/8f*2, Gdx.graphics.getHeight(), Gdx.graphics.getWidth()/8f*2, 0);
		SR.line(Gdx.graphics.getWidth()/8f*3, Gdx.graphics.getHeight(), Gdx.graphics.getWidth()/8f*3, 0);
		SR.line(Gdx.graphics.getWidth()/8f*4, Gdx.graphics.getHeight(), Gdx.graphics.getWidth()/8f*4, 0);
		SR.line(Gdx.graphics.getWidth()/8f*5, Gdx.graphics.getHeight(), Gdx.graphics.getWidth()/8f*5, 0);
		SR.line(Gdx.graphics.getWidth()/8f*6, Gdx.graphics.getHeight(), Gdx.graphics.getWidth()/8f*6, 0);
		SR.line(Gdx.graphics.getWidth()/8f*7, Gdx.graphics.getHeight(), Gdx.graphics.getWidth()/8f*7, 0);

		SR.line(0, Gdx.graphics.getHeight()/4, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/4);
		SR.line(0, Gdx.graphics.getHeight()/4*2, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/4*2);
		SR.line(0, Gdx.graphics.getHeight()/4*3, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/4*3);
		SR.line(0, Gdx.graphics.getHeight()/8, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/8);
		SR.line(0, Gdx.graphics.getHeight()/8*3, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/8*3);
		SR.end();
		*/

		SB.begin();
		TextFontSmall.setColor(1, 1, 1, 1);
		TextFontSmall.draw(SB, "Beta v1.0.6", 5, Gdx.graphics.getHeight() - 5);
		TextFontSmall.draw(SB, "FPS: " + Gdx.graphics.getFramesPerSecond(), 5, Gdx.graphics.getHeight() - TextFontSmall.getLineHeight() - 15);
		SB.end();

		sleep(FPS);
	}

	private long diff, start = System.currentTimeMillis();

	public void sleep(int fps) {
		if(fps>0){
			diff = System.currentTimeMillis() - start;
			long targetDelay = 1000/fps;
			if (diff < targetDelay) {
				try{
					Thread.sleep(targetDelay - diff);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			start = System.currentTimeMillis();
		}
	}

	@Override
	public void dispose () {
		SR.dispose();
		SB.dispose();
	}
}

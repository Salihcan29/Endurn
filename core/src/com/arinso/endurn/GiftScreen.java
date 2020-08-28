package com.arinso.endurn;

import com.arinso.endurn.Objects.coin;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;

/**
 * Created by Salih can on 24.05.2017.
 */


public class GiftScreen {
    int RT = 2;
    int prize = 0;
    float opacity256 = 0;
    float Flash256 = 0;
    Boolean CollectActive = false;
    Boolean AfterFlash = false;

    public GiftScreen() {

    }

    public void update(){
        if(Gdx.input.justTouched()&&Gdx.graphics.getHeight()-Gdx.input.getY()>(Gdx.graphics.getHeight()-100*(Gdx.graphics.getHeight()/720f))){
            GameClass.HS.PlayButtonAlphaTimer = 20;
            GameClass.SCREEN = SCREENS.HOME;
            GameClass.HS.timer = 0;
            GameClass.HS.TouchActive = false;
            GameClass.HS.coin = new coin(1);
            CollectActive = false;
            AfterFlash = false;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.BACK)||Gdx.input.isKeyJustPressed(Input.Keys.BACKSPACE)){
            GameClass.HS.PlayButtonAlphaTimer = 20;
            GameClass.SCREEN = SCREENS.HOME;
            GameClass.HS.timer = 0;
            GameClass.HS.TouchActive = false;
            GameClass.HS.coin = new coin(1);
            CollectActive = false;
            AfterFlash = false;
        }

        if(opacity256!=0)
            opacity256-=5;

        if(!AfterFlash&&Flash256!=255)
            Flash256+=15;

        if(AfterFlash&&Flash256!=0)
            Flash256-=15;

        if(Gdx.input.isTouched())
            RT = 0;
        else
            RT++;

        if(RT == 1)
            CollectActive = true;

        if(CollectActive&&Gdx.input.justTouched()&&Gdx.graphics.getHeight()-Gdx.input.getY()<180*(Gdx.graphics.getHeight()/720f)&&Gdx.graphics.getHeight()-Gdx.input.getY()>80*(Gdx.graphics.getHeight()/720f)){
            if(GameClass.prefs.getInteger("GIFTP") >= 500){
                opacity256 = 255;
                GameClass.prefs.putInteger("GIFTP",0);
                GameClass.prefs.flush();
                AfterFlash = true;
                RandomPrize();
            }
        }



        render(GameClass.SR,GameClass.SB);
    }

    private void RandomPrize() {
        int i = MathUtils.random(0,1000);
        if(i<500)
            prize = 10;
        if(i>499&&i<750)
            prize = 25;
        if(i>749&&i<900)
            prize = 40;
        if(i>899)
            prize = 50;

        GameClass.prefs.putInteger("Coin",GameClass.prefs.getInteger("Coin")+prize);
        GameClass.prefs.flush();
    }

    public void render(ShapeRenderer SR,SpriteBatch SB) {
        SR.begin(ShapeRenderer.ShapeType.Filled);
        SR.end();

        SB.setColor(1, 1, 1, 1 - GameClass.HS.GameLogoAlphaTimer / 256);
        SB.begin();
        SB.draw(GameClass.home, Gdx.graphics.getWidth() / 2 - Gdx.graphics.getHeight() / 20, (Gdx.graphics.getHeight() - 50 * (Gdx.graphics.getHeight() / 720f)) - Gdx.graphics.getHeight() / 20, Gdx.graphics.getHeight() / 10, Gdx.graphics.getHeight() / 10);
        SB.draw(GameClass.giftlayout, 2, 0, Gdx.graphics.getWidth() - 4, Gdx.graphics.getHeight());


        SB.setColor(1, 1, 1, Flash256 / 256);
        SB.draw(GameClass.ftg, 0, Gdx.graphics.getHeight() / 32f * 25 - (GameClass.ftg.getHeight() * (Gdx.graphics.getWidth() / 405f)) / 2, Gdx.graphics.getWidth(), GameClass.ftg.getHeight() * (Gdx.graphics.getWidth() / 405f));
        SB.draw(GameClass.scoreleft, 0, Gdx.graphics.getHeight() / 32f * 19 - 100 * (Gdx.graphics.getHeight() / 720f) - (GameClass.scoreleft.getHeight() * (Gdx.graphics.getWidth() / 405f)) / 2, Gdx.graphics.getWidth(), GameClass.scoreleft.getHeight() * (Gdx.graphics.getWidth() / 405f));
        GameClass.TextFontLarge.setColor(1, 1, 1, Flash256 / 256);
        if(500 - GameClass.prefs.getInteger("GIFTP")>0)
            GameClass.TextFontLarge.draw(SB, 500 - GameClass.prefs.getInteger("GIFTP") + "", Gdx.graphics.getWidth() / 2f - (500 - GameClass.prefs.getInteger("GIFTP") + "").length() * (int) ((24f / 405) * Gdx.graphics.getWidth()), Gdx.graphics.getHeight() / 4f * 3 - 100 * (Gdx.graphics.getHeight() / 720f)+GameClass.TextFontMedium.getLineHeight()/3f*2+6);
        else
            GameClass.TextFontLarge.draw(SB, "0", Gdx.graphics.getWidth() / 20f*9, Gdx.graphics.getHeight() / 4f * 3 - 100 * (Gdx.graphics.getHeight() / 720f)+GameClass.TextFontMedium.getLineHeight()/3f*2+6);

        if(AfterFlash){
            SB.setColor(1, 1, 1, 1 - Flash256 / 256);
            SB.draw(GameClass.youearned, 0, Gdx.graphics.getHeight() / 32f * 25 - (GameClass.youearned.getHeight() * (Gdx.graphics.getWidth() / 405f)) / 2, Gdx.graphics.getWidth(), GameClass.youearned.getHeight() * (Gdx.graphics.getWidth() / 405f));
            SB.draw(GameClass.cointext, 0, Gdx.graphics.getHeight() / 32f * 19 - 100 * (Gdx.graphics.getHeight() / 720f) - (GameClass.cointext.getHeight() * (Gdx.graphics.getWidth() / 405f)) / 2, Gdx.graphics.getWidth(), GameClass.cointext.getHeight() * (Gdx.graphics.getWidth() / 405f));
            GameClass.TextFontLarge.setColor(1, 1, 1, 1 - Flash256 / 256);
            GameClass.TextFontLarge.draw(SB, prize + "", Gdx.graphics.getWidth() / 10f * 4, Gdx.graphics.getHeight() / 4f * 3 - 100 * (Gdx.graphics.getHeight() / 720f) + GameClass.TextFontMedium.getLineHeight() / 3f * 2 + 6);
        }


        if (500 - GameClass.prefs.getInteger("GIFTP") <= 0)
            SB.setColor(1, 1, 1, 1);
        else
            SB.setColor(1, 1, 1, 0.3f);
        SB.draw(GameClass.collect, 0, 130 * (Gdx.graphics.getHeight() / 720f) - (GameClass.collect.getHeight() * (Gdx.graphics.getWidth() / 405f)) / 2, Gdx.graphics.getWidth(), GameClass.collect.getHeight()*(Gdx.graphics.getWidth() / 405f));


        SB.setColor(1,1,1,opacity256/256);
        SB.draw(GameClass.square,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        SB.end();
    }
}

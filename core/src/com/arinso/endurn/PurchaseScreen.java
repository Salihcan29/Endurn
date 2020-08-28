package com.arinso.endurn;

import com.arinso.endurn.Objects.coin;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by Salih can on 24.05.2017.
 */

public class PurchaseScreen {
    Boolean confirm;
    Boolean TouchActive;
    Boolean CancelActive;
    float confirmAlpha256 = 0;
    int exitTimer = 0;

    public PurchaseScreen(){
        confirm = false;
        TouchActive = false;
        CancelActive = false;
    }

    public void update(){
        if(Gdx.input.isKeyPressed(Input.Keys.BACK)||Gdx.input.isKeyJustPressed(Input.Keys.BACKSPACE)){
            if(confirm){
                confirm = false;
                exitTimer = 0;
            } else {
                if(exitTimer == 30){
                    GameClass.HS.PlayButtonAlphaTimer = 0;
                    GameClass.SCREEN = SCREENS.HOME;
                    GameClass.HS.timer = 0;
                    GameClass.HS.TouchActive = false;
                    GameClass.HS.coin = new coin(1);
                    TouchActive = false;
                    confirmAlpha256 = 0;
                    CancelActive = false;
                }
            }
        }
        if(exitTimer<30)
        exitTimer++;

        if(confirm){
            if(confirmAlpha256<255)
            confirmAlpha256+=15;
        }else{
            if(confirmAlpha256>0)
            confirmAlpha256-=15;
        }

        if(Gdx.input.justTouched()){
            if(!confirm){
                if(TouchActive&&Gdx.input.getX() < Gdx.graphics.getWidth() - 2 && Gdx.input.getX() > 2&& Gdx.graphics.getHeight() - Gdx.input.getY() > 160*GameClass._HC&& Gdx.graphics.getHeight()-Gdx.input.getY() < 260*GameClass._HC){
                    confirm = true;
                }
                TouchActive = true;
                CancelActive = false;
            }

            if(confirm){
                if(Gdx.input.justTouched()&&CancelActive){
                    if(Gdx.input.getX()>40*GameClass._WC&&Gdx.input.getX()<Gdx.graphics.getWidth()/2-8*GameClass._WC&&Gdx.input.getY()>Gdx.graphics.getHeight()/2+56*GameClass._HC&&Gdx.input.getY()<Gdx.graphics.getHeight()/2+110*GameClass._HC||
                            (Gdx.input.getX()<32*GameClass._WC||Gdx.input.getX()>Gdx.graphics.getWidth()-32*GameClass._WC ||Gdx.input.getY()<Gdx.graphics.getHeight()/2-120*GameClass._HC|| Gdx.input.getY()>Gdx.graphics.getHeight()/2+120*GameClass._HC)){
                        confirm = false;
                        TouchActive = true;
                    }else if(Gdx.input.getX()>Gdx.graphics.getWidth()/2+8*GameClass._WC&&Gdx.input.getX()<Gdx.graphics.getWidth()-40*GameClass._WC&&Gdx.input.getY()>Gdx.graphics.getHeight()/2+56*GameClass._HC&&Gdx.input.getY()<Gdx.graphics.getHeight()/2+110*GameClass._HC){
                        if(GameClass.handler != null)
                            GameClass.handler.showVideoAd();
                        confirm = false;
                        TouchActive = true;
                    }
                }
                CancelActive = true;
            }
        }

        GameClass.prefs.flush();

        render(GameClass.SR,GameClass.SB);
    }

    public void render(ShapeRenderer SR, SpriteBatch SB){
        SR.begin(ShapeRenderer.ShapeType.Filled);
        SR.end();

        SB.setColor(1, 1, 1, 1 - GameClass.HS.GameLogoAlphaTimer / 256);
        SB.begin();
        SB.draw(GameClass.purchaselayout, 2, 0, Gdx.graphics.getWidth() - 4, Gdx.graphics.getHeight());
        SB.draw(GameClass.freecoin, 0, (210 * GameClass._HC) - (GameClass.freecoin.getHeight() * GameClass._WC)/2, Gdx.graphics.getWidth(), GameClass.freecoin.getHeight() * GameClass._WC);
        SB.draw(GameClass.removeads, 0, (510 * GameClass._HC) - (GameClass.removeads.getHeight() * GameClass._WC)/2, Gdx.graphics.getWidth(), GameClass.removeads.getHeight() * GameClass._WC);
        SB.draw(GameClass.unlockall, 0, Gdx.graphics.getHeight()/2 - (GameClass.removeads.getHeight() * GameClass._WC)/2, Gdx.graphics.getWidth(), GameClass.removeads.getHeight() * GameClass._WC);


        SB.setColor(1, 1, 1, confirmAlpha256 / 256);
        SB.draw(GameClass.alpha192,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        SB.draw(GameClass.confirm,0,Gdx.graphics.getHeight()/2-(GameClass.confirm.getHeight()* GameClass._WC)/2,Gdx.graphics.getWidth(),GameClass.confirm.getHeight()*GameClass._WC);
        SB.end();
    }
}

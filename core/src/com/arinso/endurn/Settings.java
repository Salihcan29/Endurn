package com.arinso.endurn;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by Salih Can on 19.05.2017.
 */

public class Settings {
    int musictextureinteger;
    float soundtextureinteger;

    public Settings(){
        musictextureinteger = GameClass.prefs.getInteger("MusicVol");
        soundtextureinteger = GameClass.prefs.getFloat("SFXVol");
    }

    public void update(){
        if(Gdx.input.isKeyPressed(Input.Keys.BACK)||Gdx.input.isKeyJustPressed(Input.Keys.BACKSPACE)){
            GameClass.HS.PlayButtonAlphaTimer = 20;
            GameClass.SCREEN = SCREENS.HOME;
            GameClass.HS.timer = 0;
            GameClass.HS.TouchActive = false;
        }


        if(Gdx.input.justTouched()) {
            if (Gdx.input.getX() > Gdx.graphics.getWidth() / 8 && Gdx.input.getX()<Gdx.graphics.getWidth() / 8 * 7) {
                if(Gdx.graphics.getHeight()-Gdx.input.getY()>Gdx.graphics.getHeight() / 8 * 5 && Gdx.graphics.getHeight()-Gdx.input.getY()<Gdx.graphics.getHeight() / 8 * 5 +Gdx.graphics.getHeight()/10){
                    if(GameClass.prefs.getInteger("MusicVol") == 1){
                        GameClass.prefs.putInteger("MusicVol" , 0);
                        GameClass.prefs.flush();
                        GameClass.bg.setVolume(GameClass.prefs.getInteger("MusicVol"));
                    }else{
                        GameClass.bg.stop();
                        GameClass.prefs.putInteger("MusicVol", 1);
                        GameClass.prefs.flush();
                        GameClass.bg.setVolume(GameClass.prefs.getInteger("MusicVol"));
                        GameClass.bg.play();
                    }

                }

                if(Gdx.graphics.getHeight()-Gdx.input.getY()>Gdx.graphics.getHeight() / 8 * 4 && Gdx.graphics.getHeight()-Gdx.input.getY()<Gdx.graphics.getHeight() / 8 * 4 +Gdx.graphics.getHeight()/10){
                   if(GameClass.prefs.getFloat("SFXVol") == 1)
                       GameClass.prefs.putFloat("SFXVol" , 0);
                   else
                       GameClass.prefs.putFloat("SFXVol" , 1);
                }

                if(Gdx.graphics.getHeight()-Gdx.input.getY()>Gdx.graphics.getHeight() / 8 * 3 && Gdx.graphics.getHeight()-Gdx.input.getY()<Gdx.graphics.getHeight() / 8 * 3 +Gdx.graphics.getHeight()/10) {
                    GameClass.prefs.clear();
                    GameClass.prefs.putInteger("MusicVol", musictextureinteger);
                    GameClass.prefs.putFloat("SFXVol", soundtextureinteger);
                }

                GameClass.prefs.flush();
            }

            if(GameClass.prefs.getInteger("MusicVol") == 1)
                musictextureinteger = 1;
            else
                musictextureinteger = 0;

            if(GameClass.prefs.getFloat("SFXVol") == 1)
                soundtextureinteger = 1;
            else
                soundtextureinteger = 0;

        }



        render(GameClass.SR,GameClass.SB);
    }

    public void render(ShapeRenderer SR, SpriteBatch SB){
        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        SR.begin(ShapeRenderer.ShapeType.Filled);
        SR.setColor(1, 1, 1, 0.5f - GameClass.HS.GameLogoAlphaTimer / 256);

        SR.rect(Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 8 * 3, Gdx.graphics.getWidth() / 4 * 3, Gdx.graphics.getHeight() / 10);
        SR.end();
        Gdx.gl.glDisable(GL20.GL_BLEND);

        SB.setColor(1, 1, 1, 1 - GameClass.HS.GameLogoAlphaTimer / 256);

        SB.begin();
        if(musictextureinteger == 0)
            SB.draw(GameClass.MUSIC_OFF, Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 8 * 5, Gdx.graphics.getWidth() / 4 * 3, Gdx.graphics.getHeight() / 10);
        else
            SB.draw(GameClass.MUSIC_ON, Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 8 * 5, Gdx.graphics.getWidth() / 4 * 3, Gdx.graphics.getHeight() / 10);

        if(soundtextureinteger == 0)
            SB.draw(GameClass.SOUNDS_OFF, Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 8 * 4, Gdx.graphics.getWidth() / 4 * 3, Gdx.graphics.getHeight() / 10);
        else
            SB.draw(GameClass.SOUNDS_ON, Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 8 * 4, Gdx.graphics.getWidth() / 4 * 3, Gdx.graphics.getHeight() / 10);

        SB.end();
    }
}

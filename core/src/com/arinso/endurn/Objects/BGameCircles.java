package com.arinso.endurn.Objects;

import com.arinso.endurn.GameClass;
import com.arinso.endurn.GameScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;

/**
 * Created by Salih can on 21.05.2017.
 */
public class BGameCircles {
    float x,y;
    int radius;
    int SRColor;
    float speed;

    public BGameCircles(){

        radius = (int) (MathUtils.random(20, 100)/405f* Gdx.graphics.getWidth());

        int directionSpawn = MathUtils.random(1,3);
        if(directionSpawn!=3 || GameClass.GS.direction >= 88 && GameClass.GS.direction <= 92){
            y = -radius;
            x = MathUtils.random(0,Gdx.graphics.getWidth());
        }else{
            if(GameClass.GS.direction>92){
                x = Gdx.graphics.getWidth()+radius;
                y = MathUtils.random(0,Gdx.graphics.getHeight()-Gdx.graphics.getHeight()/45f*Math.abs(90-GameClass.GS.direction));
            }

            if(GameClass.GS.direction<88){
                x = -radius;
                y = MathUtils.random(0,Gdx.graphics.getHeight()-Gdx.graphics.getHeight()/45f*Math.abs(90-GameClass.GS.direction));
            }

        }

        SRColor = MathUtils.random(1,6);
        speed = MathUtils.random(10,30);
        speed = (speed/10)/720*Gdx.graphics.getHeight();
    }

    void randomColor(ShapeRenderer SR,int i){
        switch(i){
            case 1: SR.setColor(1, 0, 1, 0.1f); break;
            case 2: SR.setColor(1, 1, 0, 0.1f); break;
            case 3: SR.setColor(0, 1, 1, 0.1f); break;
            case 4: SR.setColor(0, 0, 1, 0.1f); break;
            case 5: SR.setColor(0, 1, 0, 0.1f); break;
            case 6: SR.setColor(1, 0, 0, 0.1f); break;
        }

    }

    public void update(){

        x += speed*MathUtils.cosDeg(GameClass.GS.direction - 180);
        y += speed*MathUtils.sinDeg(GameClass.GS.direction-180);

        if((y>Gdx.graphics.getHeight()+radius)||
                (GameClass.GS.direction > 90 && x < -radius)||
                (GameClass.GS.direction < 90 && x > Gdx.graphics.getWidth()+radius))
            GameScreen.BGameCircles.remove(this);

        render(GameClass.SR, GameClass.SB);
    }

    public void render(ShapeRenderer SR, SpriteBatch SB){
        randomColor(SR, SRColor);
        SR.circle(x, y, radius);
    }
}

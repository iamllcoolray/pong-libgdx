package com.game.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class PlayerOne extends Paddle{
    public PlayerOne() {
        x = 25;
    }
    public void movement(){
        if (Gdx.input.isKeyPressed(Input.Keys.W)){
            if (checkCollisionTop()){
                y = Gdx.graphics.getHeight() - height;
            }else {
                y += ySpeed * Gdx.graphics.getDeltaTime();
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)){
            if (checkCollisionBottom()){
                y = 0;
            }else {
                y += -ySpeed * Gdx.graphics.getDeltaTime();
            }
        }
    }
}

package com.game.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class PlayerTwo extends Paddle {
    public PlayerTwo() {
        x = Gdx.graphics.getWidth() - 50;
    }

    public void movement(){
        if (Gdx.input.isKeyPressed(Input.Keys.UP)){
            if (checkCollisionTop()){
                y = Gdx.graphics.getHeight() - height;
            }else {
                y += ySpeed * Gdx.graphics.getDeltaTime();
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            if (checkCollisionBottom()){
                y = 0;
            }else {
                y += -ySpeed * Gdx.graphics.getDeltaTime();
            }
        }
    }
}

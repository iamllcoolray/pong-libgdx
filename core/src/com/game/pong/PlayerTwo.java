package com.game.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class PlayerTwo extends Paddle {
    public PlayerTwo() {
        super();
        x = Gdx.graphics.getWidth() - 50;
    }

    @Override
    public void update() {
        playerMovement();
    }

    private void playerMovement(){
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

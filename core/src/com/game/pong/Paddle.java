package com.game.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle {
    int x, y, width, height, ySpeed, score;

    public Paddle(){
        this.width = 25;
        this.height = 75;
        this.x = 25;
        this.y = (Gdx.graphics.getHeight() / 2) - (width / 2);
        this.ySpeed = 300;
        this.score = 0;
    }

    public void update(){

    }

    public void draw(ShapeRenderer shape){
        shape.rect(x, y, width, height);
    }

    public int getScore(){
        return score;
    }

    protected boolean checkCollisionTop() {
        return y + height >= Gdx.graphics.getHeight();
    }

    protected boolean checkCollisionBottom() {
        return y <= 0;
    }
}

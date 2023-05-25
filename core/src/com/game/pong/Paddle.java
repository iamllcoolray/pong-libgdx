package com.game.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class Paddle implements IMovement{
    int x, y, width, height, ySpeed, score;

    public Paddle(){
        this.width = 25;
        this.height = 75;
        this.y = (Gdx.graphics.getHeight() / 2) - (width / 2);
        this.ySpeed = 300;
        this.score = 0;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void update(){
        movement();
    }

    public abstract void movement();

    public void draw(ShapeRenderer shape){
        shape.rect(x, y, width, height);
    }

    protected boolean checkCollisionTop() {
        return y + height >= Gdx.graphics.getHeight();
    }

    protected boolean checkCollisionBottom() {
        return y <= 0;
    }
}

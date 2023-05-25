package com.game.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball implements IMovement{
    private int x, y, size, xSpeed, ySpeed, playerOneScore, playerTwoScore;
    public Ball(){
        this.size = 15;
        this.x = (Gdx.graphics.getWidth() / 2) - (size / 2);
        this.y = (Gdx.graphics.getHeight() / 2) - (size / 2);
        this.xSpeed = 300;
        this.ySpeed = 300;
        this.playerOneScore = 0;
        this.playerTwoScore = 0;
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    public int getPlayerOneScore() {
        return playerOneScore;
    }

    public void setPlayerOneScore(int playerOneScore) {
        this.playerOneScore = playerOneScore;
    }

    public int getPlayerTwoScore() {
        return playerTwoScore;
    }

    public void setPlayerTwoScore(int playerTwoScore) {
        this.playerTwoScore = playerTwoScore;
    }

    public void update(){
        movement();
    }

    public void draw(ShapeRenderer shape){
        shape.circle(x, y, size);
    }

    public void movement(){
        x += xSpeed * Gdx.graphics.getDeltaTime();
        y += ySpeed * Gdx.graphics.getDeltaTime();
        if (checkRight()) {
            playerOneScore++;
            x = (Gdx.graphics.getWidth() / 2) - (size / 2);
            y = (Gdx.graphics.getHeight() / 2) - (size / 2);
        }
        if (checkLeft()) {
            playerTwoScore++;
            x = (Gdx.graphics.getWidth() / 2) - (size / 2);
            y = (Gdx.graphics.getHeight() / 2) - (size / 2);
        }
        if ((y * 2) + size < 0 || y + size > Gdx.graphics.getHeight()) {
            ySpeed = -ySpeed;
        }
    }

    public boolean checkLeft() {
        return x - size < 0;
    }

    public boolean checkRight() {
        return x + size > Gdx.graphics.getWidth();
    }

    public void checkCollision(Paddle paddle) {
        if(collidesWith(paddle)){
            xSpeed *= -1;
        }
    }
    public boolean collidesWith(Paddle paddle) {
        if (x + size < paddle.x || x - size > paddle.x + paddle.width || y + size < paddle.y || y - size > paddle.y + paddle.height) {
            return false;
        }
        return true;
    }
}

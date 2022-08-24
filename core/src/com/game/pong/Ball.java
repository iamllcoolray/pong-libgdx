package com.game.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball {
    int x, y, size, xSpeed, ySpeed;
    PlayerOne playerOne;
    PlayerTwo playerTwo;
    public Ball(){
        this.size = 15;
        this.x = (Gdx.graphics.getWidth() / 2) - (size / 2);
        this.y = (Gdx.graphics.getHeight() / 2) - (size / 2);
        this.xSpeed = 300;
        this.ySpeed = 300;
        playerOne = new PlayerOne();
        playerTwo = new PlayerTwo();
    }

    public void update(){
        ballMovementDirection();
    }

    public void draw(ShapeRenderer shape){
        shape.circle(x, y, size);
    }

    private void ballMovementDirection(){
        x += xSpeed * Gdx.graphics.getDeltaTime();
        y += ySpeed * Gdx.graphics.getDeltaTime();
        if (checkRight()) {
            playerOne.score++;
            x = (Gdx.graphics.getWidth() / 2) - (size / 2);
            y = (Gdx.graphics.getHeight() / 2) - (size / 2);
        }
        if (checkLeft()) {
            playerTwo.score++;
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
    private boolean collidesWith(Paddle paddle) {
        if (x + size < paddle.x || x - size > paddle.x + paddle.width || y + size < paddle.y || y - size > paddle.y + paddle.height) {
            return false;
        }
        return true;
    }
}

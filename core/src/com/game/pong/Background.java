package com.game.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Background {
    int x, y, width, height;
    public Background(){
        this.x = (Gdx.graphics.getWidth() - 10) / 2;
        this.y = 0;
        this.width = 2;
        this.height = Gdx.graphics.getHeight();
    }
    public void draw(ShapeRenderer shape){
        shape.rect(x, y, width, height);
    }
}

package com.game.pong;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class PongGame extends ApplicationAdapter {
	ShapeRenderer shape;
	SpriteBatch batch;
	BitmapFont font;
	PlayerOne playerOne;
	PlayerTwo playerTwo;
	Ball ball;
	Background background;
	
	@Override
	public void create () {
		shape = new ShapeRenderer();
		batch = new SpriteBatch();
		font = new BitmapFont();
		playerOne = new PlayerOne();
		playerTwo = new PlayerTwo();
		ball = new Ball();
		background = new Background();
	}

	@Override
	public void render () {
		Gdx.graphics.setResizable(false);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		playerOne.update();
		playerTwo.update();
		ball.checkCollision(playerOne);
		ball.checkCollision(playerTwo);
		ball.update();

		batch.begin();
		font.draw(batch, Integer.toString(ball.getPlayerOneScore()), (Gdx.graphics.getWidth() / 2) - 40, Gdx.graphics.getHeight() - 10);
		font.draw(batch, Integer.toString(ball.getPlayerTwoScore()), (Gdx.graphics.getWidth() / 2) + 20, Gdx.graphics.getHeight() - 10 );
		batch.end();

		shape.begin(ShapeRenderer.ShapeType.Filled);
		background.draw(shape);
		playerOne.draw(shape);
		playerTwo.draw(shape);
		ball.draw(shape);
		shape.end();
	}
	
	@Override
	public void dispose () {
		shape.dispose();
		batch.dispose();
		font.dispose();
	}
}

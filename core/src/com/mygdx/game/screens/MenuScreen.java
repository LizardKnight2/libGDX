package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Main;

import com.badlogic.gdx.math.Rectangle;

public class MenuScreen implements Screen {
    private Main game;

    private SpriteBatch batch;
    private Texture img;
    private Rectangle startRect;
    private ShapeRenderer shapeRenderer;



    public MenuScreen(Main game){
        this.game = game;
        batch = new SpriteBatch();
        img = new Texture("koshachyaLapa.png"); //тут картинка
        startRect = new Rectangle(0, 0, img.getWidth(), img.getHeight());
        shapeRenderer = new ShapeRenderer();

    }
    @Override
    public void show() {


    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.GRAY);
        batch.begin();
        batch.draw(img, 0, 0);
        batch.end();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.GREEN);
        shapeRenderer.rect(startRect.x, startRect.y, startRect.width, startRect.height);
        shapeRenderer.end();

        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
            int x = Gdx.input.getX();
            int y = Gdx.graphics.getHeight() - Gdx.input.getY();
            Vector2 vect = new Vector2(x, y);
            if(startRect.contains(x, y)){
                dispose();
                game.setScreen(new GameScreen(game));
            }
            dispose();
            game.setScreen(new GameScreen(game));
        }

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        this.batch.dispose();
        this.img.dispose();
        this.shapeRenderer.dispose();

    }
}

package com.dusitibi.flappybird.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dusitibi.flappybird.Flappy;

public class MenuState extends State {

    private Texture background;
    private Texture playButton;


    public MenuState(GameStateManager gameStateManager) {
        super(gameStateManager);
        cam.setToOrtho(false, Flappy.WIDTH / 2, Flappy.HEIGHT / 2);
        background = new Texture("background.png");
        playButton = new Texture("playbutton.png");
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()){
            gameStateManager.set(new PlayState(gameStateManager));
        }
    }

    @Override
    public void update(float delta) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(cam.combined);
        spriteBatch.begin();
        spriteBatch.draw(background, 0, 0, Flappy.WIDTH, Flappy.HEIGHT);
        spriteBatch.draw(playButton, cam.position.x - playButton.getWidth() / 2, cam.position.y);
        spriteBatch.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playButton.dispose();
    }
}

package com.dusitibi.flappybird.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class Bird {

    public static final int GRAVITY = -15;
    private static final int MOVEMNET = 100;

    private Vector2 position;
    private Vector3 velocity;

    private Rectangle bounds;
    private Texture birdTextures;
    private Animation birdAnimation;
    private Sound flap;


    public Bird(int x, int y){
        position = new Vector2(x, y);
        velocity = new Vector3(0, 0, 0);
        birdTextures = new Texture("birdanimation.png");
        birdAnimation = new Animation(new TextureRegion(birdTextures), 3, 0.5f);
        bounds = new Rectangle(x, y, birdTextures.getWidth() / 3, birdTextures.getHeight());
        flap = Gdx.audio.newSound(Gdx.files.internal("flap.ogg"));
    }

    public void update(float delta){
        birdAnimation.update(delta);
        if (position.y > 0)
                velocity.add(0, GRAVITY, 0);
            velocity.scl(delta);
            position.add(MOVEMNET * delta, velocity.y);
        if (position.y < 0)
            position.y = 0;


        velocity.scl(1/delta);
        bounds.setPosition(position.x, position.y);
    }

    public void jump(){
        velocity.y = 250;
        flap.play(0.2f);
    }

    public void dispose(){
        birdTextures.dispose();
        flap.dispose();
    }


    // Getters - Setters


    public Vector2 getPosition() {
        return position;
    }

    public TextureRegion getTexture() {
        return birdAnimation.getFrame();
    }

    public Rectangle getBounds(){
        return bounds;
    }
}
